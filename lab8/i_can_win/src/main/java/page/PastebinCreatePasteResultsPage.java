package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinCreatePasteResultsPage {
    private WebDriver driver;

    private WebElement successResult;
    private By successResultLocator = By.xpath("//div[@class='notice -success -post-view']");

    public PastebinCreatePasteResultsPage(WebDriver driver) {
        this.driver = driver;
        successResult = findElementByLocator(successResultLocator);
    }

    public boolean isInitialized() {
        return successResult.isDisplayed();
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}
