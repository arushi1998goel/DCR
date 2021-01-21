package com.sample.apiconstant;

public class GlobalConstant {

	public final static String resource = "src/test/resources/";
	public final static String inputFile = resource + "/inputfiles";
	public final static String outputFile = resource + "jsonfile/output";
	
	// Memos URI  details
	public static final String Root_URI = "v2/pet/";
	public static final String findByStatus = Root_URI+"findByStatus";
	
	// Content Type
	public static final String  Application_JSON= "application/json";
	public static final String  Application_XML= "application/xml";
	
	public enum FileName {

		Pets("pets");

		private String value;

		private FileName(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}

	}

	public enum FileName2 {

		CreateRequest("changeRequestbyID");

		private String value;

		private FileName2(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}
	}
	public enum FileName3 {

		UpdateRequest("updateRequest");

		private String value;

		private FileName3(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}
	}

	public enum FileName4 {

		UpdateChangeRequestIssueInfo("updateChangeRequestIssueInfo");

		private String value;

		private FileName4(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}
	}
	public enum FileName5 {

		updateChangeRequestandPartStatus("updateChangeRequestandPartStatus");

		private String value;

		private FileName5(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}

	}
	public enum FileName6 {

		updateChangeRequestStatus("updateChangeRequestStatus");

		private String value;

		private FileName6(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}

	}
	public enum FileName7 {

		availableActionsForChangeRequest("availableActionsForChangeRequest");

		private String value;

		private FileName7(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}

	}
	public enum FileName8 {

		uploadFile("uploadFile");

		private String value;

		private FileName8(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}

	}
	public enum FileName9 {

		postDataChange("dataChangebyStudyID");

		private String value;

		private FileName9(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}

	}
	public enum FileName10 {

		changeRequestProcessLog("ChangeRequestProcessLogById");

		private String value;

		private FileName10(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}

	}

}
