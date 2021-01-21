Feature: To verify the response for deleting a Change Request by Id
  @TC20
  Scenario: Delete a Change Request by Id
    Given Request URL to  Delete a Change Request by Id
    When User enters the required data for Delete Request
    And User hit the delete request for deleting a Change Request by Id
    Then Verify the response code and message for deleting a Change Request by Id