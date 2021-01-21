package com.dataproviders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apitest.model.PetsDataModel;
import com.apitest.model.PetsStatusModel;
import com.framework.utilities.DataBuilder;

public class APIDataProviders {

	@DataProvider(name = "GetPetsBy")
	public static Object[][] GetPetsBy() {
		return new Object[][] { 
			{ "pending" }, 
			{ "available" }, 
			{ "sold" }, 
		};
	}
	
	/**
	 * Data provider for pets status
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name = "PetsStatus")
	public Iterator<Object[]> petsStatus() throws IOException {
		Collection<Object[]> requestData = new ArrayList<Object[]>();
		{
			{
				DataBuilder dataBuilder = new DataBuilder();
				List<PetsStatusModel> data = dataBuilder.preparePetsStatusData();
				for (PetsStatusModel petStatus : data) {
					requestData.add(new Object[] { petStatus });
				}
			}
		}

		return requestData.iterator();
	}
	

	/**
	 * Data provider for pets status
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name = "PetsPostData")
	public Iterator<Object[]> petsData() throws IOException {
		Collection<Object[]> requestData = new ArrayList<Object[]>();
		{
			{
				DataBuilder dataBuilder = new DataBuilder();
				List<PetsDataModel> data = dataBuilder.preparePetsData();
				for (PetsDataModel petsData : data) {
					requestData.add(new Object[] { petsData });
				}
			}
		}

		return requestData.iterator();
	}
	
	
	@Test(dataProvider = "PetsPostData")
	public void testData(PetsDataModel data) {	
		
		System.out.println(data.getStatus());
	}

}
