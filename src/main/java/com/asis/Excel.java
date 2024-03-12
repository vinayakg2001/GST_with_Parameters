package com.asis;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.asis.util.BaseClass;



public class Excel {

	public Workbook wb;
	public  Sheet sheet1;
	public  Sheet sheet2;
	public int start_row = 0;
	public int start_col = 0;
	public final int total_col = 14;
	public String[][] col_data = { 
			{ "BAS SUMMARY" },
			{ "Basis:", "Cash" },
			{ "Monthly/", "Income ", "Income", "GST", "Capital", "Purchases ", "GST", "GST", "Wages ", "PAYG", "PAYG ",
				"Fuel", "ATO Total", "ATO Report" },
			{ "Quarterly", "inc GST", "GST Free", "Received", "inc GST", "inc GST", "Paid", "Payment", "XXX",
					"W/holding", "Instalment", "Credit", "Payment" },
			{ "", "(G1)", "(G3)", "(1A)", "(G10)", "(G11)", "(1B)", "Refund", "(W1)", "(4)", "(5A)", "(7D)",
			"Refund" } 

	};
	public ArrayList<String[]> col_data2 = new ArrayList<>();



	public ArrayList<ArrayList<QuaterData>> local_row_data = new ArrayList<>();
	public void print_rowdata() {
//		System.out.println(local_row_data);
		int rowNo = 0;
		for(ArrayList<QuaterData> row : local_row_data) {
			System.out.println(" ROw No "+rowNo);
			rowNo++;
		}
	}
	public void createTest1() {

		Map<Integer, List<String>> tableData = new HashMap<>();

		for (int i = 0; i<col_data.length;i++) { 
			tableData.put(i, new ArrayList<String>(Arrays.asList(col_data[i]))); 
		}

		wb = new HSSFWorkbook(); 
		sheet1 = wb.createSheet("Financial Summary");

		//printing header section
		for(Entry<Integer, List<String>> entry: tableData.entrySet()) { 
			start_row =entry.getKey(); 
			Row row = sheet1.createRow(start_row);

			int col_start = 0; 
			for (String col : entry.getValue()) { 
				Cell cell = row.createCell(col_start);
				cell.setCellValue(col); 
				col_start = col_start+1;
			} 
			while(col_start < total_col) 
			{ 
				Cell cell =  row.createCell(col_start);
				cell.setCellValue(""); 
				col_start = col_start+1; 
			}
		}
		// printing middle section
		for (ArrayList<QuaterData> row : local_row_data) {
			System.out.println(start_row);
			start_row++;
			int col_start = 0;
			Row new_row = sheet1.createRow(start_row);
			for(QuaterData r : row) {

				Cell cell = new_row.createCell(col_start);
				cell.setCellValue(r.getQuarter_name()); 
				col_start =col_start+1;
				System.out.println(col_start);
				Cell cell1 = new_row.createCell(col_start);
				cell1.setCellValue(r.get_G1()); 
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell2 = new_row.createCell(col_start);
				cell2.setCellValue(r.get_G3());
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell3 = new_row.createCell(col_start);
				cell3.setCellValue(r.get_1A());
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell4 = new_row.createCell(col_start);
				cell4.setCellValue(r.get_G10());	
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell5 = new_row.createCell(col_start);
				cell5.setCellValue(r.get_G11());
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell6 = new_row.createCell(col_start);
				cell6.setCellValue(r.get_1B());
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell7 = new_row.createCell(col_start);
				cell7.setCellValue(r.get_GST_Refund());
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell8 = new_row.createCell(col_start);
				cell8.setCellValue(r.get_W1());
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell9 = new_row.createCell(col_start);
				cell9.setCellValue(r.get_4());
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell10 = new_row.createCell(col_start);
				cell10.setCellValue(r.get_5A());
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell11 = new_row.createCell(col_start);
				cell11.setCellValue(r.get_7D());
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell12 = new_row.createCell(col_start);
				cell12.setCellValue(r.get_ATO_Total_Refund());
				col_start =col_start+1; 
				System.out.println(col_start);
				Cell cell13 = new_row.createCell(col_start);
				cell13.setCellValue(r.get_ATO_Reports());
				col_start =col_start+1; 				
			}
		}


		FileOutputStream fileOut; 
		try {
			fileOut = new FileOutputStream("wb.xls");
			wb.write(fileOut); 
			fileOut.close(); 
			wb.close(); 
		} catch(FileNotFoundException e) {// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

	public void createBASSummary(ArrayList<ArrayList<QuaterData>> ato_row_data,
			ArrayList<ArrayList<QuaterData>> p_XERO_DATA, Sheet sheetName
			) {

		Map<Integer, List<String>> tableData = new HashMap<>();
		for (int i = 0; i<col_data2.size();i++) { 
			tableData.put(i, new ArrayList<String>(Arrays.asList(col_data2.get(i)))); 
		}
		//printing header section

		for(Entry<Integer, List<String>> entry: tableData.entrySet()) { 
			start_row =entry.getKey(); 
			Row row = sheet1.createRow(start_row);

			int col_start = 0; 
			for (String col : entry.getValue()) { 
				Cell cell = row.createCell(col_start);
				cell.setCellValue(col); 
				col_start = col_start+1; 
			} 
			while(col_start < total_col) 
			{ 
				Cell cell =  row.createCell(col_start);
				cell.setCellValue(""); 
				col_start = col_start+1; 
			}
		}
		// printing middle section
		for (ArrayList<QuaterData> row : ato_row_data) {
			System.out.println("start_row "+start_row);
			start_row++;
			int col_start = 0;
			Row new_row = sheetName.createRow(start_row);
			for(QuaterData r : row) {
				Cell cell = new_row.createCell(col_start);
				cell.setCellValue(r.getQuarter_name()); 
				col_start =col_start+1;
				System.out.println(r.getQuarter_name());
				Cell cell1 = new_row.createCell(col_start);
				cell1.setCellValue(r.get_G1()); 
				col_start =col_start+1; 
				Cell cell2 = new_row.createCell(col_start);
				cell2.setCellValue(r.get_G3());
				col_start =col_start+1; 
				Cell cell3 = new_row.createCell(col_start);
				cell3.setCellValue(r.get_1A());
				col_start =col_start+1; 
				Cell cell4 = new_row.createCell(col_start);
				cell4.setCellValue(r.get_G10());	
				col_start =col_start+1; 
				Cell cell5 = new_row.createCell(col_start);
				cell5.setCellValue(r.get_G11());
				col_start =col_start+1; 
				Cell cell6 = new_row.createCell(col_start);
				cell6.setCellValue(r.get_1B());
				col_start =col_start+1; 
				Cell cell7 = new_row.createCell(col_start);
				cell7.setCellValue(r.get_GST_Refund());
				col_start =col_start+1; 
				Cell cell8 = new_row.createCell(col_start);
				cell8.setCellValue(r.get_W1());
				col_start =col_start+1; 
				Cell cell9 = new_row.createCell(col_start);
				cell9.setCellValue(r.get_4());
				col_start =col_start+1; 
				Cell cell10 = new_row.createCell(col_start);
				cell10.setCellValue(r.get_5A());
				col_start =col_start+1; 
				Cell cell11 = new_row.createCell(col_start);
				cell11.setCellValue(r.get_7D());
				col_start =col_start+1; 
				Cell cell12 = new_row.createCell(col_start);
				cell12.setCellValue(r.get_ATO_Total_Refund());
				col_start =col_start+1; 
				Cell cell13 = new_row.createCell(col_start);
				cell13.setCellValue(r.get_ATO_Reports());
				col_start =col_start+1; 				
			}
		}

		/*========== Start of total of each column section ===================================*/
		start_row++;
		System.out.println("start_row for total "+start_row);		
		start_col = 0;		
		Row new_row = sheetName.createRow(start_row);

		Cell cell = new_row.createCell(start_col);
		cell.setCellValue("Total for the year");		
		start_col =start_col+1; 

		Cell cell1 = new_row.createCell(start_col);
		cell1.setCellValue(QuaterData.getTotal_of_year_G1());		
		start_col =start_col+1; 

		Cell cell2 = new_row.createCell(start_col);
		cell2.setCellValue(QuaterData.getTotal_of_year_G3());		
		start_col =start_col+1; 

		Cell cell3 = new_row.createCell(start_col);
		cell3.setCellValue(QuaterData.getTotal_of_year_1A());		
		start_col =start_col+1; 

		Cell cell4 = new_row.createCell(start_col);
		cell4.setCellValue(QuaterData.getTotal_of_year_G10());		
		start_col =start_col+1; 

		Cell cell5 = new_row.createCell(start_col);
		cell5.setCellValue(QuaterData.getTotal_of_year_G11());		
		start_col =start_col+1; 

		Cell cell_1B = new_row.createCell(start_col);
		cell_1B.setCellValue(QuaterData.getTotal_of_year_1B());		
		start_col =start_col+1; 

		Cell cell6 = new_row.createCell(start_col);
		cell6.setCellValue(QuaterData.getTotal_of_year_GST_Refund());		
		start_col =start_col+1; 

		Cell cell7 = new_row.createCell(start_col);
		cell7.setCellValue(QuaterData.getTotal_of_year_W1());		
		start_col =start_col+1; 

		Cell cell8 = new_row.createCell(start_col);
		cell8.setCellValue(QuaterData.getTotal_of_year_4());		
		start_col =start_col+1; 

		Cell cell9 = new_row.createCell(start_col);
		cell9.setCellValue(QuaterData.getTotal_of_year_5A());		
		start_col =start_col+1; 

		Cell cell_10 = new_row.createCell(start_col);
		cell_10.setCellValue(QuaterData.getTotal_of_year_7D());		
		start_col =start_col+1; 

		Cell cell_11 = new_row.createCell(start_col);
		cell_11.setCellValue(QuaterData.getTotal_of_year_ATO_Total_Refund());		
		start_col =start_col+1; 

		Cell cell_12 = new_row.createCell(start_col);
		cell_12.setCellValue(QuaterData.getTotal_of_year_ATO_Reports());		
		start_col =start_col+1; 

		/*========== END of total of each column section ===================================*/

		/*=======================Start of EXRO DATA + Variance section ================================*/
		for (ArrayList<QuaterData> row : p_XERO_DATA) {
			System.out.println("start_row xero data"+start_row);
			start_row++;
			int col_start = 0;
			Row xero_row = sheetName.createRow(start_row);
			for(QuaterData r : row) {
				Cell xero_cell = xero_row.createCell(col_start);
				xero_cell.setCellValue(r.getQuarter_name()); 
				col_start =col_start+1;
				System.out.println(r.getQuarter_name());
				Cell xero_cell1 = xero_row.createCell(col_start);
				xero_cell1.setCellValue(r.get_G1()); 
				col_start =col_start+1; 
				Cell xero_cell2 = xero_row.createCell(col_start);
				xero_cell2.setCellValue(r.get_G3());
				col_start =col_start+1; 
				Cell xero_cell3 = xero_row.createCell(col_start);
				xero_cell3.setCellValue(r.get_1A());
				col_start =col_start+1; 
				Cell xero_cell4 = xero_row.createCell(col_start);
				xero_cell4.setCellValue(r.get_G10());	
				col_start =col_start+1; 
				Cell xero_cell5 = xero_row.createCell(col_start);
				xero_cell5.setCellValue(r.get_G11());
				col_start =col_start+1; 
				Cell xero_cell6 = xero_row.createCell(col_start);
				xero_cell6.setCellValue(r.get_1B());
				col_start =col_start+1; 
				Cell xero_cell7 = xero_row.createCell(col_start);
				xero_cell7.setCellValue(r.get_GST_Refund());
				col_start =col_start+1; 
				Cell xero_cell8 = xero_row.createCell(col_start);
				xero_cell8.setCellValue(r.get_W1());
				col_start =col_start+1; 
				Cell xero_cell9 = xero_row.createCell(col_start);
				xero_cell9.setCellValue(r.get_4());
				col_start =col_start+1; 
				Cell xero_cell10 = xero_row.createCell(col_start);
				xero_cell10.setCellValue(r.get_5A());
				col_start =col_start+1; 
				Cell xero_cell11 = xero_row.createCell(col_start);
				xero_cell11.setCellValue(r.get_7D());
				col_start =col_start+1; 
				Cell xero_cell12 = xero_row.createCell(col_start);
				xero_cell12.setCellValue(r.get_ATO_Total_Refund());
				col_start =col_start+1; 
				Cell xero_cell13 = xero_row.createCell(col_start);
				xero_cell13.setCellValue(r.get_ATO_Reports());
				col_start =col_start+1; 				
			}
		}
		/*=======================END of EXRO DATA + Variance section ================================*/

		/*====================Start of last section===================================*/
		start_row +=2;
		Row headRow = sheetName.createRow(start_row);

		Cell headRowCol1 = headRow.createCell(0);
		headRowCol1.setCellValue("BAS not yet Paid/(Received)"); 

		Cell headRowCol2 = headRow.createCell(1);
		headRowCol2.setCellValue("GST");

		for(HashMap<String, Double> entry : BaseClass.LAST_TABLE_DATA) {
			start_row++;

			int col_start = 0;
			Row xero_row = sheetName.createRow(start_row);
			for(String key: entry.keySet()) {
				Cell xero_key = xero_row.createCell(col_start);
				xero_key.setCellValue(key); 
				col_start =col_start+1;

				Cell xero_val = xero_row.createCell(col_start);
				xero_val.setCellValue(entry.get(key));
			}
		}
		/*====================End of last section===================================*/
	}


	public void createFinancialSummaryExcelWithData(
			String fileName, 
			ArrayList<ArrayList<QuaterData>> ato_row_data,
			ArrayList<ArrayList<QuaterData>> p_XERO_DATA, ArrayList<ArrayList<String>> activity_statement_data, 
			String[] client_data
			){

		String[] table_heading = {"BAS SUMMARY"};
		String[] client_name = {"Client:",client_data[0]};
		String[] client_year = {"Year:",client_data[1]};
		String[] basis = {"Basis:","Cash"};


		String[] tableHead1 = { "Monthly/", "Income ", "Income", "GST", "Capital", "Purchases ", "GST", "GST", "Wages ", "PAYG", "PAYG ",
				"Fuel", "ATO Total", "ATO Report" };
		String[] tableHead2 = { "Quarterly", "inc GST", "GST Free", "Received", "inc GST", "inc GST", "Paid", "Payment", "XXX",
				"W/holding", "Instalment", "Credit", "Payment" };
		String[] tableHead3 = { "", "(G1)", "(G3)", "(1A)", "(G10)", "(G11)", "(1B)", "Refund", "(W1)", "(4)", "(5A)", "(7D)",
		"Refund" } ;


		col_data2.add(table_heading);
		col_data2.add(client_name);
		col_data2.add(client_year);
		col_data2.add(basis);
		col_data2.add(tableHead1);
		col_data2.add(tableHead2);
		col_data2.add(tableHead3);

		wb = new HSSFWorkbook(); 
		sheet1 = wb.createSheet("BAS Summary");
		sheet2 = wb.createSheet("ICA Statement");

		createBASSummary(ato_row_data,p_XERO_DATA,sheet1);
		printICAStatementSheet(activity_statement_data,sheet2,client_data);

		FileOutputStream fileOut; 
		try {
			fileOut = new FileOutputStream(fileName);
			wb.write(fileOut); 
			fileOut.close(); 
			wb.close(); 
		} catch(FileNotFoundException e) {// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

	private void printICAStatementSheet(ArrayList<ArrayList<String>> activity_statement_data, Sheet ica_sheet, String[] client_data) {
		// TODO Auto-generated method stub
		int start_row = 0;
		String[][] ica_col_data = { 
				{ "Activity statement" ,"1"},
				{client_data[0]}, 
				{ "Processed Date", "Effective Date","Description", "Debit(DR)","Credit(CR)", "Running Balance" }
		};


		for(int i = 0; i < ica_col_data.length; i++) {
			start_row = i;
			Row row = ica_sheet.createRow(start_row);
			for(int j = 0; j < ica_col_data[i].length; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(ica_col_data[i][j]); 
			}
		}

		for(ArrayList<String> row_data : activity_statement_data) {
			start_row++;
			Row row = ica_sheet.createRow(start_row);
			int cold_start = 0;
			for(String col_data : row_data) {
				Cell cell = row.createCell(cold_start);
				cell.setCellValue(col_data); 
				cold_start++;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Excel obj = new Excel();
		obj.createTest1();
		System.out.println("Done");
	}
}

