package com.framework.selenium.core;

import java.io.File;
import java.net.URL;
import java.nio.file.StandardOpenOption;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.aventstack.extentreports.Status;
import com.deque.axe.AXE;
import com.framework.report.ReportName;
import com.framework.report.ReportTestManager;

public class AXEDeque {
	
	/**
	 * Class logger.
	 */
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private static final URL scriptUrl =
			AXEDeque.class.getResource("/axe-lib/axe.min.js");

	public void testAccessibility(WebDriver driver	) throws Exception {
		
		String enable = Configuration.getAxeConfig("enableaxe");
		String standard = Configuration.getAxeConfig("axestandard");
		if(enable.equalsIgnoreCase("true")) {
			try {
				JSONObject responseJSON = new AXE.Builder(driver, scriptUrl)
						.options("{\n" + "  runOnly: {\n" + "    type: \"tag\",\n"
								+ "    values: [\"$text$\"]\n".replace("$text$", standard)
								+ "  }\n" + "}")
						.analyze();	
				JSONArray violations = responseJSON.getJSONArray("violations");	
				if (violations.length() > 0) {
					File folderPath = new File(System.getProperty("user.dir") + "/target/Axe/");
					if(!folderPath.exists()) {
						folderPath.mkdir();
					}
					Path axeReport = Paths.get(folderPath.getAbsolutePath() + "/Axe-"+ReportName.getInstance().getReportName()+".txt");
					if(!Files.exists(axeReport) )
					{
						Files.createFile(axeReport);
					}
					String reportPath = "<a href='file:///$path$'>Report</a>".replace("$path$", axeReport.toString());
					String text = driver.getCurrentUrl() + System.lineSeparator() + AXE.report(violations);
					Files.write(axeReport, text.getBytes(), StandardOpenOption.APPEND);
					System.out.println(violations.length() + " length");
					System.out.println(driver.getCurrentUrl() + " length");
					ReportTestManager.getTest().log(Status.WARNING,"WARNING: Accessibility failed for " + driver.getCurrentUrl() + System.lineSeparator() + "Violations: " + violations.length() + System.lineSeparator()  + reportPath);
					//ReportTestManager.getTest().log(Status.WARNING, violations.toString());
				} else {
					ReportTestManager.getTest().log(Status.PASS, "No accessibility errors for: "  + standard);
				}
			} catch (Exception e) {
				LOG.error("Error while running AXE", e);
			}	
		}
		else{
			LOG.info("Axe not scanning");
		}
	}
} 
