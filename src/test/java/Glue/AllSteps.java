package Glue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.config.ConfigurationReader;
import utils.ui.implementations.DesktopImp;
import utils.ui.service.Serviceable;


public class AllSteps {

    Serviceable serviceable = new DesktopImp();

    @Given("^ABC$")
    public void abc()   {
        serviceable.firstImp();
        System.out.println("First Step" + ConfigurationReader.getProperty("userName"));
    }

    @Then("^DFG$")
    public void dfg()  {
        serviceable.secondStep();
        System.out.println("Second Step" + ConfigurationReader.getProperty("password"));
    }



   /// feature ->> Glue ->>Serviable ->  desktopimp

}
