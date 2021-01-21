Feature: Verify response for getting all change request types
  @TC2
  Scenario Outline:Response validation for getting all change request types
    Given User enters the api request url
    When User hit the post request api
    Then Success response should return with Status code
    And Validate the response "<definition>" "<changeRequestTypeId>" "<name>"


    Examples:
      | definition|changeRequestTypeId|name|
      |Assign Rater name to <source_rater_name> for assessment <source_assessment_name> in visit <source_visit_name>| 778c2bff-71d8-4b9b-b1d4-865085a59826|Assign Rater|
      |Regenerate PDF for assessment <source_assessment_name> for visit <source_visit_name> for subject <source_subject>|fd8bd098-b28a-414c-b0a1-6b4f4d130c1c|PDF Regeneration|
      |Remove survey for <source_rater_name> - <source_rater_email> from study <study_id>|b6b7cbd3-6341-470a-a747-619a35ed95c5|Remove Survey|
      |Reprocess visit <source_visit_name> for subject <source_subject>|47fca844-32fb-4936-a102-1a31fda3018d|Reprocess Visit|
      |Unassign Rater name to <source_rater_name> for assessment <source_assessment_name> in visit <source_visit_name>|3c339d3b-af4d-4c13-9f6a-34f911718c59|Unassign Rater|
      |Update feedback to 'Read' for assessment <source_assessment_name>|749bc86a-af46-49d8-be2f-12cc1a8bf68d|Update Feedback to Read|
      |Update Rater name from <from_source_rater_name> to <to_source_rater_name> for assessment <source_assessment_name> in visit <source_visit_name>|b8b70434-397f-44da-b743-ee075339c846|Update Rater Name|
      |Update Screening number from <from_source_screening> to <to_source_screening>|e13cc1fc-e772-46d0-aabb-1d58a3375243|Update Screening Number|
      |Update subject number from <from_source_subject> to <to_source_subject>|ef84670d-9a31-40a6-84ef-6a6eb6d77071|Update Subject Number|
      |Update Randomization Number from <from_source_randomization> to <to_source_randomization>|6373abd1-0016-431b-98a3-ccada615d0ff|Update Subject Randomization Number|
      |Update form culture for assessment <source_assessment_name> to culture <to_culture> for subject <source_subject>|2a03f8e7-fa98-439f-ab0f-9e6e60b04709|Update Virgil Form Culture|
      |Update form version for assessment <source_assessment_name> to version <to_form_version> for subject <source_subject>|749bc86a-af46-49d8-be2f-12cc1a8bf68d|Update Feedback to Read|
      |Update feedback to 'Read' for assessment <source_assessment_name>|dd6779bc-5b25-4c20-b23f-038a795cb984|Update Virgil Form Version|
