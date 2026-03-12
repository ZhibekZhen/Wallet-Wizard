@regression @loggedIn @mainPage
Feature: main page navigation

  Scenario Outline: user can navigate to different sections from the main page
    Given user is logged in and on the main page
    When user clicks on the "<Section>" section
    Then the "<Section>" page should be displayed
    Examples:
      | Section                |
      | Accounts               |
      | Customer Insights      |
      | Pay & transfer         |
      | Statements & documents |
      | Cards                  |
      | Profile & Settings     |
