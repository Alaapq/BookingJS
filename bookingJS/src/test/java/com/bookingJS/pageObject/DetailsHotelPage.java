package com.bookingJS.pageObject;


import java.util.StringTokenizer;
 import org.openqa.selenium.JavascriptExecutor;
  import org.openqa.selenium.WebDriver;
   import org.openqa.selenium.support.PageFactory;
    import com.bookingJS.utilities.ReadConfig;

public class DetailsHotelPage {
	
	WebDriver ldriver;
	 ReadConfig readconfig =new ReadConfig();
      public String priceValue=readconfig.getPriceValue();
       JavascriptExecutor js ;
       
	public DetailsHotelPage (WebDriver rdriver) {
		ldriver=rdriver;
		 PageFactory.initElements(rdriver,this);
		  js= (JavascriptExecutor) ldriver;
	}
		
	
	public String getPriceValue()
	{
		 String price = js.executeScript(priceValue).toString();			
	       return price;
	}
	

	
	public String helpPrice(String target) {
		StringTokenizer st = new StringTokenizer(target,"$");
		  return st.nextToken();
	}
	
}
