package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.EnquiryBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class CommercialTab_EnquiryDataProvider {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<EnquiryBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(EnquiryBean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getEmail(); 
			obj[2] = temp.getSubject(); 
			obj[3] = temp.getMessage();  
			result[count ++] = obj; 
		}
		
		
		return result;
	}

}