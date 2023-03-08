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

  @dnm
  Scenario: H1 As a client I should be able to manage personal information.

    When I click on profile button at  side nodule
    And I select country
    And I select City
    And I select country code
    And I enter mobile phone
    When I click save button
    And  I refresh page
    Then Verify entered values holding by application


  Scenario: H2 As a client I should be able to  cancel managed personal information.

    When I click on profile button at  side nodule
    And I select country
    And I select City
    And I select country code
    And I enter mobile phone
    When I click save button
    And I set none filled places
    And I click on cancel button
    Then Verify entered values holding by application


    # min length = 7
    # max length = 14
    # Only  numerical
  Scenario Outline:  N1 As a client I should not be able to enter inconvenient mobile number.
    When I click on profile button at  side nodule
    And I enter "<mobileNumber>" mobile phone
    Then Verify mobile field error message appears
    Examples:
      | mobileNumber    |
      | -               |
      | 123456          |
      | 1234567         |
      | 123456123456123 |
      | 1 1             |
      |                 |
      | -1234567        |
      | abcdefglm       |
      | **              |