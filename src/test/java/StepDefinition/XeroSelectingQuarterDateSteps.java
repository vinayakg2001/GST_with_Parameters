package StepDefinition;

import java.text.ParseException;

import Pages.XeroSelectingQuarterDatePage;
import io.cucumber.java.en.*;

public class XeroSelectingQuarterDateSteps {

	public XeroSelectingQuarterDatePage xeroselectDate  = new XeroSelectingQuarterDatePage();

	@Given("user is on client home page")
	public void user_is_on_client_home_page() {
//		System.out.println("XeroSelectingQuarterDatePage title" +xeroselectDate.getPageTitle());
	}

	@When("user click on Accounting button")
	public void user_click_on_accounting_button() {
		xeroselectDate.clickAccountingButton();
	}

	@When("User click on activity statement")
	public void user_click_on_activity_statement() {
		xeroselectDate.clickActivityStatement();
	}

	@Then("user is on client Activity statement page")
	public void user_is_on_client_activity_statement_page(){
//		System.out.println("XeroSelectingQuarterDatePage title" +xeroselectDate.getPageTitle());
	}

	@Then("User enter the From date on Xero software")
	public void user_enter_the_from_date_on_xero_software() throws ParseException {
		xeroselectDate.enterFromoDate();
	}

	@Then("User enter the To date on Xero software")
	public void user_enter_the_to_date_on_xero_software() throws ParseException {
		xeroselectDate.enterToDate();
	}

	@Then("User click the update button again")
	public void user_click_the_update_button_again() {
		xeroselectDate.clickUpdateButton();
	}
}
