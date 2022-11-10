package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import util.utility;

public class baseclass {
	public static AppiumDriver<MobileElement> driver;
	public static ExtentReports extentReport;
	public static ExtentTest test;
	
	public static void start() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"3af95351");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability("appPackage","com.onjoyride.jrxsolitaireblitz");
		cap.setCapability("appActivity", "com.onjoyride.unityModule.LauncherActivity");
		driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(utility.implicitWait,TimeUnit.SECONDS);
	}
	
	
	public static void report()
	{
		extentReport = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\extentreport.html",true);
	}
	
	public static String screenshotCapture(AppiumDriver<MobileElement> driver,String screenshot) throws IOException
	{
		driver=baseclass.driver;
		String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File a=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\test-output\\"+screenshot+date+".png";
		FileHandler.copy(a, new File(destination));
		return destination;
	}
}
