Feature: Sign in and Security settings

  Scenario: User can open Sign-in & Security page

    Given user logs in to VaultBank
    When user clicks "Profile & settings"
    And user clicks "Sign-in & security"
    Then "Change Password" button should be visible



  Scenario: User can enable Two-Factor Authentication

    Given user logs in to VaultBank
    When user clicks "Profile & settings"
    And user clicks "Sign-in & security"
    And user enables Two-Factor Authentication
    Then Two-Factor Authentication should be enabled


  Scenario: User can reset password from security settings

    Given user logs in to VaultBank
    When user clicks "Profile & settings"
    And user clicks "Sign-in & security"
    And user clicks "Change Password"
    Then password reset email confirmation message should be displayed