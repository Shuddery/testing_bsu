package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KiwiBookingPage {

    private WebDriver driver;

    private By totalPriceLocator = By.xpath("//div[@class='ReservationBill-item-priceWrapper']/div/div/span/span/span/span/span");

    public KiwiBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String copyTotalCost() {
        return waitPresenceOfElementLocated(totalPriceLocator).getText().replace("€", "").trim();
    }

    private WebElement waitPresenceOfElementLocated(By locator) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
