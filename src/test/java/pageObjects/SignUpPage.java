package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

	// Constructor

	public SignUpPage() {
		super();

	}

	Select oselect;

	// SignUp Page Elements

	// @FindBy(xpath="//div[@class=\"login-form\"]/h2/b")
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/h2/b")
	WebElement text_SignUpPage;

	@FindBy(xpath = "//input[@id=\"id_gender1\"]")
	WebElement radiobtn_gender;

	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement disabled_name_SignUpPage;

	@FindBy(xpath = "//input[@id=\"email\"][@disabled=\"disabled\"]")
	WebElement disabled_email_SignUpPage;

	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement input_Password;

	@FindBy(xpath = "//select[@name=\"days\"]")
	WebElement dropdown_days;

	@FindBy(xpath = "//select[@id=\"months\"]")
	WebElement dropdown_months;

	@FindBy(xpath = "//select[@id=\"years\"]")
	WebElement dropdown_years;

	@FindBy(xpath = "//input[@id=\"newsletter\"]")
	WebElement checkbox_newsletter;

	@FindBy(xpath = "//input[@id=\"optin\"]")
	WebElement checkbox_Speiceal_offer;

	@FindBy(xpath = "(//h2[@class=\"title text-center\"]/b)[2]")
	WebElement text_adress_information;

	@FindBy(xpath = "//input[@id=\"first_name\"]")
	WebElement input_FirstName;

	@FindBy(xpath = "//input[@id=\"last_name\"]")
	WebElement input_LastName;

	@FindBy(xpath = "//input[@id=\"company\"]")
	WebElement input_Company;

	@FindBy(xpath = "//input[@id=\"address1\"]")
	WebElement input_address1;

	@FindBy(xpath = "//input[@id=\"address2\"]")
	WebElement input_address2;

	@FindBy(xpath = "//select[@name=\"country\"]")
	WebElement dropdown_country;

	@FindBy(xpath = "//input[@id=\"state\"]")
	WebElement input_state;

	@FindBy(xpath = "//input[@id=\"city\"]")
	WebElement input_city;

	@FindBy(xpath = "//input[@id=\"zipcode\"]")
	WebElement input_zipcode;

	@FindBy(xpath = "//input[@id=\"mobile_number\"]")
	WebElement input_mobile_number;

	@FindBy(xpath = "(//button[@type=\"submit\"])[1]")
	WebElement btn_createAccount;

	// Methods

	public String get_text_signupPage() {
		return text_SignUpPage.getText();
	}

	public void click_gender_radiobtn() {
		radiobtn_gender.click();
	}

	public void enter_password(String Password) {
		input_Password.sendKeys(Password);

	}

	public void select_day_dropdown(int day) {
		oselect = new Select(dropdown_days);
		oselect.selectByIndex(day);
	}

	public void select_month_dropdown(int month) {
		oselect = new Select(dropdown_months);
		oselect.selectByIndex(month);
	}

	public void select_year_dropdown(int year) {
		oselect = new Select(dropdown_years);
		oselect.selectByIndex(year);
	}

	public boolean isSelected_newslettercheckbox() {
		checkbox_newsletter.click();
		boolean checkbox_nl_status = checkbox_newsletter.isSelected();
		return checkbox_nl_status;

	}

	public boolean isSelected_offerscheckbox() {
		checkbox_Speiceal_offer.click();
		boolean checkbox_Speiceal_offer_status = checkbox_newsletter.isSelected();
		return checkbox_Speiceal_offer_status;

	}

	public String text_address_information() {
		String text_add_inform = text_adress_information.getText();
		return text_add_inform;
	}

	public void enter_firstname(String fname) {
		input_FirstName.sendKeys(fname);
	}

	public void enter_Lastname(String lname) {
		input_LastName.sendKeys(lname);
	}

	public void enter_company(String Company) {
		input_Company.sendKeys(Company);
	}

	public void enter_addressline1(String address1) {
		input_address1.sendKeys(address1);
	}

	public void enter_addressline2(String address2) {
		input_address2.sendKeys(address2);
	}

	public void select_country_dropdown(int country) {
		oselect = new Select(dropdown_country);
		oselect.selectByIndex(country);
	}

	public void enter_state(String State) {
		input_state.sendKeys(State);
	}

	public void enter_city(String City) {
		input_city.sendKeys(City);
	}

	public void enter_zip(String code) {
		input_zipcode.sendKeys(code);
	}

	public void enter_mobile(String num) {
		input_mobile_number.sendKeys(num);
	}

	public void cl_CreateAcc_btn() {
		btn_createAccount.click();
	}

}
