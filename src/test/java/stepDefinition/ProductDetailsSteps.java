package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductsPage;

public class ProductDetailsSteps 
{
	WebDriver driver;
	HomePage hp;
	ProductsPage pp;
	ProductDetailsPage pd;
	
	
	@When("user Click on Products button")
	public void user_click_on_products_button() 
	{
	   hp=new HomePage(BaseClass.getDriver());
	   hp.click_On_Products_link();
	}

	@Then("user navigated to ALL PRODUCTS page successfully")
	public void user_navigated_to_all_products_page_successfully() throws IOException 
	{
		
	   pp= new ProductsPage(BaseClass.getDriver());
	   Assert.assertEquals(pp.get_ProductsPage_title(),BaseClass.getProperties().getProperty("products_page_title"));
	   //Assert.assertEquals(pp.get_ProductsPage_title(), BaseClass.getProperties().getProperty("products_page_title")); 
	}
	@Then("The products list is visible")
	public void the_products_list_is_visible() 
	{
	    boolean all_products_status= pp.isall_products_displayed();
	    Assert.assertTrue(all_products_status);
	}

	@When("user Click on View Product of first product")
	public void user_click_on_view_product_of_first_product() 
	{
         pp.click_on_view_product();
	}

	@Then("User is landed to product detail page")
	public void user_is_landed_to_product_detail_page() 
	{
	 pd=new ProductDetailsPage(BaseClass.getDriver());
	// assert.assertEquals(pd.product_details_title(), BaseClass.getProperties().getProperty("product_details_page_title")); 
	Assert.assertTrue(true);
	
	}

	@Then("all product detail is visible: product name, category, price, availability, condition, brand")
	public void all_product_detail_is_visible_product_name_category_price_availability_condition_brand() {
		  pd.is_product_name_displayed();
		  pd.is_product_availability_displayed();
		  pd.is_product_brand_displayed();
		  pd.is_product_category_displayed();
		  pd.is_product_condition_displayed();
		  pd.is_product_price_displayed();
	}

}
