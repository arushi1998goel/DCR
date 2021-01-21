package com.ui.dcr.pages;

import com.framework.selenium.core.BasePage;
import com.framework.selenium.core.Configuration;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.*;

public class ChangeRequestPage extends BasePage {
    private String username;
    private String password;
    public ChangeRequestPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Value of definition field verify.
     * @param dropdownValue - selected dropdown from the pop-up value
     * @param subject - subject value pop-up input
     */

    @FindBy(xpath = "//label[text()='Visit Name']/../..//input")
    private List<WebElement> visitName;

    @FindBy(xpath = "//label[text()='Sponsor Name']/../..//input")
    private WebElement sponsorName;

    @FindBy(xpath = "//label[text()='Study Name']/../..//input")
    private WebElement studyName;

    @FindBy(xpath = "//label[text()='Change From']/../..//input")
    private WebElement changeFrom;

    @FindBy(xpath = "//label[text()='Change To']/../..//input")
    private WebElement changeTo;

    @FindBy(xpath = "//label[text()='Visit Start Date']/../..//input")
    private List<WebElement> visitStartDate;

    @FindBy(xpath = "//label[text()='Assessment Started Date/Time']/../..//input")
    private List<WebElement> AssessmentStartedDateTime;

    @FindBy(xpath = "//label[text()='Assessment Name']/../..//input")
    private List<WebElement> AssessmentName;

    @FindBy(xpath = "//input[@class='ng-valid ng-dirty ng-touched']")
    private List<WebElement> fromFlagState;

    @FindBy(xpath = "(//label[text()=' Checked '])[1]")
    private WebElement checked;

    @FindBy(xpath = "//label[text()=' Unchecked ']/../..//input")
    private List<WebElement> unChecked;

    @FindBy(xpath = "//input[@class='ng-dirty ng-valid ng-touched']")
    private List<WebElement> toFlagState;

    @FindBy(xpath = "//input[@id='from_date_time']")
    private WebElement fromDateTime;

    @FindBy(xpath = "//input[@id='to_date_time']")
    private WebElement toDateTime;

    @FindBy(xpath = "//input[@id='timePart_from_date_time']")
    private WebElement fromTime;

    @FindBy(xpath = "//label[text()='Visit Status']/../..//input")
    private List<WebElement> visitStatus;

    @FindBy(xpath = "//label[text()='Version Number']/../..//input")
    private WebElement versionNumber;

    @FindBy(xpath = "//label[text()='SVID']/../..//input")
    private List<WebElement> SVID;

    @FindBy(xpath = "//label[text()='Study']/../..//input")
    private List<WebElement> study;

    @FindBy(xpath = "//li[contains(text(),'Privacy and Data Protection')]")
    private WebElement value4;

    @FindBy(xpath = "//label[text()='Use same reason for all Related Requests']/../..//input")
    private WebElement checkbox;

    @FindBy(xpath = "//button[text()=' Cancel']")
    private WebElement cancelButton;

    @FindBy(css = "a[title='Refresh']")
    private  WebElement refreshIcon;

    @FindBy(xpath = "//span[@class='icon-small icon-add']")
    private WebElement createChangeRequestIcon;

    @FindBy(xpath = "//span[@title='Create Change Request']")
    private WebElement createChangeRequestPopTitle;

    @FindBy(xpath = "//a[@class='add-request-part ng-star-inserted']")
    private WebElement addRequestButton;

    @FindBy(xpath = "(//label[contains(text(),'Standard')]/../..//input)[1]")
    private WebElement priorityStandard;

    @FindBy(xpath = "(//label[contains(text(),'Expedited')]/../..//input)[2]")
    private WebElement priorityExpedited;

    @FindBy(xpath = "//button[contains(text(),'Create Change Request')]")
    private WebElement createChangeRequestButtonDisabled;

    @FindBy(xpath = "//label[contains(text(),'Upload')]")
    private WebElement uploadButton;

    @FindBy(xpath = "//span[@title='Add Request']")
    private WebElement addRequestPopTitle;

    @FindBy(xpath = "//label[contains(text(),'Change Types')]")
    private WebElement changeType;

    @FindBy(xpath = "//label[contains(text(),'Description')]")
    private WebElement description;

    @FindBy(xpath = "//textarea[@placeholder='Describe the change required']")
    private WebElement descriptionArea;

    @FindBy(xpath = "//textarea[@placeholder='Describe the reason for change']")
    private WebElement reasonDescriptionArea;

    @FindBy(xpath = "//button[contains(text(),'Add Request')]")
    private WebElement addRequestButtonDisabled;

    @FindBy(xpath = "//kendo-dropdownlist[@placeholder='Select change type']//span[@class='k-input']")
    private WebElement changeTypeDropDown;

    @FindBy(xpath = "//li[contains(text(),'Remove Subject')]")
    private WebElement value1;

    @FindBy(xpath = "//li[contains(text(),'Remove Visit/SVID')]")
    private WebElement value3;

    @FindBy(xpath = "//li[contains(text(),'Remove Assessment')]")
    private WebElement RemoveAssessment;

    @FindBy(xpath = "//li[contains(text(),'Remove Survey')]")
    private WebElement RemoveSurvey;

    @FindBy(xpath = "//li[contains(text(),'Remove Revision')]")
    private WebElement removeRevision;

    @FindBy(xpath = "//li[contains(text(),'Remove Audio/Video')]")
    private WebElement RemoveAudioVideo;

    @FindBy(xpath = "//li[contains(text(),'Move Assessment')]")
    private WebElement MoveAssessment;

    @FindBy(xpath = "//li[contains(text(),'Move Audio/Update Source File')]")
    private WebElement moveAudioUpdateSourceFile;

    @FindBy(xpath = "//li[contains(text(),'Move/Rename Visit')]")
    private WebElement moveRenameVisit;

    @FindBy(xpath = "//li[contains(text(),'Transfer Subject Between Sites')]")
    private WebElement transferSubjectBetweenSites;

    @FindBy(xpath = "//li[contains(text(),'Move Survey')]")
    private WebElement moveSurvey;

