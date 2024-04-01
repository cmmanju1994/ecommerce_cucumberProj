package drivers;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.PropertiesConfig;


public class DriverInitialization {

	 static WebDriver driver;
     static Properties p ;
     static Logger logger;
     PropertiesConfig pc = new PropertiesConfig(); 

    
	public WebDriver initilizeBrowser() throws IOException {
		
    	 if(pc.getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
				switch(pc.getProperties().getProperty("browser").toLowerCase()) {
				case "chrome":
				
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    case "firefox":
			        driver=new FirefoxDriver();
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
     
     public static WebDriver getDriver() {
 		return driver;
 	}
}
