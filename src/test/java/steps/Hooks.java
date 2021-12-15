package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

import java.io.IOException;

public class Hooks extends CommonMethods {
    @Before
    public void start() throws IOException {
        openBrowser();
    }
    @After
    public void end(Scenario scenario){
        byte[] picture;
        if(scenario.isFailed()){
         picture= takeScreenshot("failed/"+scenario.getName());
        }else{
            picture=takeScreenshot("passed/"+scenario.getName());
        }
        //it will attach pics in report
        scenario.attach(picture,"image/png",scenario.getName());
        tearDown();
    }
}
