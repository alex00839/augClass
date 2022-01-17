import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YandexSearchTest {

    // 1. Go to main page
    // 2. Type the search query
    // 3. Submit Search query
    // 4. Verify Results page has been loaded


    WebDriver driver;

    @BeforeSuite
    private void setup(){
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    }

    @AfterSuite
    private void cleanup(){
        driver.quit();
    }

    @Test
    public void Test0001(){
        String TextToSearch = "Putin Hooylow";
        openSearchPage();
        enterSearchQuery(TextToSearch);
        submitSearchQuery();
        verifySearchResults();
    }

    private void verifySearchResults() {
        String searchResultAmountXPath = "(//*[@class='serp-adv__found'])";
        WebElement element = driver.findElement(By.xpath(searchResultAmountXPath));
        boolean isResultDisplayed = element.isDisplayed();
        Assert.assertTrue(isResultDisplayed);
    }

    private void submitSearchQuery() {
        String searchFieldXPath = "(//input[@name='text'])";
        WebElement element = driver.findElement(By.xpath(searchFieldXPath));
        element.submit();
    }

    private void enterSearchQuery(String textToSearch) {
        String searchFieldXPath = "(//input[@id='text'])";
        WebElement element = driver.findElement(By.xpath(searchFieldXPath));
        element.sendKeys(textToSearch);
    }

    private void openSearchPage() {
        String url = "https://www.yandex.com";
        driver.get(url);
    }


}


