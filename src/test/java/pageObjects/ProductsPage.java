package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class ProductsPage extends BasePage 
{

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	// Constructor 
	
	
	//
	
	// Page Elements
	
	@FindBy(xpath="//div[@class=\"single-products\"]")
	List<WebElement> All_Products_On_ProductsPage;
	
	@FindBy(xpath="//a[@href=\"/product_details/1\"]")
	WebElement view_product;
	
	@FindBy(xpath="//input[@id=\"search_product\"]")
	WebElement search_box;
	
	@FindBy(xpath="//button[@id=\"submit_search\"]")
	WebElement search_button;
	
	/*@FindBy(xpath="(//div[@class=\"single-products\"]//p)[1]")
	WebElement searched_product_name;*/
	
	@FindBy(xpath="//div[@class=\"productinfo text-center\"]//p")
	List<WebElement> Searched_Products;
	
	@FindBy(xpath="//img[@src=\"/get_product_picture/1\"]")
	WebElement First_Product;
	
	@FindBy(xpath="//img[@src=\"/get_product_picture/2\"]")
	WebElement Second_Product;
	
	@FindBy(xpath="//img[@alt=\"ecommerce website products\"]")
	List<WebElement> all_products;
	
	@FindBy(xpath="(//div[@class=\"productinfo text-center\"]//a[@class=\"btn btn-default add-to-cart\"])[1]")
	WebElement addtocart_FirstProduct;
	
	@FindBy(xpath="(//a[@data-product-id=\"2\"][@class=\"btn btn-default add-to-cart\"])[1]")
	WebElement addtocart_SecondProduct;
	
	@FindBy(xpath="//div[@class=\"modal-footer\"]/button")
	WebElement btn_ContinueShopping;
	
	@FindBy(xpath="(//a[@href=\"/view_cart\"])[2]")
	WebElement view_cart;
	
	// Action methods
	
	
	public String get_ProductsPage_title()
	{
		//BaseClass.getDriver().getTitle();
		String Products_Page_Title=driver.getTitle();
		return Products_Page_Title;
		
	}
	
	public boolean isall_products_displayed()
	{
	      boolean flag=false;
	      try
	      {
	          for(WebElement x:All_Products_On_ProductsPage)
	          {
	        	 System.out.println(x.getText()); 
	          }
	          flag=true;
	          return flag;
	      }
	      catch(Exception e)
	      {
	    	  System.out.println("Exception occured");
	    	  return false;
	      }
	      finally
	      {
	    	  if(flag)
	    	  {
	    		  System.out.println("Products are displayed");
	    	  }
	    	  else
	    	  {
	    		  System.out.println("Products not displayed");
	    	  }
	      }
	}
	

	public void click_on_view_product()
	{
		BaseClass.ClickAction(driver, view_product);
	}
	
	public void enter_productname_searchbox(String Prod_name)
	{
		search_box.sendKeys(Prod_name);
	}
	
	public void click_on_search_btn()
	{
		search_button.click();
	}
	
	/*public boolean isSearchedProduct_exists(String productName)
	{
		boolean flag=false;
		
		if(searched_product_name.getText().contains(productName))
		{
			flag=true;
			
			
		}
		return flag;
	}*/
	
	public boolean is_searchrelatedProducts_visible(String ProductName)
	{
		boolean flag=false;
		
		for(WebElement li:Searched_Products)
		{
			if(li.getText().contains(ProductName) || li.getText().contains("Shirt") || li.getText().contains("Tops"))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public boolean isAllPeoductsDisplayed()
	{
		boolean flag=false;
		for(WebElement li:all_products)
		{
			if(li.isDisplayed())
			 flag=true;
			break;
			
		}
		return flag;
	}
	
	public void MouseHover_FirstProduct()
	{
	    // BaseClass obj=new BaseClass();
	    // obj.mouseover(driver, First_Product);
		BaseClass.mouseOverElement(driver, First_Product);
		
		// click on add to cart 
		
		addtocart_FirstProduct.click();
		
		
		
	}
	
	public void click_on_continue_shopping()
	{
		btn_ContinueShopping.click();
	}
	
	public void MouseHover_SecondProduct()
	{
		BaseClass.mouseOverElement(driver, Second_Product);
		
		if(addtocart_SecondProduct.isDisplayed())
		{
			addtocart_SecondProduct.click();
			System.out.println("Successfuly clicked on add to cart page");
		}
		else
		{
			System.out.println("unable to click on add to cart");
		}
		
		//addtocart_SecondProduct
		
	}
	
	public void click_on_viewcart()
	{
		view_cart.click();
	}
	
	
}
