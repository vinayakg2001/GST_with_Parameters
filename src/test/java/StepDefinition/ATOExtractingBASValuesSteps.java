package StepDefinition;

import javax.mail.MessagingException;

import com.asis.util.BaseClass;
import Pages.ATOExtractingBASValuesPage;
import Pages.pdfFormatPage;
import io.cucumber.java.en.*;

public class ATOExtractingBASValuesSteps {
	public ATOExtractingBASValuesPage dataValues  = new ATOExtractingBASValuesPage();
	public pdfFormatPage pdfFormat  = new pdfFormatPage();


	@Given("All the filtered Quarter are visible to user")
	public void all_the_filtered_quarter_are_visible_to_user() {
//		System.out.println("ATOExtractingBASValuesPage title"+ ATOExtractingBASValuesPage.getPageTitle());
	}

	@When("user click on July Quarter")
	public void user_click_on_quarter() throws InterruptedException, MessagingException {
		dataValues.clickOnJulyQuarter();
		System.out.println("quarter statement");
        String textContent = "Sample text content extracted from activityStatement1 WebElement"; // Replace with your actual text content
        byte[] pdfContent = pdfFormatPage.createPDF(textContent);
        String recipientEmail = BaseClass.SENDER_TO ;  // Replace with recipient's email
        if (pdfContent != null) {
            pdfFormatPage.sendEmailWithAttachment(pdfContent, recipientEmail);
        } else {
            System.out.println("Failed to create PDF content.");
        }
		System.out.println("");
	}

	@Then("July Quarter will get open")
	public void july_quarter_will_get_open() throws MessagingException {
		System.out.println("quarter statement");

	}
	@Given("All the filtered Quarters are visible to user")
	public void all_the_filtered_quarters_are_visible_to_user() {
//		System.out.println("ATOExtractingBASValuesPage title"+ ATOExtractingBASValuesPage.getPageTitle());
	}

	@When("user click on October Quarter")
	public void user_click_on_october_quarter() throws InterruptedException {
		dataValues.clickOnOctQuarter();
		System.out.println("");
	}

	@Then("October Quarter will get open")
	public void october_quarter_will_get_open() {
		System.out.println("quarter statement");
	}

	@Given("All the filtered Quarter are visible to the user")
	public void all_the_filtered_quarter_are_visible_to_the_user() {
//		System.out.println("ATOExtractingBASValuesPage title"+ ATOExtractingBASValuesPage.getPageTitle());
	}

	@When("user click on January Quarter")
	public void user_click_on_january_quarter() throws InterruptedException {
		dataValues.clickOnJanQuarter();
		System.out.println("");
	}

	@Then("January Quarter will get open")
	public void january_quarter_will_get_open() {
		System.out.println("quarter statement");
	}

	@Given("All the filtered Quarters are visible to the user")
	public void all_the_filtered_quarters_are_visible_to_the_user() {
//		System.out.println("ATOExtractingBASValuesPage title"+ ATOExtractingBASValuesPage.getPageTitle());
	}

	@When("user click on April Quarter")
	public void user_click_on_april_quarter() throws InterruptedException {
		dataValues.clickOnAprQuarter();
		System.out.println("");
	}

	@Then("April Quarter will get open")
	public void april_quarter_will_get_open() {
		System.out.println("quarter statement");
	}


	
}
