package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.Waits;

public class KiwiBookingPage extends AbstractPage{

    private By totalPriceLocator = By.xpath("//div[@class='ReservationBill-item-priceWrapper']/div/div/span/span/span/span/span");

    public KiwiBookingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public KiwiBookingPage openPage() {
        return this;
    }

    public String copyTotalCost() {
        return Waits.waitPresenceOfElementLocated(driver, totalPriceLocator).getText()
                .replace("€", "").trim();
    }

}
