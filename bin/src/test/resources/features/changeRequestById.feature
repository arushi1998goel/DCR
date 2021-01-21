Feature: Verify the response for getting Change Request By Id
  @TC3
  Scenario Outline: Validate the parts fields in the response for getting Change Request By Id
    Given A request url has been set for getting Change Reason Type by id
    When User hit the get api request
    Then Success response has been returned with valid Status code
    And Validate the response of the parts fields "<changeRequestId>" "<parts_id>"  "<changeRequestPartDefinition>" "<description>" "<priority>" "<priorityDescription>" "<studyId>" "<siteId>" "<siteName>" "<studyName>" "<status>"
    Examples:
      | changeRequestId |parts_id |changeRequestPartDefinition|description|priority|priorityDescription|studyId|siteId|siteName|studyName|status|
      |137c9a7b-315d-4dca-a8d8-d29d86495224|111ad346-7fdc-4b88-8c05-b72cbf81433c|Add assessment to visit Visit 155 for subject 777|Add assessment to visit description|2|High priority|9a11e558-436b-492a-8d03-0d8d3a1a9c68|d107007e-9349-465d-8c37-4d0a72563384|1 - QCSiteNine UserL|QC Study 05|Needs More Information|
  @TC3
  Scenario Outline: Validate the changeRequestType fields in the response for getting Change Request By Id
    Given A request url has been set for getting Change Reason Type by id
    When User hit the get api request
    Then Success response has been returned with valid Status code
    And Validate the changeRequestType fields "<changeRequestTypeId>" "<name>"
    Examples:
     |changeRequestTypeId|name|
     |9cae0534-19aa-454f-ae29-3ab062665932|Add Assessment to Visit|

  @TC3
  Scenario Outline: Validate the changeReasonType fields in the response for getting Change Request By Id
    Given A request url has been set for getting Change Reason Type by id
    When User hit the get api request
    Then Success response has been returned with valid Status code
    And Validate the changeReasonType fields "<changeReasonTypeId>" "<englishName>" "<reasonDescription>"
    Examples:
      |changeReasonTypeId|englishName|reasonDescription|
      |bb794ca2-4905-483c-a96c-ed7080bf4c58|Privacy and Data Protection|Data protection and privacy is needed for the site work|
  @TC31
  Scenario Outline: Validate the context fields in the response for getting Change Request By Id
    Given A request url has been set for getting Change Reason Type by id
    When User hit the get api request
    Then Success response has been returned with valid Status code
    And Validate the context fields "<key>" "<label>" "<value>"
    Examples:
    |key|label|value|
    |source_subject|Subject #|777|
    |source_visit_name|Visit Name|Visit 155|
    |source_assessment_name|Assessment Name|Assessment 155|
    |source_site|SVID|999|
