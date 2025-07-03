package com.cicd;

import org.testng.annotations.Test;

public class sample {
	
	@Test
	public void sampletest() {
		
	
	String input ="I love Java programming language";
	String[] words = input.split(" ");
	
	String lastWord = words[words.length-1];
	StringBuilder builder = new StringBuilder(lastWord);
	String reverseLastWord = builder.reverse().toString();
	
	String result = input.replace(lastWord, reverseLastWord);
	
	
	 System.out.println("Original String : " + input);
     System.out.println("Reversed String : " + result);
}
}
