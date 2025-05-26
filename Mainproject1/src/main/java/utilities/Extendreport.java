package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extendreport 
{
	public static final ExtentReports extentReports = new ExtentReports(); //object crtn for extentreport class  
	public synchronized static ExtentReports createExtentReports() {//thread safety used synchronized    

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//path reporter object 
		
		reporter.config().setReportName("grocery application");  
		extentReports.attachReporter(reporter);  //attach reporter object to extenetreporter object .it gives a repot in folder 
		extentReports.setSystemInfo("Organization", "Obsqura");  
		extentReports.setSystemInfo("Name", "farsana ");
		return extentReports;   
	}

}
