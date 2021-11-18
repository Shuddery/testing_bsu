package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class KiwiResultsPage {

    private WebDriver driver;

    private By intermediateCostLocator = By.xpath("(//span[@class=' length-5'])[1]");

    private By bookingButtonLocator = By.xpath("(//a[@class='ButtonPrimitive__StyledButtonPrimitive-q2qrvj-0 eDjyNZ'])[1]");

    public KiwiResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String copyIntermediateCost() {
        return waitVisibilityOfElementLocated(intermediateCostLocator)
                .getText().replace("$ ", "").trim();
    }

    public KiwiBookingPage openBookingPage() {
        waitElementToBeClickable(bookingButtonLocator).click();
        return new KiwiBookingPage(driver);
    }

    private WebElement waitVisibilityOfElementLocated(By locator) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private WebElement waitElementToBeClickable(By locator) {
        return new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}

























































































