@regression
Feature: Validation that the Deposit Was successful

Background: Login as a customer
Given XYZ Bank page is open
When XYZ Bank page is open then Click customer login button
And Verify customer page
Then Click dropdown list to select a customer name
When Customer name is selected verify Login button displayed
And Click Login button
Then Verify that Home page is displayed
#When Home page is displayed click deposit button
#And Verify deposit button is displayed

@TestOne
Scenario Outline: Validate the Deposit Was successful on XYZ Bank one
When Home page is displayed click deposit button
And Verify deposit button is displayed
Then Enter deposit <Amount>
And Click deposit button to do a deposit
Then Verify Deposit Successful is displayed
Examples:
|Amount|
|1500|

@TestTwo
Scenario Outline: Validate the Deposit Was successful on XYZ Bank two
When Home page is displayed click deposit button
And Verify deposit button is displayed
Then Enter deposit <Amount>
And Click deposit button to do a deposit
Then Verify Deposit Successful is displayed
Examples:
|Amount|
|1500|

@TestThree
Scenario Outline: Validate the Deposit Was successful on XYZ Bank three
When Open Transactions
Then Validate the Transaction appears
And Open Withdrawl
When Withdraw <Amount>
Then Validate the current Balance is the original balance
And Open Transactions two
Then Validate the Transaction appears tab

Examples:
|Amount|
|1500|