package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    protected final static int WAIT_TIMEOUT_SECONDS = 30;

    public static WebElement waitElementToBeClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement findElementByLocator(WebDriver driver,  By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    public static WebElement findElementByLocatorStaleElementReferenceException(WebDriver driver, By locator) {
        try {
            return findElementByLocator(driver, locator);
        } catch (StaleElementReferenceException e) {
            return findElementByLocator(driver, locator);
        }
    }

    public static WebElement waitPresenceOfElementLocated(WebDriver driver, By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
