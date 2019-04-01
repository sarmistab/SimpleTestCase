package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.ContactFormBean;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<ContactFormBean> list = new ELearningDAO().getRealestate(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(ContactFormBean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getEmail(); 
			obj[2] = temp.getMessage();
			obj[3]= temp.getInfo();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Manipal Selenium\\Manipal_Project\\TestData.xlsx"; 
		String sheetname="TC-71";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:\\Manipal Selenium\\Manipal_Project\\TestData.xlsx"; 
		String sheetname="TC-72";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:\\Manipal Selenium\\Manipal_Project\\TestData.xlsx"; 
		String sheetname="TC-74";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
	}
	
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
