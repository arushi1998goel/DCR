Feature: To verify the response for updating a Change Request
  @TC7
  Scenario: Updating a Change Request
    Given Request URL to update a change request
    When User wants to update a change request with required data passed in body
    And User hit the update request
    Then verify the response code and message after updating the request