@regression @loggedIn
Feature: Profile and Settings - Overview page

  @smoke
  Scenario: Verify all sections are visible on Overview page
    Given user navigates to Profile and Settings overview
    Then the page heading should display "Profile & settings"
    And Personal details card should be visible on overview
    And Business details card should be visible on overview
    And Sign-in and security card should be visible on overview
    And Account settings card should be visible on overview
    And Alerts card should be visible on overview
    And Payment preferences card should be visible on overview
