package framework.Appium;

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
	
	@Test(enabled=false)
	public void testcase1() {
		
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
		
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Maitrayee");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		
		String Cus_nm= driver.findElementById("com.androidsample.generalstore:id/nameField").getAttribute("text");
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	}

	@Test(enabled=false)
	public void testcase2() {
		
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"))").click();
		
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Maitrayee");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		
		//String Cus_nm= driver.findElementById("com.androidsample.generalstore:id/nameField").getAttribute("test");
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		
		String err_msg=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("text");
		System.out.println(err_msg);
		
	}
	
	@Test(enabled=false)
	public void testcase3() {
		
		
	//	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))");
	//	driver.findElementById("com.androidsample.generalstore:id/productAddCart").click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\").instance(0)).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
		int list=driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		System.out.println(list);
		
		for (int i=0;i<list;list++) 
		{
			
			String productName=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			if(productName.equalsIgnoreCase("Air Jordan 9 Retro")) 
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		String cartProduct = driver.findElementById("com.androidsample.generalstore:id/productName").getText();
		String productName = "Air Jordan 9 Retro";
		
		Assert.assertEquals(cartProduct, productName);
	}
	
	@Test
	public void testcase4() throws InterruptedException 
	{
	
		
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
		
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Maitrayee");
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		
		String Cus_nm= driver.findElementById("com.androidsample.generalstore:id/nameField").getAttribute("text");
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		int list=driver.findElementsById("com.androidsample.generalstore:id/productName").size();

		//for (int i=1;i<list;list++) 
		//{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		//}		
				driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
				Thread.sleep(3000);
				String amount_1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
				amount_1=amount_1.substring(1);
				//System.out.println(amount_1);
				
				String amount_2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
				amount_2=amount_2.substring(1);
				//System.out.println(ampoun_2);
				Double am1=Double.parseDouble(amount_1);
				Double am2=Double.parseDouble(amount_2);
				Double Total=am1+am2;
				
				String Finalamt= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
				Finalamt=Finalamt.substring(1);
				Double Fnlamt=Double.parseDouble(Finalamt);
				
				Assert.assertEquals(Total, Fnlamt);
				
				driver.findElement(By.className("android.widget.CheckBox")).click();
				TouchAction t = new TouchAction(driver);
				WebElement obj1=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
				t.longPress(longPressOptions().withElement(element(obj1)).withDuration(ofSeconds(3))).release().perform();
				Thread.sleep(2000);
				driver.findElement(By.id("android:id/button1")).click();
				driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
				Thread.sleep(5000);
				
				Set<String> contextNames = driver.getContextHandles();
				for (String contextName : contextNames) {
				    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
				}
				
				driver.context("WEBVIEW_com.androidsample.generalstore");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
				driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.RETURN);
				Thread.sleep(3000);
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				driver.context("NATIVE_APP");
				
				service.stop();
	}
}
