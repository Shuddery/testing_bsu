package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.Waits;


public class KiwiResultsPage extends AbstractPage {

    private By intermediateCostLocator = By.xpath("(//strong[contains(@class, 'ResultCardstyled')]/span)[1]");

    private By bookingButtonLocator = By.xpath("(//div[contains(@data-test, 'BookingButton')])[1]");

    private By priceOfTheBestOption = By.xpath("(//div[contains(@class, 'DataContainer')]/span)[1]");

    private By errorMessageLocator = By.xpath("//div[contains(@class, 'NoResultsFiltersWrapper')]/div[contains(@class, 'StyledHeading')]");

    private By moreDetailsLocator = By.xpath("(//div[contains(@data-test, 'ResultCardBadges')])[1]");

    private By dockingLocator = By.xpath("(//div[contains(@class, 'Stack__StyledStack')]/span[contains(@class, 'Text__StyledText')])[2]");

    public KiwiResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public KiwiBookingPage openPage() {
        Waits.waitElementToBeClickable(driver, bookingButtonLocator).click();
        return new KiwiBookingPage(driver);
    }

    public String copyIntermediateCost() {
        return Waits.waitPresenceOfElementLocated(driver, intermediateCostLocator)
                .getText().replace("€", "").trim();
    }

    public String copyPriceOfTheBestOption() {
        return Waits.waitPresenceOfElementLocated(driver, priceOfTheBestOption)
                .getText().replace("€", "").trim();
    }

    public boolean isErrorMessageDisplayed() {
        return Waits.waitPresenceOfElementLocated(driver, errorMessageLocator).isDisplayed();
    }

    public KiwiResultsPage clickOnMoreDetails() {
        Waits.waitElementToBeClickable(driver, moreDetailsLocator).click();
        return this;
    }

    public boolean isDockingDisplayed() {
        return Waits.waitPresenceOfElementLocated(driver, dockingLocator).isDisplayed();
    }
}

























































































