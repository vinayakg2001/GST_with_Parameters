package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class XeroBalanceSheetPage extends BaseClass{


	@FindBy(xpath = "//button[contains(text(),'Accounting')]")
	WebElement accountingButton;
	@FindBy(xpath = "//a[contains(text(),'Balance Sheet')]")
	WebElement balanceSheet;
	@FindBy(xpath = "//tr//descendant::div[contains(text(),'GST')]/ancestor::tr/td[2]//a")
	WebElement GST;

	// Constructor
	public XeroBalanceSheetPage() {	
		PageFactory.initElements(DriverManager.getDriver(), this); 
	}
	//list  of all the actions on page
	public static String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public void clickOnAccountingButton() {
		accountingButton.click();
	}
	public void clickOnBalanceSheetButton() {
		balanceSheet.click();
	}
	public void fetchingGST() {
		double GST_asperBalanceSheet= Double.parseDouble((GST).getText().replaceAll(",", ""));
		System.out.println(GST_asperBalanceSheet);
	}
}
