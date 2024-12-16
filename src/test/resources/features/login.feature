Feature: Login to the application

  Scenario Outline: Verify that user cannot login with invalid email and correct password
    Given user is on "login" page
    When the user login with credentials: "<username>" "<password>"
    Then the user see the warning alert
    Examples:
      | username | password |
      | user1    | pwd1     |
      | user2    | pwd2     |
      | user     |          |
