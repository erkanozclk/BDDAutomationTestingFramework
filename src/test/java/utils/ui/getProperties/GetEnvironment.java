package utils.ui.getProperties;


import utils.config.ConfigurationReader;

public class GetEnvironment {

    private String environment = ConfigurationReader.getProperty("environment");

    public String env =null;


    public String getENV() {

        switch (environment) {

            case ("STG"):
                env = "http://library2.cybertekschool.com/login.html";
                break;
            case ("UAT"):
                env = "http://library3.cybertekschool.com/login.html";
                break;
            case ("DEV"):
                env = "http://library4.cybertekschool.com/login.html";
                break;
            case ("PROD"):
                env = "http://library5.cybertekschool.com/login.html";
                break;
            default:
        }
        return env;
    }




}
