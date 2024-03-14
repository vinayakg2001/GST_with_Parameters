package StepDefinition;

import Pages.GenratingExcelPage;
import io.cucumber.java.en.*;

public class GenrateExcel {
	GenratingExcelPage genratingExcel = new GenratingExcelPage();
	
	@Given("User end with the process")
	public void user_end_with_the_process() {
		genratingExcel.getXeroData();
	}

	@Then("Genrating the final excel")
	public void genrating_the_final_excel() {
		genratingExcel.generateExcel();
	}
}
