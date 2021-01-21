Feature: To verify the response for uploading a file
  @TC10
  Scenario: Upload a File
    Given Request URL to upload a file
    When User wants to upload a file request with required data passed in body
    And User hits the upload file post request
    Then Verify the response body message