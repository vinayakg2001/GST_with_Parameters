package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Driver_manager.DriverManager;

public class ATOHomePage {
	
	//list of webelements
	@FindBy(xpath = "//input[@type='search']")
    WebElement clientNameSearch;
		
	//constructor
	public ATOHomePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);       
    }
	
	//list  of all the actions on page
	
	public void enterClientName() {
		clientNameSearch.sendKeys("xyz");
	}
	
	public void doSearchClientName() {
		clientNameSearch.sendKeys(Keys.ENTER);
	}
}


