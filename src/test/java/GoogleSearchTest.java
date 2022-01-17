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
        String selector = ".a4bIc > input[role='combobox']";
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.sendKeys(queryForSearch);
        element.submit();

    }

    private void submitQuery() {
        String selector = ".a4bIc > input[role='combobox']";
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.submit();

    }

    /*private void waitForResultToBeDisplayed() {
        By elementToWait = By.id("result-stats");
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(elementToWait);
        WebElement until = new WebDriverWait(driver, 20).until(condition);


    }*/

    private void verifyResultsPage() {
        String resultStatsElementId = "result-stats";
        WebElement element = driver.findElement(By.id(resultStatsElementId));
        boolean isResultsDisplayed = element.isDisplayed();
        Assert.assertTrue(isResultsDisplayed);

    }




}
