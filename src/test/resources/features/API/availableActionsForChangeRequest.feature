Feature: To verify the response of the available actions based on the claims for a Change Request
  @TC12
Scenario: Response validation of the available actions based on the claims for a Change Request
Given User enters the request url for the available actions
When User adds the data for the available actions
And User hit the update request for the response of the available actions
Then verify the response code and message for response of the available actions based on the claims for a Change Request