package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpAndLoginPage extends BasePage
{
	
   // Constructor
	
	public SignUpAndLoginPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	// Page Objects
	
	@FindBy(xpath="//div[@class=\"signup-form\"]/h2")
	WebElement text_SignUp;
	
	@FindBy(xpath="//input[@name=\"name\"]")
	WebElement input_Name;
	
	@FindBy(xpath="(//input[@name=\"email\"])[2]")
	WebElement input_EmailSignUp;
	
	@FindBy(xpath="(//button[@type=\"submit\"])[2]")
	WebElement btn_SignUp;
	
	// Methods
	
	public String get_SignUptext()
	{
		String act_text=text_SignUp.getText();
		return act_text;
	}
	
	public void enter_name_signup(String Name)
	{
		input_Name.sendKeys(Name);
	}
	
	public void enter_email_signup(String email)
	{
		input_EmailSignUp.sendKeys(email);
	}
	
	public void click_on_SignUp_btn()
	{
		btn_SignUp.click();
	}
	
	

}
