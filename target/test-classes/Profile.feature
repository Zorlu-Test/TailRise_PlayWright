Feature: Register

  As a user I should be able to manage profile.

  Acceptance criteria :

  1- User should not be able to change first name, last name, linkedin and email adress
  2- User should not enter country code at the mobile number field.
  3- Mobile number field should be entered as expected format.
  4- Save button once has clicked conveys information to database and holds changed information.
  5- Cancel button should be work and once clicked cancel all entered information's.


  Background:

    Given I am on the Home page.


  Scenario: H1 As a client I should be able to manage personal information.

    When I click on profile button at  side nodule
    And I select country
    And I select City
    And I select country code
    And I enter mobile phone
    When I click save button
    And  I refresh page
    Then Verify entered values holding by application







