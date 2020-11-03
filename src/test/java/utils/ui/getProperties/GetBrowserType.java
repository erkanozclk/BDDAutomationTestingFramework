package utils.ui.getProperties;

import utils.config.ConfigurationReader;
import utils.ui.enums.BrowserNameEnums;

public class GetBrowserType {

    private String browserName = ConfigurationReader.getProperty("browser");

    public BrowserNameEnums getBrowserName() {

        if (browserName.equalsIgnoreCase("CHROME")) {

            return BrowserNameEnums.CHROME;

        } else if (browserName.equalsIgnoreCase("EDGE")) {

            return BrowserNameEnums.EDGE;

        } else if (browserName.equalsIgnoreCase("FIREFOX")) {

            return BrowserNameEnums.FIREFOX;

        } else if (browserName.equalsIgnoreCase("MAC_CHROME")) {

            return BrowserNameEnums.MAC_CHROME;

        } else if (browserName.equalsIgnoreCase("SAFARI")) {

            return BrowserNameEnums.SAFARI;

        }  else {

            throw new RuntimeException("No browser name specified in properties file at: " + browserName + ". Please specify the correct DeviceType name");

        }

    }
}
