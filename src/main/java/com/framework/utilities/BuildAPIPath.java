package com.framework.utilities;

import com.apitest.model.PetsStatusModel;
import com.sample.apiconstant.GlobalConstant;

public class BuildAPIPath {

	public static String getPetsUriPath(PetsStatusModel petsStatusModel){
		return GlobalConstant.findByStatus + "?status="+petsStatusModel.getStatus();
	}
	
	public static String getPetsUriPath(String status){
		return GlobalConstant.findByStatus + "?status="+status;
	}
}
