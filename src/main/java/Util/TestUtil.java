package Util;

import java.util.Hashtable;

import Core.Page;

public class TestUtil extends Page{
	
	
	//Validating if the Run mode in Excel file is set as Yes or No
		public static boolean isExecutable(String tcid, Xls_Reader excel){
			
			for(int rowNum=2; rowNum<=excel.getRowCount("test_suite"); rowNum++){
				if(excel.getCellData("test_suite","TCID", rowNum).equals(tcid)){
					if(excel.getCellData("test_suite","Runmode", rowNum).equalsIgnoreCase("Y")){
						return true;
					}
					else{
						return false;
					}
						
				}
			}
			return false;
		}
		
		
		//TestNG Parameterization
		
		public static Object[][] getData(String testName,Xls_Reader excel){
			
			/*
			 * this will tell you where the test starts from
			 */
			int testCaseStartIndex=0;
			for(int rNum=1;rNum<=excel.getRowCount("test data"); rNum++){
			if(testName.equals(excel.getCellData("test data", 0, rNum))){
			testCaseStartIndex=rNum;
			break;
			} }

			System.out.println("Test Starts from - "+testCaseStartIndex);

			/*
			 * Logic for finding total number of cols in each testcase
			 * 
			 */
			int colStartIndex = testCaseStartIndex+1;
			int cols=0;
			while(!excel.getCellData("test data", cols, colStartIndex).equals("")){

			cols++;
			}
			System.out.println("Total cols are : "+cols);
			
			/*
			 * 
			 * Logic for finding total number of rows in each testcase
			 * 
			 */
			int dataStartIndex = testCaseStartIndex+2;
			int rows=0;
			while(!excel.getCellData("test data", 0, (dataStartIndex+rows)).equals("")){
			rows++;
			}

			System.out.println("Total rows are : "+rows);
			
			/*
			 * 
			 * Print data from the test case
			 * 
			 * 
			 */
			
			Object[][] data = new Object[rows][1];
			Hashtable<String, String> table = null;
			for(int rNum=dataStartIndex; rNum<(dataStartIndex+rows);rNum++){
			table = new Hashtable<String, String>();
			for(int cNum=0; cNum<cols; cNum++){
			table.put(excel.getCellData("test data", cNum, colStartIndex), excel.getCellData("test data", cNum, rNum));
			//System.out.print(excel.getCellData("test data", cNum, rNum)+"---");

			}
			data[rNum-dataStartIndex][0]=table;


			}
			System.out.println(); // Debug at this point
			return data;

			
			
		}


}
