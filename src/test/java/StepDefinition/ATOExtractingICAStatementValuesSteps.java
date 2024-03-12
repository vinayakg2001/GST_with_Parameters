package StepDefinition;

import Pages.ATOExtractingICAStatementPage;
import Pages.ATOExtractingBASValuesPage;
import io.cucumber.java.en.*;

public class ATOExtractingICAStatementValuesSteps {

	public ATOExtractingICAStatementPage extractValues  = new ATOExtractingICAStatementPage();

	
	@Given("User is on ICA Statement")
	public void user_is_on_ica_statement() {
		System.out.println("ATOExtractingICAStatementPage title"+ ATOExtractingICAStatementPage.getPageTitle());
		
	}

	@When("User extract ICA Statement")
	public void user_extract_ica_statement() {
		extractValues.extractActivityStatement();
	}

	@Then("User close the Tab")
	public void user_close_the_tab() {
		extractValues.closingTabs();
	}
}
