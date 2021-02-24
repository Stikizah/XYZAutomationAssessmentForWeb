package pagefactory;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XYZAccount {
	
	@FindBy(xpath = "//*[@ng-class = 'btnClass2']")
	WebElement btn_btnClass2;
	
	@FindBy(xpath = "//input[@type='number']")
	WebElement txt_Amount;

	@FindBy(xpath = "//label")
	WebElement lbl_VerifyDisplayed;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement btn_Diposit_Submit;
	
	@FindBy(xpath = "//div[4]/div/span")
	WebElement lblSuccessfully;
	
	@FindBy(xpath = "//*[@class = 'btn btn-default']")
	WebElement btn_DepositButton;
	
	private StringBuffer verificationErrors = new StringBuffer();
	
	WebDriver driver;
	public XYZAccount(WebDriver driver)
    {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
	
	public void clickDepositButton()
	{
		btn_btnClass2.click();
	}
	
	public void waitForElementToAppear() throws Exception
	{
		for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent()) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
		
	}

	public void checkDisplayedName()
	{
		try {
		      assertEquals(lbl_VerifyDisplayed.getText(), "Amount to be Deposited :");//ResultValue
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		      
		    }
	}
	
	public void enterAmount(int amount) 
	{
		txt_Amount.clear();
		txt_Amount.sendKeys(String.valueOf(amount));
	}
	
	public void clickDeposit()
	{
//		driver.findElement(By.xpath("//button[@value='']")).click();
//	    driver.findElement(By.xpath("//div[4]/div")).click();
//	    
		btn_Diposit_Submit.click();
	}
	
	public void ClickButtonDeposit()
	{
		btn_DepositButton.click();
	}
	public void validateSuccessful()
	{
		try {
		      assertEquals(lblSuccessfully.getText(), "Deposit Successful");//DepositResult
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	}
	private boolean isElementPresent() {
	    try {
	    	btn_btnClass2.getText();
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
}
