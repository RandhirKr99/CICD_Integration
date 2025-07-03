package com.cicd;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidTest {
	
	//project location : - D:\eclipse-workspace\CICD_Integration
   //from cmd - cd /d D:\eclipse-workspace\CICD_Integration
	//git url = https://github.com/RandhirKr99/CICD_Integration.git
@ Test
    public void androidLaunchTest() throws MalformedURLException, InterruptedException {

    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("Android")
    .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
    options.setDeviceName("Redmi K20 Pro");
    options.setApp(System.getProperty("user.dir")+"/apps/DemoApp.apk");

    options.setAppPackage("com.swaglabsmobileapp");
    options.setAppActivity("com.swaglabsmobileapp.MainActivity");
    AndroidDriver driver =new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

    // driver.unlockDevice ();
    // Thread.sleep(4000);
    driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT,1000);
    driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
    driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
    driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

   /* new WebDriverWait(driver, Duration.ofSeconds(60))
            .until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//*[@text='PRODUCTS']")));

    */
    driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")")).click();
  //driver.installApp (System.getProperty("user.dir")+"/apps/DemoApp.apk");
    System.out.println("Current Package :"+driver.getCurrentPackage());
    System.out.println("Current Activity :"+driver.currentActivity());
    boolean appInstalled = driver.isAppInstalled("com.swaglabsmobileapp");
    System.out.println("appInstalled: "+appInstalled);
    var batteryPercent = driver.getBatteryInfo ().getLevel ();
    System.out.println("batteryPercent :"+ batteryPercent);
    SessionId sessionId = driver.getSessionId();
    System.out.println("sessionId :"+sessionId);
//  boolean b = driver.removeApp("com.swaglabsmobileapp");
//  System.out.println("App removed :"+b);




}
}
