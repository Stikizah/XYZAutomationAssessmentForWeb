package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class XYZCustomer {
	
	@FindBy(id = "userSelect")
	WebElement btnCutomerbtn;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//*[text()='Your Name :']")
	WebElement lblVerify;

	WebDriver driver;
	
	private StringBuffer verificationErrors = new StringBuffer();

	public XYZCustomer(WebDriver driver)
    {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
	
	public void verifyCustomerPage() throws Exception{
		
		try {
			Thread.sleep(1000);
		      assertEquals("Your Name :", (lblVerify).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	}
	
	public void clickCustomerDropdown()
	{
		btnCutomerbtn.click();
	}
	
	public void select_a_customer_nameFromDropdown()
	{
		new Select(btnCutomerbtn).selectByVisibleText("Hermoine Granger");//CustomerName
		btnCutomerbtn.click();
	}
	
	public void waitForLoginButtonToAppear() throws InterruptedException
	{
		for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent()) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	}
	
	public void clickLoginButton() 
	{
		btnLogin.click();
	}
	
	private boolean isElementPresent() {
	    try {
	    	btnCutomerbtn.getText();
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

}
