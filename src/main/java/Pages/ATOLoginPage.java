package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asis.util.BaseClass;
import com.asis.util.ExcelUtil;

import Driver_manager.DriverManager;

public class ATOLoginPage extends BaseClass{	
	
	@FindBy(xpath="//a[@id='btn-myGovID']")
	WebElement myGOV;
	
	@FindBy(xpath= "//input[@placeholder='myGovID email']")
	WebElement emailAddress;

	@FindBy(xpath= "//button[@title='Submit']")
	WebElement loginButton;

	

	public ATOLoginPage(){	
		PageFactory.initElements(DriverManager.getDriver(), this);       
	}

	public void clickOnMyGOVButton() {
		myGOV.click();
	}

	public void sendingEmailAddress() {
		System.out.println(ATO_USER_NAME);
		
		String user_id=ATO_USER_NAME;
		emailAddress.sendKeys(user_id);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}
}
