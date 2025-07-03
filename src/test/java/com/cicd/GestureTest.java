package com.cicd;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class GestureTest {

    AndroidDriver driver;

    @Test
    public void gesturesTest() throws MalformedURLException, InterruptedException
    {

       UiAutomator2Options options = new UiAutomator2Options();
       options.setPlatformName("Android")
               .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
       options.setDeviceName("Redmi K20 Pro");
       options.setApp(System.getProperty("user.dir") + "/apps/DemoApp.apk");

       options.setAppPackage("com.swaglabsmobileapp");
       options.setAppActivity("com.swaglabsmobileapp.MainActivity");
       driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 1000);
        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
        WebElement sauceBag = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")"));
        centerOfElement(sauceBag);
        tapOnElement(sauceBag);

    }
    public Point centerOfElement(WebElement element){

        Dimension d= driver.manage().window().getSize();
        System.out.println("Dimension of Screen : "+d);
        Point location = element.getLocation();
        System.out.println("location of element : "+location);
        int xCenterOfElement = location.getX() + (element.getSize().getWidth()) / 2;
        System.out.println("xCenterOfElement : "+xCenterOfElement);
        int yCenterOfElement = location.getY()  + (element.getSize().getHeight())/2;
        System.out.println("yCenterOfElement : "+yCenterOfElement);
        return new Point(xCenterOfElement,yCenterOfElement);
    }

    public void tapOnElement(WebElement element){


        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "Finger1");
        Sequence tap = new Sequence(input,0);
        tap.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerOfElement(element)));
        tap.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));




    }
}