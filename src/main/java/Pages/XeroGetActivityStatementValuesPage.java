package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class XeroGetActivityStatementValuesPage extends BaseClass{

	@FindBy(xpath = "//tr//descendant::span[contains(text(),'Total sales')]/ancestor::tr/td[3]//descendant::span[1]")
	WebElement G1;
	@FindBy(xpath = "//tr//descendant::span[contains(text(),'GST on sales')]/ancestor::tr/td[3]//descendant::span[1]")
	WebElement A1;
	@FindBy(xpath = "//tr//descendant::span[contains(text(),'GST on purchases')]/ancestor::tr/td[3]//descendant::span[1]")
	WebElement B1;

	// Constructor
	public XeroGetActivityStatementValuesPage() {	
		PageFactory.initElements(DriverManager.getDriver(), this); 
	}
	//list  of all the actions on page
	public static String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	public void captureA1G1B1Data() {
		System.out.println(G1.getText().replaceAll("[,]", ""));
		System.out.println(A1.getText().replaceAll("[,]", ""));
		System.out.println(B1.getText().replaceAll("[,]", ""));
	}
}
