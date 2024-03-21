package MyHooks;

import java.io.IOException;

import com.asis.Excel;
import com.asis.util.BaseClass;
import com.asis.util.ExcelUtil;
import com.asis.util.xeroexcel;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class AppHooks extends BaseClass{

	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Started scenario -"+scenario.getName());
		setProperties();
	}
	
	@Before("@add30SecondWait")
	public void beforeScenariowait30Second() {
		System.out.println("Running after each scenario");
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void afterScenariowait(Scenario scenario) {
		System.out.println("Eneded scenario - "+scenario.getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeStep
	public void waitBeforeEachStep() {
		System.out.println("Running before each step");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
