Feature: Submit to contact

  Scenario: submit information
    Given user is on "contact" page
    When the user submit fields
    Then the user can see the thank you message
