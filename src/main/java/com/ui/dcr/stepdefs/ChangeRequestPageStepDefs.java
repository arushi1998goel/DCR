package com.ui.dcr.stepdefs;
import com.ui.dcr.pages.ChangeRequestPage;
import com.ui.dcr.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class ChangeRequestPageStepDefs{
    public ChangeRequestPage changeRequestPage;
    public LoginPage loginPage ;
    public static WebDriver driver;
    public int requestId;
    public ChangeRequestPageStepDefs(){
        driver = Hooks.getDriver();
        this.changeRequestPage = PageFactory.initElements(driver, ChangeRequestPage.class);
        this.loginPage = new LoginPage(driver);
    }
    String  site = "All the best constol 123456789 []",
            subject = "Value of subject 123456789 []",
            visitName="Visit Name[]",
            AssessmentName="Assessment Name",
            SVID="SVID Number 898989898[]",
            removeDropdownValue = "Remove Subject",
            removeDropdownValue1 = "Remove Visit",
            DropdownValue1 = "Remove Assessment",
            DropdownValue2 = "Remove Audio/Video",
            DropdownValue3 = "Remove survey",
            siteSelect = "Study QC Sponsor Org 05",
            siteSelect1 = "study QC Sponsor Org 05",
            raterName="Rater Name",
            raterEmail="test360@youmail.com",
            versionNumber="456789",
            fromsubject="From Subject Name",
            fromvisitName="From Visit Name",
            fromAssessmentName="from Assessment Name",
            fromSVID="from SVID",
            tosubject="to Subject Name",
            tovisitName="to Visit Name",
            toAssessmentName="to Assessment Name",
            toSVID="to SVID",
            fromStudyName="from Study Name",
            fromSiteName="from Site Name",
            toStudyName="To Study Name",
            toSiteName="To Site NAme",
            fromRaterName="From Rater Name",
            fromRaterEmail="test360@yopmail.com",
            toRaterName="To Rater Email",
            toRaterEmail="test360@yopmail.com",
            fromRandomization="From Randomization Number",
            toRandomization="To Randomization Number",
            fromScreening= "From Screening",
            toScreening="To Screening",
            fromVisitStatus="From Visit Status",
            toVisitStatus="To Visit Status",
            sponsorName="Sponscer Name",
            studyName="Study Name",
            changeFrom="Change From",
            changeTo="Change To",
            subSelct = "QC Study 05";


    @Given("^click on New Change Request 'New Change Request' Icon\\.$")
    public void click_on_New_Change_Request_New_Change_Request_Icon(){
        changeRequestPage.clickOnCreateChangeRequestIcon();

    }

    @Then("^verify the DCR form pop up displays\\.$")
    public void verify_the_DCR_form_pop_up_displays(){
        changeRequestPage.verifyCreateChangeRequestPopTitle();
    }

    @Then("^verify 'Request Parts' menu with '\\+ Add a Request Part' button\\.$")
    public void verify_Request_Parts_menu_with_Add_a_Request_Part_button() {
        changeRequestPage.verifyAddRequestButton();
    }

    @Then("^verify 'Priority' radio buttons with 'Expedited' field and 'Standard' selected as default\\.$")
    public void verify_Priority_radio_buttons_with_Expedited_field_and_Standard_selected_as_default(){
        changeRequestPage.priorityStandardRadioButtonSelected();

    }

    @Then("^verify Attachment Upload button\\.$")
    public void verify_Attachment_Upload_button(){
        changeRequestPage.verifyUploadButton();
    }

    @Then("^verify 'Create Change Request' button displays disabled\\.$")
    public void verify_Create_Change_Request_button_displays_disabled(){
        changeRequestPage.verifyCreateChangeRequestButtonDisabled();
    }

    @Given("^Click on '\\+ Add Related Request'\\.$")
    public void click_on_Add_Related_Request() throws InterruptedException {
        changeRequestPage.clickOnAddRequestButton();
    }

    @Then("^verify the Add Request pop up displays\\.$")
    public void verify_the_Add_Request_pop_up_displays(){
        changeRequestPage.verifyAddRequestPopTitle();
    }

    @Then("^verify 'Change Type' drop down menu with 'Description' field\\.$")
    public void verify_Change_Type_drop_down_menu_with_Description_field(){
        changeRequestPage.verifyChangeTypeDropDown();
    }

    @Then("^verify 'Reason for Change' menu with 'Reason Description' field\\.$")
    public void verify_Reason_for_Change_menu_with_Reason_Description_field(){
        changeRequestPage.verifyDescription();
    }

    @Then("^verify 'Add Request' button displays disabled\\.$")
    public void verify_Add_Request_button_displays_disabled(){
        changeRequestPage.verifyAddRequestButtonDisabled();
    }

    @Then("^verify 'Use same reason for all Related Requests' checkbox\\.$")
    public void verify_Use_same_reason_for_all_Related_Requests_checkbox(){
        changeRequestPage.verifyCheckboxDiplayed();
    }

    @Then("^verify All fields are visually marked as Mandatory Fields\\.$")
    public void verify_All_fields_are_visually_marked_as_Mandatory_Fields(){
        changeRequestPage.verifyAllFieldsMarkedMandatory();
    }
    @Then("^verify 'Cancel' button is active\\.$")
    public void verify_Cancel_button_is_active(){
        changeRequestPage.verifyCancelButton();
    }

    @Given("^From the 'Change Type' drop down menu select 'Remove Subject'$")
    public void from_the_Change_Type_drop_down_menu_select_Remove_Subject(){
        changeRequestPage.selectChangeType();
    }
    @Given("^From the 'Change Type' drop down menu select 'Remove Visit/SVID'$")
    public void from_the_Change_Type_drop_down_menu_select_Remove_Visit_SVID(){
        changeRequestPage.selectChangeTypeDropDown();
    }

    @Given("^From the 'Change Type' drop down menu select 'Remove Assessment'$")
    public void from_the_Change_Type_drop_down_menu_select_Remove_Assessment(){
        changeRequestPage.selectChangeTypeDropDownRemoveAssessment();
    }

    @Given("^From the 'Change Type' drop down menu select 'Remove Audio/Video'$")
    public void from_the_Change_Type_drop_down_menu_select_Remove_Audio_Video(){
        changeRequestPage.selectChangeTypeDropDownRemoveAudioVideo();
    }

    @Given("^From the 'Change Type' drop down menu select 'Remove Survey'$")
    public void from_the_Change_Type_drop_down_menu_select_Remove_Survey(){
        changeRequestPage.selectChangeTypeDropDownRemoveSurvey();
    }
    @Given("^From the 'Change Type' drop down menu select 'Remove Revision'$")
    public void from_the_Change_Type_drop_down_menu_select_Remove_Revision(){
        changeRequestPage.selectChangeTypeDropDownRemoveRevision();
    }

    @Given("^From the 'Change Type' drop down menu select 'Move Assessment'$")
    public void from_the_Change_Type_drop_down_menu_select_Move_Assessment(){
        changeRequestPage.selectChangeTypeDropDownMoveAssessment();
    }

    @Given("^From the 'Change Type' drop down menu select 'Move Audio/Update Source File'$")
    public void from_the_Change_Type_drop_down_menu_select_Move_Audio_Update_Source_File(){
        changeRequestPage.selectChangeTypeDropDownMoveAudioUpdateSourceFile();
    }

    @Given("^From the 'Change Type' drop down menu select 'Move/Rename Visit'$")
    public void from_the_Change_Type_drop_down_menu_select_Move_Rename_Visit(){
        changeRequestPage.selectChangeTypeDropDownMoveRenameVisit();
    }
    @Given("^From the 'Change Type' drop down menu select 'Transfer Subject Between Sites'$")
    public void from_the_Change_Type_drop_down_menu_select_Transfer_Subject_Between_Sites(){
        changeRequestPage.selectChangeTypeDropDownTransferSubjectBetweenSites();
    }

    @Given("^From the 'Change Type' drop down menu select 'Move Survey'$")
    public void from_the_Change_Type_drop_down_menu_select_Move_Survey(){
        changeRequestPage.selectChangeTypeDropDownMoveSurvey();
    }

    @Given("^From the 'Change Type' drop down menu select 'Update Rater Name'$")
    public void from_the_Change_Type_drop_down_menu_select_Update_Rater_Name(){
        changeRequestPage.selectChangeTypeDropDownUpdateRaterName();
    }

    @Given("^From the 'Change Type' drop down menu select 'Update Feedback to Read'$")
    public void from_the_Change_Type_drop_down_menu_select_Update_Feedback_to_Read(){
        changeRequestPage.selectChangeTypeDropDownUpdateFeedbackToRead();
    }

    @Given("^From the 'Change Type' drop down menu select 'Assign Rater'$")
    public void from_the_Change_Type_drop_down_menu_select_Assign_Rater(){
        changeRequestPage.selectChangeTypeDropDownAssignRater();
    }

    @Given("^From the 'Change Type' drop down menu select 'Unassign Rater'$")
    public void from_the_Change_Type_drop_down_menu_select_Unassign_Rater(){
        changeRequestPage.selectChangeTypeDropDownUnassignRater();
    }

    @Given("^From the 'Change Type' drop down menu select 'Update Subject Number'$")
    public void from_the_Change_Type_drop_down_menu_select_Update_Subject_Number(){
        changeRequestPage.selectChangeTypeDropDownUpdateSubjectNumber();
    }

    @Given("^From the 'Change Type' drop down menu select 'Update Subject Randomization Number'$")
    public void from_the_Change_Type_drop_down_menu_select_Update_Subject_Randomization_Number(){
        changeRequestPage.selectChangeTypeDropDownUpdateSubjectRandomizationNumber();
    }

    @Given("^From the 'Change Type' drop down menu select 'Generate Scores'$")
    public void from_the_Change_Type_drop_down_menu_select_Generate_Scores(){
        changeRequestPage.selectChangeTypeDropDownGenerateScores();
    }

    @Given("^From the 'Change Type' drop down menu select 'Update Screening Number'$")
    public void from_the_Change_Type_drop_down_menu_select_Update_Screening_Number(){
        changeRequestPage.selectChangeTypeDropDownUpdateScreeningNumber();
    }

    @Given("^From the 'Change Type' drop down menu select 'Add Assessment to Visit'$")
    public void from_the_Change_Type_drop_down_menu_select_Add_Assessment_to_Visit(){
        changeRequestPage.selectChangeTypeDropDownAddAssessmentToVisit();
    }

    @Given("^From the 'Change Type' drop down menu select 'Update Visit Status'$")
    public void from_the_Change_Type_drop_down_menu_select_Update_Visit_Status(){
        changeRequestPage.selectChangeTypeDropDownUpdateVisitStatus();
    }

    @Given("^From the 'Change Type' drop down menu select 'Update Assessment 'Paper Transcription'$")
    public void from_the_Change_Type_drop_down_menu_select_Update_Assessment_Paper_Transcription(){
        changeRequestPage.selectChangeTypeDropDownUpdateAssessmentPaperTranscription();
    }

    @Given("^From the 'Change Type' drop down menu select 'Update Assessment 'Not Administered/Completed'$")
    public void from_the_Change_Type_drop_down_menu_select_Update_Assessment_Not_Administered_Completed(){
        changeRequestPage.selectChangeTypeDropDownUpdateAssessmentNotAdministeredCompleted();
    }

    @Given("^From the 'Change Type' drop down menu select 'Other'$")
    public void from_the_Change_Type_drop_down_menu_select_Other(){
        changeRequestPage.selectChangeTypeDropDownOther();
    }

    @Then("^verify additional fields Site, Subject, Visit Name, Assessment Name, Assessment Started Start Date/Time and SVID fields displayed\\.$")
    public void verify_additional_fields_Site_Subject_Visit_Name_Assessment_Name_Assessment_Started_Start_Date_Time_and_SVID_fields_displayed(){
        changeRequestPage.verifyAdditionalfieldsSiteSubjectVisitNameAssessmentNameAssessmentStartedStartDateTimeandSVID();
    }

    @Then("^verify additional fields Rater Name and Rater E-mail displayed\\.$")
    public void verify_additional_fields_Rater_Name_and_Rater_E_mail_displayed(){
        changeRequestPage.verifyAdditionalfieldsRaterNameAndRaterEmail();
    }

    @Then("^verify additional fields Site, Subject, Visit Name, Assessment Name, Assessment Started Start Date/Time, Version Number and SVID fields displayed\\.$")
    public void verify_additional_fields_Site_Subject_Visit_Name_Assessment_Name_Assessment_Started_Start_Date_Time_Version_Number_and_SVID_fields_displayed(){
        changeRequestPage.verifyAdditionalfieldsSiteSubjectVisitNameAssessmentNameAssessmentStartedStartDateTimeVersionNumberAndSVID();
    }

    @Then("^verify additional fields Site and Subject displayed\\.$")
    public void verify_additional_fields_Site_and_Subject_displayed(){
        changeRequestPage.verifySubjectAndSite();
    }

    @Then("^verify additional fields Site From: Subject #, Visit Name, Assessment Name, SVID and To: Subject #, Visit Name, Assessment Name, SVID displayed\\.$")
    public void verify_additional_fields_Site_From_Subject_Visit_Name_Assessment_Name_SVID_and_To_Subject_Visit_Name_Assessment_Name_SVID_displayed(){
        changeRequestPage.verifyAdditionalfieldsSiteFromSubjectVisitNameAssessmentNameSVIDAndToSubjectVisitNameAssessmentNameSVID();
    }

    @Then("^additional fields Site From: Subject #, Visit Name, SVID and To: Subject #, Visit Name, SVID displayed\\.$")
    public void additional_fields_Site_From_Subject_Visit_Name_SVID_and_To_Subject_Visit_Name_SVID_displayed(){
        changeRequestPage.verifyAdditionalfieldsSiteFromSubjectVisitNameSVIDAndToSubjectVisitNameSVID();
    }

    @Then("^verify additional fields SVID From: Study, Site, Subject #, Visit Name, Assessment Name and To: Study, Site, Subject #, Visit Name, Assessment Name displayed\\.$")
    public void verify_additional_fields_SVID_From_Study_Site_Subject_Visit_Name_Assessment_Name_and_To_Study_Site_Subject_Visit_Name_Assessment_Name_displayed(){
        changeRequestPage.verifyAdditionalfieldsSVIDFromStudySiteSubjectVisitNameAssessmentNameAndToStudySiteSubjectVisitNameAssessmentName();
    }

    @Then("^additional fields From: Site, Subject # and To: Site, Subject # displayed\\.$")
    public void additional_fields_From_Site_Subject_and_To_Site_Subject_displayed(){
        changeRequestPage.verifyAdditionalfieldsFromSiteSubjectAndToSiteSubject();
    }

    @Then("^verify additional fields Assessment Name from Site, Rater Name, Rater E-mail and to Site, Rater Name, Rater E-mail displayed\\.$")
    public void verify_additional_fields_Assessment_Name_from_Site_Rater_Name_Rater_E_mail_and_to_Site_Rater_Name_Rater_E_mail_displayed(){
        changeRequestPage.verifyAdditionalfieldsAssessmentNameFromSiteRaterNameRaterEmailAndToSiteRaterNameRaterEmailDisplayed();
    }

    @Then("^verify additional fields Site, Subject #, Visit Name,  Assessment Name, SVID from Rater Name and to Rater Name displayed\\.$")
    public void verify_additional_fields_Site_Subject_Visit_Name_Assessment_Name_SVID_from_Rater_Name_and_to_Rater_Name_displayed(){
        changeRequestPage.verifyAdditionalFieldsSiteSubjectVisitNameAssessmentNameSVIDFromRaterNameAndToRaterNameDisplayed();
    }

    @Then("^verify additional fields Site, Subject #, Visit Name,  Assessment Name, Rater Name and SVID displayed\\.$")
    public void verify_additional_fields_Site_Subject_Visit_Name_Assessment_Name_Rater_Name_and_SVID_displayed(){
        changeRequestPage.verifyAdditionalFieldsSiteSubjectVisitNameAssessmentNameRaterNameAndSVIDdisplayed();
    }

    @Then("^verify additional fields Site from Subject # and to Subject # displayed\\.$")
    public void verify_additional_fields_Site_from_Subject_and_to_Subject_displayed(){
        changeRequestPage.verifyAdditionalFieldsSiteFromSubjectAndToSubjectDisplayed();
    }

    @Then("^verify additional fields Site, from Randomization # and to Randomization # displayed\\.$")
    public void verify_additional_fields_Site_from_Randomization_and_to_Randomization_displayed(){
        changeRequestPage.verifyAdditionalFieldsSiteFromRandomizationAndToRandomizationDisplayed();
    }

    @Then("^verify additional fields Site, Subject #, Visit Name,  Assessment Name, Assessment Started Date/Time, Version Number and SVID displayed\\.$")
    public void verify_additional_fields_Site_Subject_Visit_Name_Assessment_Name_Assessment_Started_Date_Time_Version_Number_and_SVID_displayed(){
        changeRequestPage.verifyAdditionalFieldsSiteSubjectVisitNameAssessmentNameAssessmentStartedDateTimeVersionNumberAndSVIDDisplayed();
    }

    @Then("^verify additional fields Site From: Screening # and To: Screening # displayed\\.$")
    public void verify_additional_fields_Site_From_Screening_and_To_Screening_displayed(){
        changeRequestPage.verifyAdditionalFieldsSiteFromScreeningAndToScreeningDisplayed();
    }
    @Then("^verify additional fields Subject #, Visit Name, Assessment Name and SVID displayed\\.$")
    public void verify_additional_fields_Subject_Visit_Name_Assessment_Name_and_SVID_displayed(){
        changeRequestPage.verifyAdditionalFieldsSubjectVisitNameAssessmentNameAndSVIDDisplayed();
    }
    @Then("^verify additional fields Site, Subject #, Visit Name, SVID From Visit Status To Visit Status displayed\\.$")
    public void verify_additional_fields_Site_Subject_Visit_Name_SVID_From_Visit_Status_To_Visit_Status_displayed(){
        changeRequestPage.verifyAdditionalFieldsSiteSubjectVisitNameSVIDFromVisitStatusToVisitStatusDisplayed();
    }

    @Then("^verify additional fields Visit Name,  Assessment Name From: Checked, Unchecked, Date/Time and To Checked, Unchecked, Date/Time displayed\\.$")
    public void verify_additional_fields_Visit_Name_Assessment_Name_From_Checked_Unchecked_Date_Time_and_To_Checked_Unchecked_Date_Time_displayed(){
        changeRequestPage.verifyVisitNameAssessmentNameFromCheckedUncheckedDateTimeAndToCheckedUncheckedDateTimeDisplayed();
    }

    @Then("^verify additional fields Sponsor Name, Study Name, Change From, Change To fields displayed\\.$")
    public void verify_additional_fields_Sponsor_Name_Study_Name_Change_From_Change_To_fields_displayed(){
        changeRequestPage.verifyVisitNameAssessmentNameFromSponsorNameStudyNameChange();
    }

    String desc;
    @Given("^Enter the description, attempt to enter more than (\\d+) characters, including alphanumerical and special characters\\.$")
    public void enter_the_description_attempt_to_enter_more_than_characters_including_alphanumerical_and_special_characters(int arg1){
        desc = "TRTRYRK9pcapHGH50UgW4PLH5CwQIdC46JV8wrMlUUVr3aC7W5xWOcK3u197NbHRAnMYde613SdPtRdL982vfP2GW8clAwOzGsiMsvJwuDBCc4ifuuE0BtyEAAlWRashVnmd1bNHsD3vuQBINNuGEQIgG1GPKzUnuruSXoVo0DNnut0WPCQt47LWAeb4OE2S2fRfCMORlvTeIzXlaFgJZVZIMdew8XV02VDdUAsNtsjYrZVCy04fcw6d4JRCYKHQsG4xaUoZcPAUBGlEvPpdAQNYlYWsOhSxrLgN1oS7mOL5fqPTk17vlwh8DruZH4WWMZLtq9kcw4p8y5bhetGCjKmjZnp4fZOB8mhEH1NRcU9DM5K6TcloFVSTbLm2YgonT4oi1hvYThTQfMNVljWGuzeArOfMDIR9BPUff9mdy1iSO7mzc0JqhChix6SL0P5KQtNPuOwLPgMu6YbDZRGqQ9GM9Q8OfSm3wOER9DSYAZdUdWgiN3zcrQ2UD7bZ3xSGJvDqSIFsaaXmZMHmHkC1IRFwX1fNcYRR1j1EbGzbJRFxMz7YsFHkGCkZRVgflqwnVmNv6WdCavaWyyFTtVAIpT7EqVCqL0H78pI4ZdI2twAkTgmpZTQ1Mo4FrOFa8WmfNBay1wHOUSayg9CrkW83hsj3Vqbs6E1DPDiQOyrPts6LtbwrE5NWoHSQFWxY0rxZTuDFh4FWpLdzPSpv5YNt2PC10cXMWrtPtxxqSI7Og9PrutlEOKvEGoLdKtPlo8T5EgdqI268yBvLoCm1EF1BV1M264abqi75JXMW8kJWCucDW24TdY2YeNp8Ic0hI3J9u42G3UobYIhPmuckXwqcTs8X1BrzvURPPzG1WrPqsYEZgygHlKrZwwd8i0M8r4UBqwvAY12INEGHAVgIEdqlQWUDhJ78QtALQc1QNYYedIvpIEFwGxZd3DiGlXSKXQ3l30yjx9Fxbjcx2vhXqw2JHbM3ZuzKHjuILEIGev1PUYchpe0d92kw4nxJI3w4UiXOfnxEVXo5sCNPiWVMX0XLOVNFfugi0bIoiuH1c73UnUVlcTIHbtFFKpKAErH0TDqvkYpA0pRINkydY17QiQiNWQQ4f0bt3VmXyBMrZFkyu9MdHBVY2SVwmoW4LwpKeuunxzJgyiVCQ7eziOj1RyaRX2hjRz26PGOpxSje119KAuxk53Mzv3aya631fO3yLJyTsdHNR2uYiPP3UNjDQGBKm6yTEXFCCEPvXBKQj2g7iUCQqebAtO9oVQBp0Auhqs1oxyCXGgQHUCo2fDvq32J1d1GzJOcyI7uacMrLQSMoZbXgD0MrUm2KbPkbn5CC7vZekIsBL57bEfuW8U2mW7TRo4m9tVvynaWAmC05OK2HQEcJyuYUcBFnf3C8qhJqrP29k9V2YrRXoR7sODBWu22rM62l1OezcUNOYT0q5pnwRSoUakuFvLhEI1hEFzNZYdQV4crx9sFQM1H9K33jtuM0TZ7yhVI84cSbR6tKr5iIZ3nPnaxgreKK1WxsbGzXds9xIq6tTfz3AuU708AYELgoOKhP8f94Bgp8bVkpZWXIUdSsBLGCiA3lW9Zu38zcfdxduPkCzqDRgm2HAVb8i1BzACpCkdxTAV28JIhjeWpwfEX5CO0j7T4gz9XLr3DBz6ML07gN3pzB10JgqdLGS9jkbzzxmydhzYjfH2L0820heIBkgpLGtajkxRyyP1OG4mOm2NrlEoMLWSx5cxAPL2ZMj8BEpjY8zscOe91ZcsRRs9YwAJrsoI765bGAjBewltqgROzmkZTSGrNde5OkOwLvux8Yx3otvFFBnZjvoo1YuwST7r3CAkXa6uknpEYbQS0HosakpKFrTDzsgPKz35degdJFpHAWX4VrAIlcA8iozWkjmwshRxJRC9pN4fTn6XTsLasn@~!@#$#$#$#%%$^%^%&^&*^*&&*&*&((*(+_+_)_)_)_()(*(*(&*(&*&*&<><??)_+HJJKKJLLJLJOIOU";
        changeRequestPage.enterDescriptionField(desc);
        changeRequestPage.verifyDescriptionInvalid(false);

        desc ="demo text";
        changeRequestPage.enterDescriptionField(desc);
        changeRequestPage.verifyDescriptionInvalid(true);
    }

    @Then("^verify the description field is editable\\.$")
    public void verify_the_description_field_is_editable(){
        changeRequestPage.verifyDescriptionIsEditable();
    }

    @Then("^verify the description displays in the description field\\.$")
    public void verify_the_description_displays_in_the_description_field(){
        changeRequestPage.verifyDescriptionFiledDisplayedInDescriptionField();
    }

    @Then("^verify the system will allow only the first (\\d+) characters to be entered in description field\\.$")
    public void verify_the_system_will_allow_only_the_first_characters_to_be_entered_in_description_field(int arg1){
        changeRequestPage.verifyDescriptionFiledAllowOnlyFirstTwoThousandCharacter(desc);
    }

    @Given("^Fill the Site and Subject fields\\.$")
    public void fill_the_Site_and_Subject_fields(){
        changeRequestPage.enterSiteAndSubjeExpeditedctField(site, subject);
    }
    @Then("^verify additional fields Site, Subject, Visit Name, Visit Start Date and SVID fields displayed\\.$")
    public void verify_additional_fields_Site_Subject_Visit_Name_Visit_Start_Date_and_SVID_fields_displayed(){
        changeRequestPage.verifySiteSubjectVisitNameVisitStartDateAndSVID();

    }
    @Given("^Fill the Site, Subject, Visit Name, Visit Start Date and SVID fields\\.$")
    public void fill_the_Site_Subject_Visit_Name_Visit_Start_Date_and_SVID_fields(){
        changeRequestPage.enterSiteAndSubjectField(site,subject, visitName, SVID);
    }

    @Given("^Fill the Site, Subject, Visit Name, Assessment Name, Assessment Started Date/Time and SVID fields\\.$")
    public void fill_the_Site_Subject_Visit_Name_Assessment_Name_Assessment_Started_Date_Time_and_SVID_fields(){
        changeRequestPage.enterSiteSubjectVisitNameAssessmentNameAssessmentStartedDateTimeandSVID(site,subject, visitName,AssessmentName, SVID);
    }

    @Given("^Fill the Site, Subject, Visit Name, Assessment Name, Assessment Started Date/Time, Version Number and SVID fields\\.$")
    public void fill_the_Site_Subject_Visit_Name_Assessment_Name_Assessment_Started_Date_Time_Version_Number_and_SVID_fields(){
        changeRequestPage.enterSiteSubjectVisitNameAssessmentNameAssessmentStartedDateTimeVersionNumberAndSVID(site,subject, visitName,AssessmentName,versionNumber, SVID);
    }

    @Given("^Fill the Rater Name and Rater E-mail fields\\.$")
    public void fill_the_Rater_Name_and_Rater_E_mail_fields(){
        changeRequestPage.enterRaterNameAndRaterEmail(raterName, raterEmail);
    }
    @Given("^Fill the Site From: Subject #, Visit Name, Assessment Name, SVID and To: Subject #, Visit Name, Assessment Name, SVID fields\\.$")
    public void fill_the_Site_From_Subject_Visit_Name_Assessment_Name_SVID_and_To_Subject_Visit_Name_Assessment_Name_SVID_fields(){
        changeRequestPage.enterSiteFromSubjectVisitNameAssessmentNameSVIDAndToSubjectVisitNameAssessmentNameSVID(site,fromsubject, fromvisitName,fromAssessmentName, fromSVID, tosubject, tovisitName,toAssessmentName, toSVID);
    }

    @Given("^Fill the Site From: Subject #, Visit Name, SVID and To: Subject #, Visit Name, SVID fields\\.$")
    public void fill_the_Site_From_Subject_Visit_Name_SVID_and_To_Subject_Visit_Name_SVID_fields(){
        changeRequestPage.enterSiteFromSubjectVisitNameSVIDAndToSubjectVisitNameSVID(site,fromsubject, fromvisitName,fromSVID, tosubject, tovisitName,toSVID);
    }

    @Given("^Fill the SVID From: Study, Site, Subject #, Visit Name, Assessment Name and To: Study, Site, Subject #, Visit Name, Assessment Name fields\\.$")
    public void fill_the_SVID_From_Study_Site_Subject_Visit_Name_Assessment_Name_and_To_Study_Site_Subject_Visit_Name_Assessment_Name_fields(){
        changeRequestPage.enterSVIDFromStudySiteSubjectVisitNameAssessmentNameAndToStudySiteSubjectVisitNameAssessmentNameFields(SVID, fromStudyName, fromSiteName, fromsubject, fromvisitName, fromAssessmentName, toStudyName, toSiteName, tosubject, tovisitName, toAssessmentName );
    }

    @Given("^Fill the fields From: Site, Subject # and To: Site, Subject #\\.$")
    public void fill_the_fields_From_Site_Subject_and_To_Site_Subject(){
        changeRequestPage.enterFromSiteSubjectAndToSiteSubject(fromSiteName, fromsubject, toSiteName, tosubject );
    }

    @Given("^Fill the Assessment Name from Site, Rater Name, Rater E-mail and to Site, Rater Name, Rater E-mail displayed\\.$")
    public void fill_the_Assessment_Name_from_Site_Rater_Name_Rater_E_mail_and_to_Site_Rater_Name_Rater_E_mail_displayed(){
        changeRequestPage.enterAssessmentNameFromSiteRaterNameRaterEmailAndToSiteRaterNameRaterEmail(AssessmentName, fromSiteName, fromRaterName, fromRaterEmail, toSiteName, toRaterName, toRaterEmail);
    }

    @Given("^Fill the Site, Subject #, Visit Name,  Assessment Name, SVID from Rater Name and to Rater Name\\.$")
    public void fill_the_Site_Subject_Visit_Name_Assessment_Name_SVID_from_Rater_Name_and_to_Rater_Name(){
        changeRequestPage.enterSiteSubjectVisitNameAssessmentNameSVIDFromRaterNameAndToRaterName(site, subject, visitName, AssessmentName, SVID, fromRaterName, toRaterName);
    }
    @Given("^Fill the Site, Subject #, Visit Name,  Assessment Name, Rater Name and SVID\\.$")
    public void fill_the_Site_Subject_Visit_Name_Assessment_Name_Rater_Name_and_SVID(){
        changeRequestPage.enterSiteSubjectVisitNameAssessmentNameRaterNameAndSVID(site, subject, visitName, AssessmentName, raterName , SVID);
    }

    @Given("^Fill the Site from Subject # and to Subject # displayed fields\\.$")
    public void fill_the_Site_from_Subject_and_to_Subject_displayed_fields(){
        changeRequestPage.enterSiteFromSubjectAndToSubject(site, fromsubject, tosubject);
    }

    @Given("^Fill the Site, from Randomization # and to Randomization #\\.$")
    public void fill_the_Site_from_Randomization_and_to_Randomization(){
        changeRequestPage.enterSiteFromRandomizationAndToRandomization(site, fromRandomization, toRandomization);
    }
    @Given("^Fill the fields Site From: Screening # and To: Screening #\\.$")
    public void fill_the_fields_Site_From_Screening_and_To_Screening(){
        changeRequestPage.enterSiteFromSiteFromScreeningAndToScreening(site, fromScreening, toScreening);
    }

    @Given("^Fill the Subject #, Visit Name, Assessment Name and SVID fields\\.$")
    public void fill_the_Subject_Visit_Name_Assessment_Name_and_SVID_fields(){
        changeRequestPage.enterSubjectVisitNameAssessmentNameAndSVIDFields(subject, visitName, AssessmentName, SVID);
    }

    @Given("^Fill the Site, Subject #, Visit Name, SVID From Visit Status To Visit Status\\.$")
    public void fill_the_Site_Subject_Visit_Name_SVID_From_Visit_Status_To_Visit_Status(){
        changeRequestPage.enterSiteSubjectVisitNameSVIDFromVisitStatusToVisitStatusFields(site, subject, visitName, SVID, fromVisitStatus, toVisitStatus);
    }

    @Given("^Fill the Visit Name, Assessment Name From Date/Time To Date/Time and Check one of the following option From \\(Checked, Unchecked\\) in both From and To section:$")
    public void fill_the_Visit_Name_Assessment_Name_From_Date_Time_To_Date_Time_and_Check_one_of_the_following_option_From_Checked_Unchecked_in_both_From_and_To_section() throws Exception {
        changeRequestPage.enterVisitNameAssessmentNameFromDateTimeToDateTimeAndCheckFromCheckedUncheckedInFromAndToSection(visitName, AssessmentName);
    }

    @Given("^Fill the Sponsor Name, Study Name, Change From, Change To fields:$")
    public void fill_the_Sponsor_Name_Study_Name_Change_From_Change_To_fields(){
        changeRequestPage.enterSponsorNameStudyNameChangeFromChangeToFields(sponsorName, studyName, changeFrom, changeTo);
    }

    @Then("^verify Definition is generated according to this format: Remove Subject from Site and Study\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Remove_Subject_from_Site_and_Study(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingChangeTypeSiteAndSubject(removeDropdownValue, site, subject, siteSelect, subSelct);
    }
    @Then("^verify Definition is generated according to this format 'Remove Visit from Subject '\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Remove_Visit_from_Subject() {
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingChangeTypeRemoveVisitFromSubject(removeDropdownValue1, visitName, subject);
    }
    @Then("^verify Definition is generated according to this format: Remove Assessment\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Remove_Assessment(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingChangeTypeRemoveAssessment(DropdownValue1, AssessmentName, visitName, subject);
    }

    @Then("^verify Definition is generated according to this format: 'Remove Audio/Video' from Assessment\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Remove_Audio_Video_from_Assessment(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingChangeTypeRemoveAudioVideo(DropdownValue2, AssessmentName, subject);
    }

    @Then("^verify Definition is generated according to this format: 'Remove Survey' from Assessment\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Remove_Survey_from_Assessment(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingChangeTypeRemoveSurvey(DropdownValue3, raterName, raterEmail, siteSelect1, subSelct);
    }

    @Then("^verify Definition is generated according to this format: 'Remove from version' from 'Assessment Name' for 'Subject'\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Remove_from_version_from_Assessment_Name_for_Subject(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingChangeTypeRemoveFromVersion(versionNumber, AssessmentName, subject);
    }
    @Then("^Definition is generated according to this format: 'Move Assessment\\(s\\) from <'from' visit name> to <'to' visit name>'\\.$")
    public void definition_is_generated_according_to_this_format_Move_Assessment_s_from_from_visit_name_to_to_visit_name(){
//        System.exit(0);
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatMoveAssessment(fromAssessmentName, fromvisitName, tovisitName);
    }

    @Then("^verify Definition is generated according to this format: 'Move visit from <'from' visit name> to <'to' visit name> for subject'\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Move_visit_from_from_visit_name_to_to_visit_name_for_subject(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatMoveVisitFromVisitNameForSubject(fromvisitName, tovisitName, fromsubject);
    }

    @Then("^verify Definition is generated according to this format: 'Move audio/video from visit <'from' visit name> in assessment <'from' assessment name> to <'to' visit name> in assessment <'to' assessment name> for subject'\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Move_audio_video_from_visit_from_visit_name_in_assessment_from_assessment_name_to_to_visit_name_in_assessment_to_assessment_name_for_subject(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatMoveAudioVideoFromVisitFromVisitNameInAssessmentFromAssessmentNameToToVisitNameInAssessmentToAssessmentNameForSubjec(fromvisitName, fromAssessmentName,tovisitName, toAssessmentName, tosubject);
    }

    @Then("^verify Definition is generated according to this format: 'Transfer subject from <'from' site> to <'to' site>'\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Transfer_subject_from_from_site_to_to_site(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatTransferSubjectFromFromSiteToToSite(fromsubject, fromSiteName,toSiteName);
    }
    @Then("^verify Definition is generated according to this format: 'Move survey for - < rater email> from study , site to - < rater email>, study , site'\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Move_survey_for_rater_email_from_study_site_to_rater_email_study_site(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatMovesurveyForRaterEmailFromStudySiteToRaterEmailStudySite(fromRaterName, fromRaterEmail, siteSelect1, subSelct, fromSiteName, toRaterName, toRaterEmail, toSiteName);
    }

    @Then("^verify Definition is generated according to this format: 'Update Rater name from Rater Name and to Rater Name\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Update_Rater_name_from_Rater_Name_and_to_Rater_Name(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatUpdateRaterName(fromRaterName, toRaterName, AssessmentName, visitName);
    }

    @Then("^verify Definition is generated according to this format: 'Update feedback to Read'\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Update_feedback_to_Read(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToFormatUpdateFeedbackToRead(AssessmentName);
    }

    @Then("^Definition is generated according to this format: 'Assign Rater name to <'rater name'> for assessment <'assessment name'> in visit <'visit name'>'\\.$")
    public void definition_is_generated_according_to_this_format_Assign_Rater_name_to_rater_name_for_assessment_assessment_name_in_visit_visit_name(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToFormatAssignRaterName(raterName, AssessmentName, visitName);
    }

    @Then("^Definition is generated according to this format: 'Unassign Rater name for assessment in visit'\\.$")
    public void definition_is_generated_according_to_this_format_Unassign_Rater_name_for_assessment_in_visit(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToFormatUnassignRaterNameForAssessmentInVisit(raterName, AssessmentName, visitName);
    }

    @Then("^verify Definition is generated according to this format:'Update subject number' from <'from' subject #> to <'to' subject #>\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Update_subject_number_from_from_subject_to_to_subject(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToUpdateSubjectNumber(fromsubject, tosubject);
    }

    @Then("^verify Definition is generated according to this format: 'Update Randomization Number from < 'from' randomization #> to <'to' randomization #>'\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Update_Randomization_Number_from_from_randomization_to_to_randomization(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToUpdateRandomizationNumber(fromRandomization, toRandomization);
    }

    @Then("^verify Definition is generated according to this format:'Generate scores for assessment for subject'\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Generate_scores_for_assessment_for_subject(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatGenerateScoresForAssessmentForSubject(AssessmentName, subject);
    }

    @Then("^verify Definition is generated according to this format: 'Update Screening number from < 'from' screening #> to <'to' screening #>'\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Update_Screening_number_from_from_screening_to_to_screening(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatUpdateScreeningNumber(fromScreening, toScreening);
    }
    @Then("^verify Definition is generated according to this format:'Add assessment to visit <'visit name'> for subject <'subject #'>\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Add_assessment_to_visit_visit_name_for_subject_subject(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatAddAssessmentToVisit(visitName, subject);
    }
    @Then("^verify Definition is generated according to this format: 'Update Visit Status for subject <'subject number'> for visit <'visit'> from Visit Status <'VisitStatus'> to <'VisitStatus'>'\\.$")
    public void verify_Definition_is_generated_according_to_this_format_Update_Visit_Status_for_subject_subject_number_for_visit_visit_from_Visit_Status_VisitStatus_to_VisitStatus(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatUpdateVisitStatus(subject, visitName, fromVisitStatus, toVisitStatus);
    }

    @Then("^Definition is generated according to this format: 'Update Assessment 'Paper Transcription' from <'Date/Time'> to <'Date/Time'> from Current Status <'Flag State'> to <'Flag State'> for assessment in visit'\\.$")
    public void definition_is_generated_according_to_this_format_Update_Assessment_Paper_Transcription_from_Date_Time_to_Date_Time_from_Current_Status_Flag_State_to_Flag_State_for_assessment_in_visit(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatUpdateAssessmentPaperTranscription(AssessmentName, visitName);
    }


    @Then("^Definition is generated according to this format: 'Update information for Client Study from to'\\.$")
    public void definition_is_generated_according_to_this_format_Update_information_for_Client_Study_from_to(){
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatUpdateInformationForClientStudy(AssessmentName, visitName);
    }
    @Then("^Definition is generated according to this format: \"([^\"]*)\"\\.$")
    public void definition_is_generated_according_to_this_format(String arg1) throws Throwable {
        changeRequestPage.verifyDefinitionFieldGeneratedAccordingToThisFormatOther(sponsorName, studyName, changeFrom, changeTo);
    }

    @Then("^verify Definition displays in 'Definition' field\\.$")
    public void verify_Definition_displays_in_Definition_field(){
        changeRequestPage.verifyDefinitionFiledDisplayedInDefinitionField();
    }

    @Then("^Verify The system will allow only the first (\\d+) characters to be entered\\.$")
    public void verify_The_system_will_allow_only_the_first_characters_to_be_entered(int arg1){
        changeRequestPage.verifyDefinitionFiledAllowOnlyFirstHundredCharacter();
    }

    @Given("^From the 'Reason for Change' drop down menu select 'Data Entry Error'\\.$")
    public void from_the_Reason_for_Change_drop_down_menu_select_Data_Entry_Error(){
        changeRequestPage.selectReasonTypes();
    }
    @Given("^From the 'Reason Types' drop down menu select 'Privacy and Data Protection'$")
    public void from_the_Reason_Types_drop_down_menu_select_Privacy_and_Data_Protection(){
        changeRequestPage.selectReasonTypesDropDown();
    }

    @Given("^From the 'Reason for Change' drop down menu select 'Reconciliation'\\.$")
    public void from_the_Reason_for_Change_drop_down_menu_select_Reconciliation(){
        changeRequestPage.selectReasonTypesDropDownReconciliation();
    }

    @Given("^From the 'Reason Types' drop down menu select 'Other'$")
    public void from_the_Reason_Types_drop_down_menu_select_Other(){
        changeRequestPage.selectReasonTypesDropDownOther();

    }
    @Given("^From the 'Reason Types' drop down menu select 'Sponsor Request'$")
    public void from_the_Reason_Types_drop_down_menu_select_Sponsor_Request(){
        changeRequestPage.selectReasonTypesDropDownSponsorRequest();
    }
    @Given("^From the 'Reason Types' drop down menu select 'System Error / Limitation'\\.$")
    public void from_the_Reason_Types_drop_down_menu_select_System_Error_Limitation(){
        changeRequestPage.selectReasonTypesDropDownSystemErrorLimitation();
    }

    @Then("^verify 'Privacy and Data Protection' displays in the 'Reason Types' field\\.$")
    public void verify_Privacy_and_Data_Protection_displays_in_the_Reason_Types_field() throws Throwable {
        changeRequestPage.verifyPrivacyAndDataProtectionDisplayedInReasonTypes();
    }

    @Then("^verify 'Data Entry Error' displays in the Reason for Change field\\.$")
    public void verify_Data_Entry_Error_displays_in_the_Reason_for_Change_field(){
        changeRequestPage.verifyDataEntryErrorDisplayedInReasonTypes();
    }

    @Then("^verify 'Reconciliation' displays in the Reason for Change field\\.$")
    public void verify_Reconciliation_displays_in_the_Reason_for_Change_field(){
        changeRequestPage.verifyReconciliationDisplayedInReasonTypes();
    }

    @Then("^verify 'Other' displays in the 'Reason Types' field\\.$")
    public void verify_Other_displays_in_the_Reason_Types_field(){
        changeRequestPage.verifyOtherDisplayedInReasonTypes();
    }

    @Then("^verify 'Sponsor Request' displays in the 'Reason Types' field\\.$")
    public void verify_Sponsor_Request_displays_in_the_Reason_Types_field(){
        changeRequestPage.verifySponsorRequestDisplayedInReasonTypes();
    }

    @Then("^verify 'System Error / Limitation' displays in the Reason for Change field\\.$")
    public void verify_System_Error_Limitation_displays_in_the_Reason_for_Change_field(){
        changeRequestPage.verifySystemErrorLimitationDisplayedInReasonTypes();
    }
    String reasonDesc;
    @Given("^Enter the reason's description, attempt to enter more than (\\d+) characters, including alphanumerical and special characters\\.$")
    public void enter_the_reason_s_description_attempt_to_enter_more_than_characters_including_alphanumerical_and_special_characters(int arg1){
        reasonDesc = "#@$$#%$$%$^%^%&^&^*&*&(&(*&(&)(+_)+)+(+K9pcapHGH50UgW4PLH5CwQIdC46JV8wrMlUUVr3aC7W5xWOcK3u197NbHRAnMYde613SdPtRdL982vfP2GW8clAwOzGsiMsvJwuDBCc4ifuuE0BtyEAAlWRashVnmd1bNHsD3vuQBINNuGEQIgG1GPKzUnuruSXoVo0DNnut0WPCQt47LWAeb4OE2S2fRfCMORlvTeIzXlaFgJZVZIMdew8XV02VDdUAsNtsjYrZVCy04fcw6d4JRCYKHQsG4xaUoZcPAUBGlEvPpdAQNYlYWsOhSxrLgN1oS7mOL5fqPTk17vlwh8DruZH4WWMZLtq9kcw4p8y5bhetGCjKmjZnp4fZOB8mhEH1NRcU9DM5K6TcloFVSTbLm2YgonT4oi1hvYThTQfMNVljWGuzeArOfMDIR9BPUff9mdy1iSO7mzc0JqhChix6SL0P5KQtNPuOwLPgMu6YbDZRGqQ9GM9Q8OfSm3wOER9DSYAZdUdWgiN3zcrQ2UD7bZ3xSGJvDqSIFsaaXmZMHmHkC1IRFwX1fNcYRR1j1EbGzbJRFxMz7YsFHkGCkZRVgflqwnVmNv6WdCavaWyyFTtVAIpT7EqVCqL0H78pI4ZdI2twAkTgmpZTQ1Mo4FrOFa8WmfNBay1wHOUSayg9CrkW83hsj3Vqbs6E1DPDiQOyrPts6LtbwrE5NWoHSQFWxY0rxZTuDFh4FWpLdzPSpv5YNt2PC10cXMWrtPtxxqSI7Og9PrutlEOKvEGoLdKtPlo8T5EgdqI268yBvLoCm1EF1BV1M264abqi75JXMW8kJWCucDW24TdY2YeNp8Ic0hI3J9u42G3UobYIhPmuckXwqcTs8X1BrzvURPPzG1WrPqsYEZgygHlKrZwwd8i0M8r4UBqwvAY12INEGHAVgIEdqlQWUDhJ78QtALQc1QNYYedIvpIEFwGxZd3DiGlXSKXQ3l30yjx9Fxbjcx2vhXqw2JHbM3ZuzKHjuILEIGev1PUYchpe0d92kw4nxJI3w4UiXOfnxEVXo5sCNPiWVMX0XLOVNFfugi0bIoiuH1c73UnUVlcTIHbtFFKpKAErH0TDqvkYpA0pRINkydY17QiQiNWQQ4f0bt3VmXyBMrZFkyu9MdHBVY2SVwmoW4LwpKeuunxzJgyiVCQ7eziOj1RyaRX2hjRz26PGOpxSje119KAuxk53Mzv3aya631fO3yLJyTsdHNR2uYiPP3UNjDQGBKm6yTEXFCCEPvXBKQj2g7iUCQqebAtO9oVQBp0Auhqs1oxyCXGgQHUCo2fDvq32J1d1GzJOcyI7uacMrLQSMoZbXgD0MrUm2KbPkbn5CC7vZekIsBL57bEfuW8U2mW7TRo4m9tVvynaWAmC05OK2HQEcJyuYUcBFnf3C8qhJqrP29k9V2YrRXoR7sODBWu22rM62l1OezcUNOYT0q5pnwRSoUakuFvLhEI1hEFzNZYdQV4crx9sFQM1H9K33jtuM0TZ7yhVI84cSbR6tKr5iIZ3nPnaxgreKK1WxsbGzXds9xIq6tTfz3AuU708AYELgoOKhP8f94Bgp8bVkpZWXIUdSsBLGCiA3lW9Zu38zcfdxduPkCzqDRgm2HAVb8i1BzACpCkdxTAV28JIhjeWpwfEX5CO0j7T4gz9XLr3DBz6ML07gN3pzB10JgqdLGS9jkbzzxmydhzYjfH2L0820heIBkgpLGtajkxRyyP1OG4mOm2NrlEoMLWSx5cxAPL2ZMj8BEpjY8zscOe91ZcsRRs9YwAJrsoI765bGAjBewltqgROzmkZTSGrNde5OkOwLvux8Yx3otvFFBnZjvoo1YuwST7r3CAkXa6uknpEYbQS0HosakpKFrTDzsgPKz35degdJFpHAWX4VrAIlcA8iozWkjmwshRxJRC9pN4fTn6XTsLasn@~!@#$#$#$#%%$^%^%&^&*^*&&*&*&((*(+_+_)_)_)_()(*(*(&*(&*&*&<><??)_+HJJKKJLLJLJOIOU";
        changeRequestPage.enterReasonDescriptionField(reasonDesc);
        changeRequestPage.verifyReasonDescriptionInvalid(false);
        reasonDesc ="Reason Description text";
        changeRequestPage.enterReasonDescriptionField(reasonDesc);
        changeRequestPage.verifyReasonDescriptionInvalid(true);
    }

    @Then("^verify the reason description field is editable\\.$")
    public void verify_the_reason_description_field_is_editable(){
        changeRequestPage.verifyReasonDescriptionIsEditable();
    }

    @Then("^verify the reason description displays in the reason description field\\.$")
    public void verify_the_reason_description_displays_in_the_reason_description_field(){
        changeRequestPage.verifyReasonDescriptionFiledDisplayedInReasonDescriptionField();
    }

    @Then("^verify the system will allow only the first (\\d+) characters to be entered in reason description field\\.$")
    public void verify_the_system_will_allow_only_the_first_characters_to_be_entered_in_reason_description_field(int arg1){
        changeRequestPage.verifyReasonDescriptionFiledAllowOnlyFirstTwoThousandCharacter(reasonDesc);
    }

    @Given("^click on 'Add Request' button\\.$")
    public void click_on_Add_Request_button(){
        changeRequestPage.clickOnAddRequest();
    }

    @Then("^verify 'Add Related Request' form closes\\.$")
    public void verify_Add_Related_Request_form_closes(){
    }

    @Then("^verify Request Part added displays correctly in the 'Create Change Request' form, including a trash icon next to it\\.$")
    public void verify_Request_Part_added_displays_correctly_in_the_Create_Change_Request_form_including_a_trash_icon_next_to_it(){
        changeRequestPage.verifyRemoveSubject();
    }

    @Then("^verify '\\+ Add Related Request' button displays\\.$")
    public void verify_Add_Related_Request_button_displays(){
        changeRequestPage.verifyAddRelatesRequestButton();
    }

    @Then("^verify 'Create change request' button is enabled as 'Standard' radio button is already selected\\.$")
    public void verify_Create_change_request_button_is_enabled_as_Standard_radio_button_is_already_selected(){
        changeRequestPage.verifyCreateChangeRequest();
    }

    @Given("^Select 'Expedited' priority\\.$")
    public void select_Expedited_priority(){
        changeRequestPage.clickOnExpedited();
    }

    @Then("^verify 'Expedited' radio button is selected\\.$")
    public void verify_Expedited_radio_button_is_selected(){
        changeRequestPage.verifyExpeditedRadioButtonSelected();
    }

    @Then("^verify Explanation text field displays as mandatory\\.$")
    public void verify_Explanation_text_field_displays_as_mandatory(){
        changeRequestPage.verifyMandatoryField();
    }

    @Then("^verify 'Create Change Request' button becomes disabled\\.$")
    public void verify_Create_Change_Request_button_becomes_disabled(){
        changeRequestPage.verifyCreateChangeRequestButtonDisabled2();
    }
String expeditedDesc;
    @Given("^Enter the priority explanation, attempt to enter more than (\\d+) characters, including alphanumerical and special characters\\.$")
    public void enter_the_priority_explanation_attempt_to_enter_more_than_characters_including_alphanumerical_and_special_characters(int arg1){
        expeditedDesc = "K9pcapHGH50UgW4PLH5CwQIdC46JV8wrMlUUVr3aC7W5xWOcK3u197NbHRAnMYde613SdPtRdL982vfP2GW8clAwOzGsiMsvJwuDBCc4ifuuE0BtyEAAlWRashVnmd1bNHsD3vuQBINNuGEQIgG1GPKzUnuruSXoVo0DNnut0WPCQt47LWAeb4OE2S2fRfCMORlvTeIzXlaFgJZVZIMdew8XV02VDdUAsNtsjYrZVCy04fcw6d4JRCYKHQsG4xaUoZcPAUBGlEvPpdAQNYlYWsOhSxrLgN1oS7mOL5fqPTk17vlwh8DruZH4WWMZLtq9kcw4p8y5bhetGCjKmjZnp4fZOB8mhEH1NRcU9DM5K6TcloFVSTbLm2YgonT4oi1hvYThTQfMNVljWGuzeArOfMDIR9BPUff9mdy1iSO7mzc0JqhChix6SL0P5KQtNPuOwLPgMu6YbDZRGqQ9GM9Q8OfSm3wOER9DSYAZdUdWgiN3zcrQ2UD7bZ3xSGJvDqSIFsaaXmZMHmHkC1IRFwX1fNcYRR1j1EbGzbJRFxMz7YsFHkGCkZRVgflqwnVmNv6WdCavaWyyFTtVAIpT7EqVCqL0H78pI4ZdI2twAkTgmpZTQ1Mo4FrOFa8WmfNBay1wHOUSayg9CrkW83hsj3Vqbs6E1DPDiQOyrPts6LtbwrE5NWoHSQFWxY0rxZTuDFh4FWpLdzPSpv5YNt2PC10cXMWrtPtxxqSI7Og9PrutlEOKvEGoLdKtPlo8T5EgdqI268yBvLoCm1EF1BV1M264abqi75JXMW8kJWCucDW24TdY2YeNp8Ic0hI3J9u42G3UobYIhPmuckXwqcTs8X1BrzvURPPzG1WrPqsYEZgygHlKrZwwd8i0M8r4UBqwvAY12INEGHAVgIEdqlQWUDhJ78QtALQc1QNYYedIvpIEFwGxZd3DiGlXSKXQ3l30yjx9Fxbjcx2vhXqw2JHbM3ZuzKHjuILEIGev1PUYchpe0d92kw4nxJI3w4UiXOfnxEVXo5sCNPiWVMX0XLOVNFfugi0bIoiuH1c73UnUVlcTIHbtFFKpKAErH0TDqvkYpA0pRINkydY17QiQiNWQQ4f0bt3VmXyBMrZFkyu9MdHBVY2SVwmoW4LwpKeuunxzJgyiVCQ7eziOj1RyaRX2hjRz26PGOpxSje119KAuxk53Mzv3aya631fO3yLJyTsdHNR2uYiPP3UNjDQGBKm6yTEXFCCEPvXBKQj2g7iUCQqebAtO9oVQBp0Auhqs1oxyCXGgQHUCo2fDvq32J1d1GzJOcyI7uacMrLQSMoZbXgD0MrUm2KbPkbn5CC7vZekIsBL57bEfuW8U2mW7TRo4m9tVvynaWAmC05OK2HQEcJyuYUcBFnf3C8qhJqrP29k9V2YrRXoR7sODBWu22rM62l1OezcUNOYT0q5pnwRSoUakuFvLhEI1hEFzNZYdQV4crx9sFQM1H9K33jtuM0TZ7yhVI84cSbR6tKr5iIZ3nPnaxgreKK1WxsbGzXds9xIq6tTfz3AuU708AYELgoOKhP8f94Bgp8bVkpZWXIUdSsBLGCiA3lW9Zu38zcfdxduPkCzqDRgm2HAVb8i1BzACpCkdxTAV28JIhjeWpwfEX5CO0j7T4gz9XLr3DBz6ML07gN3pzB10JgqdLGS9jkbzzxmydhzYjfH2L0820heIBkgpLGtajkxRyyP1OG4mOm2NrlEoMLWSx5cxAPL2ZMj8BEpjY8zscOe91ZcsRRs9YwAJrsoI765bGAjBewltqgROzmkZTSGrNde5OkOwLvux8Yx3otvFFBnZjvoo1YuwST7r3CAkXa6uknpEYbQS0HosakpKFrTDzsgPKz35degdJFpHAWX4VrAIlcA8iozWkjmwshRxJRC9pN4fTn6XTsLasn@~!@#$#$#$#%%$^%^%&^&*^*&&*&*&((*(+_+_)_)_)_()(*(*(&*(&*&*&<><??)_+HJJKKJLLJLJOIOU";
        changeRequestPage.enterPriorityExpedited(expeditedDesc);
        changeRequestPage.verifyPriorityDescriptionInvalid(false);
        expeditedDesc ="Priority Description text";
        changeRequestPage.enterPriorityExpedited(expeditedDesc);
        changeRequestPage.verifyPriorityDescriptionInvalid(true);
    }

    @Then("^verify the explanation displays in the Explain field\\.$")
    public void verify_the_explanation_displays_in_the_Explain_field(){
        changeRequestPage.verifyPriorityExpeditedDescriptionDisplayedInDescriptionField();
    }

    @Then("^verify the system will allow only the first (\\d+) characters to be entered in priority expedited field\\.$")
    public void verify_the_system_will_allow_only_the_first_characters_to_be_entered_in_priority_expedited_field(int arg1){
        changeRequestPage.verifyPriorityExpeditedDescriptionFiledAllowOnlyFirstTwoThousandCharacter(expeditedDesc);
    }

    @Then("^verify 'Create Change Request' button enables\\.$")
    public void verify_Create_Change_Request_button_enables(){
        changeRequestPage.verifyCreateChangeRequestButtonEnabled();
    }

    @Given("^Click on Create Change Request 'Create Change Request' button$")
    public void click_on_Create_Change_Request_Create_Change_Request_button(){
        changeRequestPage.clickOnCreateChangeRequestButton();
    }

    @Then("^verify the ESignature window pop up displays with Username, Password and  Confirm button:$")
    public void verify_the_ESignature_window_pop_up_displays_with_Username_Password_and_Confirm_button(){
        changeRequestPage.verifyElectronicSignaturePopUp();
    }

    @Given("^Fill username and password fields with correct credentials and click 'Confirm' button\\.$")
    public void fill_username_and_password_fields_with_correct_credentials_and_click_Confirm_button() throws Exception {
        changeRequestPage.enterUsernamePasswordAndClickOnConfirmButton();
    }

    @Then("^verify ESignature window closes\\.$")
    public void verify_ESignature_window_closes(){

    }

    @Then("^verify Grid is shown including the new DCR\\.$")
    public void verify_Grid_is_shown_including_the_new_DCR(){
        changeRequestPage.verifyGridIsShownIncludingTheNewDCR(requestId);
    }

    @Then("^verify New DCR has Unique Number ID\\.$")
    public void verify_New_DCR_has_Unique_Number_ID(){
        changeRequestPage.verifyNewDCRHasUniqueNumberID(requestId);
    }

    @Then("^verify New DCR status is 'Under Review'\\.$")
    public void verify_New_DCR_status_is_Under_Review(){
        changeRequestPage.verifyNewDCRStatusIsUnderReview();
    }
}
