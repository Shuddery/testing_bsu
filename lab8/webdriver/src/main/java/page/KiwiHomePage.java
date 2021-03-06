package page;

import model.Flight;
import org.openqa.selenium.*;
import waits.Waits;

import java.util.concurrent.TimeUnit;


public class KiwiHomePage extends AbstractPage{

    private static final String HOMEPAGE_URL = "https://www.kiwi.com/ru/";
    
    private By acceptCookiesButtonLocator = By.xpath("(//section[contains(@class, 'ModalSection__StyledModalSection')]//button)[2]");

    private By destinationInputLocator = By.xpath("//div[contains(@data-test, 'PlacePickerInput-destination')]/input");
    private By destinationInputChoiceLocator = By.xpath("//div[contains(@data-test, 'PlacepickerModalOpened-destination')]//div[contains(@data-test, 'PlacePickerRow-city')]");

    private By bookingHotelCheckboxLocator = By.xpath("//input[contains(@class, 'Checkbox__Input')]");

    private By enabledSearchButtonLocator = By.xpath("//a[contains(@data-test, 'LandingSearchButton')]");
    private By disabledSearchButtonLocator = By.xpath("//button[contains(@data-test, 'LandingSearchButton')]");

    private By crossToCloseTheAutomaticDeparturePointLocator = By.xpath("//div[contains(@data-test, 'PlacePickerInputPlace-close')]");

    private By flightServiceClassLocator = By.xpath("//div[contains(@data-test, 'CabinClassField-active-economy')]");
    private By flightServiceClassChoiceLocator = By.xpath("//a[contains(@data-test, 'CabinClassPicker-filter-first')]");
    private By acceptFlightServiceClassChoiceButtonLocator = By.xpath("//button[contains(@data-test, 'CabinClassFooter-done')]");

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
        Waits.waitVisibilityOfElementLocated(driver, destinationInputLocator)
                .sendKeys(trip.getDestination());
        Waits.waitVisibilityOfElementLocated(driver, destinationInputChoiceLocator)
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

    public KiwiHomePage chooseFlightServiceClass() {
        Waits.waitElementToBeClickable(driver, flightServiceClassLocator).click();
        Waits.waitElementToBeClickable(driver, flightServiceClassChoiceLocator).click();
        return this;
    }

    public KiwiHomePage acceptFlightServiceClass() {
        Waits.waitElementToBeClickable(driver, acceptFlightServiceClassChoiceButtonLocator).click();
        return this;
    }

    public KiwiResultsPage searchFlights() {
        Waits.waitElementToBeClickable(driver, enabledSearchButtonLocator).click();
        return new KiwiResultsPage(driver);
    }

}
