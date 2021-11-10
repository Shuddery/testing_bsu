package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KiwiHomePage {

    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://www.kiwi.com/ru/";

    private By acceptCookiesButtonLocator = By.xpath("//button[@class='ButtonPrimitive__StyledButtonPrimitive-q2qrvj-0 GCpcO']");

    private By destinationInputLocator = By.xpath("//div[@class='PlacePickerInputstyled__StyledPlacePickerInput-e55dp-0 gcUvWB']/input");

    private By destinationInputChoiceLocator = By.xpath("//div[@class='PlacePickerstyled__PlacePickerItem-sc-1ialbal-9 lkJldZ']");

    private By bookingHotelCheckboxLocator = By.xpath("//input[@class='Checkbox__Input-sc-1x6twh3-4 bLIjCb']");

    private By searchButtonLocator = By.xpath("//div[@class='ActionButtonWrapperstyled__ButtonWrap-sc-1mv3uh-0 eGhXgY']/a");

    public KiwiHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public KiwiHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public KiwiHomePage acceptCookies() {
        waitElementToBeClickable(acceptCookiesButtonLocator).click();
        return this;
    }

    public KiwiHomePage enterDestination(String destination) {
        findElementByLocatorStaleElementReferenceException(destinationInputLocator)
                .sendKeys(destination);
        findElementByLocatorStaleElementReferenceException(destinationInputChoiceLocator)
                .sendKeys(Keys.ENTER);
        return this;
    }

    public KiwiHomePage turnOffBookingHotelCheckbox() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", findElementByLocator(bookingHotelCheckboxLocator));
        return this;
    }

    public KiwiResultsPage searchFlights() {
        waitElementToBeClickable(searchButtonLocator).click();
        return new KiwiResultsPage(driver);
    }

    private WebElement waitElementToBeClickable(By locator) {
        return new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 30)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    public WebElement findElementByLocatorStaleElementReferenceException(By locator) {
        try {
            return findElementByLocator(locator);
        } catch (StaleElementReferenceException e) {
            return findElementByLocator(locator);
        }
    }
}
