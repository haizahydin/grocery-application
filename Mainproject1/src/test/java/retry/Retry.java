package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer { 
		   
	 	private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class"); //log retry attempt ,log manager is a class 
	 	private static final int maxTry = 3;//how many times    
	 	private int count = 0; //track no of retry   
	  
	 	@Override 
	 	public boolean retry(final ITestResult iTestResult) { //override retry method
	 		if (!iTestResult.isSuccess()) {  //fail  
	 			if (this.count < maxTry) {      
	  
	 				LOG.info("Retrying test " + iTestResult.getName() + " with status " 
	 						+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");  
	 				this.count++; 
	 				return true; //happened retry  
	 			} 
	 		} 
	 		return false;  //nomore retry  
	 	} 
	 public String getResultStatusName(final int status) { 
	 		String resultName = null; 
	 		if (status == 1) { 
	 			resultName = "SUCCESS"; 
	 		} 
	 		if (status == 2) { 
	 			resultName = "FAILURE"; 
	 		} 
	 		if (status == 3) { 
	 			resultName = "SKIP"; 
	 		} 
	 		return resultName; 
	 	} 
	  
	 }


