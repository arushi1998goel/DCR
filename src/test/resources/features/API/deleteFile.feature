Feature: To verify the response for deleting a file
  @TC15
  Scenario: Delete a File
    Given Request URL to delete a file
    When User wants to delete a file request with required data passed in body
    And User hits the delete file post request
    Then Verify the response body messages