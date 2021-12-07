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

}

























































































