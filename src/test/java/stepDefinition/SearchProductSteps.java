package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.ProductsPage;

public class SearchProductSteps 
{
	WebDriver driver;
	ProductsPage pp;
	
	
	
	@When("user enter product name in search box and click search button")
	public void user_enter_product_name_in_search_box_and_click_search_button() throws IOException 
	{
	    pp=new ProductsPage(BaseClass.getDriver());
	    pp.enter_productname_searchbox(BaseClass.getProperties().getProperty("searchProductName"));
	    
	}

	@Then("searched product is visible")
	public void searched_product_is_visible() throws IOException 
	{
	  //boolean status=pp.isSearchedProduct_exists(BaseClass.getProperties().getProperty("searchProductName"));
		boolean status=pp.is_searchrelatedProducts_visible(BaseClass.getProperties().getProperty("searchProductName"));
	  Assert.assertTrue(status);
	}

	@Then("search related products also visible")
	public void search_related_products_also_visible() throws IOException 
	{
		Assert.assertTrue(pp.is_searchrelatedProducts_visible(BaseClass.getProperties().getProperty("searchProductName")));
	}




}
