Feature: Verify response for getting all external change request types
  @TC8
  Scenario Outline:Response validation for getting all external change request types
    Given User enters the api request url for external change request
    When User hit the external post request api
    Then Success response should return with valid Status code
    And Validate the fields "<definition>" "<changeRequestTypeId>" "<name>" in the response

    Examples:
    |definition|changeRequestTypeId|name|
    |Add assessment to visit <source_visit_name> for subject <source_subject>|9cae0534-19aa-454f-ae29-3ab062665932|Add Assessment to Visit|
    |Generate scores for assessment <source_assessment_name> for subject <source_subject>|8e562ce7-9d62-41fd-9caf-46f76fcda520|Generate Scores|
    |Move Assessment(s) <from_source_assessment_name> from <from_source_visit_name> to <to_source_visit_name>|7823aef0-33ad-4a26-8295-af7796b65c63|Move Assessment|
    |Move audio/video from visit <from_source_visit_name> in assessment <from_source_assessment_name> to <to_source_visit_name> in assessment <to_source_assessment_name> for subject <to_source_subject>|8ea09ce4-1c24-442d-b0a3-07118f58a2c3|Move Audio/Update Source File|
    |Move survey for <from_source_rater_name> - <from_source_rater_mail> from study <study_id>, site <from_source_site> to <source_rater_name> - <to_source_rater_mail>, study <study_id>, site <to_source_site>|de972552-bc8b-4c51-b211-a78e8d78d5ec|Move Survey|
    |Move visit from <from_source_visit_name> to <to_source_visit_name> for subject <from_source_subject>|c66e5432-8061-4273-b7a4-14280aee0274|Move/Rename Visit|
    |Remove Assessment <source_assessment_name> from <source_visit_name> for <source_subject>|7400b410-67a8-4a3d-b855-e94e48eeb2a9|Remove Assessment|
    |Remove Audio/Video from Assessment <source_assessment_name> for <source_subject>|419cb1e4-a30e-4882-9d44-5d0b567326c2|Remove Audio/Video|
    |Remove from version <source_version_number> from <source_assessment_name> for <source_subject_number>|4efc871a-34b5-4643-b76d-1ded21123bfe|Remove Revision|
    |Remove Subject <source_subject> from Site <source_site> and Study <study_id>|7eb59941-176a-4fe9-b2ef-4bdde78657e3|Remove Subject|
    |Remove Visit <source_visit_name> from Subject <source_subject>|b1017c3a-48bc-4948-9125-75cf3bd4537c|Remove Visit/SVID|
    |Transfer subject <from_source_subject> from <from_source_site> to <to_source_site>|478b4de4-8c73-4313-a5ee-6866546c0138|Transfer Subject Between Sites|
