package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;
import utils.GlobalVariables;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash=new DashBoardPage();
        click(dash.pimOption);

    }
    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash=new DashBoardPage();
        click(dash.addEmployeeButton);


    }
    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage addEmployeePage=new AddEmployeePage();
        sendText(addEmployeePage.firstname, "Ana");
        sendText(addEmployeePage.midName, "Tomi");
        sendText(addEmployeePage.lastName, "Kostic");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage addEmployeePage=new AddEmployeePage();
        click(addEmployeePage.saveBtn);

    }
    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage addEmployeePage=new AddEmployeePage();
        click(addEmployeePage.createLoginCheckBox);


    }
    @When("user enters username password and confirmpassword")
    public void user_enters_username_password_and_confirmpassword() {
       AddEmployeePage addEmployeePage=new AddEmployeePage();
       GlobalVariables.userName="ajdeajde19871987";

       sendText(addEmployeePage.createUsername, GlobalVariables.userName);
       sendText(addEmployeePage.createPassword, "Hum@nhrm123");
       sendText(addEmployeePage.rePassword, "Hum@nhrm123");
    }
    @Then("employee added successfully")
    public void employeeAddedSuccessfully() {

        System.out.println("Employee added successfully");
    }



    @When("user deletes employee id")
    public void user_deletes_employee_id() {
       AddEmployeePage addEmployeePage=new AddEmployeePage();
       addEmployeePage.employeeId.clear();
    }
    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstname, String middleName, String lastname) {
        //initializing global variables using local variables (value coming from feature file)
        GlobalVariables.firstname=firstname;
        GlobalVariables.middleName=middleName;
        GlobalVariables.lastName=lastname;
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstname, firstname);
        sendText(addEmployeePage.midName, middleName);
        sendText(addEmployeePage.lastName, lastname);
         //fali jedan korak
    }
    @When("user enters {string} {string} and {string} for an employee")
    public void user_enters_and_for_an_employee(String firstName, String middleName, String lastName) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstname, firstName);
        sendText(addEmployeePage.midName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }

    @When("I add multiple employees and verify them that user has been added successfully")
        public void i_add_multiple_employees_and_verify_them_that_user_has_been_added_successfully(DataTable employees) throws InterruptedException {

        List<Map<String,String>> employeeNames  =employees.asMaps();

        for(Map<String,String>employeeName:employeeNames)      {
            String valueFirstName=employeeName.get("firstName")   ;
            String valueMiddleName=employeeName.get("middleName")      ;
            String valueLastName=employeeName.get("lastName")     ;

              AddEmployeePage addEmployeePage = new AddEmployeePage();
           sendText(addEmployeePage.firstname, valueFirstName);
              sendText(addEmployeePage.midName, valueMiddleName);
            sendText(addEmployeePage.lastName, valueLastName);
            click(addEmployeePage.saveBtn);


        DashBoardPage dash=new DashBoardPage();
        click(dash.addEmployeeButton);
        Thread.sleep(2000);
}
    }
    @When("user clicks on PIM option and Add Employee option")
    public void user_clicks_on_pim_option_and_add_employee_option() {
       DashBoardPage dash=new DashBoardPage();
       click(dash.pimOption);
       click(dash.addEmployeeButton);
    }

    @Then("user is navigated to add employee page")
    public void user_is_navigated_to_add_employee_page() {
        AddEmployeePage emp=new AddEmployeePage();
      //  Assert.assertTrue(emp.headerValue.isDisplayed()); this one will not work because it will
        //show the element is found the text but not what does it says in text

        String actualText=emp.headerValue.getText();
        String expectedText="Add Employee";
        Assert.assertEquals("Value do not match",actualText,expectedText);
    }
    @When("I add multiple employees and verify them that user has been added successfully in application")
    public void i_add_multiple_employees_and_verify_them_that_user_has_been_added_successfully_in_application(DataTable employeeData ) {
        List<Map<String,String>>employeeNames= employeeData.asMaps();
        for(Map<String,String> employee:employeeNames){
           String valueFirstName= employee.get("firstName");
            String valueMiddleName= employee.get("MiddleName");
           String valueLastName=employee.get("lastName");

           AddEmployeePage addEmployeePage=new AddEmployeePage();
           sendText(addEmployeePage.firstname,valueFirstName);
           sendText(addEmployeePage.midName, valueMiddleName);
           sendText(addEmployeePage.lastName, valueLastName);
           click(addEmployeePage.saveBtn);

           DashBoardPage dash= new DashBoardPage();
           click(dash.addEmployeeButton);

        }

    }
    @When("user add multiple employees from excel file usinf\"EmployeeData\" sheet and verify the added employee")
    public void user_add_multiple_employees_from_excel_file_usinf_employee_data_sheet_and_verify_the_added_employee(String sheetName) {
       List<Map<String,String>>newEmployees= ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH,sheetName);
       DashBoardPage dash=new DashBoardPage();
       AddEmployeePage add=new AddEmployeePage();

       Iterator<Map<String,String>> iterator=newEmployees.iterator();
       while(iterator.hasNext()){
           Map<String,String> mapNewEmp= iterator.next();
           sendText(add.firstname, mapNewEmp.get("FirstName"));
           sendText(add.midName, mapNewEmp.get("MiddleName"));
           sendText(add.lastName, mapNewEmp.get("LastName"));
           click(add.saveBtn);
           click(dash.addEmployeeButton);
       }
    }
    @When("captures employee id")
    public void captures_employee_id() {
      AddEmployeePage emp= new AddEmployeePage();
      GlobalVariables.empId =emp.employeeId.getAttribute("value");

        System.out.println("-------"+GlobalVariables.empId+"-----------------------------");
    }
    @Then("verify employee data is matched in ui and db")
    public void verify_employee_data_is_matched_in_ui_and_db() {
        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_firstname"),GlobalVariables.firstname);
        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_middle_name"),GlobalVariables.middleName);
        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_lastname"),GlobalVariables.lastName);
    }






}