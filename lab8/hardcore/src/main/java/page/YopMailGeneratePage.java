package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopMailGeneratePage {
    private WebDriver driver;

    private WebElement copyEmailField;
    private By copyEmailFieldLocator = By.xpath("//div[@id='egen']");

    public YopMailGeneratePage(WebDriver driver) {
        this.driver = driver;
        copyEmailField = findElementByLocator(copyEmailFieldLocator);
    }

    public boolean isInitialized() {
        return copyEmailField.isDisplayed();
    }

    public String copyEmail() {
        return copyEmailField.getText();
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}