package com.bookingJS.testCases;
import java.io.File;
 import java.io.FileOutputStream;
  import java.io.IOException;
   import java.util.Calendar;
    import java.util.concurrent.TimeUnit;
     import org.apache.commons.io.FileUtils;
      import org.apache.commons.lang3.RandomStringUtils;
       import org.apache.log4j.Logger;
        import org.apache.log4j.PropertyConfigurator;
         import org.apache.poi.ss.usermodel.Workbook;
          import org.apache.poi.xssf.usermodel.XSSFSheet;
           import org.apache.poi.xssf.usermodel.XSSFWorkbook;
           import org.openqa.selenium.OutputType;
           import org.openqa.selenium.TakesScreenshot;
          import org.openqa.selenium.WebDriver;
         import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
      import org.openqa.selenium.ie.InternetExplorerDriver;
     import org.testng.annotations.BeforeClass;
    import org.testng.annotations.Parameters;
   import com.bookingJS.pageObject.hotelsObject;
import com.bookingJS.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig =new ReadConfig();
	 public String baseUrl=readconfig.getApplicationURL();
	  public String etc=readconfig.getEtc();
	   public String etcCheck=readconfig.getEEtCheck();
	    public static WebDriver driver;
	     public static Logger logger;
	      public static hotelsObject objectHotelsAssistance[];
	       public static String linkThatAvoidVerf[];

	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("BookingApp");
		 PropertyConfigurator.configure("Log4j.properties");
			if(br.equals("chrome")) {
			   System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+readconfig.getChromePath());
			    ChromeOptions options = new ChromeOptions();
			      options.addArguments("--start-maximied");
			       options.addArguments("--headless");
			        options.addArguments("--disable-infobars");
				     driver=new ChromeDriver(options);

			}else if (br.equals("firefox")) {
				 System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+readconfig.getfirefoxpathURL());
					driver=new FirefoxDriver();
					
			}else if (br.equals("ie")){
				 System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+readconfig.getIEpathURL());
					driver=new InternetExplorerDriver();
					
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.get(baseUrl);
			
	}
/*
	@AfterClass
	public void tearDown() {
	//	driver.quit();
		
	}
*/
	public String aggregation (String name) {
		return name+etc;
	} 
	
	public String aggregationCheck (String name) {
		return name+etcCheck;
	}

	
	public void captureScreen(WebDriver driver ,String tname) throws IOException {
	
		try {
			TakesScreenshot ts= (TakesScreenshot) driver;
			 File source = ts.getScreenshotAs(OutputType.FILE);
			  System.out.println("dd "+getDate().trim()+tname);
			   File target = new File (System.getProperty("user.dir")+"//Screenshots//"+tname+randomeNumrical(6)+".png");
			    FileUtils.copyFile(source, target);
			     System.out.println("Screenshot taken ");
		          }catch (Exception e){
			       System.out.println("Exception is  / BaseClass / captureScreen "+e.getMessage());}
	}
	
	public String getDate () {
		 int dateOne4 = Calendar.HOUR;
		  int dateOne5 = Calendar.MINUTE;
		   int dateOne6 = Calendar.SECOND;
		    return ""+dateOne4+dateOne5+dateOne6;
	}
	
	public void fillArrayOfObject(int length ) {
		objectHotelsAssistance = new hotelsObject[length];
		 for (int i = 0;i<length;i++) {
		   String day = dayRandomeNumrical();
			String mounth = mounthRandomeNumrical();
			 System.out.println("the day is "+"2022"+mounth+day);
			  objectHotelsAssistance[i] = new hotelsObject();
			   objectHotelsAssistance[i].setCheckin("2022"+"-"+mounth+"-"+day);
			    objectHotelsAssistance[i].setCheckOut("2022"+"-"+mounth+"-"+(Integer.parseInt(day)+1));
		}
	}
	
	
	public String dayRandomeNumrical() {
		String dayCheckin= randomeNumrical(2);
		 if (Integer.parseInt(dayCheckin) >28){
		   dayCheckin="27";}
		    if (dayCheckin.length()==1) {
			 dayCheckin="0"+dayCheckin;}
		      return dayCheckin;

	}
	
	public String mounthRandomeNumrical() {
		String mounthCheckin= randomeNumrical(2);
		 if(Integer.parseInt(mounthCheckin) >12){
           mounthCheckin="12";}
            if (mounthCheckin.length()==1) {
			 mounthCheckin="0"+mounthCheckin;}
		      return mounthCheckin;
	} 
	
	  
	public String randomeNumrical(int range) {
		  String generatedstring=  RandomStringUtils.randomNumeric(range);
		   return generatedstring;
	}
	
	
	
	public void writeExecl(int row,int cell,String value) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/src/test/java/com/bookingJS/testData/hotels.xlsx");
         try {
          Workbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0); 
             sheet.getRow(row).createCell(cell).setCellValue(value);//Create a row object to retrieve row at index 
              FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir") + "/src/test/java/com/bookingJS/testData/hotelsRE.xlsx");//write the data in excel using output stream
               workbook.write(fileOut);
                workbook.close();
                 fileOut.close();
                  } catch (Exception e) {
			       System.out.println("e form writeExecl"+ e.getLocalizedMessage());}
	}
	
	
}
