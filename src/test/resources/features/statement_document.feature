@regression @loggedIn
Feature: Statements and Documents functionality

  Scenario: Verify user can view statements
    
    When user clicks the Statements tab
    Then verify user is on the Statements and Documents page
    And verify statements are displayed
    And verify documents are downloadable