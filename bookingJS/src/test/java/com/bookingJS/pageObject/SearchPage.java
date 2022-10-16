package com.bookingJS.pageObject;


import java.util.List;
 import java.util.StringTokenizer;
  import org.openqa.selenium.JavascriptExecutor;
   import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
     import org.openqa.selenium.support.CacheLookup;
      import org.openqa.selenium.support.FindAll;
       import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.How;
         import org.openqa.selenium.support.PageFactory;
          import com.bookingJS.testCases.BaseClass;
           import com.bookingJS.utilities.ReadConfig;

public class SearchPage extends BaseClass{

	 WebDriver ldriver;
	  JavascriptExecutor js ;
	   ReadConfig readconfig =new ReadConfig();
	    public String baseUrl=readconfig.getApplicationURL();
	     public String countryNameOrder= readconfig.getExecuteScriptById()+readconfig.getEexecuteScriptByIdValue();
	      public String clickSearch=readconfig.getClickSearch();
	       public String checkInScript=readconfig.getCheckInScript();
	        public String checkOutScript=readconfig.getCheckOutScript();
	// public String guestGroup=readconfig.getGuestGroup();
	 
	 public SearchPage (WebDriver rdriver){
	 		ldriver=rdriver;
	 		  PageFactory.initElements(rdriver, this);
	 		   js= (JavascriptExecutor) ldriver;
	 	}
	 
	    @FindAll({@FindBy(how = How.XPATH, using ="//*[@id=\"b_results\"]/li//h2/a")})
		 @CacheLookup 		  //WebElement webSites;
		  List<WebElement> webSites;
		public void setCountryName(String countryName)
		{
			js.executeScript(countryNameOrder+aggregation(countryName));
			  System.out.println(countryNameOrder+aggregation(countryName));
		}
		
		public void clickSearch()
		{
			js.executeScript(clickSearch);
		}
		
	    public String selAccount(String name) {
	    	int posiation =-1;
	    	 int maxSimilarly=0;
	    	  int i = 0 ; 
	      	   for (WebElement site: webSites) {
	    		int dum=filter(name ,site.getAttribute("href"));
	    		 if (maxSimilarly < dum) {
	    		   maxSimilarly=dum;
	    			posiation=i;}
	    		     i++;}
	    	          if(maxSimilarly ==0) {// the hotal is not exist 
	    		       return null;}
	    	            else { 
	    	  	         return webSites.get(posiation).getAttribute("href")+""; // the hotal is  exist
	    	}
		}
	    
	    public int filter(String name , String link) {	
	     if(link.contains("www.expedia")) {
	      String dum =link.replace("https://www.expedia.","");
	    	StringTokenizer st = new StringTokenizer(deleteFromFilter(dum),".");
	    	 String dumSt= st.nextToken().replace("-"," ");
	    	  return filteHelp(name,dumSt);}
	           return 0;
	    }
	    
	    
	   public int filteHelp(String name,String target) {
		   
		   StringTokenizer st = new StringTokenizer(name," ");
		    int matches=0;
		     for (;st.hasMoreTokens();) {
			   String dum = st.nextToken();
			    if(target.contains(dum)) {
			     matches++;}}
		          return matches;
	   }
	    public String deleteFromFilter(String target){
	       StringBuilder MyString = new StringBuilder(target);
	    	for(int i=0;i<MyString.length();i++) {
	    	  if (MyString.charAt(0) != '/') {
	    		MyString.deleteCharAt(0);	 
	    		  }else {
	    		    MyString.deleteCharAt(0);
	    			 break;}}
	    	          return MyString.toString();
	    }
	    
		public void setCheckOut(String checkOut)
		{
			js.executeScript(checkOutScript+ aggregation(checkOut));	
		}		
		
		public void btnSubmit()
		{
			js.executeScript(readconfig.getSubmitBtn());	
		}
		
			
}
