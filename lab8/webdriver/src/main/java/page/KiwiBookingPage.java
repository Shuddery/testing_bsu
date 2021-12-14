package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import waits.Waits;

public class KiwiBookingPage extends AbstractPage {

    private By priceForTicketLocator = By.xpath("(//span[@class='SpinEffect-value']/span)[2]");
    private By priceForInsuranceLocator = By.xpath("(//span[@class='SpinEffect-value']/span)[4]");
    private By totalPriceLocator = By.xpath("//div[contains(@class, 'AutoScaleText')]//span[contains(@class, 'SpinEffect-value')]/span");

    private By travelPlusInsuranceLocator = By.xpath("(//label[contains(@class, 'Radio__Label')])[5]");



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

    public String copyPriceForTicket() {
        return Waits.waitPresenceOfElementLocated(driver, priceForTicketLocator).getText()
                .replace("€", "").trim();
    }

    public String copyPriceForInsurance() {
        return Waits.waitPresenceOfElementLocated(driver, priceForInsuranceLocator).getText()
                .replace("€", "").trim();
    }

    public KiwiBookingPage moveToTravelPlusInsurance() {
        Waits.findElementByLocator(driver, travelPlusInsuranceLocator).sendKeys(Keys.PAGE_DOWN);
        return this;
    }

    public KiwiBookingPage addTravelPlusInsurance() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", Waits.findElementByLocator(driver, travelPlusInsuranceLocator));
        return this;
    }

}
