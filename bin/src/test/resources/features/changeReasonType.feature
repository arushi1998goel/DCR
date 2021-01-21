Feature: Verify the response for getting all Change Reason Types
  @TC1
  Scenario Outline: Validate the response for getting all Change Reason Types
    Given A request url has been set for getting Change Reason Type
    When User hit the get api request
    Then Success response has been returned with Status code
    And Validate the data "<changeActionId>" "<isStudySpecific>" "<changeReasonTypeId>" "<englishName>"
    Examples:
      |changeActionId|isStudySpecific|changeReasonTypeId|englishName|
      |679f0be0-c067-4c5c-b5f4-a9f440a5ec63|false|b6a77955-8027-4e22-ac7b-c314089d4bc2|Data Entry Error|
      |679f0be0-c067-4c5c-b5f4-a9f440a5ec63|false|442d20c5-e6ba-4a79-b38d-3325d94f9aed|Other|
      |679f0be0-c067-4c5c-b5f4-a9f440a5ec63|false|bb794ca2-4905-483c-a96c-ed7080bf4c58|Privacy and Data Protection|
      |679f0be0-c067-4c5c-b5f4-a9f440a5ec63|false|3b41decf-855f-4dd7-90d6-e682c9714800|Reconciliation|
      |679f0be0-c067-4c5c-b5f4-a9f440a5ec63|false|b2bae154-af47-451a-920e-1c0a206c329d|Sponsor Request|
      |679f0be0-c067-4c5c-b5f4-a9f440a5ec63|false|0e2f2480-e012-4b1e-b60d-a296f6c8e7e6|System Error/Limitation|
