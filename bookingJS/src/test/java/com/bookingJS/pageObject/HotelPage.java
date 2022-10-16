package com.bookingJS.pageObject;

import java.util.ArrayList;
 import java.util.List;
  import java.util.StringTokenizer;
    import org.openqa.selenium.JavascriptExecutor;
     import org.openqa.selenium.WebDriver;
      import org.openqa.selenium.support.PageFactory;
       import com.bookingJS.testCases.BaseClass;
         import com.bookingJS.utilities.ReadConfig;

public class HotelPage extends BaseClass{

	JavascriptExecutor js ;
	 WebDriver ldriver;
	  ReadConfig readconfig =new ReadConfig();
       public String checkInScript=readconfig.getCheckInScript();
        public String checkOutScript=readconfig.getCheckOutScript();
         public String submitAvailabilityBtn=readconfig.getSubmitAvailabilityBtn();
    
	 
	 
	public HotelPage (WebDriver rdriver) {
		ldriver=rdriver;
		 PageFactory.initElements(rdriver,this);
		  js= (JavascriptExecutor) ldriver;
	}
	

	 public void setCheckIn(String checkIn)
		{
		 List <String> finnalyCorrectionOfDate= filterDate(checkIn);
		  js.executeScript(readconfig.getCheckInScriptFrist()+aggregationCheck(finnalyCorrectionOfDate.get(0))+readconfig.getCheckInScriptSecond()+aggregation(finnalyCorrectionOfDate.get(1))+readconfig.getCheckInScripThird()+aggregationCheck(checkIn));	
		}
	 
	 
	 public void setCheckOut(String checkOut)
		{
		 List <String> finnalyCorrectionOfDate= filterDate(checkOut);
		  js.executeScript(readconfig.getCheckOutScriptFrist()+aggregationCheck(finnalyCorrectionOfDate.get(0))+readconfig.getCheckOutScriptSecond()+aggregation(finnalyCorrectionOfDate.get(1))+readconfig.getCheckOutScripThird()+aggregationCheck(checkOut));		
		}
	 
	 public List<String> filterDate(String date) {
		// "2022-10-13"
		 StringTokenizer st = new StringTokenizer(date,"-");
		  String year= st.nextToken();
		   String mounth= st.nextToken();
		    String day= st.nextToken();
		     String getMnthStat= getMounthStatement(mounth);
		      List <String>dates = new ArrayList<String>();
		       dates.add(day+" "+getMnthStat+" "+year);
		        dates.add(day+" "+getMnthStat.substring(0, 3));
                 return dates;
	 }
	 
	 public String getMounthStatement (String mounth) {
		 String[] mounths=new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"};
		  int targetMounth= Integer.parseInt(mounth);
		   return mounths[targetMounth-1];
	 }
	 
		public void clickAvailability(int postion)
		{
			js.executeScript(submitAvailabilityBtn);
			  String st = driver.getCurrentUrl();
			    objectHotelsAssistance[postion].setLinkAvoid(st);
			
		}
	
}
