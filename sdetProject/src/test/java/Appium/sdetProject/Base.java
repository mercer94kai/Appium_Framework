package Appium.sdetProject;



import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Base extends Capability {
	
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt () throws IOException, InterruptedException 
	{
	
		service = startServer();
		driver = capabilities(appActivity, appPackage, deviceName, platformName, chromeExecutable); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testcase1() throws InterruptedException
	{
		Thread.sleep(10000);
		//***Click on 'Dismiss' button on start up page
		driver.findElementByAndroidUIAutomator("text(\"Dismiss\")").click();
		Thread.sleep(2000);
		//***Click on 'Dismiss' button on Covid-19 message
		driver.findElementByAndroidUIAutomator("text(\"Dismiss\")").click();
		
		//***Explore 'Search' tab option 
		driver.findElementByAccessibilityId("Search tab").click();
		driver.findElementByAndroidUIAutomator("text(\"Computing\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Code.org\")").click();
		
		//***Click on 'Explore'tab option
		driver.findElementByAccessibilityId("Explore tab").click();
	}
	
	@Test
	public void testcase2() throws InterruptedException 
	{
		//***Scroll down to 'Select language' button and change the language
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Select language\").instance(0))").click();
		driver.findElementByAndroidUIAutomator("text(\"English (default)\")").click();
		driver.findElementByAccessibilityId("Back").click();
		
		//***Click on 'Settings' button and turn on 'Sound effects' option
		driver.findElementByAccessibilityId("Settings").click();
		driver.findElementByAndroidUIAutomator("text(\"OFF\")").click();
		
	}

	@Test
	public void testcase3() throws InterruptedException
	{
		//***Click on 'Privacy policy' on settings menu
		driver.findElementByAndroidUIAutomator("text(\"Privacy policy\")").click();
		driver.findElementById("android:id/button_once").click();
		
		//***Verify Content Switching between NATIVE & WEBVIEW 
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames)
		{
		    System.out.println(contextName); 
	    }	
		//driver.context("WEBVIEW_org.khanacademy.android");
	    Thread.sleep(5000);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.context("NATIVE_APP");
	}
	
	@Test
	public void testcase4() throws InterruptedException
	{
		//***Sign up Using Email in 'Sign in' Window
		driver.findElementByAndroidUIAutomator("text(\"Sign in\")").click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("text(\"Sign up with email\")").click();
		driver.findElementByAccessibilityId("First name").sendKeys("Alex");
		driver.findElementByAccessibilityId("Last name").sendKeys("Mercer");
		driver.findElementByAccessibilityId("Birthday").click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollForward().scrollTextIntoView(\"Dec\")").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollForward(15).scrollTextIntoView(\"10\")").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(2)).scrollBackward().scrollTextIntoView(\"1994\")").click();
		Thread.sleep(3000);
		driver.findElementById("android:id/button1").click();

		driver.findElementByAccessibilityId("Email address").sendKeys("alexMercer@gmail.com");
		driver.findElementByAccessibilityId("Password").sendKeys("SDET@1234");
		driver.findElementByAndroidUIAutomator("text(\"CREATE\")").click();
		Thread.sleep(2000);
		
		//***Signing out from the application
		driver.findElementByAccessibilityId("Settings").click();
		driver.findElementByAndroidUIAutomator("text(\"Sign out\")").click();
		Thread.sleep(2000);
		driver.findElementById("android:id/button1").click();

		//***Signing in into the application
		driver.findElementByAndroidUIAutomator("text(\"Sign in\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Sign in\")").click();
		driver.findElementByAccessibilityId("Enter an e-mail address or username").sendKeys("alexMercer@gmail.com");
		driver.findElementByAccessibilityId("Password").sendKeys("SDET@1234");
		driver.findElementByAccessibilityId("Sign in").click();
		
	}
	
	@Test
	public void testcase5() throws InterruptedException
	{
		//***Adding Courses  
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Get started\").instance(0))").click();
		Thread.sleep(3000);
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollTextIntoView(\"Adult learner\")").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Computer programming\").instance(0))").click();
		driver.findElementByAndroidUIAutomator("text(\"Done\")").click();	
		Thread.sleep(3000);
	
		//***Signing Out from the application
		driver.findElementByAccessibilityId("Settings").click();
		driver.findElementByAndroidUIAutomator("text(\"Sign out\")").click();
		driver.findElement(By.id("android:id/button1")).click();
		
		service.stop();
	}
	}
