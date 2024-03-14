package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asis.util.BaseClass;

import Driver_manager.DriverManager;

public class closingATOPage extends BaseClass{

	@FindBy(xpath = "//table[@class='table']/tbody/tr")
	List<WebElement> tableTr;

	//constructor
	public closingATOPage(){
		PageFactory.initElements(DriverManager.getDriver(), this);       
	}

	//list  of all the actions on page
	public static String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
//
//	public void switchingTabs() {
//		ArrayList<String> tabs = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
//		DriverManager.getDriver().switchTo().window(tabs.get(1));
//	}
	public void closingTabs() {
		/*
		 * ArrayList<String> tabs = new
		 * ArrayList<>(DriverManager.getDriver().getWindowHandles());
		 * DriverManager.getDriver().close();
		 * DriverManager.getDriver().switchTo().window(tabs.get(0));
		 */
		//DriverManager.getDriver().switchTo().window(defaultTab);
	}
	
	public void closeBrowser() {
		DriverManager.getDriver().quit();
	}
}
