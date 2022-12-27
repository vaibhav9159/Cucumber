Feature: Verify Accounts page

Background: 
Given user has already logged in to app
|username 				|	password		|
|bholenath@bharat.co.in	|	bholebaba07#	|

Scenario: verify accounts page title
Given user is on accounts page
When  user captures page title
Then page title should be "My account - My Store"

Scenario: Verify my accounts section
Given user is on accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And account section count should be 6