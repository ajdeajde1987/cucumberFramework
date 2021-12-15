Feature: Login error verification
  @reviewLogin1
  Scenario:valid username and invalid password
    When user enters valid "Admin" and invalid "fjdkfjdj"
    And user clicks on login button
    Then user see invalid credentials message on login page

  @reviewLogin
  Scenario Outline:valid username and valid password
    When user enters valid "<username>" and invalid "<password>"
    And user clicks on login button
    Then user verify dashboard page
    Examples:
    |username|password|
    |admin   |Hum@nhrm123|
    |johnny1234560000|Syntax1253!!!!|

  @datatable1
  Scenario: adding an employee using data table
    When I add multiple employees and verify them that user has been added successfully in application
      |firstName|middleName|lastName|
      |Mike145|meme      |lopetrtrz   |