    @FindBy(xpath = "//li[contains(text(),'Update Rater Name')]")
    private WebElement updateRaterName;

    @FindBy(xpath = "//li[contains(text(),'Update Feedback to Read')]")
    private WebElement updateFeedbackToRead;

    @FindBy(xpath = "//li[contains(text(),'Assign Rater')]")
    private WebElement assignRater;

    @FindBy(xpath = "//li[contains(text(),'Unassign Rater')]")
    private WebElement unassignRater;

    @FindBy(xpath = "//li[contains(text(),'Update Subject Number')]")
    private WebElement updateSubjectNumber;

    @FindBy(xpath = "//li[contains(text(),'Update Subject Randomization Number')]")
    private WebElement updateSubjectRandomizationNumber;

    @FindBy(xpath = "//li[contains(text(),'Generate Scores')]")
    private WebElement generateScores;

    @FindBy(xpath = "//li[contains(text(),'Update Screening Number')]")
    private WebElement updateScreeningNumber;

    @FindBy(xpath = "//li[contains(text(),'Add Assessment to Visit')]")
    private WebElement addAssessmentToVisit;

    @FindBy(xpath = "//li[contains(text(),'Update Visit Status')]")
    private WebElement updateVisitStatus;

    @FindBy(xpath = "//li[contains(text(),'Update Assessment')]")
    private List<WebElement> updateAssessment;

    @FindBy(xpath = "//li[contains(text(),'Other')]")
    private WebElement changeTypeOther;

    @FindBy(xpath = "//label[text()='Subject #']/../..//input")
    private List<WebElement> subject;

    @FindBy(xpath = "//label[text()='Site']/../..//input")
    private List<WebElement> site;

    @FindBy(xpath = "//label[text()='Screening #']/../..//input")
    private List<WebElement> screening;

    @FindBy(xpath = "//label[text()='Randomization #']/../..//input")
    private List<WebElement> randomization;

    @FindBy(xpath = "//p[@class='allow-white-spaces']")
    private WebElement definitionFieldArea;

    @FindBy(xpath = "//label[text()='Rater Name']/../..//input")
    private List<WebElement> RaterName;

    @FindBy(xpath = "//label[text()='Rater E-mail']/../..//input")
    private List<WebElement> RaterEmail;

    @FindBy(xpath = "//kendo-dropdownlist[@placeholder='Select Reason for Change']//span[@class='k-input']")
    private WebElement reasonTypesDropDown;

    @FindBy(xpath = "//li[contains(text(),'Data Entry Error')]")
    private WebElement value2;

    @FindBy(xpath = "//li[contains(text(),'Reconciliation')]")
    private WebElement reconciliation;

    @FindBy(xpath = "//li[contains(text(),'Other')]")
    private WebElement other;

    @FindBy(xpath = "//li[contains(text(),'Sponsor Request')]")
    private WebElement sponsorRequest;

    @FindBy(xpath = "//li[contains(text(),'System Error/Limitation')]")
    private WebElement SystemErrorLimitation;

    @FindBy(xpath = "//button[contains(text(),'Add Request')]")
    private WebElement addRequest;

    @FindBy(xpath = "//label[@class='dcr-part-title part-type']")
    private WebElement removeSubject;

    @FindBy(xpath = "//a[contains(text(),'Add Related Request')]")
    private WebElement addRelatedRequestButton;

    @FindBy(xpath = "//button[contains(text(),'Create Change Request')]")
    private WebElement createChangeRequest;

    @FindBy(xpath= "//input[@id='priority-expedited']/../input")
    private WebElement expedited;

    @FindBy(xpath = "//textarea[@formcontrolname='priorityDescription']")
    private WebElement errorInfo;

    @FindBy(xpath = "//button[contains(text(),'Create Change Request')]")
    private WebElement getCreateChangeRequestButtonDisabled;

    @FindBy(xpath = "//textarea[@placeholder='If expedited, please provide reason']")
    private WebElement priorityExpeditedDescription;

    @FindBy(xpath = "//button[contains(text(),'Create Change Request')]")
    private WebElement createChangeRequestButton;

    @FindBy(xpath = "//span[@title='Electronic Signature']")
    private WebElement electronicSignaturePopUp;

    @FindBy(xpath = "//input[@formcontrolname='userName']")
    private WebElement usernameTextArea;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordTextArea;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    private WebElement confirmButton;

    @FindBy(css = "div.k-grid-aria-root a.link")
    private List<WebElement> requestLink;

    @FindBy(css = "div.k-grid-aria-root  td[aria-colindex='6']")
    private List<WebElement> status;

    public int clickOnCreateChangeRequestIcon(){
        String requestId = requestLink.get(0).getText();
        int reqid = Integer.parseInt(requestId);
        hoverOverElementAndClick(createChangeRequestIcon,createChangeRequestIcon);
        return reqid;
    }
    public void verifyCreateChangeRequestPopTitle(){
        assertElementIsVisibile(createChangeRequestPopTitle, "Create Change Request");
    }

    public void verifyAddRequestButton(){
        assertElementIsVisibile(addRequestButton, "+ Add Request");
    }
    public void priorityStandardRadioButtonSelected(){
        assertEquals(true, priorityStandard.isSelected());
    }
    public void verifyUploadButton(){
        assertElementIsVisibile(uploadButton, "Upload");
    }
    public void verifyCreateChangeRequestButtonDisabled(){
        assertEquals(true, createChangeRequestButtonDisabled.isDisplayed());
        assertEquals(false, createChangeRequestButtonDisabled.isEnabled());
    }
    public void clickOnAddRequestButton() throws InterruptedException {
        _waitForJStoLoad();
        Thread.sleep(10000);
        clickOn(addRequestButton);
    }
    public void verifyAddRequestPopTitle(){
        assertElementIsVisibile(addRequestPopTitle, "Add Request");
    }
    public void verifyChangeTypeDropDown(){
        assertElementIsVisibile(changeType, "Change Type");
    }
    public void verifyDescription(){
        assertElementIsVisibile(description, "Description");
    }
    public void verifyAddRequestButtonDisabled(){
        assertEquals(true, addRequestButtonDisabled.isDisplayed());
        assertEquals(false, addRequestButtonDisabled.isEnabled());
    }

