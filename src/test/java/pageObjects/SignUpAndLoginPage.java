package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpAndLoginPage extends BasePage {

	// Constructor

	public SignUpAndLoginPage() {
		super();

	}

	// Page Objects

	@FindBy(xpath = "//div[@class=\"signup-form\"]/h2")
	WebElement text_SignUp;

	@FindBy(xpath = "//input[@name=\"name\"]")
	WebElement input_Name;

	@FindBy(xpath = "(//input[@name=\"email\"])[2]")
	WebElement input_EmailSignUp;

	@FindBy(xpath = "(//button[@type=\"submit\"])[2]")
	WebElement btn_SignUp;

	@FindBy(xpath = "//div[@class=\"login-form\"]/h2")
	WebElement txt_Loginto_your_acc;

	@FindBy(xpath = "//input[@name=\"email\"][@data-qa=\"login-email\"]")
	WebElement input_Login_Email;

	@FindBy(xpath = "//input[@data-qa=\"login-password\"]")
	WebElement input_login_password;

	@FindBy(xpath = "//button[@data-qa=\"login-button\"]")
	WebElement button_login;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
	WebElement txt_EmailRegisterd;

	// Methods

	public String get_SignUptext() {
		String act_text = text_SignUp.getText();
		return act_text;
	}

	public void enter_name_signup(String Name) {
		input_Name.sendKeys(Name);
	}

	public void enter_email_signup(String email) {
		input_EmailSignUp.sendKeys(email);
	}

	public void click_on_SignUp_btn() {
		btn_SignUp.click();
	}

	public String get_text_login() {
		String login_text = txt_Loginto_your_acc.getText();
		return login_text;

	}

	public void enter_login_email(String login_email) {
		input_Login_Email.sendKeys(login_email);
	}

	public void enter_login_password(String login_Password) {
		input_login_password.sendKeys(login_Password);
	}

	public void click_on_login_button() {
		button_login.click();
	}

	public String gettext_emailRegisterd() {
		return txt_EmailRegisterd.getText();
	}

}
