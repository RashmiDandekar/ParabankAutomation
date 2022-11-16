# ParabankAutomation

As per the assignment, I have created a project in modular framework using PageFactory to to automate following tests. I have also used extentReport for creating html reports.


##Assignment

AUT - https://parabank.parasoft.com/parabank/index.htm

1. Navigate to https://parabank.parasoft.com/parabank/index.htm

2. The login credentials are john/demo

3. Automate the following scenarios:

a) Verification of opening two new accounts for both account types - CHECKING and SAVINGS.
Help - Click the “Open New Account” link in the “Account Services” section

b) Verification of the account details page (click on the account number after creating it) for both the new accounts created as part of the above step.
Sample account details page - https://parabank.parasoft.com/parabank/activity.htm?id=12345

c) Bill Pay (Link is placed in the Account Services section):
- Automate the verification of the form.
- Fill in the Payee Information and transfer the whole amount of $50.00 from any one of the newly created accounts to the other new one. Verify that the Balance and transaction table details are correct in each of the accounts (both sender and receiver account) activity page (ex: https://parabank.parasoft.com/parabank/activity.htm?id=12345) *


## Tools

* Maven
* TestNG
* Java
* Selenium Webdriver
* Extent Report
* Page Object Model Framework (PageFactory)

## Requirements

In order to utilise this project you need to have the following installed locally:

* Maven 3
* Chrome and Chromedriver (UI tests use Chrome by default)
* Java 1.8

## Usage

To run , navigate to `ParabankAutomation` directory and run:

`mvn clean install`

## Note

Report will be generated in "reports" folder.
