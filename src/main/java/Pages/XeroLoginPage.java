package Pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.asis.util.BaseClass;
import com.asis.util.ExcelUtil;
import com.asis.util.xeroexcel;

import Driver_manager.DriverManager;

public class XeroLoginPage extends BaseClass{

	@FindBy(id = "xl-form-email")
	WebElement Emailaddress;

	@FindBy(id = "xl-form-password")
	WebElement Password;

	@FindBy(id = "xl-form-submit")
	WebElement loginButton;

	@FindBy(xpath = "//button[contains(text(),\"Use another authentication method\")]")
	WebElement anotherAuthMethod;

	@FindBy(xpath = "//button[contains(text(),'Security questions')]")
	WebElement securityQsn;

	// Constructor
	public XeroLoginPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	public void enterUserId() {
        String userId = XERO_USER_NAME;
        Emailaddress.sendKeys(userId);
    }

    public void enterPassword() {
        String password = XERO_PASSWORD;
        Password.sendKeys(password);
    }
	public void clickLoginButton() {
		loginButton.click();
	}
	public void clickAnotherAuthMethod() {
		anotherAuthMethod.click();
	}
	public void clickSecurityQsn() {
		securityQsn.click();
	}
}
