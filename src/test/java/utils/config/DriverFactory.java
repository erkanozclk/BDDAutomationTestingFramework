package utils.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ui.getProperties.GetBrowserType;
import utils.ui.getProperties.GetDeviceType;

import java.net.URL;

public class DriverFactory {

    public static WebDriver driver;
    static GetDeviceType getDeviceType = new GetDeviceType();
    static GetBrowserType getBrowserType = new GetBrowserType();



    public static WebDriver getDriver() {

        if(ConfigurationReader.getProperty("BrowserStack").equalsIgnoreCase("true")){
            switch (getDeviceType.getDevice()) {

//                case IPAD:
//                    getIpad();
//                    break;
//                case DESKTOP:
//                    getDesktopDriver();
//                    break;
//                case IPHONE:
//                    getIphone();
//                    break;
//                case TABLET:
//                    getTablet();
//                    break;
//                case ANDROID_PHONE:
//                    getAndroidPhone();
//                    break;
                default:
            }

        }else{
            getDesktopLocalDriver();
        }

        return driver;
    }





    public static WebDriver getDesktopLocalDriver() {
        if (driver == null) {

            switch (getBrowserType.getBrowserName()) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
            }

        }

        return driver;
    }




//    public static void getIpad() {
//
//        try {
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("os_version", "14");
//            caps.setCapability("device", "iPad Pro 12.9 2020");
//            caps.setCapability("real_mobile", "true");
//            driver = new RemoteWebDriver(new URL(URL), caps);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


 //   }





    public static void closeDriver () {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
