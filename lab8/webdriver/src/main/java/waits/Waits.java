package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    protected final static int WAIT_TIMEOUT_SECONDS = 50;

    public static WebElement waitElementToBeClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement findElementByLocator(WebDriver driver,  By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    public static WebElement waitVisibilityOfElementLocated(WebDriver driver, By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
