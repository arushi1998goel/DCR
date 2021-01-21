package com.framework.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.framework.selenium.core.Configuration;
import com.framework.utilities.Utilities;

public class ReportManager {
	private static String path;
	private static ExtentReports extent;

	/**
	 * Get object of ExtentReports
	 * @return
	 * @throws Exception 
	 */
	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	/**
	 * Created object of extent report
	 * @return
	 * @throws Exception 
	 */
	public static ExtentReports createInstance()  {
		String suiteName = TestDetail.getInstance().getSuiteName();
		if (extent == null) {
			String reportName = "Report";
			try {
				reportName = Configuration.readApplicationFile("ExtentReport");
			} catch (Exception e) {
				e.printStackTrace();
			}
			String workingDir = System.getProperty("user.dir");
			//reportName = reportName +"_"+suiteName +"_" +Utilities.getDateTime() +".html";
			reportName = reportName + ".html";
			if (System.getProperty("os.name").toLowerCase().equals("mac")) {
				path = "//target//"+reportName;
			} else {
				path = "\\target\\"+reportName;
			}
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(workingDir + path);
			
			//htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
			//htmlReporter.config().setChartVisibilityOnOpen(true);
			//htmlReporter.config().setTheme(Theme.STANDARD);
			//htmlReporter.config().setDocumentTitle("Selenium Report");
			//htmlReporter.config().setEncoding("utf-8");
			//htmlReporter.config().setReportName("Selenium report");
			htmlReporter.loadXMLConfig("extent-config.xml");			
			extent = new ExtentReports();			
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("os", System.getProperty("os.name"));
		}
		return extent;
	}
}
