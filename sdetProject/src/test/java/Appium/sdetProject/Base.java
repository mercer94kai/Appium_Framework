package Appium.sdetProject;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
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

		driver.findElementByAndroidUIAutomator("text(\"Dismiss\")").click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("text(\"Dismiss\")").click();
		
		driver.findElementByAccessibilityId("Search tab").click();
		driver.findElementByAndroidUIAutomator("text(\"Computing\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Code.org\")").click();
		
		driver.findElementByAccessibilityId("Explore tab").click();
	}
	
	@Test
	public void testcase2() throws InterruptedException 
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Select language\").instance(0))").click();
		driver.findElementByAndroidUIAutomator("text(\"English (default)\")").click();
		driver.findElementByAccessibilityId("Back").click();
		
		driver.findElementByAccessibilityId("Settings").click();
		driver.findElementByAndroidUIAutomator("text(\"OFF\")").click();
		
	}

	@Test
	public void testcase3() throws InterruptedException
	{
		
		driver.findElementByAndroidUIAutomator("text(\"Privacy policy\")").click();
		driver.findElementById("android:id/button_once").click();
		
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
		
	
		driver.findElementByAccessibilityId("Settings").click();
		driver.findElementByAndroidUIAutomator("text(\"Sign out\")").click();
		Thread.sleep(2000);
		
		driver.findElementById("android:id/button1").click();
		driver.findElementByAndroidUIAutomator("text(\"Sign in\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Sign in\")").click();
		
		driver.findElementByAccessibilityId("Enter an e-mail address or username").sendKeys("alexMercer@gmail.com");
		driver.findElementByAccessibilityId("Password").sendKeys("SDET@1234");
		driver.findElementByAccessibilityId("Sign in").click();
		
	}
	
	@Test
	public void testcase5() throws InterruptedException
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Get started\").instance(0))").click();
		Thread.sleep(3000);
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollTextIntoView(\"Adult learner\")").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Computer programming\").instance(0))").click();
		driver.findElementByAndroidUIAutomator("text(\"Done\")").click();	
		Thread.sleep(3000);
	
		driver.findElementByAccessibilityId("Settings").click();
		driver.findElementByAndroidUIAutomator("text(\"Sign out\")").click();
		driver.findElement(By.id("android:id/button1")).click();
		
		service.stop();
	}
	}
