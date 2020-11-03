package utils.ui.utilites;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.config.ConfigurationReader;
import utils.config.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BrowserUtils extends TestBase {


    public void waitforpresenceofelement(By elementBy) {
        int timeout = Integer.parseInt(ConfigurationReader.getProperty("waitTimeOut"));
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }


    /**
     * This method is switch frame.
     **/

    public void switchFrame(String frameXpath) {
        driver.switchTo().frame(driver.findElement(By.xpath(frameXpath)));
    }


    /**
     * This method is return time out time for wait time.
     **/

    public int timeOut() {
        int timeout = Integer.parseInt(ConfigurationReader.getProperty("waitTimeOut"));
        return timeout;
    }


    //It will be used to pause our test execution
    //just provide number of seconds as a parameter
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            try {
                element.isDisplayed();
                break;
            } catch (StaleElementReferenceException st) {
                y++;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }

    /**
     * Waits for the provided element to be visible on the steps
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        //WebDriverWait wait = new WebDriverWait(DriverFactory.get(), timeToWaitInSec);
        WebDriverWait wait = new WebDriverWait(getDriver(), timeToWaitInSec);
        try {Thread.sleep(500);} catch (Exception e) {}
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //    PLEASE INSERT THIS METHOD INTO BROWSER UTILS
    /*
     * takes screenshot
     * whenever you call this method
     * it takes screenshot and returns location of the screenshot
     * @param name of test or whatever your like
     * take a name of a test and returns a path to screenshot takes
     */
//    public static String getScreenshot(String name) {
//        // name the screenshot with the current date time to avoid duplicate name
////        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));​
//        SimpleDateFormat df = new SimpleDateFormat("-yyyy-MM-dd-HH-mm");
//        String date = df.format(new Date());
//        // TakesScreenshot ---> interface from selenium which takes screenshots
//        TakesScreenshot ts = (TakesScreenshot) getDriver();
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        // full path to the screenshot location
//        //where screenshot will be stored
//        //System.getProperty("user.dir") returns path to the project as a string
//        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
//        File finalDestination = new File(target);
//        // save the screenshot to the path given
//        try {
//            FileUtils.copyFile(source, finalDestination);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return target;
//    }
//    public synchronized void takeScreenshot(WebDriver driver)
//    {
//        try {
//            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String screenshotLocation = System.getProperty("user.dir") + "//screenshots";
//            FileUtils.copyFileToDirectory(srcFile, new File(screenshotLocation));
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }

    /**
     * Wait 15 seconds with polling interval of 200 milliseconds then click
     *
     * @param webElement of element
     */
    public static void clickWithWait(WebElement webElement) {
        Wait wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(800))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class);
        WebElement element = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> webElement);
        try {
            element.click();
        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Wait for proper steps title
     *
     * @param pageTitle
     */
    public static void waitForPageTitle(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.titleIs(pageTitle));
    }

    /**
     * This method will convert list of WebElements into list of string
     *
     * @param listOfWebElements
     * @return list of strings
     */
    public static List<String> getListOfString(List<WebElement> listOfWebElements) {
        List<String> listOfStrings = new ArrayList<>();
        for (WebElement element : listOfWebElements) {
            String value = element.getText().trim();
            //if there is no text
            //do not add this blank text into list
            if (value.length() > 0) {
                listOfStrings.add(value);
            }
        }
        return listOfStrings;
    }

    public boolean switchWindow() {
        String parent_win = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        boolean flag =true ;
        for (String winID : windows) {

            if (!winID.equals(parent_win)) {
                driver.switchTo().window(winID);
                flag = true;
            }else {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * This method is created to click unique element when fond with text
     * */

    public void clickUniqueElement(By element){

        List<WebElement> allElem = driver.findElements( element );
        List<WebElement> filteredElem = allElem.stream().filter(elem -> !elem.getText().trim().equals("")).collect(Collectors.toList());
        filteredElem.stream().forEach(elem -> {
            elem.click();
        });
    }


    public void scrollToElement(WebElement element){

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }
    private static WebDriverWait wait = new WebDriverWait(driver, 20);
    public static void enterText(WebElement element, String text){

        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.attributeToBe(element, "value", text));
        System.out.println("Entering text: " + text);
    }


}
