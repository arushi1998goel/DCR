package com.apitest.model;

public class PetsDataModel {

	private String name;
	private String categoryName;
	private String categoryId;
	private String tagName;
	private String status;

	private PetsDataModel(PetsDataModelBuilder builder) {
		this.status = builder.status;
		this.categoryId = builder.categoryId;
		this.categoryName = builder.categoryName;
		this.tagName = builder.tagName;
		this.name = builder.name;
	}

	public String getName() {
		return name;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	
	public String getTagName() {
		return tagName;
	}
	
	public String getStatus() {
		return status;
	}

	public static class PetsDataModelBuilder {

		private String name;
		private String categoryName;
		private String categoryId;
		private String tagName;
		private String status;
		
		public PetsDataModelBuilder(){	
		}
		public PetsDataModelBuilder setName(String name){
			this.name = name;
			return this;
		}

		public PetsDataModelBuilder setCategoryName(String categoryName){
			this.categoryName = categoryName;
			return this;
		}
		
		public PetsDataModelBuilder setCategoryId(String categoryId){
			this.categoryId = categoryId;
			return this;
		}
		
		public PetsDataModelBuilder setTagName(String tagName){
			this.tagName = tagName;
			return this;
		}
		
		public PetsDataModelBuilder setStatus(String status){
			this.status = status;
			return this;
		}

		public PetsDataModel build() {
			return new PetsDataModel(this);
		}
	}
}
