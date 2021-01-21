Feature: To verify the response for getting a Change Request Details by Id
  @TC4
  Scenario Outline: Validate the response fields for getting Change Request Details By Id
    Given A request url has been set for getting Change Request Details By Id
    When User hit the get api request
    Then Validate the success response with valid Status code
    And Validate the response data "<id>" "<status>" "<requestedBy>" "<priority>" "<changeRequestNumberDescription>" "<createdById>" "<studyId>" "<siteId>"
    Examples:
      |            id                        |status                |requestedBy    |priority|changeRequestNumberDescription|createdById  |studyId|siteId|
      | 137c9a7b-315d-4dca-a8d8-d29d86495224 |Needs More Information|QCMAPP09 Last09|Expedited|           Request 484       |680a3b25-ee02-46f6-92b5-d7ba8c249fcf|9a11e558-436b-492a-8d03-0d8d3a1a9c68|d107007e-9349-465d-8c37-4d0a72563384|

  @TC4
Scenario Outline: Validate the changeRequestDetails fields in the response for getting Change Request Details By Id
  Given A request url has been set for getting Change Request Details By Id
  When User hit the get api request
  Then Validate the success response with valid Status code
  And Validate changeRequestDetails fields value "<id>" "<type>" "<description>" "<definition>" "<reasonDescription>" "<changeReasonType>"
  Examples:
    | id                                 | type                  | description | definition | reasonDescription | changeReasonType |
    |111ad346-7fdc-4b88-8c05-b72cbf81433c|Add Assessment to Visit|Add assessment to visit description|Add assessment to visit Visit 155 for subject 777|Data protection and privacy is needed for the site work|Privacy and Data Protection|


