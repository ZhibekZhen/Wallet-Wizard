@regression @loggedIn @alertsPage
  Feature: profile & settings - alerts section

    Scenario Outline: user can select an unselected Alerts radio button
      Given user is logged in and navigated to Profile & Settings Alerts section
      And the "<Alerts>" radio button is unselected
      When user clicks on the "<Alerts>" radio button
      Then the "<Alerts>" radio button should be selected
      Examples:
        | Alerts             |
        | Transaction Alerts |
        | Low Balance Alerts |
        | Monthly Statements |