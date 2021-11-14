package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchPage {
    private WebDriver driver;

    private WebElement calculatorLink;
    private By calculatorLinkLocator = By.xpath("//a[@class='gs-title']");

    public GoogleCloudSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInitialized() {
        return calculatorLink.isDisplayed();
    }

    public GoogleCloudPricingCalculatorPage openCalculator() {
        calculatorLink = findElementByLocator(calculatorLinkLocator);
        calculatorLink.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 25)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}
