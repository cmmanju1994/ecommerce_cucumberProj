package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChekoutPage extends BasePage {

	// Constructor

	public ChekoutPage() {
		super();

	}

	// Page Elements

	@FindBy(xpath = "//a[@class=\"btn btn-default check_out\"]")
	WebElement Proceedto_Checkout;

	@FindBy(xpath = "//tr[@id=\"product-1\"]/td/h4") // //tr[@id=\"product-1\"]/td/h4
	WebElement Cart_FirstProduct_Description;

	@FindBy(xpath = "//tr[@id=\"product-1\"]/td[3]/p") //// tr[@id="product-1"]/td[3]/p
	WebElement Cart_FirstProduct_UnitPrice;

	@FindBy(xpath = "//tr[@id=\"product-1\"]/td[4]") //// tr[@id="product-1"]/td[3]/p
	WebElement Cart_FirstProduct_Qty;

	@FindBy(xpath = "//tr[@id=\"product-1\"]/td[5]") //// tr[@id="product-1"]/td[3]/p
	WebElement Cart_FirstProduct_Total;

	// *******//

	@FindBy(xpath = "//tr[@id=\"product-2\"]/td[2]") // //tr[@id=\"product-1\"]/td/h4
	WebElement Cart_SecondProduct_Description;

	@FindBy(xpath = "//tr[@id=\"product-2\"]/td[3]") //// tr[@id="product-1"]/td[3]/p
	WebElement Cart_SecondProduct_UnitPrice;

	@FindBy(xpath = "//tr[@id=\"product-2\"]/td[4]") //// tr[@id="product-1"]/td[3]/p
	WebElement Cart_SecondProduct_Qty;

	@FindBy(xpath = "//tr[@id=\"product-2\"]/td[4]") //// tr[@id="product-1"]/td[3]/p
	WebElement Cart_SecondProduct_Total;

	@FindBy(xpath = "//img[@alt='Product Image']")
	WebElement FirstProduct_Cart;

	@FindBy(xpath = "(//img[@alt='Product Image'])[2]")
	WebElement SecondProduct_Cart;

	@FindBy(xpath = "//button[@class=\"disabled\"]")
	WebElement qty_cart;

	// Action methods

	public boolean is_proceedtocheckout_visible() {
		boolean proceedtocheckout_visiibility = Proceedto_Checkout.isDisplayed();
		return proceedtocheckout_visiibility;
	}

	public boolean is_both_products_incart() {
		boolean flag = false;
		// ProductsPage pp=new ProductsPage(BaseClass.getDriver());

		boolean status1 = FirstProduct_Cart.isDisplayed();
		boolean status2 = SecondProduct_Cart.isDisplayed();

		if (status1 == true && status2 == true) {
			flag = true;
		}
		return flag;
	}

	public boolean product_details_cart() {
		boolean flag = false;

		boolean First_desc = Cart_FirstProduct_Description.isDisplayed();
		boolean First_UP = Cart_FirstProduct_UnitPrice.isDisplayed();
		boolean First_qty = Cart_FirstProduct_Qty.isDisplayed();
		boolean First_total = Cart_FirstProduct_Total.isDisplayed();

		boolean Second_desc = Cart_SecondProduct_Description.isDisplayed();
		boolean Second_UP = Cart_SecondProduct_UnitPrice.isDisplayed();
		boolean Second_qty = Cart_SecondProduct_Qty.isDisplayed();
		boolean Second_total = Cart_SecondProduct_Total.isDisplayed();

		if (First_desc == true && First_UP == true && First_qty == true && First_total == true && Second_desc == true
				&& Second_UP == true && Second_qty == true && Second_total) {
			flag = true;
			return true;
		}
		return flag;

	}

	public String get_cart_qty() {
		String qty = qty_cart.getText();
		return qty;
	}

}