    public void verifyCheckboxDiplayed(){
       // assertEquals(true, checkbox.isDisplayed());
        assertElementIsVisibile(checkbox, "Use same reason for all Related Requests");
    }

    public void verifyCancelButton(){
        assertEquals(true, cancelButton.isDisplayed());
        assertEquals(true, cancelButton.isEnabled());
    }

    public void verifyAllFieldsMarkedMandatory(){

        assertEquals(true, changeTypeDropDown.isDisplayed());
        assertEquals(true, descriptionArea.isDisplayed());
        assertEquals(true, changeTypeDropDown.isDisplayed());
        assertEquals(true, reasonDescriptionArea.isDisplayed());
    }
    public void selectChangeType(){
        clickOn(changeTypeDropDown);
        clickOn(value1);
    }
    public void selectChangeTypeDropDown(){
        clickOn(changeTypeDropDown);
        clickOn(value3);
    }
    public void selectChangeTypeDropDownRemoveAssessment(){
        clickOn(changeTypeDropDown);
        clickOn(RemoveAssessment);
    }

    public void selectChangeTypeDropDownRemoveSurvey(){
        clickOn(changeTypeDropDown);
        clickOn(RemoveSurvey);
    }

    public void selectChangeTypeDropDownRemoveRevision(){
        clickOn(changeTypeDropDown);
        clickOn(removeRevision);
    }

    public void selectChangeTypeDropDownRemoveAudioVideo(){
        clickOn(changeTypeDropDown);
        clickOn(RemoveAudioVideo);
    }

    public void selectChangeTypeDropDownMoveAssessment(){
        clickOn(changeTypeDropDown);
        clickOn(MoveAssessment);
    }

    public void selectChangeTypeDropDownMoveAudioUpdateSourceFile(){
        clickOn(changeTypeDropDown);
        clickOn(moveAudioUpdateSourceFile);
    }

    public void selectChangeTypeDropDownMoveRenameVisit(){
        clickOn(changeTypeDropDown);
        clickOn(moveRenameVisit);
    }
    public void selectChangeTypeDropDownTransferSubjectBetweenSites(){
        clickOn(changeTypeDropDown);
        clickOn(transferSubjectBetweenSites);
    }

    public void selectChangeTypeDropDownMoveSurvey(){
        clickOn(changeTypeDropDown);
        clickOn(moveSurvey);
    }

    public void selectChangeTypeDropDownUpdateRaterName(){
        clickOn(changeTypeDropDown);
        clickOn(updateRaterName);
    }

    public void selectChangeTypeDropDownUpdateFeedbackToRead(){
        clickOn(changeTypeDropDown);
        clickOn(updateFeedbackToRead);
    }

    public void selectChangeTypeDropDownAssignRater(){
        clickOn(changeTypeDropDown);
        clickOn(assignRater);
    }

    public void selectChangeTypeDropDownUnassignRater(){
        clickOn(changeTypeDropDown);
        clickOn(unassignRater);
    }

    public void selectChangeTypeDropDownUpdateSubjectNumber(){
        clickOn(changeTypeDropDown);
        clickOn(updateSubjectNumber);
    }

    public void selectChangeTypeDropDownUpdateSubjectRandomizationNumber(){
        clickOn(changeTypeDropDown);
        clickOn(updateSubjectRandomizationNumber);
    }

    public void selectChangeTypeDropDownGenerateScores(){
        clickOn(changeTypeDropDown);
        clickOn(generateScores);
    }

    public void selectChangeTypeDropDownUpdateScreeningNumber(){
        clickOn(changeTypeDropDown);
        clickOn(updateScreeningNumber);
    }

    public void selectChangeTypeDropDownAddAssessmentToVisit(){
        clickOn(changeTypeDropDown);
        clickOn(addAssessmentToVisit);
    }

    public void selectChangeTypeDropDownUpdateVisitStatus(){
        clickOn(changeTypeDropDown);
        clickOn(updateVisitStatus);
    }

    public void selectChangeTypeDropDownUpdateAssessmentPaperTranscription(){
        clickOn(changeTypeDropDown);
        clickOn(updateAssessment.get(1));
    }

    public void selectChangeTypeDropDownUpdateAssessmentNotAdministeredCompleted(){
        clickOn(changeTypeDropDown);
        clickOn(updateAssessment.get(0));
    }

    public void selectChangeTypeDropDownOther(){
        clickOn(changeTypeDropDown);
        clickOn(changeTypeOther);
    }

