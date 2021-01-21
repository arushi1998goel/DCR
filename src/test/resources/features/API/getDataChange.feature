Feature: To verify the response for getting the order of the approvers of a specific study
  @TC15
  Scenario Outline: Getting the order of the approvers of a specific study
    Given A request url has been set for getting the order of the approvers of a specific study
    When User hit the get api request
    Then Success response should be returned for the study ID
    And Validate the response fields "<site>" "<mapppm>" "<sponsorCRO>" "<mappcds>"
    Examples:
      | site | mapppm | sponsorCRO | mappcds |
      | 0    |  1     |   0       |  2     |