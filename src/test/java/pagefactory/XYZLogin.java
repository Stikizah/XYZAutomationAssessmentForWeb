package pagefactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XYZLogin {

	@FindBy(xpath = "//*[text()='Customer Login']")
	WebElement btnCutomerbtn;
	
	@FindBy(xpath = "//strong")
	WebElement lbl_IsString;
	
	WebDriver driver;
    
	private StringBuffer verificationErrors = new StringBuffer();
	
    public XYZLogin(WebDriver driver)
    {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void click_customer_login_button() 
	{
		btnCutomerbtn.click();
	}
    
    public void waitForElementPresent() throws Exception
	{
    	for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }
    	
        try {
          assertEquals(lbl_IsString.getText(), "XYZ Bank"); //CampanyName
        } catch (Error e) {
          verificationErrors.append(e.toString());
        }
        
		lbl_IsString.isDisplayed();
		System.out.println("Checking....." +lbl_IsString);
	
	 }
	
	private boolean isElementPresent() {
	    try {
	    	lbl_IsString.getText();
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
}
