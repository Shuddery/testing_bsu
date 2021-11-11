package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    private WebElement textArea;
    private By textAreaLocator = By.xpath("//textarea[@id='postform-text']");

    private By expirationSelectLocator = By.xpath("//span[text()='Never']");

    private By expirationChoiceLocator = By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]");

    private WebElement nameInput;
    private By nameInputLocator = By.name("PostForm[name]");

    private By createButtonLocator = By.xpath("//button[text()='Create New Paste']");


    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInitialized() {
        return textArea.isDisplayed();
    }

    public PastebinHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        textArea = findElementByLocator(textAreaLocator);
        nameInput = findElementByLocator(nameInputLocator);
        return this;
    }

    public PastebinHomePage pasteCode(String code) {
        textArea.sendKeys(code);
        return this;
    }

    public PastebinHomePage selectExpiration() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", findElementByLocator(expirationSelectLocator));
        executor.executeScript("arguments[0].click();", findElementByLocator(expirationChoiceLocator));
        return this;
    }

    public PastebinHomePage pasteName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public PastebinCreatePasteResultsPage createPaste() {
        waitElementToBeClickable(createButtonLocator).click();
        return new PastebinCreatePasteResultsPage(driver);
    }

    private WebElement waitElementToBeClickable(By locator) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitVisibilityOfElementLocated(By locator) {
        return new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}
