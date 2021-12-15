package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import waits.Waits;


public class KiwiResultsPage extends AbstractPage {

    private By intermediateCostLocator = By.xpath("(//div[contains(@data-test, 'ResultCardPrice')]//strong/span)[1]");

    private By bookingButtonLocator = By.xpath("(//div[contains(@data-test, 'BookingButton')])[1]");

    private By priceOfTheBestOptionLocator = By.xpath("(//div[contains(@class, 'DataContainer')]/span)[1]");

    private By errorMessageLocator = By.xpath("//div[contains(@class, 'NoResultsFiltersWrapper')]/div[contains(@class, 'StyledHeading')]");

    private By moreDetailsLocator = By.xpath("(//div[contains(@data-test, 'ResultCardBadges')])[1]");

    private By dockingLocator = By.xpath("(//div[contains(@class, 'Stack__StyledStack')]/span[contains(@class, 'Text__StyledText')])[2]");

    private By passengersAndBagsFieldLocator = By.xpath("//div[contains(@data-test, 'PassengersField')]");
    private By incrementPassengersButtonLocator = By.xpath("(//div[contains(@data-test, 'PassengersRow-adults')]//button[contains(@class, 'ButtonPrimitive__StyledButtonPrimitive')])[2]");
    private By acceptChangesButtonLocator = By.xpath("//button[contains(@data-test, 'PassengersFieldFooter-done')]");
    private By searchButtonLocator = By.xpath("//a[contains(@data-test, 'SearchButton')]");

    private By incrementCheckedBagsButtonLocator = By.xpath("(//div[contains(@data-test, 'BagsPopup-checked')]//button)[2]");

    private By flightFilterLocator = By.xpath("(//div[contains(@data-test, 'TransportOptionChoiceGroup')]//div[contains(@class, 'Checkbox__IconContainer')])[1]");
    private By busFilterLocator = By.xpath("(//div[contains(@class, 'FilterWrapper__StyledContentWrapper')])[2]");
    private By busCompanyNameLocator = By.xpath("(//div[contains(@data-test, 'TripPopupWrapper')]//div[contains(@class, 'BadgePrimitive__StyledBadgeContent')])[1]");

    private By priceFilterLocator = By.xpath("//div[contains(@data-test, 'FilterHeader-days')]");

    public KiwiResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public KiwiBookingPage openPage() {
        Waits.waitElementToBeClickable(driver, bookingButtonLocator).click();
        return new KiwiBookingPage(driver);
    }

    public String copyIntermediateCost() {
        return Waits.waitVisibilityOfElementLocated(driver, intermediateCostLocator)
                .getText().replace(" €", "").trim();
    }

    public String copyPriceOfTheBestOption() {
        return Waits.waitVisibilityOfElementLocated(driver, priceOfTheBestOptionLocator)
                .getText().replace(" €", "").trim();
    }

    public boolean isErrorMessageDisplayed() {
        return Waits.waitVisibilityOfElementLocated(driver, errorMessageLocator).isDisplayed();
    }

    public KiwiResultsPage clickOnMoreDetails() {
        Waits.waitElementToBeClickable(driver, moreDetailsLocator).click();
        return this;
    }

    public boolean isDockingDisplayed() {
        return Waits.waitVisibilityOfElementLocated(driver, dockingLocator).isDisplayed();
    }

    public KiwiResultsPage openPassengersAndBagsField() {
        Waits.waitElementToBeClickable(driver, passengersAndBagsFieldLocator).click();
        return this;
    }

    public KiwiResultsPage incrementAmountOfPassengers() {
        Waits.waitElementToBeClickable(driver, incrementPassengersButtonLocator).click();
        return this;
    }

    public KiwiResultsPage closePassengersAndBagsField() {
        Waits.waitElementToBeClickable(driver, acceptChangesButtonLocator).click();
        return this;
    }

    public void searchFlightsWithChangedAmountOfPassengers() {
        Waits.waitElementToBeClickable(driver, searchButtonLocator).click();
    }

    public KiwiResultsPage incrementAmountOfCheckedBags() {
        Waits.waitElementToBeClickable(driver, incrementCheckedBagsButtonLocator).click();
        return this;
    }

    public KiwiResultsPage removeFilterByFlight() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", Waits.findElementByLocator(driver, flightFilterLocator));
        return this;
    }

    public KiwiResultsPage enableBusFilter() {
        Waits.waitElementToBeClickable(driver, busFilterLocator).click();
        return this;
    }

    public String copyBusCompanyName() {
        return Waits.waitVisibilityOfElementLocated(driver, busCompanyNameLocator).getText();
    }
}

























































































