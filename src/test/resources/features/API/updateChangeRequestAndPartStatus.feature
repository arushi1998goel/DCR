Feature: To verify the response for updating the Change Request and Part Status from Issue
  @TC10
  Scenario: Updating a Change Request and Part Status from Issue
    Given Request URL to update a change request and part status from issue
    When User update the data for change request and part status from issue
    And User hit the update request for change request and part status
    Then verify the response code and message after updating the the change request and part status from issue