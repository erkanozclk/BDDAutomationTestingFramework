package Glue;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.config.DriverFactory;
import utils.config.TestBase;
import utils.ui.getProperties.GetEnvironment;

import java.util.concurrent.TimeUnit;

public class Hooks {


    GetEnvironment getEnvironment = new GetEnvironment();
    @Before
    public void setUp() {
        TestBase.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        TestBase.driver.manage().window().maximize();
        TestBase.driver.get(getEnvironment.getENV());
    }


    @After
    public void tearDown(Scenario scenario) {
        // only takes a screenshot if the scenario fails
        if (scenario.isFailed()) {
            // taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            // adding the screenshot to the report
            scenario.embed(screenshot, "image/png");
        }
        TestBase.closeDriver();
    }



}
