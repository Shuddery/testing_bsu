package page;

import model.Flight;
import org.openqa.selenium.*;
import waits.Waits;


public class KiwiHomePage extends AbstractPage{

    private static final String HOMEPAGE_URL = "https://www.kiwi.com/ru/";

    //private By acceptCookiesButtonLocator = By.xpath("//button[@type='button' and contains (., 'Принять')]");
    private By acceptCookiesButtonLocator = By.xpath("//button[@class='ButtonPrimitive__StyledButtonPrimitive-q2qrvj-0 GCpcO']");

    private By destinationInputLocator = By.xpath("//div[contains(@data-test, 'PlacePickerInput-destination')]/input");
    private By destinationInputChoiceLocator = By.xpath("//div[contains(@data-test, 'PlacePickerRow-city')]");

    private By bookingHotelCheckboxLocator = By.xpath("//input[contains(@class, 'Checkbox__Input')]");

    private By enabledSearchButtonLocator = By.xpath("//a[contains(@data-test, 'LandingSearchButton')]");
    private By disabledSearchButtonLocator = By.xpath("//button[contains(@data-test, 'LandingSearchButton')]");

    private By crossToCloseTheAutomaticDeparturePointLocator = By.xpath("//div[contains(@data-test, 'PlacePickerInputPlace-close')]");

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

    public KiwiHomePage enterDestination(Flight trip) {
        Waits.findElementByLocatorStaleElementReferenceException(driver, destinationInputLocator)
                .sendKeys(trip.getDestination());
        Waits.findElementByLocatorStaleElementReferenceException(driver, destinationInputChoiceLocator)
                .sendKeys(Keys.ENTER);
        return this;
    }

    public KiwiHomePage turnOffBookingHotelCheckbox() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", Waits.findElementByLocator(driver, bookingHotelCheckboxLocator));
        return this;
    }

    public void closeTheAutomaticDeparturePoint() {
        Waits.waitElementToBeClickable(driver, crossToCloseTheAutomaticDeparturePointLocator).click();
    }

    public boolean isSearchButtonEnabled() {
        return Waits.findElementByLocator(driver, disabledSearchButtonLocator).isEnabled();
    }

    public KiwiResultsPage searchFlights() {
        Waits.waitElementToBeClickable(driver, enabledSearchButtonLocator).click();
        return new KiwiResultsPage(driver);
    }

}
