Feature: To verify the response for uploading a change request file to Jira
  @TC15
  Scenario: Uploading a change request file to Jira
    Given Request URL to uploading a change request file to Jira
    When User wants to uploading a change request file to Jira request with required data passed in body
    And User hit the uploading a change request file to Jira Id post request
    Then Verify response body message