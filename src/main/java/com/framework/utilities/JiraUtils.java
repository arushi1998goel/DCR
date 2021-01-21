package com.framework.utilities;

import static io.restassured.RestAssured.given;
import com.sun.jersey.core.util.Base64;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JiraUtils {

	private String jiraUser;
	private String jiraBaseUrl;
	private String auth;

	public JiraUtils() {
		this.jiraUser = "ashwanis@360logica.com";
		this.jiraBaseUrl = "https://saksoftdemo.atlassian.net";
		auth = new String(Base64.encode(this.jiraUser + ":" + "ugYrTIK65QXHgEhQ4NJd5CED"));
		RestAssured.baseURI = this.jiraBaseUrl;
	}

	public Response createJiraIssue(String projectId, String issueSummary, String issueType, String userAssignTo, String description) {
		String jsonData = "{ \"fields\": { \"project\": { \"id\": \"" + projectId + "\" }, " + "\"summary\":\"Testing issue\", \"issuetype\":{ \"name\": \"" + issueType + "\"}, \"assignee\": "
				+ "{ \"name\": \"" + userAssignTo + "\"}, \"reporter\": {\"id\": \"" + "557058:aa6c3490-1ca1-4db6-b1c1-77a3b24b4c3e" + "\" },"
				+ "\"description\":{\"type\": \"doc\",\"version\": 1,\"content\": [{\"type\": \"paragraph\",\"content\": [ {\"type\": \"text\", \"text\": \"" + description + "\"}]} ]}}}";
		System.out.println(jsonData);
		Response response = given().header("Authorization", "Basic " + auth).header("Content-Type", "application/json").body(jsonData).when().post("/rest/api/3/issue");
		// Assert.assertEquals(response.getStatusCode(), 201);

		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		return response;
	}

	/**
	 * Add comment in issue
	 * 
	 * @param issueId
	 *            : provide issue id
	 * @param comment
	 *            : provide you comment
	 */
	public Response addComment(String issueId, String comment) {
		String json = "{ \"visibility\": { \"type\": \"role\",  \"value\": \"Administrators\" }, \"body\": {\"type\": \"doc\", \"version\": 1, "
				+ "\"content\": [{ \"type\": \"paragraph\", \"content\": " + "[{\"text\": \"" + comment + "\", \"type\": \"text\"} ] }] } }";
		System.out.println(json);
		Response response = given().header("Authorization", "Basic " + auth).header("Content-Type", "application/json").body(json).when().post("/rest/api/3/issue/" + issueId + "/comment");
		System.out.println(response.asString());
		return response;
	}

	/**
	 * Get issue details
	 * 
	 * @return : return response
	 */
	public Response getIssuedetails(String issueId) {
		Response response = given().header("Authorization", "Basic " + auth).header("Content-Type", "application/json").when().get("rest/api/3/issue/EEE-51");
		return response;
	}

	/**
	 * Update task/issue resolution
	 * 
	 * @param issueId
	 *            : Provide task issue id to change resolution
	 * @param resolutionName
	 *            : resolution name like "Done", "Fixed", "InProgress" etc
	 * @param transitionId
	 *            : provide corresponding resolution's transaction id
	 */
	public void updateIssueResolution(String issueId, String resolutionName, String transitionId) {
		String jsonData = "{" + " \"fields\": { \"resolution\": { \"name\": \"" + resolutionName + "\" } }, " + "\"transition\": { \"id\": \"" + transitionId + "\"  } " + "}";
		Response response4 = given().header("Authorization", "Basic " + auth).header("Content-Type", "application/json").body(jsonData).when().post("/rest/api/3/issue/" + issueId + "/transitions");
		System.out.println(response4.getStatusCode());
		System.out.println(response4.asString());
	}

	/**
	 * Get transitions details of task
	 * 
	 * @param taskId
	 *            : task Id
	 * @return
	 */
	public Response getResolutionOfTask(String taskId) {
		Response response = given().header("Authorization", "Basic " + auth).header("Content-Type", "application/json").when().get("/rest/api/3/issue/" + taskId + "/transitions");
		return response;
	}

	public String checkIssue(String summaryText) {
		Response response = given().header("Authorization", "Basic " + auth).header("Content-Type", "application/json").when().get("/rest/api/3/search?jql=project=10000 and issuetype=Bug");
		int total = response.then().extract().path("total");
		for (int i = 0; i < total; i++) {
			String bugType = response.then().extract().path("issues[" + i + "].fields.issuetype.name");
			String summary = response.then().extract().path("issues[" + i + "].fields.summary");
			String resolution = response.then().extract().path("issues[" + i + "].fields.status.name");
			String key = response.then().extract().path("issues[" + i + "].key");
			if (bugType.equals("Bug") && !resolution.equals("Done") && summary.contains(summaryText)) {
				return key;
			}
		}
		return "Not Found";

	}

	public static void main(String args[]) {
		JiraUtils jiraTicket = new JiraUtils();
		String BugID = jiraTicket.checkIssue("Sadik");
		System.out.println(BugID);

		// Uncomment this function to get Jira ticket detais
		// Response response = jiraTicket.getIssuedetails("EEE-51");
		// System.out.println(response.asString());

		// In comment function to add comment in jira ticket
		Response response = jiraTicket.addComment(BugID, "Testing");
		System.out.println(response.asString());

		Response response1 = jiraTicket.getResolutionOfTask(BugID);
		System.out.println(response1.asString());

		// TODO resolution not updating
		// jiraTicket.updateIssueResolution("EEE-51", "Done", "41");
	}
}
