Feature: Add Employee

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button

  @1027
  Scenario: first scenario of adding the employee
  And user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully
@1028
  Scenario: adding an employee from feature file
    And user enters "Mike12345" "meme" and "lopez"
    And user clicks on save button
    Then employee added successfully



@1027
Scenario: second scenario of adding the employee
    And user enters firstname middlename and lastname
    When user deletes employee id
    And user clicks on save button
    Then employee added successfully
@1027
  Scenario: third scenario of adding the employee
  And user enters firstname middlename and lastname
    And user selects checkbox
    When user enters username password and confirmpassword
    And user clicks on save button
    Then employee added successfully

  @examples
  Scenario Outline: adding an employee from feature file
    And user enters "<firstName>" "<middleName>" and "<lastName>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      |firstName|middleName|lastName|
      |Mike12345|meme      |lopez   |
      |Ana5677  |tomica    |Kosticdr|
      |Sule5566 |fjidgj    |vdjfodfjdo|
    @datatable
    Scenario: adding an employee using data table
      When I add multiple employees and verify them that user has been added successfully
        |firstName|middleName|lastName|
        |Mike145|meme      |lopetrtrz   |
        |Ana567777  |tomica7h    |Kosticdgfdr|
        |Sule556ff6 |fjifffdgj    |vdjfhghfodfjdo|
        |Mi345|memegfg     |lopegfgfz   |
        |Anagf5677  |tomigfgca    |Kostigfcdr|


      @excel
      Scenario:Adding an employee from excel file
        When user add multiple employees from excel file usinf"EmployeeData" sheet and verify the added employee

        @db @regression
        Scenario:
          Adding employee and validating in DataBase
          When user enters "Ana" "LOpez" and "meme"
          And captures employee id
          And user clicks on save button
          And employee added successfully
          Then query HRMS database
          And verify employee data is matched in ui and db

          #review class with Asgar sql
  @101
  Scenario: third scenario of adding the employee
    And user enters firstname middlename and lastname
    And user selects checkbox
    When user enters username password and confirmpassword
    And user clicks on save button
    Then verify username from db





