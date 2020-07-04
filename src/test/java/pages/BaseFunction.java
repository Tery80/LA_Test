package pages;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunction {

    String DRIVER_LOCATION = "d:/temp1/chromedriver.exe";
    private static final Logger LOGGER = LogManager.getLogger(BaseFunction.class);
    private WebDriver driver;


    private WebDriverWait wait;

    public BaseFunction() {
        LOGGER.info("Setting system property for driver.");
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);

        LOGGER.info("Initializing new driver (opening).");
        driver = new ChromeDriver();

        LOGGER.info("Maximizing window.");
        driver.manage().window().maximize();

        LOGGER.info("Wait for a 5 sec.");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void openUrl(String url) {
        LOGGER.info("Open URL: " + url);
        if ((!url.startsWith("http")) && (!url.startsWith("https"))) {
            url = "https://" + url;
        }
        driver.get(url);
    }

    public WebElement getElement(int articleNumber, List<WebElement> listOfArticles) {
        LOGGER.info("Getting Article.");
        // add check for empty list
        Assertions.assertTrue(((listOfArticles.size() > articleNumber)), "Impossible to choose that Article Number");
        return listOfArticles.get(articleNumber);
    }

    public WebElement getElement(By locator) {
        LOGGER.info("Getting Article.");
        return driver.findElement(locator);
    }

    public List<WebElement> getElementsList(By locator) {
        LOGGER.info("Getting List of Articles.");
        //      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> listOfArticles = driver.findElements(locator);
        Assert.requireNonEmpty(listOfArticles, "There are no Articles");
        return listOfArticles;
    }

    //
//    private Integer convertCommentsToInt(String commentCountString) {
//        String commentCountStr = commentCountString.replaceAll("[()]", "");
//        return Integer.parseInt(commentCountStr);
//    }
//    public void openHomePage(){
//        openUrl(HOME_PAGE);
//    }
    public void click(WebElement article) {
        LOGGER.info("Clicking element.");
        article.click();
    }

    public void closeWebPage() {
        driver.quit();
    }
}
