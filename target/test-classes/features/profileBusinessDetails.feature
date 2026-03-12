@regression @loggedIn
Feature: Profile and Settings - Business Details

  @smoke
  Scenario: Verify user can navigate to Business Details and fill in all fields
    Given user navigates to Profile and Settings overview
    When user clicks Business details in the sidebar
    Then Business Details form should be visible
    And Business Name input should be visible
    And Annual Revenue input should be visible
    And Industry input should be visible
    When user enters business name "TechCorp LLC"
    And user enters annual revenue "50000 - 100000"
    And user enters industry "Technology"
    And user clicks the Save Changes button on business details
    Then user should remain on the account page
