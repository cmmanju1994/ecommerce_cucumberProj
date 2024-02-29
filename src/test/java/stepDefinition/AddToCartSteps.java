package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.ChekoutPage;
import pageObjects.ProductsPage;

public class AddToCartSteps 
{
	
	WebDriver driver;
	ProductsPage pp=new ProductsPage(BaseClass.getDriver());
	ChekoutPage cp=new ChekoutPage(BaseClass.getDriver());
	
	
	
	
	@Then("all products are displayed on the page")
	public void all_products_are_displayed_on_the_page() 
	{
	   Assert.assertTrue(pp.isall_products_displayed());
	}

	@When("mouse over first product and click on add to cart button")
	public void mouse_over_first_product_and_click_on_add_to_cart_button() 
	{
	    pp.MouseHover_FirstProduct();
	   
	}

	@When("click continue shopping button")
	public void click_continue_shopping_button() 
	{
	 pp.click_on_continue_shopping();
	}

	@When("mouse over second product and click on view cart link")
	public void mouse_over_second_product_and_click_on_view_cart_link() 
	{
		 pp.MouseHover_SecondProduct();
		 pp.click_on_viewcart();
		 
	}



	@Then("both products are added to cart")
	public void both_products_are_added_to_cart() 
	{
	 boolean status=cp.is_proceed_checkout_visible();
	 Assert.assertTrue(status);
	 
	 Assert.assertTrue(cp.is_products_visible_cart());
	}

	@Then("prices,quantity and total price visible")
	public void prices_quantity_and_total_price_visible() 
	{
	   boolean status_First_Prod_details=cp.is_price_qty_total_visible_InCart_First();
	   Assert.assertTrue(status_First_Prod_details);
	   
	   boolean status_Second_Prod_details=cp.is_price_qty_total_visible_InCart_Second();
	   Assert.assertTrue(status_Second_Prod_details);
	}




}
