package stepDefinition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountCreatedPage;
import pageObjects.ChekoutPage;
import pageObjects.HomePage;
import pageObjects.PaymentPage;
import pageObjects.ProductsPage;
import pageObjects.SignUpAndLoginPage;
import pageObjects.SignUpPage;
import utilities.StringAndNumericReader;

public class PlaceOrder_Register {
	ProductsPage pp;
	ChekoutPage cp;
	SignUpAndLoginPage sp;
	SignUpPage sup;
	AccountCreatedPage accp;
	HomePage hp;
	PaymentPage pmtp;
	StringAndNumericReader stringAndNumericReader;

	public PlaceOrder_Register() {
		pp = new ProductsPage();
		cp = new ChekoutPage();
		sp = new SignUpAndLoginPage();
		sup = new SignUpPage();
		accp = new AccountCreatedPage();
		hp = new HomePage();
		pmtp = new PaymentPage();
		stringAndNumericReader = new StringAndNumericReader();
	}

	@Given("user added product to the cart")
	public void user_added_product_to_the_cart() {
		pp.mousehover_click_addtocart_first();
	}

	@Given("click on view cart")
	public void click_on_view_cart() {
		pp.click_viewcart();
	}

	@Then("cart page is displayed")
	public void cart_page_is_displayed() {
		Assert.assertTrue(cp.is_proceedtocheckout_visible());
	}

	@When("user click on proceed to checkout")
	public void user_click_on_proceed_to_checkout() {
		cp.click_checkout();
	}

	@Then("Register\\/login link appears")
	public void register_login_link_appears() {
		Assert.assertTrue(cp.isRegister_Login_appeared());
	}

	@When("user click on the Register\\/login link")
	public void user_click_on_the_register_login_link() {
		cp.click_SignUp_link();
	}

	@Then("user navigated to Signup\\/Login page")
	public void user_navigated_to_signup_login_page() {
		Assert.assertEquals("New User Signup!", sp.get_SignUptext());
	}

	@When("user fill required details")
	public void user_fill_required_details() {
		sp.enter_name_signup(stringAndNumericReader.randomeString());
		String email_id = stringAndNumericReader.randomeString() + "@gmail.com";
		sp.enter_email_signup(email_id);

		sp.click_on_SignUp_btn();

		sup.click_gender_radiobtn();
		sup.enter_password(stringAndNumericReader.randomAlphaNumeric());
		sup.select_day_dropdown(10);
		sup.select_month_dropdown(1);
		sup.select_year_dropdown(5);

		sup.isSelected_newslettercheckbox();
		sup.isSelected_offerscheckbox();

		sup.enter_firstname(stringAndNumericReader.randomeString());
		sup.enter_Lastname(stringAndNumericReader.randomeString());
		sup.enter_company(stringAndNumericReader.randomeString());
		sup.enter_addressline1(stringAndNumericReader.randomeString());
		sup.enter_addressline2(stringAndNumericReader.randomeString());
		sup.select_country_dropdown(5);
		sup.enter_state(stringAndNumericReader.randomeString());
		sup.enter_city(stringAndNumericReader.randomeString());
		sup.enter_zip(stringAndNumericReader.randomeNumber());
		sup.enter_mobile(stringAndNumericReader.randomeNumber());
		sup.cl_CreateAcc_btn();
	}

	@Then("Account created messeage get displayed")
	public void account_created_messeage_get_displayed() {
		Assert.assertEquals(accp.gettext_acc_created(),
				"Congratulations! Your new account has been successfully created!");
	}

	@Then("logged in as user displayed at top")
	public void logged_in_as_user_displayed_at_top() {
		accp.click_continue();
		Assert.assertTrue(hp.isLogedinas_user_displayed());
	}

	@When("user clicks on cart button")
	public void user_clicks_on_cart_button() {
		hp.click_cart();
	}

	@Then("User navigated to cart page")
	public void user_navigated_to_cart_page() {
		Assert.assertTrue(cp.is_proceedtocheckout_visible());
		cp.click_checkout();
	}

	@Then("address detials visible and review order product")
	public void address_detials_visible_and_review_order_product() {
		Assert.assertTrue(cp.isAddressdisplayed());

	}

	@When("user enter comment and click on place order button")
	public void user_enter_comment_and_click_on_place_order_button() {
		cp.add_comment();
	}

	@Then("user navigated to payment page")
	public void user_navigated_to_payment_page() {

	}

	@When("user enter card details below fields")
	public void user_enter_card_details_below_fields(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}

	@When("click on Pay and confirm order button")
	public void click_on_pay_and_confirm_order_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Congratulations! Your order has been confirmed! messeage is displayed")
	public void congratulations_your_order_has_been_confirmed_messeage_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
