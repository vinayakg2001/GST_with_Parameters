package Pages;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.asis.util.BaseClass;
import com.asis.util.ExcelUtil;

import Driver_manager.DriverManager;

public class ATOSelectingQuarterDatePage extends BaseClass{
	// List of WebElements
	@FindBy(xpath = "//div[@class='ato-tab']/ul/li[2]")
	WebElement history;

	@FindBy(xpath = "//h1/span[contains(text(),'Activity statements')]")
	WebElement scrollTo;

	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	WebElement filter;

	@FindBy(xpath = "//input[@id='dp-atoo-as-from-date-002']")
	WebElement From;

	@FindBy(xpath = "//input[@id='dp-atoo-as-to-date-002']")
	WebElement To;

	@FindBy(xpath = "//button[@id='atoo-as-atobutton-016']")
	WebElement filter2;

	// Constructor
	public ATOSelectingQuarterDatePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public void clickHistory() {
		history.click();
	}

	public void clickOnActivityStatementByScrolling() {
		js.executeScript("arguments[0].scrollIntoView(true);", scrollTo);
	}

	public void clickOnFilterButton() {
		js.executeScript("arguments[0].click();", filter);
	}

	public void enterFromoDate() throws ParseException {
		String StringFromDate = ATO_FROM_DATE;
		From.clear();
		From.sendKeys(StringFromDate);
	}

	public void enterToDate() throws ParseException {
		String StringToDate = ATO_TO_DATE;
		To.clear();
		To.sendKeys(StringToDate);
	}


	public void clickOnFilterButtonAfterEnteringDate() throws InterruptedException {
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", filter2);
		Thread.sleep(5000);
	}
}
