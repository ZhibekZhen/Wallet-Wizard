@regression @loggedIn @cards
  Feature: verify cards section

    Scenario: verify cards page opens
      When user clicks on Cards section
      Then verify user is navigated to Cards section
      Then verify user can open card detail modal
      Then verify card details modal shows correct card information
      Then verify user can close the card details modal
      Then verify card number should display only last four digits