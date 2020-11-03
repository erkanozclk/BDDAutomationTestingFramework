package runner;


import com.sun.javaws.exceptions.OfflineLaunchException;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources",
        glue = "Glue",
        tags = "@Temp",
        dryRun = false

)
public class BDDRunner {



}
