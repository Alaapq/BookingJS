package com.bookingJS.testCases;

import java.io.IOException;
 import org.testng.annotations.DataProvider;
  import org.testng.annotations.Test;
   import com.bookingJS.pageObject.SearchPage;
    import com.bookingJS.utilities.XLUtils;


public class TC_SearchTest_001 extends BaseClass{
	public static int postionAtExeclSheet=1;
	
  @Test(dataProvider="hotels")
  
  public void loginTest(String hotel_id,String name, String city, String address) throws IOException, InterruptedException 
	{
			
	    logger.info("URL is opened");
	     driver.get(baseUrl);
		  SearchPage lp=new SearchPage(driver);		
		   String searchTitle= name+" "+city+" "+"expedia";
		    lp.setCountryName(searchTitle); 
		     lp.clickSearch();
		      Thread.sleep(5000);
	       	   String link= lp.selAccount(searchTitle);
		        if ( link== null) {
			     System.out.println("link is null ");  // write null and did not contunie 
		   	      objectHotelsAssistance[postionAtExeclSheet-1].setLinkTarget("");
			       writeExecl(postionAtExeclSheet,4,"");
			        postionAtExeclSheet++;
		            }else {
			         System.out.println("link is not null ");// write link and contunie 
			          objectHotelsAssistance[postionAtExeclSheet-1].setLinkTarget(link);
			           writeExecl(postionAtExeclSheet,4,link);
			            postionAtExeclSheet++;}
		
		
		//TC_DetailsHotelTest_003 T= new TC_DetailsHotelTest_003();
		
		
		
		/*
		 
		 
		lp.setUserName(useremail);
		logger.info("Entered useremail");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
	
		if(!lp.passNotCorrect().equals("Welcome, Please Sign In!") )
		{
			//lp.clickContiune();
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
		//	captureScreen(driver,"loginTest");
			
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			System.out.println("Login test failed");
			logger.info("Login test failed");
		}
		
		*/
		
		
		
	}
	@DataProvider(name="hotels")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/bookingJS/testData/hotels.xlsx";
	 	 int rownum = XLUtils.getRowCount(path, "Sheet1");
		  int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		   String logindata[][] = new String[rownum][colcount];
		    for (int i = 1; i <= rownum; i++) {
			 for (int j = 0; j < colcount; j++) {
			   logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);}}
		        fillArrayOfObject(rownum);
		         return logindata;
	}
	
	
}
