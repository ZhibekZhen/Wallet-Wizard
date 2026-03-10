@login
Feature: verify user is able to log in

  @successfulLogin
  Scenario: successful login
    Given user logs in with multiple valid credentials


  @failedLogin
  Scenario Outline: failed login
    Given user enters username "<username>" and password "<password>"
    Then verify user stays in login page
    Examples:
      | username                 | password   |
      | testuser1@vaultbank.test | Test2Pass! |
      | testuser1@vaultbank.test |            |
      |                          | Test1Pass! |
      |                          |            |
      | abc                      | efd        |




