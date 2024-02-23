package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	
	}
	
	// WebElements
	
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]/li[10]")
	WebElement loged_in_as;
	
	// methods
	
	public boolean isUsername_visible_on_Page()
	{
		if(loged_in_as.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
