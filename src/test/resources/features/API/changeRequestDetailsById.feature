Feature: To verify the response for getting a Change Request Details by Id
  @TC4
  Scenario Outline: Validate the response fields for getting Change Request Details By Id
    Given A request url has been set for getting Change Request Details By Id
    When User hit the get api request
    Then Validate the success response with valid Status code
    And Validate the response data "<id>" "<status>" "<requestedBy>" "<priority>" "<changeRequestNumberDescription>" "<createdById>" "<studyId>" "<siteId>" "<issueKey>"
    Examples:
      |            id                        |status                |requestedBy    |priority|changeRequestNumberDescription|createdById  |studyId|siteId|issueKey|
      | 17c73129-8931-4ef3-8ee0-77632c472b58 |Cancelled        |QCMAPP09 Last09|Standard|          Request 1257       |680a3b25-ee02-46f6-92b5-d7ba8c249fcf|9a11e558-436b-492a-8d03-0d8d3a1a9c68|d107007e-9349-465d-8c37-4d0a72563384|DWP-1257|

  @TC4
Scenario Outline: Validate the changeRequestDetails fields in the response for getting Change Request Details By Id
  Given A request url has been set for getting Change Request Details By Id
  When User hit the get api request
  Then Validate the success response with valid Status code
  And Validate changeRequestDetails fields value "<id>" "<type>" "<description>" "<definition>" "<reasonDescription>" "<changeReasonType>"
  Examples:
    | id                                 | type                  | description | definition | reasonDescription | changeReasonType |
    |aa2df71d-530f-4e90-b9f9-aa120384ad45|Add Assessment to Visit|Add assessment to visit description|Add assessment to visit Visit 155 for subject 777|Data protection and privacy is needed for the site work to proceed|Privacy and Data Protection|


