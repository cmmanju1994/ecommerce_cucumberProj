package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {
	// constructor
	public AccountCreatedPage() {
		super();
	}

	// Page elements

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	WebElement acc_creat_text;

	@FindBy(xpath = "//a[text()=\"Continue\"]")
	WebElement btn_continue;

	@FindBy(xpath = "//h2[@data-qa=\"account-deleted\"]/b")
	WebElement txt_acc_deleted;

	@FindBy(xpath = "//a[text()=\"Continue\"]")
	WebElement btn_continue1;

	@FindBy(xpath = "//div[@aria-label=\"Close ad\"]")
	WebElement ad_close_btn;

	// methods

	public String gettext_acc_created() {
		return acc_creat_text.getText();

	}

	public void click_continue() {
		btn_continue.click();
	}

	public String gettext_accdeleted() {
		return txt_acc_deleted.getText();

	}

	public void click_continue1() {
		btn_continue.click();
	}

	public boolean isAdPresent() {
		if (ad_close_btn.isDisplayed()) {
			ad_close_btn.click();
			return true;
		} else {
			return false;
		}
	}
}
