Feature: To verify the response for creating a Change Request
  @TC6
  Scenario: Create a Change Request
    Given Request URL to create a change request
    When User wants to create a change request with required data passed in body
    And User hit the post request
    Then verify the response code and message
