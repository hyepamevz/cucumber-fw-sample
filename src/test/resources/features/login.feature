Feature: Login to the application

  Scenario Outline: Verify that user cannot login with invalid email and correct password
    Given the user is on the login page
    When the user login with "<username>" and "<password>"
    Then the user see the warning alert

    Examples:
      | username | password |
      | user1    | pwd1     |
      | user2    | pwd2     |
      | user     |          |
