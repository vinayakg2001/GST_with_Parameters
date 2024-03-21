package Pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.asis.util.BaseClass;
import com.asis.util.ExcelUtil;
import com.asis.util.xeroexcel;

import Driver_manager.DriverManager;

public class XeroSelectingQuarterDatePage extends BaseClass{

	//list of webelements
	@FindBy(xpath = "//button[@data-name='navigation-menu/accounting']")
	WebElement accountingButton;
	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	WebElement reports;
	@FindBy(xpath = "//*[@class='report-row-tooltip']//descendant::span[contains(text(),'Activity Statement')]")
	WebElement activitySatement;
	@FindBy(xpath = "//input[@id='fromDate']")
	WebElement From;
	@FindBy(xpath = "//input[@id='dateTo']")
	WebElement To;
	@FindBy(xpath = "//a[@id='ext-gen27']")
	WebElement UpdateButton;

	//constructor
	public XeroSelectingQuarterDatePage(){
		PageFactory.initElements(DriverManager.getDriver(), this);       
	}
	//list  of all the actions on page
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	public void clickAccountingButton() {
		accountingButton.click();
		reports.click();
	}
	public void clickActivityStatement() {
		activitySatement.click();
	}

	public void enterFromoDate() throws ParseException {
		String StringFromDate = XERO_FROM_DATE;
		From.clear();
		From.sendKeys(StringFromDate);
	}

	public void enterToDate() throws ParseException {
		String StringToDate = XERO_TO_DATE;
		To.clear();
		To.sendKeys(StringToDate);
	}
	public void clickUpdateButton() {
		UpdateButton.click();
	}

}
