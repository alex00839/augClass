import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeSuite
    private void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterSuite
    private void closeBrowser(){
        driver.quit();
    }

    // 1. Go to main page
    // 2. Type the search query
    // 3. Submit Search query
    // 4. Verify Results page has been loaded

    @Test
    public void test0001() {
        String queryForSearch = "Portnov Computer School";
        openMainPage();
        typeQuery(queryForSearch);
        submitQuery();
        verifyResultsPage();
        //waitForResultToBeDisplayed();

    }


    private void openMainPage() {
        driver.get("https://www.google.com");
    }

    private void typeQuery(String queryForSearch) {
        String xpath = "(//input[@name='q'])";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(queryForSearch);
        element.submit();

    }

    private void submitQuery() {
        String xpath = "(//input[@name='q'])";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.submit();

    }

    /*private void waitForResultToBeDisplayed() {
        By elementToWait = By.id("result-stats");
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(elementToWait);
        WebElement until = new WebDriverWait(driver, 20).until(condition);


    }*/

    private void verifyResultsPage() {
        String resultStatsElementXPath = "(//*[@id='result-stats'])";
        WebElement element = driver.findElement(By.xpath(resultStatsElementXPath));
        boolean isResultsDisplayed = element.isDisplayed();
        Assert.assertTrue(isResultsDisplayed);

    }




}
