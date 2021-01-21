package com.dcr.datamodel;

public class CreateRequestModel {

    private String studyID ;
    private String siteId;

    public String getStudyID() {
        return studyID;
    }

    public CreateRequestModel setStudyID(String studyID) {
        this.studyID = studyID;
        return this;
    }

    public String getSiteId() {
        return siteId;
    }

    public CreateRequestModel setSiteId(String studyID) {
        this.siteId = studyID;
        return this;
    }
}
