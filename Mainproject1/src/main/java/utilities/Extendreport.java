package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extendreport 
{
	public static final ExtentReports extentReports = new ExtentReports();  
	public synchronized static ExtentReports createExtentReports() {   

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		
		reporter.config().setReportName("grocery application");  
		extentReports.attachReporter(reporter);  
		extentReports.setSystemInfo("Organization", "Obsqura");  
		extentReports.setSystemInfo("Name", "farsana ");
		return extentReports;   
	}

}
