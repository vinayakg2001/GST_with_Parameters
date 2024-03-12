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
        xeroexcel.readExcel(XERO_FILE_PATH, XERO_FILE_NAME);
        String[] userId = xeroexcel.getUserLoginDetail(XERO_LOGIN_SHEET_NAME);
        Emailaddress.sendKeys(userId[0]);
        try {
            xeroexcel.closeExcel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPassword() {
        xeroexcel.readExcel(XERO_FILE_PATH, XERO_FILE_NAME);
        String[] password = xeroexcel.getUserLoginDetail(XERO_LOGIN_SHEET_NAME);
        Password.sendKeys(password[1]);
        try {
            xeroexcel.closeExcel();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
