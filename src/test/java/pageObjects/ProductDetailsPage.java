package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class ProductDetailsPage extends BasePage 
{
	
	// Constructor
	
	public ProductDetailsPage(WebDriver driver)
	{
		super(driver);
	}
	
	// Page Elements
	
	public String product_details_title()
	{
		String title=BaseClass.getDriver().getTitle();
		return title;
	}
	
	@FindBy(xpath="//div[@class=\"product-information\"]//h2")
	WebElement Product_name;
	
	@FindBy(xpath="//div[@class=\"product-information\"]//p[1]")
	WebElement Product_category;
	
	@FindBy(xpath="//span[contains(text(),\"Rs\")]")
	WebElement Product_price;
	

	@FindBy(xpath="//div[@class=\"product-information\"]//p[2]/b")
	WebElement Product_availability;
	
	@FindBy(xpath="//div[@class=\"product-information\"]//p[3]/b")
	WebElement Product_condition;
	
	@FindBy(xpath="//div[@class=\"product-information\"]//p[4]/b")
	WebElement Product_brand;
	
	@FindBy(xpath="//input[@type=\"number\"]")
	WebElement Product_Qty_Input;
	
	@FindBy(xpath="//button[@type=\"button\"]")
	WebElement button_addto_cart;
	
	@FindBy(xpath="//u[normalize-space()='View Cart']")
	WebElement view_cart;
	
	
	//corresponding action methods
	
	public boolean is_product_name_displayed()
	{
		boolean product_name_status=Product_name.isDisplayed();
		if(product_name_status)
		{
			System.out.println("Product name is diplayed");
			return true;
		}
		else
		{
			System.out.println("Product name not displayed");
			return false;
		}
	}
	
	public boolean is_product_category_displayed()
	{
		boolean Product_category_status=Product_category.isDisplayed();
		if(Product_category_status)
		{
			System.out.println("Product category is diplayed");
			return true;
		}
		else
		{
			System.out.println("Product category not displayed");
			return false;
		}
	}
	
	public boolean is_product_price_displayed()
	{
		boolean Product_price_status=Product_price.isDisplayed();
		if(Product_price_status)
		{
			System.out.println("Product price is diplayed");
			return true;
		}
		else
		{
			System.out.println("Product price not displayed");
			return false;
		}
	}
	
	public boolean is_product_availability_displayed()
	{
		boolean Product_availability_status=Product_availability.isDisplayed();
		if(Product_availability_status)
		{
			System.out.println("Product availability is diplayed");
			return true;
		}
		else
		{
			System.out.println("Product availability not displayed");
			return false;
		}
	}
	
	
	public boolean is_product_condition_displayed()
	{
		boolean Product_condition_status=Product_condition.isDisplayed();
		if(Product_condition_status)
		{
			System.out.println("Product condition is diplayed");
			return true;
		}
		else
		{
			System.out.println("Product condition not displayed");
			return false;
		}
	}
	
	public boolean is_product_brand_displayed()
	{
		boolean Product_brand_status=Product_brand.isDisplayed();
		if(Product_brand_status)
		{
			System.out.println("Product brand is diplayed");
			return true;
		}
		else
		{
			System.out.println("Product brand not displayed");
			return false;
		}
	}
	
	public void enter_Productqty(String qty)
	{
		Product_Qty_Input.clear();
		Product_Qty_Input.sendKeys(qty);
	}
	
	public void clickon_addtocart()
	{
		button_addto_cart.click();
	}
	
	public void click_on_viewcart()
	{
		view_cart.click();
	}
	
	
	
	

}
