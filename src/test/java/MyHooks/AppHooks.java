package MyHooks;

import java.io.IOException;

import com.asis.util.BaseClass;
import com.asis.util.ExcelUtil;
import com.asis.util.xeroexcel;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class AppHooks extends BaseClass{
	
	@Before("@readATOExcel")
	public void readATOExcel() {
		System.out.println("Reading ato excel ");
		ExcelUtil.readExcel(ATO_FILE_PATH,ATO_FILE_NAME);
		CLIENT_DATA = ExcelUtil.getClientDetail(ATO_CLIENT_SHEET_NAME);
		System.out.println(CLIENT_DATA);
		try {
			ExcelUtil.closeExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Before("@readXEROExcel")
	public void readXEROExcel() {
		System.out.println("Reading xero excel ");
		xeroexcel.readExcel(XERO_FILE_PATH,XERO_FILE_NAME);
		CLIENT_XERO_DATA = xeroexcel.getQuestAnsw(XERO_LOGIN_SHEET_NAME);
		System.out.println(CLIENT_XERO_DATA);
		try {
			xeroexcel.closeExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Before
	public void beforeScenario() {
		System.out.println("Running before each scenario");
		
	}
	
	@After
	public void afterScenario() {
		System.out.println("Running after each scenario");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeStep
	public void waitBeforeEachStep() {
		System.out.println("Running before each step");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
