package StepDefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.en.*;
import pagefactory.XYZAccount;
import pagefactory.XYZCustomer;
import pagefactory.XYZLogin;
import pagefactory.XYZlistTx;

public class XYZStepDefinition {
	
	WebDriver driver;
    XYZLogin loginPage;
    XYZCustomer customer;
    XYZAccount accountVOne;
    XYZlistTx transaction;
    
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    ExtentReports extent = new ExtentReports();
    static com.aventstack.extentreports.ExtentTest test;
    
	@Given("XYZ Bank page is open")
	public void xyz_bank_page_is_open() 
	{
		System.out.println("Inside step - user on the login page");

		System.setProperty("webdriver.chrome.driver","C:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
    	
	}

	@When("XYZ Bank page is open then Click customer login button")
	public void xyz_bank_page_is_open_then_click_customer_login_button() throws Exception 
	{
		loginPage = new XYZLogin(driver);
		
		extent.attachReporter(htmlReporter);
		
		test = extent.createTest("Click customer login button", "Click login");
	   
	    try {
	    	loginPage.click_customer_login_button();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("login button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
			loginPage.click_customer_login_button();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("login button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}

	@When("Verify customer page")
	public void verify_customer_page() throws Exception {
		customer = new XYZCustomer(driver);
		
		test = extent.createTest("Verify customer page", "verify customer page");
		
		try {
			customer.verifyCustomerPage();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("verify Customer Page", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
			loginPage.click_customer_login_button();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("verify Customer Page", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	    
	}

	@Then("Click dropdown list to select a customer name")
	public void click_dropdown_list_to_select_a_customer_name() throws Exception 
	{
		test = extent.createTest("select a customer name", "select a customer name in a dropdown list");
		
	    try {
	    	customer.clickCustomerDropdown();
		    customer.select_a_customer_nameFromDropdown();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("select a customer name", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("select a customer name", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	    
//	    customer.clickCustomerDropdown();
	}

	@When("Customer name is selected verify Login button displayed")
	public void customer_name_is_selected_verify_login_button_displayed() throws Exception 
	{   
	    test = extent.createTest("Cerify Login button", "verify Login button is displayed");
		
	    try {
	    	customer.waitForLoginButtonToAppear();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Verify Login button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
			loginPage.click_customer_login_button();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Verify Login button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}

	@When("Click Login button")
	public void click_login_button() throws Exception 
	{
	    test = extent.createTest("Click Login button", "click Login button");
		
	    try {
	    	customer.clickLoginButton();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Click Login button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
			loginPage.click_customer_login_button();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Click Login button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}

	@Then("Verify that Home page is displayed")
	public void verify_that_home_page_is_displayed() throws Exception 
	{
		accountVOne = new XYZAccount(driver);
		
		test = extent.createTest("Verify that Home page", "Verify that Home page is displayed");
		
	    try {
	    	accountVOne.waitForElementToAppear();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Verify that Home page", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Verify that Home page", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	    
	}

	@When("Home page is displayed click deposit button")
	public void home_page_is_displayed_click_deposit_button() throws Exception {
		
		test = extent.createTest("Click deposit button", "click deposit button");
		
	    try {
	    	accountVOne.clickDepositButton();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("click deposit button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("click deposit button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}

	@When("Verify deposit button is displayed")
	public void verify_deposit_button_is_displayed() throws Exception 
	{
		test = extent.createTest("Verify deposit button", "Verify deposit button is displayed");
		
	    try {
	    	accountVOne.checkDisplayedName();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Verify deposit button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Verify deposit button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}

	@Then("Enter deposit {int}")
	public void enter_deposit(Integer amount) throws Exception 
	{
		test = extent.createTest("Enter deposit", "Enter deposit amount");
		
	    try {
	    	accountVOne.enterAmount(amount);
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Enter deposit", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Enter deposit", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}

	@Then("Click deposit button to do a deposit")
	public void click_deposit_button_to_do_a_deposit() throws Exception 
	{
		
		test = extent.createTest("Click deposit button", "Click deposit button to do a deposit");
		
	    try {
	    	accountVOne.ClickButtonDeposit();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Click deposit button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Click deposit button", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	    
	}

	@Then("Verify Deposit Successful is displayed")
	public void verify_deposit_successful_is_displayed() throws Exception 
	{
		
		test = extent.createTest("Verify Deposit Successful", "Verify Deposit Successful");
		
	    try {
	    	accountVOne.validateSuccessful();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Verify Deposit Successful", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Verify Deposit Successful", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@When("Open Transactions")
	public void open_transactions() throws Exception 
	{
		transaction = new XYZlistTx(driver);
		
		test = extent.createTest("Open Transactions", "Open Transactions");
		
	    try {
	    	transaction.clickTransactionButton();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Open Transactions", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Open Transactions", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}

	@Then("Validate the Transaction appears")
	public void validate_the_transaction_appears() throws Exception 
	{ 
		test = extent.createTest("Validate the Transaction", "Validate the Transaction");
		
	    try {
	    	transaction.verifyTransactionPage();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Validate the Transaction", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Validate the Transaction", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}

	@Then("Open Withdrawl")
	public void open_withdrawl() throws Exception 
	{

		test = extent.createTest("Open Withdrawl", "Open Withdrawl");
		
	    try {
	    	transaction.clickBackButton();
			transaction.clickWithdowal();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Open Withdrawl", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Open Withdrawl", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}

	@When("Withdraw {int}")
	public void withdraw(Integer amount) throws Exception 
	{
			
		test = extent.createTest("Enter Withdraw", "Enter Withdraw");
		
	    try {
	    	accountVOne.checkDisplayedName();
			accountVOne.enterAmount(amount);
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Withdraw", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Withdraw", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}

	@Then("Validate the current Balance is the original balance")
	public void validate_the_current_balance_is_the_original_balance() throws Exception 
	{
		
		test = extent.createTest("Validate the current Balance", "Validate the current Balance");
		
	    try {
	    	accountVOne.clickDeposit();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Validate the current Balance", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Validate the current Balance", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	    
	}

	@Then("Open Transactions two")
	public void open_transactions_two() throws Exception 
	{

		test = extent.createTest("Open Transactions two", "Open Transactions two");
		
	    try {
	    	transaction.VerifyTransaction();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Open Transactions two", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Open Transactions two", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}
	
	@Then("Validate the Transaction appears tab")
	public void validate_the_transaction_appears_tab() throws Exception 
	{
		test = extent.createTest("Validate the Transaction", "Validate the Transaction");
		
	    try {
	    	transaction.clickTransactionButton();
		    validate_the_transaction_appears();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.pass("Validate the Transaction", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} 
	    catch (IOException e) 
	    {
			loginPage.click_customer_login_button();
		    test.log(Status.INFO, "This step shows usage of log(status, details)");
		    test.info("This step shows usage of info(details)");
	    	test.fail("Validate the Transaction", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		}
	    extent.flush();
	}
}
