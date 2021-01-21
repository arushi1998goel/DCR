Feature: To verify the response for getting the DCR Azure Scorm Connection String
  @TC16
  Scenario Outline: Validate the response for getting the DCR Azure Scorm Connection String
    Given A request url has been set for getting DCR Azure Scorm Connection String
    When User hit the get api request
    Then Success response should return with Status code and content
    And Validate the data "<content>" in the response
    Examples:
      | content |
      |DefaultEndpointsProtocol=https;AccountName=az1ddcrstgfm;AccountKey=oODSxHvBjUyByubxhA/Ofu1aOEmt0y7reTpD+YcKq7XO3jyNyDn8gcDTklva97XAjPrFzgy0peWoTNOp1HzwkA==;EndpointSuffix=core.windows.net|