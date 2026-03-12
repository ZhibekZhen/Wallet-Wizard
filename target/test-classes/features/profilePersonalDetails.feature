@regression @loggedIn
Feature: Profile and Settings - Personal Details

  @smoke
  Scenario: Verify user can navigate to Personal Details and update first name
    Given user navigates to Profile and Settings overview
    When user clicks Personal details in the sidebar
    Then Personal Information form should be visible
    And first name field should not be empty
    And last name field should not be empty
    When user updates first name to "John"
    And user clicks the Save Changes button on personal details
    Then user should remain on the account page
