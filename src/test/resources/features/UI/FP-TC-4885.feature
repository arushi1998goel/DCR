Feature: Verify Virgil user is able to create a single related request 'Generate Scores' DCR

  @UITC18
  Scenario: Verify MA-PP user is able to create a single related request 'Generate Scores' DCR
    Given Log in to the Virgil MA-PP portal with PR1 user.
    Then Go to Navigate and Change Requests.
    And verify Study and Site selector shows.
    Given select the Study and Site.
    Given click on New Change Request 'New Change Request' Icon.
    Then verify the DCR form pop up displays.
    Then verify 'Request Parts' menu with '+ Add a Request Part' button.
    Then verify 'Priority' radio buttons with 'Expedited' field and 'Standard' selected as default.
    Then verify Attachment Upload button.
    Then verify 'Create Change Request' button displays disabled.
    Given Click on '+ Add Related Request'.
    Then verify the Add Request pop up displays.
    Then verify 'Change Type' drop down menu with 'Description' field.
    Then verify 'Reason for Change' menu with 'Reason Description' field.
    Then verify 'Use same reason for all Related Requests' checkbox.
    Then verify 'Add Request' button displays disabled.
    Then verify 'Cancel' button is active.
    Then verify All fields are visually marked as Mandatory Fields.
    Given From the 'Change Type' drop down menu select 'Generate Scores'
    Then verify additional fields Site, Subject #, Visit Name,  Assessment Name, Assessment Started Date/Time, Version Number and SVID displayed.
    Given Enter the description, attempt to enter more than 2000 characters, including alphanumerical and special characters.
    Then verify the description field is editable.
    Then verify the description displays in the description field.
    Then verify the system will allow only the first 2000 characters to be entered in description field.
    Given Fill the Site, Subject, Visit Name, Assessment Name, Assessment Started Date/Time, Version Number and SVID fields.
    Then verify Definition is generated according to this format:'Generate scores for assessment for subject'.
    Then verify Definition displays in 'Definition' field.
    Then Verify The system will allow only the first 100 characters to be entered.
    Given From the 'Reason for Change' drop down menu select 'Reconciliation'.
    Then verify 'Reconciliation' displays in the Reason for Change field.
    Given Enter the reason's description, attempt to enter more than 2000 characters, including alphanumerical and special characters.
    Then verify the reason description field is editable.
    Then verify the reason description displays in the reason description field.
    Then verify the system will allow only the first 2000 characters to be entered in reason description field.
    Given click on 'Add Request' button.
    Then verify 'Add Related Request' form closes.
    Then verify Request Part added displays correctly in the 'Create Change Request' form, including a trash icon next to it.
    Then verify '+ Add Related Request' button displays.
    Then verify 'Create change request' button is enabled as 'Standard' radio button is already selected.
    Given Enter the priority explanation, attempt to enter more than 2000 characters, including alphanumerical and special characters.
    Then verify the explanation displays in the Explain field.
    Then verify the system will allow only the first 2000 characters to be entered in priority expedited field.
    Then verify 'Create Change Request' button enables.
    Given Click on Create Change Request 'Create Change Request' button
    Then verify the ESignature window pop up displays with Username, Password and  Confirm button:
    Given Fill username and password fields with correct credentials and click 'Confirm' button.
    Then verify ESignature window closes.
    Then verify Grid is shown including the new DCR.
    Then verify New DCR has Unique Number ID.
    Then verify New DCR status is 'Under Review'.
