package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChekoutPage extends BasePage 
{

	//Constructor 
	
	public ChekoutPage(WebDriver driver) 
	{
		super(driver);
	
	}
	
	// Page Elements 
	
	@FindBy(linkText="Proceed To Checkout")
	WebElement proceed_to_checkout;
	
	// dynamic xpath for products in cart is : //a[@href="/product_details/i"](where as i starts from 1 to n)
	
	@FindBy(xpath="//a[@href=\"/product_details/1\"]")
	WebElement FirstProduct_In_Cart;
	
	@FindBy(xpath="//a[@href=\"/product_details/2\"]")
	WebElement SecondProduct_In_Cart;
	
	/*@FindBy(xpath="//td[@class=\"cart_price\"]")
	List<WebElement> Price_list;*/
	
	@FindBy(xpath="//tr[@id=\"product-1\"]/td[3]")  // //tr[@id="product-1"]/td[3]  use 1 and 2 as inner and outer for loop
	WebElement ProductPrice_Perunit_inCart_First_product;
	
	
	@FindBy(xpath="//tr[@id=\"product-1\"]/td[4]")
	WebElement ProductQty_Perunit_inCart_First_product;
	
	@FindBy(xpath="//tr[@id=\"product-1\"]/td[5]")
	WebElement Total_Price_First_Product_Cart;
	
	
	//-----------
	
	@FindBy(xpath="//tr[@id=\"product-2\"]/td[3]")  // //tr[@id="product-1"]/td[3]  use 1 and 2 as inner and outer for loop
	WebElement ProductPrice_Perunit_inCart_Second_product;
	
	@FindBy(xpath="//tr[@id=\"product-2\"]/td[4]")
	WebElement ProductQty_Perunit_inCart_Second_product;
	
	@FindBy(xpath="//tr[@id=\"product-2\"]/td[5]")
	WebElement Total_Price_Second_Product_Cart;
	
	
	
	
	
	
	
	
	
	// Methods
	
	public boolean is_proceed_checkout_visible()
	{
		boolean flag=false;
		
		if(proceed_to_checkout.isDisplayed())
		{
			flag=true;
			return true;
		}
		return flag;
	}
	
	public boolean is_products_visible_cart()
	{
		boolean flag=false;
		
		if(FirstProduct_In_Cart.isDisplayed() && SecondProduct_In_Cart.isDisplayed())
		{
			flag=true;
			System.out.println("Both the products visible in cart");
			return true;
		}
		return flag;
	}
	
	public boolean is_price_qty_total_visible_InCart_First()
	{
		boolean flag=false;
		
		if(ProductPrice_Perunit_inCart_First_product.isDisplayed() && ProductQty_Perunit_inCart_First_product.isDisplayed() &&
				Total_Price_First_Product_Cart.isDisplayed()	)
		{
			flag=true;
		}
		return flag;
	}
	
	public boolean is_price_qty_total_visible_InCart_Second()
	{
		boolean flag=false;
		
		if(ProductPrice_Perunit_inCart_Second_product.isDisplayed() && ProductQty_Perunit_inCart_Second_product.isDisplayed() &&
				Total_Price_Second_Product_Cart.isDisplayed()	)
		{
			flag=true;
			return flag;
		}
		return flag;
	}
	
	

}
