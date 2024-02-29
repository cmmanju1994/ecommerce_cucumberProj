package factory;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.Logger;
//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
 	
 	// view into particular element
 	
 	public static void ScrollTillElementVisible(WebDriver driver,WebElement ele)
 	{
 		JavascriptExecutor js=(JavascriptExecutor)driver;
 		js.executeScript("arguements[0].scrollIntoView()", ele);
 	}
 	
 	// moving to element and click
 	
 	public static void ClickAction(WebDriver driver,WebElement ele)
 	{
 		Actions act=new Actions(driver);
 		act.moveToElement(ele).click().build().perform();
 	}
 	
 	// Finding element on webpage
 	
 	public static boolean findElement(WebDriver driver,WebElement ele)
 	{
 		boolean flag=false;
 		try
 		{
 			ele.isDisplayed();
 			flag=true;
 		}
 		catch (Exception e)
 		{
 			System.out.println("Element not found "+ele);
 			flag=false;
 		}
 		finally
 		{
 			if(flag)
 			{
 				System.out.println("Element found");
 			}
 			else
 			{
 				System.out.println("Element not found");
 			}
 		}
		return flag;
 		
 	}
 	
 	// Element displayed?
 	
 	public static boolean isElementDisplayed(WebDriver driver,WebElement ele)
 	{
 		boolean flag=false;
 		flag=findElement(driver,ele);
 		if(flag)
 		{
 			flag = ele.isDisplayed();
 			if(flag)
 			{
 				System.out.println("Element is displayed");
 			}
 			else
 			{
 				System.out.println("Element is not displayed");
 			}
 		}
 		else
 		{
 			System.out.println("not displayed");
 		}
		return flag;
 				
 	}
 	
 	// Is element selected
 	
 	public static boolean isSelected(WebDriver driver,WebElement ele)
 	{
 		boolean flag=false;
 		flag=findElement(driver,ele);
 		if(flag)
 		{
 			flag=ele.isSelected();
 			if(flag)
 			{
 				System.out.println("Element is selected");
 			}
 			else
 			{
 				System.out.println("Element is not selected");
 			}
 			
 		}
 		else
 		{
 			System.out.println("Element not selected");
 		}
		return flag;
 				}
 	
 // Is enabled
	
 		public static boolean isEnabled(WebDriver driver,WebElement ele)
 		{
 			boolean flag=false;
 			flag=findElement(driver,ele);
 			if(flag)
 			{
 				flag=ele.isEnabled();
 				if(flag)
 				{
 					System.out.println("Element is enabled");
 				}
 				else
 				{
 					System.out.println("Element is not enabled");
 				}
 			}
 			else
 			{
 				System.out.println("ELement is not enabled");
 			}
 			return flag;
 			
 			
 		}
 	
 	
 	/**
 		 * Type text at location
 		 * 
 		 * @param locatorName
 		 * @param text
 		 * @return - true/false
 		 */
 		
 		public static boolean type(WebElement ele,String text)
 		{
 			boolean flag=false;
 			try
 			{
 				flag=ele.isDisplayed();
 				ele.clear();
 				ele.sendKeys(text);
 				flag=true;
 			}
 			catch(Exception e)
 			{
 				flag=false;
 			}
 			finally
 			{
 				if(flag)
 				{
 					System.out.println("Successfuly entered value");
 				}
 				else
 				{
 					System.out.println("Unable to enter the value");
 				}
 			}
			return flag;
 		}
 		
 		
 		public boolean selectBySendkeys(String value,WebElement ele)
 		{
 			boolean flag=false;
 			try
 			{
 				ele.sendKeys(value);
 				flag=true;
 				return true;
 			}
 			catch(Exception e)
 			{
 				flag=false;
 			}
 			finally
 			{
 				if(flag)
 				{
 					System.out.println("Select value from the dropdown");
 				}
 				else
 				{
 					System.out.println("Not selected value from the dropdown");
 				}
 			}
			return flag;
 		}
 	
 	
 		/**
 		 * select value from DropDown by using selectByIndex
 		 * 
 		 * @param locator     : Action to be performed on element (Get it from Object
 		 *                    repository)
 		 * 
 		 * @param index       : Index of value wish to select from dropdown list.
 		 * 
 		 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
 		 *                    Listbox etc..)
 		 * 
 		 */
 		
 		public static boolean selectDropdownByIndex(WebElement ele,int index)
 		{
 			boolean flag=false;
 			try
 			{
 				Select oselect=new Select(ele);
 				oselect.selectByIndex(index);
 				flag=true;
 				return true;
 			}
 			catch(Exception e)
 			{
 				return false;
 			}
 			finally
 			{
 				if(flag)
 				{
 					System.out.println("Option selected by index value");
 				}
 				else
 				{
 					System.out.println("Option is not selected by index value");

 				}
 			}
 		}
 	
 	
 		/**
 		 * select value from DD by using value
 		 * 
 		 * @param locator     : Action to be performed on element (Get it from Object
 		 *                    repository)
 		 * 
 		 * @param value       : Value wish to select from dropdown list.
 		 * 
 		 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
 		 *                    Listbox etc..)
 		 */
 		
 		public static boolean selectDropdownUsingVisibleText(WebElement ele,String value)
 		{
 			boolean flag=false;
 			try
 			{
 				Select oselect=new Select(ele);
 				oselect.selectByValue(value);
 				flag=true;
 				return true;
 			}
 			catch(Exception e)
 			{
 				return false;
 			}
 			finally
 			{
 				if(flag)
 				{
 					System.out.println("Option selected");
 				}
 				else
 				{
 					System.out.println("Option is not selected");
 				}
 			}
 		}
 		
 		
 		// Select drop down using visible text
 		
 		public static boolean selectDropdownByVisibleText(WebElement ele,String VisibleText)
 		{
 			boolean flag=false;
 			try
 			{
 				Select oselect=new Select(ele);
 				oselect.selectByVisibleText(VisibleText);
 				return flag=true;
 			}
 			catch(Exception e)
 			{
 				flag=false;
 				return flag;
 			}
 			finally
 			{
 				if(flag)
 				{
 					System.out.println("Dropdown selected using visible text");
 				}
 				else
 				{
 					System.out.println("Drop down is not selected");
 				}
 			}
 		}
 		
 		
 		public boolean mouseHoverByJavaScript(WebElement ele) {
 			boolean flag = false;
 			try {
 				WebElement mo = ele;
 				String javaScript = "var evObj = document.createEvent('MouseEvents');"
 						+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
 						+ "arguments[0].dispatchEvent(evObj);";
 				JavascriptExecutor js = (JavascriptExecutor) driver;
 				js.executeScript(javaScript, mo);
 				flag = true;
 				return true;
 			}

 			catch (Exception e) {

 				return false;
 			} finally {
 				if (flag) {
 					System.out.println("MouseOver Action is performed");
 				} else {
 					System.out.println("MouseOver Action is not performed");
 				}
 			}
 		}
 		
 		
 		// click using java script
 		
 		public static boolean JSClick(WebDriver driver,WebElement ele)
 		{
 			boolean flag=false;
 			try
 			{
 				JavascriptExecutor js=(JavascriptExecutor)driver;
 				js.executeScript("arguments[0].click()", ele);
 				flag=true;
 				
 			}
 			catch(Exception e)
 			{
 				throw e;
 				//return flag=false;
 			}
 			finally
 			{
 				if(flag)
 				{
 					System.out.println("Click action is performed");
 				}
 				else if(!flag)
 				{
 					System.out.println("click action not performed");
 				}
 			}
			return flag;
 		}
 		
 		// switch to frame  by index
 		
 		public static boolean SwitchToFrameByIndex(WebDriver driver,int index)
 		{
 			boolean flag=false;
 			try
 			{
 				WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(15));
 				//new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
 				mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
 				driver.switchTo().frame(index);
 				flag=true;
 				return true;
 			}
 			catch(Exception e)
 			{
 				return false;
 			}
 			finally
 			{
 				if(flag)
 				{
 					System.out.println("Frame with index \"" + index + "\" is selected");
 				}
 				else
 				{
 					System.out.println("Frame with index \"" + index + "\" is not selected");
 				}
 			}
 		}
 		
 		public boolean switchToFrameById(WebDriver driver,String idValue) {
 			boolean flag = false;
 			try {
 				driver.switchTo().frame(idValue);
 				flag = true;
 				return true;
 			} catch (Exception e) {

 				e.printStackTrace();
 				return false;
 			} finally {
 				if (flag) {
 					System.out.println("Frame with Id \"" + idValue + "\" is selected");
 				} else {
 					System.out.println("Frame with Id \"" + idValue + "\" is not selected");
 				}
 			}
 		}
 		
 		// Switch to frame by name
 		
 		public boolean switchToFrameByName(WebDriver driver,String nameValue) {
 			boolean flag = false;
 			try {
 				driver.switchTo().frame(nameValue);
 				flag = true;
 				return true;
 			} catch (Exception e) {

 				return false;
 			} finally {
 				if (flag) {
 					System.out.println("Frame with Name \"" + nameValue + "\" is selected");
 				} else if (!flag) {
 					System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
 				}
 			}
 		}
 		
 		// switching back to main frame 
 		
 		public boolean switchToDefaultFrame(WebDriver driver) {
 			boolean flag = false;
 			try {
 				driver.switchTo().defaultContent();
 				flag = true;
 				return true;
 			} catch (Exception e) {
 				e.printStackTrace();
 				return false;
 			} finally {
 				if (flag) {
 					// SuccessReport("SelectFrame ","Frame with Name is selected");
 				} else if (!flag) {
 					// failureReport("SelectFrame ","The Frame is not selected");
 				}
 			}
 		}
 		
 		// Mouse hover
 		
 		public static void mouseOverElement(WebDriver driver,WebElement element) {
 			boolean flag = false;
 			try {
 				new Actions(driver).moveToElement(element).build().perform();
 				flag = true;
 			} catch (Exception e) {
 				e.printStackTrace();
 			} finally {
 				if (flag) {
 					System.out.println(" MouserOver Action is performed on ");
 				} else {
 					System.out.println("MouseOver action is not performed on");
 				}
 			}
 		}
 		
 		public boolean moveToElement(WebDriver driver, WebElement ele) {
 			boolean flag = false;
 			try {
 				// WebElement element = driver.findElement(locator);
 				JavascriptExecutor executor = (JavascriptExecutor) driver;
 				executor.executeScript("arguments[0].scrollIntoView(true);", ele);
 				Actions actions = new Actions(driver);
 				// actions.moveToElement(driver.findElement(locator)).build().perform();
 				actions.moveToElement(ele).build().perform();
 				flag = true;
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 			return flag;
 		}
 		
 		public boolean mouseover(WebDriver driver, WebElement ele) {
 			boolean flag = false;
 			try {
 				new Actions(driver).moveToElement(ele).build().perform();
 				flag = true;
 				return true;
 			} catch (Exception e) {
 				return false;
 			} finally {
 				/*
 				 * if (flag) {
 				 * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
 				 * +"\""); } else {
 				 * failureReport("MouseOver","MouseOver action is not performed on \""
 				 * +locatorName+"\""); }
 				 */
 			}
 		}
 		
 		public boolean draggable(WebDriver driver,WebElement source, int x, int y) {
 			boolean flag = false;
 			try {
 				new Actions(driver).dragAndDropBy(source, x, y).build().perform();
 				Thread.sleep(5000);
 				flag = true;
 				return true;

 			} catch (Exception e) {
 			
 				return false;
 				
 			} finally {
 				if (flag) {
 					System.out.println("Draggable Action is performed on \""+source+"\"");			
 				} else if(!flag) {
 					System.out.println("Draggable action is not performed on \""+source+"\"");
 				}
 			}
 		}
 		
 		public boolean draganddrop(WebDriver driver,WebElement source, WebElement target) {
 			boolean flag = false;
 			try {
 				new Actions(driver).dragAndDrop(source, target).perform();
 				flag = true;
 				return true;
 			} catch (Exception e) {

 				return false;
 			} finally {
 				if (flag) {
 					System.out.println("DragAndDrop Action is performed");
 				} else if(!flag) {
 					System.out.println("DragAndDrop Action is not performed");
 				}
 			}
 		}
 		
 		public boolean slider(WebDriver driver,WebElement ele, int x, int y) {
 			boolean flag = false;
 			try {
 				// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
 				// .perform();
 				new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
 				Thread.sleep(5000);
 				flag = true;
 				return true;
 			} catch (Exception e) {

 				return false;
 			} finally {
 				if (flag) {
 					System.out.println("Slider Action is performed");
 				} else {
 					System.out.println("Slider Action is not performed");
 				}
 			}
 		}
 		
 		public boolean rightclick(WebDriver driver,WebElement ele) {
 			boolean flag = false;
 			try {
 				Actions clicker = new Actions(driver);
 				clicker.contextClick(ele).perform();
 				flag = true;
 				return true;
 				// driver.findElement(by1).sendKeys(Keys.DOWN);
 			} catch (Exception e) {

 				return false;
 			} finally {
 				if (flag) {
 					System.out.println("RightClick Action is performed");
 				} else {
 					System.out.println("RightClick Action is not performed");
 				}
 			}
 		} 
 		
 		
 		// Switching to window
 		
 		public boolean switchToWindow(WebDriver driver,String windowtitle,int count)
 		{
 			boolean flag=false;
 			try
 			{
 				Set<String> windowlist=driver.getWindowHandles();
 				String[] array = windowlist.toArray(new String[0]);
 				driver.switchTo().window(array[count-1]);
 				if(driver.getTitle().contains(windowtitle))
 				{
 					flag=true;
 				}
 				else
 				{
 					flag=false;
 				}
 				return flag;
 				
 			}
 			catch(Exception e)
 			{
 				return flag;
 			}
 			finally
 			{
 				if(flag)
 				{
 					System.out.println("Navigated window with the given title");
 				}
 				else
 				{
 					System.out.println("Not navigated to window");
 				}
 			}
 			
 		}
 		
 		
 	//
 		
 		public boolean switchToNewWindow(WebDriver driver) {
 			boolean flag = false;
 			try {

 				Set<String> s=driver.getWindowHandles();
 				Object popup[]=s.toArray();
 				driver.switchTo().window(popup[1].toString());
 				flag = true;
 				return flag;
 			} catch (Exception e) {
 				flag = false;
 				return flag;
 			} finally {
 				if (flag) {
 					System.out.println("Window is Navigated with title");				
 				} else {
 					System.out.println("The Window with title: is not Selected");
 				}
 			}
 		}
 		
 		public boolean switchToOldWindow(WebDriver driver) {
 			boolean flag = false;
 			try {

 				Set<String> s=driver.getWindowHandles();
 				Object popup[]=s.toArray();
 				driver.switchTo().window(popup[0].toString());
 				flag = true;
 				return flag;
 			} catch (Exception e) {
 				flag = false;
 				return flag;
 			} finally {
 				if (flag) {
 					System.out.println("Focus navigated to the window with title");			
 				} else {
 					System.out.println("The Window with title: is not Selected");
 				}
 			}
 		}
 		
 	/*	public int getColumncount(WebElement row) {
 			List<WebElement> columns = row.findElements(By.tagName("td"));
 			int a = columns.size();
 			System.out.println(columns.size());
 			for (WebElement column : columns) {
 				System.out.print(column.getText());
 				System.out.print("|");
 			}
 			return a;
 		}*/
 		
 		public int getRowCount(WebElement table) {
 			List<WebElement> rows = table.findElements(By.tagName("tr"));
 			int a = rows.size() - 1;
 			return a;
 		}
 		
 		public boolean Alert(WebDriver driver) {
 			boolean presentFlag = false;
 			Alert alert = null;

 			try {
 				// Check the presence of alert
 				alert = driver.switchTo().alert();
 				// if present consume the alert
 				alert.accept();
 				presentFlag = true;
 			} catch (NoAlertPresentException ex) {
 				// Alert present; set the flag

 				// Alert not present
 				ex.printStackTrace();
 			} finally {
 				if (!presentFlag) {
 					System.out.println("The Alert is handled successfully");		
 				} else{
 					System.out.println("There was no alert to handle");
 				}
 			}

 			return presentFlag;
 		}
 		
 		// launch url
 		
 		public boolean launchUrl(WebDriver driver,String url) {
 			boolean flag = false;
 			try {
 				driver.navigate().to(url);
 				flag = true;
 				return true;
 			} catch (Exception e) {
 				return false;
 			} finally {
 				if (flag) {
 					System.out.println("Successfully launched \""+url+"\"");				
 				} else {
 					System.out.println("Failed to launch \""+url+"\"");
 				}
 			}
 		}
 		
 		public boolean isAlertPresent(WebDriver driver) 
 		{ 
 			try 
 			{ 
 				driver.switchTo().alert(); 
 				return true; 
 			}   // try 
 			catch (NoAlertPresentException Ex) 
 			{ 
 				return false; 
 			}   // catch 
 		}
 		
 		public String getTitle(WebDriver driver) {
 			boolean flag = false;

 			String text = driver.getTitle();
 			if (flag) {
 				System.out.println("Title of the page is: \""+text+"\"");
 			}
 			return text;
 		}
 		
 		public String getCurrentURL(WebDriver driver)  {
 			boolean flag = false;

 			String text = driver.getCurrentUrl();
 			if (flag) {
 				System.out.println("Current URL is: \""+text+"\"");
 			}
 			return text;
 		}
 		
 		public boolean click1(WebElement locator, String locatorName) {
 			boolean flag = false;
 			try {
 				locator.click();
 				flag = true;
 				return true;
 			} catch (Exception e) {
 				return false;
 			} finally {
 				if (flag) {
 					System.out.println("Able to click on \""+locatorName+"\"");
 				} else {
 					System.out.println("Click Unable to click on \""+locatorName+"\"");
 				}
 			}

 		}
 		
 		
 		// Fluent wait
 		
 		public void fluentwait(WebDriver driver,WebElement element,int timeout)
 		{
 			Wait<WebDriver> wait=null;
 			try
 			{
 				wait=new FluentWait<WebDriver>((WebDriver) driver)
 						.withTimeout(Duration.ofSeconds(20))
 						.pollingEvery(Duration.ofSeconds(2))
 						.ignoring(Exception.class);
 				 wait.until(ExpectedConditions.visibilityOf(element));
 		        element.click();
 			}
 			catch(Exception e)
 			{
 				
 			}
 			
 			
 		}
 		
 		
 	// implicit wait
 		
 	public void implicitWait(WebDriver driver,int timeoutinseconds)
 	{
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutinseconds));
 	}
 	
 	// Explicit wait
 	
 	public void explicitwait(WebDriver driver,WebElement element,int durationinseconds)
 	{
 		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationinseconds));
 		wait.until(ExpectedConditions.visibilityOf(element));
 	}
 	
 	// page loadout time
 	
 	public void pageLoadtime(WebDriver driver,int durationSeconds)
 	{
 		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(durationSeconds));
 	}
 	
 	//
 	
 	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
 	
 	
 	
 	
 	
 

}
