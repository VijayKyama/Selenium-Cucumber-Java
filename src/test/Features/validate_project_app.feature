Feature: Validate Project App


  Background: Login to the application
    Given User launches the application url
    When User enters valid credentials
    And Click on signin button
    Then User should land on home screen

  @Sanity
  Scenario: Validate Creation of a ticket
    Given User is on home screen
    When User hovers on Add button
    Then multiple buttons should appear along with Ticket
    When User clicks on Ticket
    Then new tab should open to create a new ticket
    When User enters subject, To and description fields
    And click on submit as new button
    Then a new ticket should be created

  @Sanity
  Scenario: Create a child ticket from  project app for the newly created ticket
    Given User opened newly created original ticket
    When User clicks on Make a Project from this Ticket button
    Then create single, Create Bulk, Add existing options should appear
    When User selects to create single
    Then a new screen should appear in sidebar with all required fields
    When User clicks on create single tasks in sidebar overlay
    Then a child ticket should be created

    When User opens parent ticket
    Then User should see valid parent tags
    When User opens child ticket
    Then User should see valid project id from parent ticket
    And valid tag for child ticket


  Scenario: Validate scenario when user tries to close parent ticket without closing child ticket
    Given User access the parent ticket
    When User clicks on arrow mark in the right bottom of the page to update status
    Then submit as solved option should be visible along with Open and Pending
    When User clicks on submit as solved without closing child ticket
    Then User should receive proper message that it is not possible to close parent ticket unless child ticket is closed




