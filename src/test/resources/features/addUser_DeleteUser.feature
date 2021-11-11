Feature: As an Enggner I need to automate So I can show my awesome automation skills

  Background: 
    Given I am on the userInfo Page

  Scenario: As a User I should be able to add a user and validate the user has been added to the table
    When I click on AddUser button then I am on the Add User page
    Then I add new user with following details| novak | Mat | novakMat | 1234567 | novak@gmail.com | 7031234567 |
    And I click Company AAA
    And I select Role as Sales Team
    Then I click on Save button
    Then The added user displayed on the table

  Scenario: As a User I should be able to delete a User
    When I click on the delete button
    Then a confirmation Dialog should appear with the text: "Do you really want to delete the user?"
    When I click on Ok button
    Then The user should be deleted