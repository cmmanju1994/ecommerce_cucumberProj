package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

}
