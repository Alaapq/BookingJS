package com.bookingJS.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		// Read All confige from the path 
		File src = new File (System.getProperty("user.dir")+"//Configuration//config.properties");
		 try {
			FileInputStream fis= new FileInputStream(src);
		  	 pro=new Properties();
		      pro.load(fis);
		       }catch (Exception e){
                System.out.println("Exception is "+e.getMessage());
		         }
	}
	
	public String getApplicationURL() {
		String url =pro.getProperty("baseURL");
		  return url;
	}
	
	public String getChromePath() {
		String chromepath =pro.getProperty("chromepath");
		  return chromepath;
	}
	
	public String getIEpathURL() {
		String iepath =pro.getProperty("iepath");
		  return iepath;
	}
	
	public String getfirefoxpathURL() {
		String firefoxpath =pro.getProperty("firefoxpath");
		  return firefoxpath;
	}
	
	public String getExecuteScriptById() {
		String dum =pro.getProperty("executeScriptById");
		  return dum;
	}
	
	public String getEexecuteScriptByIdValue() {
		String dum =pro.getProperty("executeScriptByIdValue");
		  return dum;
	}
		
		
	public String getEtc() {
	 	String dum =pro.getProperty("eEtc");
		  return dum;
	}
	
	public String getCheckInScript() {
		String dum =pro.getProperty("checkInScript");
		 return dum;
    }
	
	
	public String getCheckOutScript() {
		String dum =pro.getProperty("checkOutScript");
		  return dum;
    }
	
	public String getGuestGroup() {
		String dum =pro.getProperty("guestGroup");
	   	 return dum;
    }
	
	
	public String getGuestGroupAdult() {
		String dum =pro.getProperty("guestGroupAdult");
	  	 return dum;
	}
	
	
	public String getGuestGroupChildren() {
		String dum =pro.getProperty("guestGroupChildren");
		  return dum;
	}
	
	
	public String getGuestGroupRoom() {
		String dum =pro.getProperty("guestGroupRoom");
		 return dum;
	}
	
	public String getSubmitBtn() {
		String dum =pro.getProperty("submitBtn");
	  	 return dum;
	}
	public String getClickSearch() {
		String dum =pro.getProperty("clickSearch");
		 return dum;
	}
	
	public String getCheckInScriptFrist() {
		String dum =pro.getProperty("checkInScriptFrist");
	 	 return dum;
	}
	
	public String getCheckInScriptSecond() {
		String dum =pro.getProperty("checkInScriptSecond");
		 return dum;
	}
	
	public String getEEtCheck() {
		String dum =pro.getProperty("eEtCheck");
		 return dum;
	}
	
	public String getCheckInScripThird() {
		String dum =pro.getProperty("checkInScripThird");
		 return dum;
	}

	public String getCheckOutScriptFrist() {
		String dum =pro.getProperty("checkOutScriptFrist");
		 return dum;
	}
	
	public String getCheckOutScriptSecond() {
		String dum =pro.getProperty("checkOutScriptSecond");
		 return dum;
	}
	
	public String getCheckOutScripThird() {
		String dum =pro.getProperty("checkOutScripThird");
	  	 return dum;
	}
	public String getSubmitAvailabilityBtn() {
		String dum =pro.getProperty("submitAvailabilityBtn");
		 return dum;
	}
	
	public String getPriceValue() {
		String dum =pro.getProperty("priceValue");
		 return dum;
	}
	
	
	
}
