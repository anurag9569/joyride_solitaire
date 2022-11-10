package TestCases;

import org.testng.annotations.AfterMethod;
import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BaseClass.baseclass;
import ObjectRepository.Pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC1 extends baseclass{
	public AppiumDriver<MobileElement> driver;
	@BeforeTest
	public void begin() throws MalformedURLException
	{
		driver=baseclass.driver;
		baseclass.start();
		baseclass.report();
	}
	
	@Test
	public void check() throws MalformedURLException, InterruptedException
	{
		test=extentReport.startTest("Application testing");
		Pages pages=new Pages();
		test.log(LogStatus.INFO, "step 01 : //Tap on Login with SMS");
		pages.clickOnLoginSMS();
		
		test.log(LogStatus.INFO, "step 02 : //Use this number for login +19250004001");
		pages.clickOnCode();
		pages.selectCountryCode();
		pages.clickOnDoneBtn();
		pages.enterNumber("9250004001");
		pages.clickOnArrow();
		
		test.log(LogStatus.INFO, "step 03 : Enter 123456 as OTP\r\n" + 
				"We get a home/playground screen.");
		pages.enterOTP(123456);
		//pages.clickOnArrow();
		
		test.log(LogStatus.INFO, "step 04 : //Tap on “Me” in the bottom right corner.");
		pages.tapOnMe();
		
		test.log(LogStatus.INFO, "step 05 : //Scroll down.");
		//pages.scroll("Match History");
		
		test.log(LogStatus.INFO, "step 06 : //In Match history , we see completed matches cards.\r\n" + 
				"8) Tap on it, and we go to the results screen.");
		pages.clickOnCompletedCard();
		
		test.log(LogStatus.INFO, "In the results screen, pass the test case if you see\r\n" + 
				"a) “You Lost!” status in bottom of result card\r\n" + 
				"b) User’s score should be “1021”\r\n" + 
				"c) First user section shows the winnings of “40” and see “1st” in the card");
		pages.verifyResultScreen();
	}

	@AfterMethod
	public void generateReport(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "test case failed is " + result.getName() + result.getThrowable());
			
			String screenshotPath=baseclass.screenshotCapture(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "test case passed is " + result.getName());
		}
		else
		{
			test.log(LogStatus.SKIP, "" +result.getName()+result.getThrowable());
		}
	}
	
	@AfterTest
	public void end()
	{
		extentReport.flush();
	}
}
