Feature: Element on page

  Scenario Outline: Verify the element on page
    Given user is on Dropdown-Checkboxes-RadioButtons page
    Then the user can see the option '<option>' in dropdown '<dropdown>'

    Examples:
      | dropdown        | option                        |
      | dropdowm-menu-1 | Python, SQL, JAVA, C#         |
      | dropdowm-menu-2 | Maven, JUnit, Eclipse, TestNG |
      | dropdowm-menu-3 | JQuery, JavaScript, CSS, HTML |


  Scenario: Verify the element on page with data table
    Given user is on Dropdown-Checkboxes-RadioButtons page
    Then the user can see the option in each dropdown:
      | dropdown        | option                        |
      | dropdowm-menu-1 | Python, SQL, JAVA, C#         |
      | dropdowm-menu-2 | Maven, JUnit, Eclipse, TestNG |
      | dropdowm-menu-3 | JQuery, JavaScript, CSS, HTML |


  Scenario Outline:  Verify user can select value in dropdown list
    Given user is on Dropdown-Checkboxes-RadioButtons page
    When user select "<value>" in dropdown "<dropdown>"
    Then the user can see option "<value>" is selected in dropdown "<dropdown>"
    Examples:
      | dropdown        | value |
      | dropdowm-menu-1 | SQL   |
