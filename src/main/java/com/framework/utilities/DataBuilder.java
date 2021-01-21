package com.framework.utilities;

import java.util.ArrayList;
import java.util.List;

import com.apitest.model.PetsDataModel;
import com.apitest.model.PetsStatusModel;

public class DataBuilder {

	String testDataSheet = "TestData.xlsx";

	public List<PetsStatusModel> preparePetsStatusData() {		
		List<PetsStatusModel> petsRequest = new ArrayList<PetsStatusModel>();
		Read_XLS read = new Read_XLS(testDataSheet, "data/");
		Object[][] objs = new Object[read.retrieveNoOfRows("PetStatus") - 1][read.retrieveNoOfCols("PetStatus")];

		objs = read.retrieveTestData1("PetStatus");
		for (Object[] obj : objs) {					
			PetsStatusModel petsModel = new PetsStatusModel.PetsStatusModelBuilder(obj[0].toString()).build();
			
			petsRequest.add(petsModel);
		}
		return petsRequest;
	}
	
	
	public List<PetsDataModel> preparePetsData() {		
		List<PetsDataModel> petsRequest = new ArrayList<PetsDataModel>();
		Read_XLS read = new Read_XLS(testDataSheet, "data/");
		Object[][] objs = new Object[read.retrieveNoOfRows("PetsData") - 1][read.retrieveNoOfCols("PetsData")];

		objs = read.retrieveTestData1("PetsData");
		for (Object[] obj : objs) {					
			PetsDataModel petsModel = new PetsDataModel.PetsDataModelBuilder()
					.setName(obj[0].toString()).setCategoryId(obj[1].toString()).
					setCategoryName(obj[2].toString()).setTagName(obj[3].toString())
					.setStatus(obj[4].toString()).build();			
			petsRequest.add(petsModel);
		}
		return petsRequest;
	}

}
