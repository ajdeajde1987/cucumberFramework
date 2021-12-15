package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.DataBaseUtils;
import utils.GlobalVariables;

public class DBsteps {
    @Then("query HRMS database")
    public void query_hrms_database_and_get_data() {
       GlobalVariables.mapDataFromDb= DataBaseUtils.mapFromDb("SELECT emp_firstname,emp_middle_name,emp_lastname\n" +
                "FROM hs_hr_employees\n" +
                "WHERE employee_id=" + GlobalVariables.empId);

    }


    @Then("verify username from db")
    public void verifyUsernameFromDb() {

     // DataBaseUtils.mapFromDb(("select * from ohrm_user where user_name='"+GlobalVariables.userName+"';"));
     // Assert.assertEquals(GlobalVariables.mapDataFromDb.get("user_name"),GlobalVariables.userName);

        String actual=DataBaseUtils.mapFromDb("select * from ohrm_user where user_name='\"+GlobalVariables.userName+\"';").get("user_name");
        String expected=GlobalVariables.userName;
        System.out.println("Actual"+actual);
        System.out.println("Expected"+expected);
        Assert.assertEquals(actual,expected);

    }
}