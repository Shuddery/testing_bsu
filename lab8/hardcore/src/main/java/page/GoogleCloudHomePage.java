package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    private WebElement searchButton;
    private By searchButtonLocator = By.xpath("//div[@class='devsite-searchbox']/input");

    public GoogleCloudHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleCloudHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        searchButton = findElementByLocator(searchButtonLocator);
        return this;
    }

    public GoogleCloudSearchPage searchTerm(String term) {
        searchButton.sendKeys(term, Keys.ENTER);
        return new GoogleCloudSearchPage(driver);
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}
