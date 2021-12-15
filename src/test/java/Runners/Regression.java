package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features="src/test/resources/features/",
        glue="steps",
        dryRun =false,
        monochrome = true,
        tags="@db",
        publish=true
)

public class Regression {
}
