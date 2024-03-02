package pageObjects;

import org.openqa.selenium.support.PageFactory;

import drivers.DriverInitialization;

public class BasePage {
//	WebDriver driver;

	public BasePage() {
//		     this.driver=driver;     
		PageFactory.initElements(DriverInitialization.getDriver(), this);
	}

}
