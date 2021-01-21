Feature: To verify the response for getting a Change Request Process Log by Id
  @TC5
  Scenario Outline: Validate the response fields of Change Request Process Log by Id get api
    Given A request url has been set for getting Change Request Process Log by Id
    When User hit the get api request
    Then Success response should be returned with Status code
    And Validate the response fields "<changeRequestProcessLogId>" "<changeRequestId>" "<statusId>" "<createdById>" "<lastModifiedById>"
    Examples:
      | changeRequestProcessLogId | changeRequestId | statusId | createdById | lastModifiedById |
      |829a283d-2bee-438b-91e0-17add81df951|137c9a7b-315d-4dca-a8d8-d29d86495224|1|680a3b25-ee02-46f6-92b5-d7ba8c249fcf|680a3b25-ee02-46f6-92b5-d7ba8c249fcf|
