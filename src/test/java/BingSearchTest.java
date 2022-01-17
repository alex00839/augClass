import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BingSearchTest {

    // 1. Go to main page
    // 2. Type the search query
    // 3. Submit Search query
    // 4. Verify Results page has been loaded

    WebDriver driver;

    @BeforeSuite
    private void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @AfterSuite
    private void clear(){
        driver.quit();
    }

    @Test
    public void test0001(){
        String textToSearch = "Canada Travel Restrictions";
        openSearchPage();
        enterSearchQuery(textToSearch);
        submitSearchQuery();
        //verifySearchResult();
    }

    private void verifySearchResult() {
        String resultsStatsElementXpath = "(*[@class='sb_count'])";
        WebElement resultIsDisplayed = driver.findElement(By.xpath(resultsStatsElementXpath));
        boolean isResultDisplayed = resultIsDisplayed.isDisplayed();
        Assert.assertTrue(isResultDisplayed);
    }

    private void submitSearchQuery() {
        String elementXPath =  "(//input[@name='q'])";
        WebElement element = driver.findElement(By.xpath(elementXPath));
        element.submit();
    }

    private void enterSearchQuery(String textToSearch) {
        String elementXPath = "(//input[@name='q'])";
        WebElement element = driver.findElement(By.xpath(elementXPath));
        element.sendKeys(textToSearch);
    }

    private void openSearchPage() {
        driver.get("https://www.bing.com/");
    }


}
