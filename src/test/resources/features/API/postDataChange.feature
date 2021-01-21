Feature: To verify the response for saving or modifying the order of the approvers of a specific study
  @TC14
  Scenario: Create Data Change by Study ID
    Given Request URL to post data change by study ID
    When User add the required data
    And User hit the post request for data change
    Then verify the response code and message for data change by study ID