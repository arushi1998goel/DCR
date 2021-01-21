package com.dcr.datamodel;
import com.dcr.datamodel.DCR_Groups.CreateRequest;
import com.dcr.datamodel.DCR_Groups.UpdateRequest;
import com.epam.ta.reportportal.ws.annotations.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChangeRequestType {
    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String studyID ;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String siteId;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String createdBy;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String changeRequestTypeId;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    public String description;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    public String definition;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String changeReasonTypeId;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String reasonDescription;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String priority;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String priorityDescription;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private boolean draft;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String label;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String key;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String value;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private List<ContextFields> context;


}



