package factory;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass 
{
	
	 static WebDriver driver;
     static Properties p;
     static Logger logger;
     
     public static WebDriver initilizeBrowser() throws IOException
     {
    	 if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
			{
				switch(getProperties().getProperty("browser").toLowerCase()) 
				{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
		 driver.manage().deleteAllCookies(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		 
		 return driver;
     }
     
     public static Properties getProperties() throws IOException
     {
    	 FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
    		
         p=new Properties();
 		p.load(file);
 		return p; 
     }
     
     public static Logger getLogger()
     {
    	 logger=LogManager.getLogger(); //Log4j
 		return logger; 
     }
     
     public static String randomeString()
 	{
 		String generatedString=RandomStringUtils.randomAlphabetic(5);
 		return generatedString;
 	}
 	
 	
 	public static String randomeNumber()
 	{
 		String generatedString=RandomStringUtils.randomNumeric(10);
 		return generatedString;
 	}
 	
 		
 	public static String randomAlphaNumeric()
 	{
 	String str=RandomStringUtils.randomAlphabetic(5);
 	 String num=RandomStringUtils.randomNumeric(10);
 	return str+num;
 	}
     
 	public static WebDriver getDriver() {
		return driver;
	}
 	
 	public static void select_dropdown_index(WebElement element,int index_value)
 	{
 		Select oselect=new Select(element);
 		oselect.selectByIndex(index_value);
		
 	}
 

}