    public void verifySubjectAndSite() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
    }

    public void verifySiteSubjectVisitNameVisitStartDateAndSVID() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, visitStartDate.get(0).isDisplayed());
        assertEquals(true, SVID.get(0).isDisplayed());
    }

    public void verifyAdditionalfieldsSiteSubjectVisitNameAssessmentNameAssessmentStartedStartDateTimeandSVID() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, AssessmentName.get(0).isDisplayed());
        assertEquals(true, AssessmentStartedDateTime.get(0).isDisplayed());
        assertEquals(true, SVID.get(0).isDisplayed());
    }

    public void verifyAdditionalfieldsSiteSubjectVisitNameAssessmentNameAssessmentStartedStartDateTimeVersionNumberAndSVID() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, AssessmentName.get(0).isDisplayed());
        assertEquals(true, AssessmentStartedDateTime.get(0).isDisplayed());
        assertEquals(true, versionNumber.isDisplayed());
        assertEquals(true, SVID.get(0).isDisplayed());
    }

    public void verifyAdditionalfieldsSiteFromSubjectVisitNameAssessmentNameSVIDAndToSubjectVisitNameAssessmentNameSVID() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, AssessmentName.get(0).isDisplayed());
        assertEquals(true, SVID.get(0).isDisplayed());
        assertEquals(true, subject.get(1).isDisplayed());
        assertEquals(true, visitName.get(1).isDisplayed());
        assertEquals(true, AssessmentName.get(1).isDisplayed());
        assertEquals(true, SVID.get(1).isDisplayed());
    }

    public void verifyAdditionalfieldsSiteFromSubjectVisitNameSVIDAndToSubjectVisitNameSVID() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, SVID.get(0).isDisplayed());
        assertEquals(true, subject.get(1).isDisplayed());
        assertEquals(true, visitName.get(1).isDisplayed());
        assertEquals(true, SVID.get(1).isDisplayed());
    }

    public void verifyAdditionalfieldsSVIDFromStudySiteSubjectVisitNameAssessmentNameAndToStudySiteSubjectVisitNameAssessmentName() {
        assertEquals(true, SVID.get(0).isDisplayed());
        assertEquals(true, study.get(0).isDisplayed());
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, AssessmentName.get(0).isDisplayed());
        assertEquals(true, study.get(1).isDisplayed());
        assertEquals(true, site.get(1).isDisplayed());
        assertEquals(true, subject.get(1).isDisplayed());
        assertEquals(true, visitName.get(1).isDisplayed());
        assertEquals(true, AssessmentName.get(1).isDisplayed());
    }
    public void verifyAdditionalfieldsFromSiteSubjectAndToSiteSubject() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, site.get(1).isDisplayed());
        assertEquals(true, subject.get(1).isDisplayed());
    }

    public void verifyAdditionalfieldsRaterNameAndRaterEmail() {
        assertEquals(true, RaterName.get(0).isDisplayed());
        assertEquals(true, RaterEmail.get(0).isDisplayed());
    }
    public void verifyAdditionalfieldsAssessmentNameFromSiteRaterNameRaterEmailAndToSiteRaterNameRaterEmailDisplayed() {
        assertEquals(true, AssessmentName.get(0).isDisplayed());
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, RaterName.get(0).isDisplayed());
        assertEquals(true, RaterEmail.get(0).isDisplayed());
        assertEquals(true, site.get(1).isDisplayed());
        assertEquals(true, RaterName.get(1).isDisplayed());
        assertEquals(true, RaterEmail.get(1).isDisplayed());
    }

    public void verifyAdditionalFieldsSiteSubjectVisitNameAssessmentNameSVIDFromRaterNameAndToRaterNameDisplayed() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, AssessmentName.get(0).isDisplayed());
        assertEquals(true, SVID.get(0).isDisplayed());
        assertEquals(true, RaterName.get(0).isDisplayed());
        assertEquals(true, RaterName.get(1).isDisplayed());

    }

    public void verifyAdditionalFieldsSiteSubjectVisitNameAssessmentNameRaterNameAndSVIDdisplayed() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, AssessmentName.get(0).isDisplayed());
        assertEquals(true, RaterName.get(0).isDisplayed());
        assertEquals(true, SVID.get(0).isDisplayed());
    }

    public void verifyAdditionalFieldsSiteFromSubjectAndToSubjectDisplayed() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, subject.get(1).isDisplayed());
    }

    public void verifyAdditionalFieldsSiteFromRandomizationAndToRandomizationDisplayed() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, randomization.get(0).isDisplayed());
        assertEquals(true, randomization.get(1).isDisplayed());
    }

    public void verifyAdditionalFieldsSiteSubjectVisitNameAssessmentNameAssessmentStartedDateTimeVersionNumberAndSVIDDisplayed() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, AssessmentName.get(0).isDisplayed());
        assertEquals(true, AssessmentStartedDateTime.get(0).isDisplayed());
        assertEquals(true, versionNumber.isDisplayed());
        assertEquals(true, SVID.get(0).isDisplayed());
    }

    public void verifyAdditionalFieldsSiteFromScreeningAndToScreeningDisplayed() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, screening.get(0).isDisplayed());
        assertEquals(true, screening.get(1).isDisplayed());
    }

    public void verifyAdditionalFieldsSubjectVisitNameAssessmentNameAndSVIDDisplayed() {
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, AssessmentName.get(0).isDisplayed());
        assertEquals(true, SVID.get(0).isDisplayed());
    }

    public void verifyAdditionalFieldsSiteSubjectVisitNameSVIDFromVisitStatusToVisitStatusDisplayed() {
        assertEquals(true, site.get(0).isDisplayed());
        assertEquals(true, subject.get(0).isDisplayed());
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, SVID.get(0).isDisplayed());
        assertEquals(true, visitStatus.get(0).isDisplayed());
        assertEquals(true, visitStatus.get(1).isDisplayed());
    }

    public void verifyVisitNameAssessmentNameFromCheckedUncheckedDateTimeAndToCheckedUncheckedDateTimeDisplayed() {
        assertEquals(true, visitName.get(0).isDisplayed());
        assertEquals(true, AssessmentName.get(0).isDisplayed());
       // assertEquals(false, checked.isDisplayed());
        assertEquals(false, unChecked.get(0).isDisplayed());
        assertEquals(true, fromDateTime.isDisplayed());
        //assertEquals(false, checked.get(0).isDisplayed());
        assertEquals(false, unChecked.get(1).isDisplayed());
        assertEquals(true, toDateTime.isDisplayed());

    }

    public void verifyVisitNameAssessmentNameFromSponsorNameStudyNameChange() {
        assertEquals(true, sponsorName.isDisplayed());
        assertEquals(true, studyName.isDisplayed());
        assertEquals(true, changeFrom.isDisplayed());
        assertEquals(true, changeTo.isDisplayed());
    }

    public void enterDescriptionField(String description){
        inputText(descriptionArea, description);
    }

    public void verifyDescriptionInvalid(Boolean isValid) {
        if(isValid.equals(true))
            assertEquals(descriptionArea.getAttribute("class"), "ng-dirty ng-touched ng-valid");
        else
            assertEquals(descriptionArea.getAttribute("class"), "ng-untouched ng-dirty ng-invalid");
    }

    public void verifyDescriptionIsEditable(){
        assertTrue("Description is editable",descriptionArea.isDisplayed());
    }
    public void verifyDescriptionFiledDisplayedInDescriptionField(){
        assertTrue("Description is displayed",descriptionArea.isDisplayed());
    }
    public void verifyDescriptionFiledAllowOnlyFirstTwoThousandCharacter(String desc){
        String typedValue = descriptionArea.getAttribute("value");
        int size = typedValue.length();
        assertEquals(desc.length(), size);
    }
    public void enterSiteAndSubjeExpeditedctField(String siteTextField, String subjectTextFiled) {
        inputText(site.get(0), siteTextField);
        inputText(subject.get(0), subjectTextFiled);
    }
    public void enterSiteAndSubjectField(String siteTextField, String subjectTextFiled, String visitNameTextField, String SVIDTextField) {
        inputText(site.get(0), siteTextField);
        inputText(subject.get(0), subjectTextFiled);
        inputText(visitName.get(0), visitNameTextField);
        inputText(SVID.get(0), SVIDTextField);
    }

    public void enterSiteSubjectVisitNameAssessmentNameAssessmentStartedDateTimeandSVID (String siteTextField, String subjectTextFiled, String visitNameTextField, String AssessmentNameTextField, String SVIDTextField) {
        inputText(site.get(0), siteTextField);
        inputText(subject.get(0), subjectTextFiled);
        inputText(visitName.get(0), visitNameTextField);
        inputText(AssessmentName.get(0), AssessmentNameTextField);
        inputText(SVID.get(0), SVIDTextField);

    }

    public void enterSiteSubjectVisitNameAssessmentNameAssessmentStartedDateTimeVersionNumberAndSVID (String siteTextField, String subjectTextFiled, String visitNameTextField, String AssessmentNameTextField, String versionNumberTextField, String SVIDTextField) {
        inputText(site.get(0), siteTextField);
        inputText(subject.get(0), subjectTextFiled);
        inputText(visitName.get(0), visitNameTextField);
        inputText(AssessmentName.get(0), AssessmentNameTextField);
        inputText(versionNumber, versionNumberTextField);
        inputText(SVID.get(0), SVIDTextField);

    }
    public void enterSiteFromSubjectVisitNameAssessmentNameSVIDAndToSubjectVisitNameAssessmentNameSVID (String siteTextField, String fromSubjectTextFiled, String fromVisitNameTextField, String fromAssessmentNameTextField, String fromSVIDTextField, String toSubjectTextFiled, String toVisitNameTextField, String toAssessmentNameTextField, String toSVIDTextField) {
        inputText(site.get(0), siteTextField);
        inputText(subject.get(0), fromSubjectTextFiled);
        inputText(visitName.get(0), fromVisitNameTextField);
        inputText(AssessmentName.get(0), fromAssessmentNameTextField);
        inputText(SVID.get(0), fromSVIDTextField);
        inputText(subject.get(1), toSubjectTextFiled);
        inputText(visitName.get(1), toVisitNameTextField);
        inputText(AssessmentName.get(1), toAssessmentNameTextField);
        inputText(SVID.get(1), toSVIDTextField);

    }

    public void enterSiteFromSubjectVisitNameSVIDAndToSubjectVisitNameSVID (String siteTextField, String fromSubjectTextFiled, String fromVisitNameTextField, String fromSVIDTextField, String toSubjectTextFiled, String toVisitNameTextField, String toSVIDTextField) {
        inputText(site.get(0), siteTextField);
        inputText(subject.get(0), fromSubjectTextFiled);
        inputText(visitName.get(0), fromVisitNameTextField);
        inputText(SVID.get(0), fromSVIDTextField);
        inputText(subject.get(1), toSubjectTextFiled);
        inputText(visitName.get(1), toVisitNameTextField);
        inputText(SVID.get(1), toSVIDTextField);

    }

    public void enterSVIDFromStudySiteSubjectVisitNameAssessmentNameAndToStudySiteSubjectVisitNameAssessmentNameFields (String SVIDTextField, String fromStudyTextField, String fromSiteTextField, String fromSubjectTextFiled, String fromVisitNameTextField, String fromAssessmentNameTextField, String toStudyTextField, String toSiteTextField, String toSubjectTextFiled, String toVisitNameTextField, String toAssessmentNameTextField) {
        inputText(SVID.get(0), SVIDTextField);
        inputText(study.get(0), fromStudyTextField);
        inputText(site.get(0), fromSiteTextField);
        inputText(subject.get(0), fromSubjectTextFiled);
        inputText(visitName.get(0), fromVisitNameTextField);
        inputText(AssessmentName.get(0), fromAssessmentNameTextField);
        inputText(study.get(1), toStudyTextField);
        inputText(site.get(1), toSiteTextField);
        inputText(subject.get(1), toSubjectTextFiled);
        inputText(visitName.get(1), toVisitNameTextField);
        inputText(AssessmentName.get(1), toAssessmentNameTextField);

    }
    public void enterFromSiteSubjectAndToSiteSubject (String fromSiteTextField, String fromSubjectTextFiled, String toSiteTextField, String toSubjectTextFiled) {
        inputText(site.get(0), fromSiteTextField);
        inputText(subject.get(0), fromSubjectTextFiled);
        inputText(site.get(1), toSiteTextField);
        inputText(subject.get(1), toSubjectTextFiled);
    }

    public void enterAssessmentNameFromSiteRaterNameRaterEmailAndToSiteRaterNameRaterEmail (String AssessmentNameTextField, String fromSiteTextField, String fromRaterNameTextFiled, String fromRaterEmailTextField, String toSiteTextField, String toRaterNameTextFiled, String toRaterEmailTextField) {
        inputText(AssessmentName.get(0), AssessmentNameTextField);
        inputText(site.get(0), fromSiteTextField);
        inputText(RaterName.get(0), fromRaterNameTextFiled);
        inputText(RaterEmail.get(0), fromRaterEmailTextField);
        inputText(site.get(1), toSiteTextField);
        inputText(RaterName.get(1), toRaterNameTextFiled);
        inputText(RaterEmail.get(1), toRaterEmailTextField);
    }

    public void enterSiteSubjectVisitNameAssessmentNameSVIDFromRaterNameAndToRaterName (String siteTextField, String subjectTextFiled, String visitNameTextField, String AssessmentNameTextField, String SVIDTextField, String fromRaterNameTextFiled, String toRaterNameTextFiled) {
        inputText(site.get(0), siteTextField);
        inputText(subject.get(0), subjectTextFiled);
        inputText(visitName.get(0), visitNameTextField);
        inputText(AssessmentName.get(0), AssessmentNameTextField);
        inputText(SVID.get(0), SVIDTextField);
        inputText(RaterName.get(0), fromRaterNameTextFiled);
        inputText(RaterName.get(1), toRaterNameTextFiled);
    }

    public void enterSiteSubjectVisitNameAssessmentNameRaterNameAndSVID (String siteTextField, String subjectTextFiled, String visitNameTextField, String AssessmentNameTextField, String raterNameTextField, String SVIDTextField) {
        inputText(site.get(0), siteTextField);
        inputText(subject.get(0), subjectTextFiled);
        inputText(visitName.get(0), visitNameTextField);
        inputText(AssessmentName.get(0), AssessmentNameTextField);
        inputText(RaterName.get(0), raterNameTextField);
        inputText(SVID.get(0), SVIDTextField);
    }

    public void enterSiteFromSubjectAndToSubject(String siteTextField, String fromSubjectTextFiled, String toSubjectTextFiled){
        inputText(site.get(0), siteTextField);
        inputText(subject.get(0), fromSubjectTextFiled);
        inputText(subject.get(1), toSubjectTextFiled);
    }
    public void enterSiteFromRandomizationAndToRandomization(String siteTextField, String fromRandomizationTextFiled, String toRandomizationTextFiled){
        inputText(site.get(0), siteTextField);
        inputText(randomization.get(0), fromRandomizationTextFiled);
        inputText(randomization.get(1), toRandomizationTextFiled);
    }
    public void enterRaterNameAndRaterEmail (String raterNameTextField, String raterEmailTextFiled) {
        inputText(RaterName.get(0), raterNameTextField);
        inputText(RaterEmail.get(0), raterEmailTextFiled);
    }

    public void enterSiteFromSiteFromScreeningAndToScreening(String siteTextField, String fromScreeningTextFiled, String toScreeningTextFiled){
        inputText(site.get(0), siteTextField);
        inputText(screening.get(0), fromScreeningTextFiled);
        inputText(screening.get(1), toScreeningTextFiled);
    }

    public void enterSubjectVisitNameAssessmentNameAndSVIDFields(String subjectTextField, String visitNameTextField, String AssessmentNameTextField, String SVIDTextField){
        inputText(subject.get(0), subjectTextField);
        inputText(visitName.get(0), visitNameTextField);
        inputText(AssessmentName.get(0), AssessmentNameTextField);
        inputText(SVID.get(0), SVIDTextField);
    }

    public void enterSiteSubjectVisitNameSVIDFromVisitStatusToVisitStatusFields(String siteTextField, String subjectTextField, String visitNameTextField, String SVIDTextField, String fromVisitStatusTextField, String toVisitStatusTextField){
        inputText(site.get(0), siteTextField);
        inputText(subject.get(0), subjectTextField);
        inputText(visitName.get(0), visitNameTextField);
        inputText(SVID.get(0), SVIDTextField);
        inputText(visitStatus.get(0), fromVisitStatusTextField);
        inputText(visitStatus.get(1), toVisitStatusTextField);
    }

    public void enterVisitNameAssessmentNameFromDateTimeToDateTimeAndCheckFromCheckedUncheckedInFromAndToSection(String visitNameTextField, String AssessmentNameTextField) throws Exception {
        inputText(visitName.get(0), visitNameTextField);
        inputText(AssessmentName.get(0), AssessmentNameTextField);
        Thread.sleep(1000);
        waitForElementClickable(checked,5);
        clickOn(checked);
        //waitAndClick(checked.get(0));
    }


    public void enterSponsorNameStudyNameChangeFromChangeToFields(String sponsorNameTextField, String studyNameTextField, String changeFromTextField, String changeToTextField){
        inputText(sponsorName, sponsorNameTextField);
        inputText(studyName, studyNameTextField);
        inputText(changeFrom, changeFromTextField);
        inputText(changeTo, changeToTextField);

    }
    public void verifyDefinitionFieldGeneratedAccordingChangeTypeSiteAndSubject(String dropdownValue, String site, String subject, String selectorSite, String selectorSub){
        String msg = dropdownValue + " " + subject + " from Site " + site + " and " + selectorSite + " - " + selectorSub;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }
    public void verifyDefinitionFieldGeneratedAccordingChangeTypeRemoveVisitFromSubject(String dropdownValue, String visitName, String subject){
        String msg = dropdownValue + " " + visitName + " from Subject " + subject;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingChangeTypeRemoveAssessment(String dropdownValue, String AssessmentName, String visitName, String subject){
        String msg = dropdownValue + " " + AssessmentName + " from " + visitName + " for " + subject;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingChangeTypeRemoveAudioVideo(String dropdownValue, String AssessmentName, String subject){
        String msg = dropdownValue + " from Assessment " + AssessmentName + " for " + subject;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }
    public void verifyDefinitionFieldGeneratedAccordingChangeTypeRemoveSurvey(String dropdownValue, String raterName, String raterEmail, String selectorSite, String selectorSub){
        String msg = dropdownValue + " for " + raterName + " - " + raterEmail + " from " + selectorSite + " - " + selectorSub;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingChangeTypeRemoveFromVersion(String versionNumber, String AssessmentName, String subject){
        String msg = "Remove from version " + versionNumber + " from " + AssessmentName + " for " + subject;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToThisFormatMoveAssessment(String fromAssessmentName, String fromvisitName,String tovisitName){
        String msg = "Move Assessment(s) " + fromAssessmentName + " from "+fromvisitName+" to " + tovisitName;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToThisFormatMoveVisitFromVisitNameForSubject(String fromvisitName, String tovisitName,String fromsubject){
        String msg = "Move visit from " + fromvisitName + " to " + tovisitName + " for subject " + fromsubject;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }


    public void verifyDefinitionFieldGeneratedAccordingToThisFormatMoveAudioVideoFromVisitFromVisitNameInAssessmentFromAssessmentNameToToVisitNameInAssessmentToAssessmentNameForSubjec(String fromvisitName, String fromAssessmentName,String tovisitName, String toAssessmentName, String tosubject){
        String msg = "Move audio/video from visit " + fromvisitName + " in assessment " + fromAssessmentName + " to " + tovisitName + " in assessment " + toAssessmentName + " for subject " + tosubject;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToThisFormatTransferSubjectFromFromSiteToToSite(String fromsubject, String fromSiteName,String toSiteName){
        String msg = "Transfer subject " + fromsubject + " from " + fromSiteName + " to " + toSiteName;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }
    public void verifyDefinitionFieldGeneratedAccordingToThisFormatMovesurveyForRaterEmailFromStudySiteToRaterEmailStudySite(String fromRaterName, String fromRaterEmail,String selectorSite, String selectorSub, String fromSiteName, String toRaterName, String toRaterEmail, String toSiteName){
        String msg = "Move survey for " + fromRaterName + " - " + fromRaterEmail + " from " + selectorSite + " - " + selectorSub + ", site "+ fromSiteName + " to " + toRaterName + " - " + toRaterEmail + ", " + selectorSite + " - " + selectorSub + ", site " + toSiteName;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToThisFormatUpdateRaterName(String fromRaterName, String toRaterName, String AssessmentName, String visitName){
        String msg = "Update Rater name from " + fromRaterName + " to " + toRaterName + " for assessment " + AssessmentName + " in visit " + visitName;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }
    public void verifyDefinitionFieldGeneratedAccordingToFormatUpdateFeedbackToRead(String AssessmentName){
        String msg = "Update feedback to 'Read' for assessment " + AssessmentName;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }
    public void verifyDefinitionFieldGeneratedAccordingToFormatAssignRaterName(String raterName, String AssessmentName, String visitName){
        String msg = "Assign Rater name to " + raterName + " for assessment " + AssessmentName + " in visit " + visitName;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToFormatUnassignRaterNameForAssessmentInVisit(String raterName, String AssessmentName, String visitName){
        String msg = "Unassign Rater name to " + raterName + " for assessment " + AssessmentName + " in visit " + visitName;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToUpdateSubjectNumber(String fromsubject, String tosubject){
        String msg = "Update subject number from " + fromsubject + " to " + tosubject;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToUpdateRandomizationNumber(String fromRandomization, String toRandomization){
        String msg = "Update Randomization Number from " + fromRandomization + " to " + toRandomization;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToThisFormatGenerateScoresForAssessmentForSubject(String AssessmentName, String subject){
        String msg = "Generate scores for assessment " + AssessmentName + " for subject " + subject;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToThisFormatUpdateScreeningNumber(String fromScreening, String toScreening){
        String msg = "Update Screening number from " + fromScreening + " to " + toScreening;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToThisFormatAddAssessmentToVisit(String visitName, String subject){
        String msg = "Add assessment to visit " + visitName + " for subject " + subject;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToThisFormatUpdateVisitStatus(String subject, String visitName, String fromVistStatus, String toVistStatus){
        String msg = "Update Visit Status for subject " + subject + " for visit " + visitName + " from Visit Status " + fromVistStatus + " to " + toVistStatus;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFieldGeneratedAccordingToThisFormatUpdateAssessmentPaperTranscription(String AssessmentName, String visitName){
        String date=fromDateTime.getAttribute("aria-valuetext").toUpperCase();
        String time=fromTime.getAttribute("aria-valuetext");
        System.out.println(date);
        System.out.println(time);
        String msg = "Update Assessment 'Paper Transcription' from " + date + " " + time + " to " + date + " " + time + " from Current Status Checked to Unchecked for assessment " + AssessmentName + " in visit " + visitName;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

   public void verifyDefinitionFieldGeneratedAccordingToThisFormatUpdateInformationForClientStudy(String AssessmentName, String visitName){
       String date=fromDateTime.getAttribute("aria-valuetext").toUpperCase();
       String time=fromTime.getAttribute("aria-valuetext");
        String msg = "Update Assessment 'Not Administered/Completed' from " + date + " " + time + " to " + date + " " + time + " from Current Status Checked to Unchecked for assessment " + AssessmentName + " in visit " + visitName;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }
    public void verifyDefinitionFieldGeneratedAccordingToThisFormatOther(String sponsorName, String studyName, String changeFrom, String changeTo){

        String msg = "Update information for Client " + sponsorName + " Study " + studyName + " from " + changeFrom + " to " + changeTo;
        System.out.println((definitionFieldArea.getText()));
        assertEquals(definitionFieldArea.getText(), msg);
    }

    public void verifyDefinitionFiledDisplayedInDefinitionField(){
        assertTrue("Definition is displayed",definitionFieldArea.isDisplayed());
    }
    public void verifyDefinitionFiledAllowOnlyFirstHundredCharacter(){
        String typedValue = site.get(0).getAttribute("value");
        int size = typedValue.length();
        assertEquals(33, size);
    }
    public void selectReasonTypes(){
        clickOn(reasonTypesDropDown);
        clickOn(value2);
    }

    public void selectReasonTypesDropDown(){
        clickOn(reasonTypesDropDown);
        clickOn(value4);
    }
    public void selectReasonTypesDropDownReconciliation(){
        clickOn(reasonTypesDropDown);
        clickOn(reconciliation);
    }

    public void selectReasonTypesDropDownOther(){
        clickOn(reasonTypesDropDown);
        clickOn(other);
    }

    public void selectReasonTypesDropDownSponsorRequest(){
        clickOn(reasonTypesDropDown);
        clickOn(sponsorRequest);
    }

    public void selectReasonTypesDropDownSystemErrorLimitation(){
        clickOn(reasonTypesDropDown);
        clickOn(SystemErrorLimitation);
    }

    public void verifyPrivacyAndDataProtectionDisplayedInReasonTypes(){
        assertElementIsVisibile(reasonTypesDropDown, "Privacy and Data Protection");
    }
    public void verifyDataEntryErrorDisplayedInReasonTypes(){
        assertElementIsVisibile(reasonTypesDropDown, "Data Entry Error");
    }

    public void verifyReconciliationDisplayedInReasonTypes(){
        assertElementIsVisibile(reasonTypesDropDown, "Reconciliation");
    }

    public void verifyOtherDisplayedInReasonTypes(){
        assertElementIsVisibile(reasonTypesDropDown, "Other");
    }

    public void verifySponsorRequestDisplayedInReasonTypes(){
        assertElementIsVisibile(reasonTypesDropDown, "Sponsor Request");
    }

    public void verifySystemErrorLimitationDisplayedInReasonTypes(){
        assertElementIsVisibile(reasonTypesDropDown, "System Error/Limitation");
    }

    public void enterReasonDescriptionField(String reasonDescription){
        inputText(reasonDescriptionArea, reasonDescription);
    }

    public void verifyReasonDescriptionInvalid(Boolean isValid) {
        if(isValid.equals(true))
            assertEquals(reasonDescriptionArea.getAttribute("class"), "ng-dirty ng-touched ng-valid");
        else
            assertEquals(reasonDescriptionArea.getAttribute("class"), "ng-untouched ng-dirty ng-invalid");
    }

    public void verifyReasonDescriptionIsEditable(){
    assertTrue("Reason Description is editable",reasonDescriptionArea.isDisplayed());
}
    public void verifyReasonDescriptionFiledDisplayedInReasonDescriptionField(){
        assertTrue("Reason Description is displayed",reasonDescriptionArea.isDisplayed());
    }
public void verifyReasonDescriptionFiledAllowOnlyFirstTwoThousandCharacter(String reasonDesc){
        String typedValue = reasonDescriptionArea.getAttribute("value");
        int size = typedValue.length();
        assertEquals(reasonDesc.length(), size);
        }
public void clickOnAddRequest(){
        clickOn(addRequest);
        }

public void verifyRemoveSubject(){
        assertEquals(true, removeSubject.isDisplayed());
        }
public void verifyAddRelatesRequestButton(){
        assertEquals(true, addRelatedRequestButton.isDisplayed());
        }
public void verifyCreateChangeRequest(){
        assertEquals(true, createChangeRequest.isEnabled());
        }
public void clickOnExpedited(){
        hoverOverElementAndClick(expedited, expedited);
        }
public void verifyExpeditedRadioButtonSelected(){
        _waitForJStoLoad();
        assertEquals(true, expedited.isEnabled());
        }
public void verifyMandatoryField(){
        assertEquals(true, errorInfo.isDisplayed());
        }
public void verifyCreateChangeRequestButtonDisabled2(){
        assertEquals(true, getCreateChangeRequestButtonDisabled.isDisplayed());
        assertEquals(false, getCreateChangeRequestButtonDisabled.isEnabled());
        }

public void enterPriorityExpedited(String priorityExpeditedTextField) {
        inputText(priorityExpeditedDescription, priorityExpeditedTextField);
        }
    public void verifyPriorityDescriptionInvalid(Boolean isValid) {
        if(isValid.equals(true))
            assertEquals(priorityExpeditedDescription.getAttribute("class"), "ng-valid ng-dirty ng-touched");
        else
            assertEquals(priorityExpeditedDescription.getAttribute("class"), "ng-untouched ng-valid ng-dirty");
    }


    public void verifyPriorityExpeditedDescriptionDisplayedInDescriptionField(){
        assertTrue("Description is displayed",priorityExpeditedDescription.isDisplayed());
        }

public void verifyPriorityExpeditedDescriptionFiledAllowOnlyFirstTwoThousandCharacter(String expeditedDesc){
        String typedValue = priorityExpeditedDescription.getAttribute("value");
        int size = typedValue.length();
        assertEquals(expeditedDesc.length(), size);
        }
public void verifyCreateChangeRequestButtonEnabled(){
        //assertEquals(false, getCreateChangeRequestButtonDisabled.isDisplayed());
        assertEquals(true, createChangeRequestButton.isDisplayed());
        assertEquals(true, createChangeRequestButton.isEnabled());
        }

public void clickOnCreateChangeRequestButton(){
        clickOn(createChangeRequestButton);
        }
public void verifyElectronicSignaturePopUp() {
        //Assert.assertTrue(getPageTitle().contains("Add Request"), "Add Request pop up displays");
        assertElementIsVisibile(electronicSignaturePopUp, "Electronic Signature");
        assertEquals(true, usernameTextArea.isDisplayed());
        assertEquals(true, passwordTextArea.isDisplayed());
        assertEquals(true, confirmButton.isDisplayed());
        }
public void enterUsernamePasswordAndClickOnConfirmButton() throws Exception {
        username= Configuration.readApplicationFile("Username");
        password = Configuration.readApplicationFile("Password");
        inputText(usernameTextArea, username);
        inputText(passwordTextArea, password);
        clickOn(confirmButton);
        _waitForJStoLoad();
        Thread.sleep(10000);
        hoverOverElementAndClick(refreshIcon, refreshIcon);
        Thread.sleep(10000);
        }
public void verifyGridIsShownIncludingTheNewDCR(int rid){
        String requestId = requestLink.get(0).getText();
    assertFalse(requestId.equals(String.valueOf(rid)));
        }

public void verifyNewDCRHasUniqueNumberID(int rid) {
        String requestId = requestLink.get(0).getText();
        assertFalse(requestId.equals(String.valueOf(rid)));
        }
public void verifyNewDCRStatusIsUnderReview() {
        assertEquals("Under Review", status.get(0).getText());
        }
}
