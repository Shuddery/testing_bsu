package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KiwiBookingPage {

    private WebDriver driver;

    private By totalPriceLocator = By.xpath("(//span[@class=' length-5'])[2]");

    public KiwiBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String copyTotalCost() {
        return waitVisibilityOfElementLocated(totalPriceLocator).getText().replace("$ ", "").trim();
    }

    private WebElement waitVisibilityOfElementLocated(By locator) {
        return new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
