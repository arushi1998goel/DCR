package com.framework.report;

public class TestDetail {

	private static TestDetail testDetail = null;
	private String currentSuiteName = "Default-Suite";
	private String currentTestName = "Default-Test";

	private TestDetail() {
	}

	public static synchronized TestDetail getInstance() {
		if (testDetail == null)
			testDetail = new TestDetail();
		return testDetail;
	}

	public synchronized void setSuiteName(String suiteName) {
		this.currentSuiteName = suiteName;
	}

	public synchronized String getSuiteName() {
		return currentSuiteName;
	}

	public synchronized void setTestName(String testName) {
		this.currentTestName = testName;
	}

	public synchronized String getTestName() {
		return currentTestName;
	}
}
