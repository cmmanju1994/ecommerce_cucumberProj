package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage
{
	// constructor
     public AccountCreatedPage(WebDriver driver)
     {
    	 super(driver);
     }
     
     // Page elements
     
     @FindBy(xpath="//*[@id=\"form\"]/div/div/div/h2/b")
     WebElement acc_creat_text;
     
     @FindBy(xpath="//a[text()=\"Continue\"]")
     WebElement btn_continue;
     
     @FindBy(xpath="//h2[@data-qa=\"account-deleted\"]/b")
     WebElement txt_acc_deleted;
     
     @FindBy(xpath="//a[text()=\"Continue\"]")
     WebElement btn_continue1;
     
     
     
   
     
     //methods
     
     public String gettext_acc_created()
     {
    	 return acc_creat_text.getText();    
    	 
     }
     
     public void click_continue()
     {
    	 btn_continue.click();
     }
     
     public String gettext_accdeleted()
     {
		return txt_acc_deleted.getText();
    	 
     }
     
     public void click_continue1()
     {
    	 btn_continue.click();
     }
}