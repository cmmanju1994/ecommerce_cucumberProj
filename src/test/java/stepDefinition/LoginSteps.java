package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.SignUpAndLoginPage;

public class LoginSteps 

{
	
	WebDriver driver;
	SignUpAndLoginPage sl;
	HomePage hp;
	Properties prop;
	MyAccountPage macc=new MyAccountPage(BaseClass.getDriver());
	
	@Then("Login to your account visible")
	public void login_to_your_account_visible() 
	{
		sl=new SignUpAndLoginPage(BaseClass.getDriver());
	    String Actual_text=sl.get_text_login();
	    String Expected_text="Login to your account";
	    Assert.assertEquals(Actual_text, Expected_text);
	    
	    
	    
	}

	@When("user enter email adress as {string}")
	public void user_enter_email_adress_as(String email) throws IOException 
	{
	   sl.enter_login_email(email);
	}

	@When("Password as {string}")
	public void password_as(String password) throws IOException 
	{
	    sl.enter_login_password(password);
	}

	@When("click on login button")
	public void click_on_login_button() 
	{
	    sl.click_on_login_button();
	}

	@Then("user navigated to My account Page")
	public void user_navigated_to_my_account_page() 
	{
        Assert.assertTrue(macc.isUsername_visible_on_Page());
	}


}
