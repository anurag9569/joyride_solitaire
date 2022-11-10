package ObjectRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseclass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.Assert;

public class Pages extends baseclass{
	public Pages() {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Login with SMS\"]")
	private WebElement loginWithSMS;
	
	@FindBy(id="tv_country_code")
	private WebElement code;
	
	@FindBy(id="rl_content")
	private List<WebElement> countryCode;
	
	@FindBy(id="et_number")
	private WebElement number;
	
	@FindBy(xpath="//android.widget.Button[@text=\"Done\"]")
	private WebElement doneBtn;
	
	@FindBy(id="iv_arrow")
	private WebElement arrowBtn;
	
	@FindBy(xpath="//android.widget.EditText/android.widget.TextView")
	private List<WebElement> OTP;
	
	@FindBy(id="close_button_iv")
	private WebElement closeBtn;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Today\"]")
	private WebElement claimBtn;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Profile\"]")
	private WebElement profileBtn;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Match History\"]")
	private WebElement matchHistory;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Completed\"]")
	private WebElement completedText;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"You Lost\"]")
	private WebElement youLostText;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"You Lost!\"]")
	private WebElement statusResult;
	
	@FindBy(id="tv_lost_user_score_reward")
	private WebElement scoreReward;
	
	@FindBy(id="currency_text4")
	private WebElement pointWinnings;
	
	@FindBy(id="tv_tag_first_position")
	private WebElement firstposition;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Day 1\"]")
	private WebElement day1Txt;
	
	@FindBy(id="vip_shield_iv")
	private WebElement vipShield;
	
	
	
	public void clickOnLoginSMS() {
		try {Thread.sleep(20000);}catch(Exception e) {e.getMessage();}
		loginWithSMS.click();
	}
	
	public void clickOnCode() {
		try {Thread.sleep(10000);}catch(Exception e) {e.getMessage();}
		code.click();
	}
	
	public void selectCountryCode() {
		try {Thread.sleep(5000);}catch(Exception e) {e.getMessage();}
		countryCode.get(1).click();
	}
	
	public void clickOnDoneBtn() {
		try {Thread.sleep(2000);}catch(Exception e) {e.getMessage();}
		doneBtn.click();
	}
	
	public void enterNumber(String num) {
		try {Thread.sleep(2000);}catch(Exception e) {e.getMessage();}
		number.click();
		number.sendKeys(num);
	}
	
	public void clickOnArrow() {
		try {Thread.sleep(2000);}catch(Exception e) {e.getMessage();}
		arrowBtn.click();
		try {Thread.sleep(2000);}catch(Exception e) {e.getMessage();}
	}
	
	public void enterOTP(int otp) {
		try {Thread.sleep(2000);}catch(Exception e) {e.getMessage();}
		String sotp=Integer.toString(otp);
		char c[]=sotp.toCharArray();
		for(int i=0;i<c.length;i++) {
			OTP.get(i).click();
			System.out.println("c = "+c[i]);
			try {Thread.sleep(2000);}catch(Exception e) {e.getMessage();}
			
			if(Character.getNumericValue(c[i])==0) {
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_0));
			}
			if(Character.getNumericValue(c[i])==1) {
				System.out.print("inside 1 block");
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_1));
			}
			if(Character.getNumericValue(c[i])==2) {
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_2));
			}
			if(Character.getNumericValue(c[i])==3) {
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_3));
			}
			if(Character.getNumericValue(c[i])==4) {
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_4));
			}
			if(Character.getNumericValue(c[i])==5) {
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_5));
			}
			if(Character.getNumericValue(c[i])==6) {
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_6));
			}
			if(Character.getNumericValue(c[i])==7) {
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_7));
			}
			if(Character.getNumericValue(c[i])==8) {
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_8));
			}
			if(Character.getNumericValue(c[i])==9) {
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_9));
			}
		}
	}
	
	public void tapOnMe() {
		System.out.println("inside tapOnMe");
		try {Thread.sleep(30000);}catch(Exception e) {e.getMessage();}
		claimBtn.click();
		int i=1;
		while(i!=0) {
			if(checkForElementAvailabilityBoolean(claimBtn)) {
				claimBtn.click();
				i++;
			}
			else {
				i=0;
				break;
			}
		}
		try {Thread.sleep(3000);}catch(Exception e) {e.getMessage();}
		closeBtn.click();
		try {Thread.sleep(5000);}catch(Exception e) {e.getMessage();}
		//Alert alert=driver.switchTo().alert();
		//alert.dismiss();
		try {Thread.sleep(3000);}catch(Exception e) {e.getMessage();}
		profileBtn.click();
	}
	
	public void scroll(WebElement element) {
		try {Thread.sleep(2000);}catch(Exception e) {e.getMessage();}
		String s=element.toString();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + s +"\").instance(0))"));
	}
	
	public void scroll(String s) {
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains("+s+").instance(0))"));
		scroll(matchHistory);
	}
	
	public void checkElement(WebElement element) {
		int i=1;
		int count=0;
		while(i!=0) {
			if(!(checkForElementAvailabilityBoolean(element))) {
				scroll();
				i++;
				count++;
			}
			else {
				i=0;
				break;
			}
			if(count>20) {
				i=0;
				break;
			}
		}
	}
	
	public void verticalSwipe(double a,double b) {
		Dimension d=driver.manage().window().getSize();
		int startx = d.width/2;
		int starty = (int) (d.height*a);
		int endy = (int) (d.height*b);

		TouchAction action=new TouchAction(driver);
		action.longPress(PointOption.point(startx,starty)).moveTo(PointOption.point(startx,endy)).release().perform();
	}
	
	public void scroll() {
		Dimension d=driver.manage().window().getSize();
		int startx = d.width/2;
		int starty = (int) (d.height*0.8);
		int endy = (int) (d.height*0.2);

		TouchAction action=new TouchAction(driver);
		action.longPress(PointOption.point(startx,starty)).moveTo(PointOption.point(startx,endy)).release().perform();
	}
	
	public void clickOnCompletedCard() {
//		try {Thread.sleep(2000);}catch(Exception e) {e.getMessage();}
//		checkElement(matchHistory);
//		try {Thread.sleep(3000);}catch(Exception e) {e.getMessage();}
//		checkElement(youLostText);
		verticalSwipe(0.8, 0.2);
		verticalSwipe(0.8, 0.2);
		verticalSwipe(0.8, 0.2);
		verticalSwipe(0.8, 0.2);
		try {Thread.sleep(2000);}catch(Exception e) {e.getMessage();}
		youLostText.click();
	}
	
	public void verifyResultScreen() {
		Assert.assertEquals(statusResult.getText(),"You Lost!");
		Assert.assertEquals(scoreReward.getText(),"1021");
		Assert.assertEquals(pointWinnings.getText(), " 40");
		Assert.assertEquals(firstposition.getText(), "1st");
	}
	
	public boolean checkForElementAvailabilityBoolean(WebElement element) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean flag=false;
		if(isElementPresent(element)) {
			Assert.assertEquals(element.isDisplayed(), "true",""+element+" not displayed");
			flag=true;
		}
		else {
			System.out.println(element+ " not visible");
		}
		return flag;
	}
	public boolean isElementPresent(WebElement element) {
		boolean flag=false;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			Assert.assertTrue(element.isDisplayed());
			flag=true;
		}catch (Exception e) {
			
		}
		return flag;
	}
}
