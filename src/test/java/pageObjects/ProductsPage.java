package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;

public class ProductsPage extends BasePage 
{

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	
	
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
	public WebElement First_Product;
	
	@FindBy(xpath="//img[@src=\"/get_product_picture/2\"]")
	public WebElement Second_Product;
	
	@FindBy(xpath="//img[@alt=\"ecommerce website products\"]")
	List<WebElement> all_products;
	
	//***********//
	
	@FindBy(xpath="/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
	WebElement AddtoCart_FirstProduct;
	
	@FindBy(xpath="//div[@class=\"modal-content\"]//button")
	WebElement continue_shopping_button;
	
	@FindBy(xpath="//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]")
	WebElement AddtoCart_SecondProduct;
	
	
	
	@FindBy(xpath="//div[@class=\"modal-body\"]//a")
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
	
	public void mousehover_click_addtocart_first()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 5000);", "");
		BaseClass.mouseOverElement(driver, First_Product);
		AddtoCart_FirstProduct.click();
		
	}
	
	public void click_on_ContinueShopping()
	{
		continue_shopping_button.click();
	}
	
	public void mousehover_click_addtocart_second()
	{
		BaseClass.mouseOverElement(driver,Second_Product);
		AddtoCart_SecondProduct.click();
	}
	
	public void click_viewcart()
	{
		view_cart.click();
	}
	
	
	
	
	
}
