@regression @loggedIn @accounts
Feature: verify accounts section

  Scenario: verify accounts page opens
    When user clicks on Accounts section
    Then verify user is navigated to Accounts section
    Then verify user can click Credit option and open Credit account
    Then verify user can get statements&documents of chosen account
    When user returns back can Transfer money
#    Then user clicks on Accounts section and can set Savings goal