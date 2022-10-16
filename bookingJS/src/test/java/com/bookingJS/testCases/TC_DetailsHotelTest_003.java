package com.bookingJS.testCases;

import java.io.IOException;
 import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
   import com.bookingJS.pageObject.DetailsHotelPage;
    import com.bookingJS.pageObject.hotelsObject;

public class TC_DetailsHotelTest_003 extends BaseClass{
	public static int postionAtExeclSheet=1;
	 
	  @Test 
	  public void detailOfHotel() throws InterruptedException, IOException {
		  
		  for (hotelsObject obj:objectHotelsAssistance) {
			  if (obj.getLinkTarget()=="") {
				  // do something here
			  }else {
			  ChromeOptions options = new ChromeOptions();
			   options.addArguments("--start-maximied");
			    options.addArguments("--headless");
				 options.addArguments("--disable-infobars");
				  driver=new ChromeDriver(options);
				   driver.get(obj.getLinkAvoid());
				    driver.manage().window().maximize();	
				     Thread.sleep(2000);
				      captureScreen(driver,"first result");
				       DetailsHotelPage editcust =new DetailsHotelPage(driver); 
				        Thread.sleep(2000);
				         String price = editcust.getPriceValue();
				          writeExecl(postionAtExeclSheet,5,price);
				           postionAtExeclSheet++; }}	 
    }
    
	  
	  
  
  }
