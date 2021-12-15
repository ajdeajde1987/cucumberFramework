package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="@target/failed.txt",
        //glue is where we can find the implementation for gherkin steps
        //here we provide the path of our steps package
        glue="steps",
        //if we set dryRun to true, then no actual execution happens
        //it will quickly scan all gherkin steps whether they have been implemented or not
       // dryRun=false,
        //it keeps the console  output for the cucumber test easily readable
        //it will remove all the unreadable character dont set it to false always true
        monochrome = true,
        ////tags we can segregate scenarios based on tags and can execute them accordingly
        //  tags="@smoke"
        // tags="@sprint1 or @sprint2"
        //  tags="@smoke and sprint3"
       // tags="@error",
        plugin={"pretty"}
        //plugin we use it to generate report for the execution
        //pretty -it takes care of printing the steps in console

        //strict=true, it checks all the steps definition
)

public class FailedRunner {
}
