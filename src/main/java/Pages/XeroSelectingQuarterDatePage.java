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

	@FindBy(xpath = "//a[contains(text(),'Activity Statement')]")
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
	}
	public void clickActivityStatement() {
		activitySatement.click();
	}

	public void enterFromoDate() throws ParseException {
		try {
			getQuestAnsw();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateFormat fromDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH); 
		DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date from_date = fromDateFormat.parse(CLIENT_XERO_DATA.get("From date"));

		String StringFromDate = outputFormat.format(from_date);
		From.clear();
		From.sendKeys(StringFromDate);
		try {
			xeroexcel.closeExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterToDate() throws ParseException {
		try {
			getQuestAnsw();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateFormat fromDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH); 
		DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date to_date = fromDateFormat.parse(CLIENT_XERO_DATA.get("To date"));
		String StringToDate = outputFormat.format(to_date);
		To.clear();
		To.sendKeys(StringToDate);
		try {
			xeroexcel.closeExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickUpdateButton() {
		UpdateButton.click();
	}

}
