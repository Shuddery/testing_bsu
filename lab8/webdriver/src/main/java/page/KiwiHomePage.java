package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.Waits;


public class KiwiHomePage extends AbstractPage{

    private static final String HOMEPAGE_URL = "https://www.kiwi.com/ru/";

    private By acceptCookiesButtonLocator = By.xpath("//button[@type='button' and contains (., 'Принять')]");

    private By destinationInputLocator = By.xpath("//div[contains(@data-test, 'PlacePickerInput-destination')]/input");
    private By destinationInputChoiceLocator = By.xpath("//div[contains(@data-test, 'PlacePickerRow-city')]");

    private By bookingHotelCheckboxLocator = By.xpath("//input[contains(@class, 'Checkbox__Input')]");

    private By searchButtonLocator = By.xpath("//a[contains(@data-test, 'LandingSearchButton')]");

    public KiwiHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public KiwiHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public KiwiHomePage acceptCookies() {
        Waits.waitElementToBeClickable(driver, acceptCookiesButtonLocator).click();
        return this;
    }

    public KiwiHomePage enterDestination(String destination) {
        Waits.findElementByLocatorStaleElementReferenceException(driver, destinationInputLocator)
                .sendKeys(destination);
        Waits.findElementByLocatorStaleElementReferenceException(driver, destinationInputChoiceLocator)
                .sendKeys(Keys.ENTER);
        return this;
    }

    public KiwiHomePage turnOffBookingHotelCheckbox() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", Waits.findElementByLocator(driver, bookingHotelCheckboxLocator));
        return this;
    }

    public KiwiResultsPage searchFlights() {
        Waits.waitElementToBeClickable(driver, searchButtonLocator).click();
        return new KiwiResultsPage(driver);
    }

}
