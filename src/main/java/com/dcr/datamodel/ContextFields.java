package com.dcr.datamodel;
import com.dcr.datamodel.DCR_Groups.CreateRequest;
import com.dcr.datamodel.DCR_Groups.UpdateRequest;
import com.epam.ta.reportportal.ws.annotations.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ContextFields {
    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String label ;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String key;

    @NotEmpty(groups = {CreateRequest.class,
            UpdateRequest.class})
    private String value;

}
