package stepDefinition;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ChekoutPage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductsPage;
import utilities.PropertiesConfig;

public class VerifyProdQtyInCart {
//	WebDriver driver;
	ProductsPage pp;
	ProductDetailsPage pd;
	ChekoutPage cp;
	PropertiesConfig propertiesConfig;

	public VerifyProdQtyInCart() {
		propertiesConfig = new PropertiesConfig();
		pp = new ProductsPage();
		pd = new ProductDetailsPage();
		cp = new ChekoutPage();
	}

	@When("user click on view product for any product")
	public void user_click_on_view_product_for_any_product() {
		pp.click_on_view_product();
	}

	@Then("details of the product is visible")
	public void details_of_the_product_is_visible() {
		Assert.assertTrue(pd.is_product_availability_displayed());
		Assert.assertTrue(pd.is_product_brand_displayed());
		Assert.assertTrue(pd.is_product_category_displayed());
		Assert.assertTrue(pd.is_product_name_displayed());

	}

	@When("user increase the quantity to {int}")
	public void user_increase_the_quantity_to(Integer qty) throws IOException {
		// int int1=Integer.parseInt(BaseClass.getProperties().getProperty("qty"));
		pd.enter_Productqty(propertiesConfig.getProperties().getProperty("qty"));
	}

	@When("click on add to cart button")
	public void click_on_add_to_cart_button() {
		pd.clickon_addtocart();
	}

	@When("click view cart button")
	public void click_view_cart_button() {
		pd.click_on_viewcart();
	}

	@Then("verify total quanity as {int} in the cart")
	public void verify_total_quanity_as_in_the_cart(Integer int1) throws IOException {
		String act_qty = cp.get_cart_qty();
		Assert.assertEquals(act_qty, propertiesConfig.getProperties().getProperty("qty"));
	}

}
