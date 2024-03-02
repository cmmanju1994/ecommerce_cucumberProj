package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

	// constructor

	public PaymentPage() {
		super();

	}

	// page elements

	@FindBy(xpath = "//h2[@class=\"heading\"]")
	WebElement PaymentPage_title;

	@FindBy(xpath = "//input[@name=\"name_on_card\"]")
	WebElement input_Name_onCard;

	@FindBy(xpath = "//input[@name=\"card_number\"]")
	WebElement input_Card_Number;

	@FindBy(xpath = "//input[@name=\"cvc\"]")
	WebElement input_cvc;

	@FindBy(xpath = "//input[@name=\"expiry_month\"]")
	WebElement input_expiry_month;

	@FindBy(xpath = "//input[@name=\"expiry_year\"]")
	WebElement input_expiry_year;

	@FindBy(xpath = "//button[@id=\"submit\"]")
	WebElement button_Pay_Confirm;

	@FindBy(xpath = "//h2[@data-qa=\"order-placed\"]")
	WebElement text_order_Placed;

	// methods

	public String get_Paymentpage_title() {
		return PaymentPage_title.getText();
	}

}
