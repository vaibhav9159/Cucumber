Feature: Test user login access

Scenario: Verfiy login page title
Given user is on login page
When user captures page title
Then page title should be "Login - My Store"

 
Scenario: Verify login page logo image
Given user is on login page
Then verify logo image is displayed

Scenario: Verify login page authentication section
Given user is on login page
Then create an account section is displayed 
And create an account button is enabled
And already registered section is displayed
And sign in button is enabled
And forgot password link is displayed

Scenario: Verify user login with valid credentials
Given user is on login page
When user enters username "bholenath@bharat.co.in"
And user enters password "bholebaba07#"
Then user captures page title
And page title should be "My account - My Store"
