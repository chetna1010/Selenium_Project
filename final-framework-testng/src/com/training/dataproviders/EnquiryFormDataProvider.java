package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;


import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;
public class EnquiryFormDataProvider {

	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\ChetnaGupta\\Documents\\Project\\Selenium Project Documents\\EnquiryFormData.xlsx"; 
		String sheetName="Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}	

}