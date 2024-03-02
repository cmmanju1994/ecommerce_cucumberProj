package stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductsPage;
import utilities.PropertiesConfig;

public class SearchProductSteps {
//	WebDriver driver;
	ProductsPage pp;
	PropertiesConfig propertiesConfig;

	public SearchProductSteps() {
		propertiesConfig = new PropertiesConfig();
		pp = new ProductsPage();
	}

	@When("user enter product name in search box and click search button")
	public void user_enter_product_name_in_search_box_and_click_search_button() throws IOException {
		pp.enter_productname_searchbox(propertiesConfig.getProperties().getProperty("searchProductName"));

	}

	@Then("searched product is visible")
	public void searched_product_is_visible() throws IOException {
		// boolean
		// status=pp.isSearchedProduct_exists(BaseClass.getProperties().getProperty("searchProductName"));
		boolean status = pp
				.is_searchrelatedProducts_visible(propertiesConfig.getProperties().getProperty("searchProductName"));
		Assert.assertTrue(status);
	}

	@Then("search related products also visible")
	public void search_related_products_also_visible() throws IOException {
		Assert.assertTrue(
				pp.is_searchrelatedProducts_visible(propertiesConfig.getProperties().getProperty("searchProductName")));
	}

}
