import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YahooSearchTest {

    // 1. Go to main page
    // 2. Type the search query
    // 3. Submit Search query
    // 4. Verify Results page has been loaded

    WebDriver driver;

    @BeforeSuite
    private void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterSuite
    private void clear() {
        driver.quit();
    }

    @Test
    public void test0001(){
        String searchText = "Manitoba Hydro";
        openSearchPage();
        typeQuery(searchText);
        submitQuery();
        verifySearchResult();

    }

    private void verifySearchResult() {
        String elementToFindXPath = "(//*[@class='title'])";
        WebElement element = driver.findElement(By.xpath(elementToFindXPath));
        boolean isSearchResultDisplayed = element.isDisplayed();
        Assert.assertTrue(isSearchResultDisplayed);
    }

    private void submitQuery() {
        String xpath = "(//input[@name='p'])";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.submit();
    }

    private void typeQuery(String searchText) {
        String xpath = "(//input[@name='p'])";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(searchText);
    }

    private void openSearchPage() {
        driver.get("https://yahoo.com");

    }


}
