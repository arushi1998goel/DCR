package com.framework.report;

import com.framework.utilities.Utilities;

public class ReportName {

	private static ReportName reportName = null;
	private static String reportFileName = "Default-Name";

	private ReportName() {
	}

	public static synchronized ReportName getInstance() {
		if (reportName == null) {
			reportName = new ReportName();
			reportFileName = TestDetail.getInstance().getSuiteName() + "-"+Utilities.getDateTime();
		}
		return reportName;
	}

	public synchronized String getReportName() {
		return reportFileName;
	}
}