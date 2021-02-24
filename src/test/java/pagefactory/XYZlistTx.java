package pagefactory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XYZlistTx {

	@FindBy(xpath = "//div[3]/button")
	WebElement btnTransaction;
	
	@FindBy(xpath = "//tr[@id='anchor0']/td[3]")
	WebElement lbl_Transaction;
	
	@FindBy(xpath = "//div[2]/div/div/button")
	WebElement btn_Back;
	
	@FindBy(xpath = "//button[3]")
	WebElement btn_Withdrowl;
	
	@FindBy(xpath = "//button[3]")
	WebElement lbl_VerifyTransaction;
	
	WebDriver driver;
    
	private StringBuffer verificationErrors = new StringBuffer();
	
	public XYZlistTx(WebDriver driver)
    {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
	
	public void clickTransactionButton()
	{
		btnTransaction.click();
	}
	
	public void verifyTransactionPage()
	{
		try {
		      assertEquals(lbl_Transaction.getText(), "Credit");//TransactionValue
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	}
	
	public void clickBackButton()
	{
		btn_Back.click();
	}
	
	public void clickWithdowal()
	{
		btn_Withdrowl.click();
	}
	
	public void VerifyTransaction()
	{
		try {
		      assertEquals(lbl_VerifyTransaction.getText(), "200"); //VerifyValue
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	}
		
}
