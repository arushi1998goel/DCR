package com.apitest.model;

public class PetsStatusModel {

	private String status;

	private PetsStatusModel(PetsStatusModelBuilder builder) {
		this.status = builder.status;
	}

	public String getStatus() {
		return status;
	}

	public static class PetsStatusModelBuilder {

		private String status;

		public PetsStatusModelBuilder(String status) {
			this.status = status;
		}

		public PetsStatusModel build() {
			return new PetsStatusModel(this);
		}
	}
}
