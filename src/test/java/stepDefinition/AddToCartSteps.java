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
	
	
	
	@When("user mouse hover on first product and click on add to cart")
	public void user_mouse_hover_on_first_product_and_click_on_add_to_cart() 
	{
	    pp.mousehover_click_addtocart_first();
	}

	@When("user click on continue shopping button")
	public void user_click_on_continue_shopping_button() 
	{
	    pp.click_on_ContinueShopping();
	}

	@When("user mouse hover on second product and click on add to cart")
	public void user_mouse_hover_on_second_product_and_click_on_add_to_cart() 
	{
	   pp.mousehover_click_addtocart_second();
	}

	@When("user click on view cart link")
	public void user_click_on_view_cart_link() 
	{
         pp.click_viewcart();
	}

	@Then("both products have been added to cart successfully")
	public void both_products_have_been_added_to_cart_successfully() 
	{
	    Assert.assertTrue(cp.is_proceedtocheckout_visible());
	    Assert.assertTrue(cp.is_both_products_incart());
	    
	}

	@Then("unit price,qty and total price is visible")
	public void unit_price_qty_and_total_price_is_visible() 
	{
	  Assert.assertTrue(cp.product_details_cart());
	}




}
