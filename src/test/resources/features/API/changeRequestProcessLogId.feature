Feature: To verify the response for getting a Change Request Process Log by Id
  @TC5
  Scenario Outline: Validate the response fields of Change Request Process Log by Id get api
    Given A request url has been set for getting Change Request Process Log by Id
    When User hit the get api request
    Then Success response should be returned with Status code
    And Validate the response fields "<changeRequestProcessLogId>" "<changeRequestId>" "<statusId>" "<createdById>" "<lastModifiedById>"
    Examples:
      | changeRequestProcessLogId | changeRequestId | statusId | createdById | lastModifiedById |
      |60b2424d-c1e6-45be-b441-2b3ea70a724a|17c73129-8931-4ef3-8ee0-77632c472b58|1|680a3b25-ee02-46f6-92b5-d7ba8c249fcf|680a3b25-ee02-46f6-92b5-d7ba8c249fcf|
