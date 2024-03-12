package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.asis.util.BaseClass;
import Driver_manager.DriverManager;

public class XeroSecurityQuestionPage extends BaseClass{

	@FindBy(xpath = "//label[contains(@class,\"auth-firstquestion\")]")
	WebElement firstquestion;

	@FindBy(xpath = "//div[contains(@data-automationid,\"auth-firstanswer\")]/div/input")
	WebElement firstanswer;

	@FindBy(xpath = "//label[contains(@class,\"auth-secondquestion\")]")
	WebElement secondquestion;

	@FindBy(xpath = "//div[contains(@data-automationid,\"auth-secondanswer\")]/div/input")
	WebElement secondanswer;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitAns;

	// Constructor
	public XeroSecurityQuestionPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	public void answerSecurityQuestions() {
		try {
			getQuestAnsw();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ques1 = CLIENT_XERO_DATA.get("Security_qa1");
		String ans1 = CLIENT_XERO_DATA.get("Security_qa1_answer");
		String ques2 = CLIENT_XERO_DATA.get("Security_qs2");
		String ans2 = CLIENT_XERO_DATA.get("Security_qa2_answer");
		String ques3 = CLIENT_XERO_DATA.get("Security_qs3");
		String ans3 = CLIENT_XERO_DATA.get("Security_qa3_answer");
		
		if(firstquestion.getText().equals(ques1)) {
			firstanswer.sendKeys(ans1);
		}
		else if(firstquestion.getText().equals(ques2)) {
			firstanswer.sendKeys(ans2);
		}
		else {
			firstanswer.sendKeys(ans3);
		}

		if(secondquestion.getText().equals(ques1)) {
			secondanswer.sendKeys(ans1);
		}
		else if(secondquestion.getText().equals(ques2)) {
			secondanswer.sendKeys(ans2);
		}
		else {
			secondanswer.sendKeys(ans3);
		}
	}
	public void clickSubmitButton() {
		submitAns.click();
	}
}
