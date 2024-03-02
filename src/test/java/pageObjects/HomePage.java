package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class HomePage extends BasePage
{

	// Constructor to initialize Page Objects
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	// Home Page Elements
	
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]/li[4]")
	WebElement link_signuplogin;
	
	@FindBy(xpath="//i[@class=\"fa fa-user\"]")
	WebElement txt_loggedin_as;
	
	@FindBy(xpath="//a[@href=\"/delete_account\"]")
	WebElement link_delete_acc;
	
	@FindBy(xpath="//a[@href=\"/products\"]")
	WebElement link_Products;
	
	//*************//
	@FindBy(xpath="//div[@class=\"end-card-overlay\"]")
	WebElement adlayout;
	
	@FindBy(xpath="//div[@id=\"dismiss-button\"]")
	WebElement adclose;
	
	@FindBy(xpath="//div[@id=\"ad_position_box\"]")
	WebElement adPositionBox;
	
	@FindBy(xpath="//div[@id=\"dismiss-button\"]")
	WebElement disimiss_button_ad;
	
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]/li[3]")
	WebElement cart;
	
	
	
	// Methods
	
	public boolean isSignUp_Login_displayed()
	{
		boolean signup_login=link_signuplogin.isDisplayed();
		return signup_login;
	}
	
	public void click_on_LoginLink()
	{
		link_signuplogin.click();
	}
	
	/*public String gettext_loged_in_as()
	{
		String user_text=txt_loggedin_as.getText();
		return user_text;
	}*/
	
	public boolean isLogedinas_user_displayed()
	{
		boolean logedin_status= txt_loggedin_as.isDisplayed();
		return logedin_status;
	}
	
	public void click_deleteacc()
	{
		link_delete_acc.click();
	}
	
	public void click_On_Products_link()
	{
		
		link_Products.click();
		try
		{
		if(adPositionBox.isDisplayed())
		{
			driver.switchTo().frame(adPositionBox);
			disimiss_button_ad.click();
			driver.switchTo().defaultContent();
		}
		else
		{
			System.out.println("Ad has not come");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Finally executed");
		}
		
		/*BaseClass obj=new BaseClass();
		if(adlayout.isDisplayed())
		{
			obj.switchToFrameById(driver, "aswift_3");
			adclose.click();
			driver.switchTo().defaultContent();
			
		}
		else
		{
			link_Products.click();
		}*/
		
		
	}
	
	public void click_cart()
	{
		cart.click();
	}
	

}
