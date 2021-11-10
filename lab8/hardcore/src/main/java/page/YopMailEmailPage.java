package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopMailEmailPage {
    private WebDriver driver;

    private WebElement frameEmail;
    private By frameEmailLocator = By.xpath("//iframe[@id='ifmail']");

    private WebElement costField;
    private By costFieldLocator = By.tagName("h2");

    public YopMailEmailPage(WebDriver driver) {
        this.driver = driver;
        frameEmail = findElementByLocator(frameEmailLocator);
        driver.switchTo().frame(frameEmail);
        costField = findElementByLocator(costFieldLocator);
    }

    public boolean isInitialized() {
        return frameEmail.isDisplayed();
    }

    public boolean compareCost(String instancesCost) {
        instancesCost = instancesCost.replace("Total Estimated Cost: USD","").replace(" per 1 month","").trim();
        String anotherInstancesCost = costField.getText().replace("Estimated Monthly Cost: USD", "").trim();
        return instancesCost.equals(anotherInstancesCost);
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}