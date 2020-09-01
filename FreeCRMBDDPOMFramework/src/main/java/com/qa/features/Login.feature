Feature: Free CRM BDD with POM 

Scenario: Free CRM login Test
Given user opens browser
When user is on login page
Then user logs into app
Then user is on home page
Then user clicks on logout button
Then user closes the browser