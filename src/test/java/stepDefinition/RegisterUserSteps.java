package stepDefinition;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.AccountCreatedPage;
import pageObjects.HomePage;
import pageObjects.SignUpAndLoginPage;
import pageObjects.SignUpPage;

public class RegisterUserSteps 
{
	Logger logger;
	WebDriver driver;
	HomePage hp=new HomePage(BaseClass.getDriver());
	AccountCreatedPage accp;
	SignUpAndLoginPage sl;
	SignUpPage sp;
	
	@Given("user navigates to home page")
	public void user_navigates_to_home_page() 
	{
		   
           hp.isSignUp_Login_displayed();     

	}

	@When("user click on Signup \\/ Login button")
	public void user_click_on_signup_login_button() 
	{
		
	   hp.click_on_LoginLink();
	}

	@Then("{string} is visible")
	public void is_visible(String string) 
	{
		sl=new SignUpAndLoginPage(BaseClass.getDriver());
	    String actual_title=sl.get_SignUptext();
	    String Expected_title="New User Signup!";
	    Assert.assertEquals(actual_title, Expected_title);
	}

	@When("user enter name and email address")
	public void user_enter_name_and_email_address() 
	{
	  
	   sl.enter_name_signup(BaseClass.randomeString());
	   String email_id=BaseClass.randomeString()+"@gmail.com";
	   sl.enter_email_signup(email_id);
	   
	}

	@When("click on Signup button")
	public void click_on_signup_button() 
	{
	    sl.click_on_SignUp_btn();
	}

	@When("user fill details Title, Name, Email, Password, Date of birth")
	public void user_fill_details_title_name_email_password_date_of_birth() 
	{
		 sp=new SignUpPage(BaseClass.getDriver());
		 sp.click_gender_radiobtn();
		 //sp.enter_firstname(BaseClass.randomeString());
		sp.enter_password(BaseClass.randomAlphaNumeric());
		sp.select_day_dropdown(5);
		sp.select_month_dropdown(10);
		sp.select_year_dropdown(5);
	}

	@When("Select checkbox {string}")
	public void select_checkbox(String string) 
	{
	   sp.isSelected_newslettercheckbox();
	   sp.isSelected_offerscheckbox();
	}

	@When("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number.")
	public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() 
	{
	   sp.enter_firstname(BaseClass.randomeString());
	   sp.enter_Lastname(BaseClass.randomeString());
	   sp.enter_company(BaseClass.randomeString());
	   sp.enter_addressline1(BaseClass.randomeString());
	   sp.enter_addressline2(BaseClass.randomeString());
	   sp.select_country_dropdown(5);
	   sp.enter_state(BaseClass.randomeString());
	   sp.enter_city(BaseClass.randomeString());
	   sp.enter_zip(BaseClass.randomeNumber());
	   sp.enter_mobile(BaseClass.randomeNumber());
	   
	}

	@When("Click Create Account button")
	public void click_create_account_button() 
	{
	   sp.cl_CreateAcc_btn();
	}
	
	

	@When("user Click on Continue button")
	public void user_click_on_continue_button() throws InterruptedException 
	{
	   accp.click_continue();
	   //Thread.sleep(100000);
	  // accp.isAdPresent();
	   }
	
	@When("user Click on Delete Account button")
	public void user_click_on_delete_account_button() 
	{
	  // hp.click_deleteacc();
		WebDriverWait mywait=new WebDriverWait(BaseClass.getDriver(),Duration.ofSeconds(30));
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class=\"nav navbar-nav\"]/li)[5]")));
	  
	}

	@Then("Logged in as username is visible")
	public void logged_in_as_username_is_visible() 
	{
	   Assert.assertTrue(hp.isLogedinas_user_displayed()); 
	   
	}

	@Then("ACCOUNT DELETED! is visible and click Continue button")
	public void account_deleted_is_visible_and_click_continue_button() 
	{
	    hp.click_deleteacc();
	   String acc_deleted_text= accp.gettext_accdeleted();
	   String exp_deleted_text="ACCOUNT DELETED!";
	   Assert.assertEquals(acc_deleted_text, exp_deleted_text);
	   
	   accp.click_continue1();
	   
	    
	}
	

@Then("ACCOUNT CREATED! messeage is visible")
public void account_created_messeage_is_visible() 
{
	  accp=new AccountCreatedPage(BaseClass.getDriver());
      String act_text= accp.gettext_acc_created();
      String exp_text="ACCOUNT CREATED!";
      Assert.assertEquals(act_text, exp_text);
}
}
