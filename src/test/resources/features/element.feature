Feature: Element on page

  Scenario Outline: Verify the element on page
    Given user is on Dropdown-Checkboxes-RadioButtons page
    Then the user can see the option '<option>' in dropdown '<dropdown>'

    Examples:
      | dropdown        | option                        |
      | dropdowm-menu-1 | Python, SQL, JAVA, C#         |
      | dropdowm-menu-2 | Maven, JUnit, Eclipse, TestNG |
      | dropdowm-menu-3 | JQuery, JavaScript, CSS, HTML |


  Scenario:  Verify user can select