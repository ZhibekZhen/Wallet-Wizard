Feature: Account Settings

  Scenario: User can open Account Settings page
    Given user logs in to VaultBank
    When user clicks "Profile & settings"
    And user clicks "Account settings"
    Then Account Settings page should be visible


  Scenario: User can enable Go Paperless
    Given user logs in to VaultBank
    When user clicks "Profile & settings"
    And user clicks "Account settings"
    And user enables "Go Paperless"
    Then Go Paperless should be enabled


  Scenario: User can change Account Nickname
    Given user logs in to VaultBank
    When user clicks "Profile & settings"
    And user clicks "Account settings"
    And user changes account nickname to "My Account"
    Then account nickname should be updated


  Scenario: User can hide account
    Given user logs in to VaultBank
    When user clicks "Profile & settings"
    And user clicks "Account settings"
    And user enables "Hide Account"
    Then account should be hidden from dashboard