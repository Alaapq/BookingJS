package com.bookingJS.testCases;

import java.io.IOException;
 import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WindowType;
   import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
     import com.bookingJS.pageObject.HotelPage;
      import com.bookingJS.pageObject.hotelsObject;

public class TC_HotelTest_002 extends BaseClass{
	public static int postionAtObjectArray=0;
  @Test 
  public void hotel() throws InterruptedException, IOException {
	  
	  for (hotelsObject obj:objectHotelsAssistance) {
		  
		  if (obj.getLinkTarget().equals("")) {
			  
		  }else {
	      WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		   ChromeOptions options = new ChromeOptions();
		    options.addArguments("--start-maximied");
			 options.addArguments("--headless");
			  options.addArguments("--disable-infobars");
			   driver=new ChromeDriver(options);
			    driver.get(obj.getLinkTarget());
			     HotelPage addNew =new HotelPage(driver);
			      captureScreen(driver,"attach it to allure");
			       Thread.sleep(5000);  
			        addNew.setCheckIn(obj.getCheckin());
			         Thread.sleep(5000);
			          addNew.setCheckOut(obj.getCheckOut());
			           addNew.clickAvailability(postionAtObjectArray);
			             postionAtObjectArray++; }}
  }
  
  
  
}
