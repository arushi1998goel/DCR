Feature: To verify the response for updating the status of a Change Request
  @TC11
  Scenario: Updating the status of a change request
    Given Request URL to update a change request status
    When User adds the data for updating the change request status
    And User hit the update request to change the status of a Change Request
    Then verify the response code and message for updating the status of a Change Request
