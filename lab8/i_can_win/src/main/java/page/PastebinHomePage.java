package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    private WebElement textArea;
    private By textAreaLocator = By.xpath("//textarea[@id='postform-text']");

    private WebElement expirationSelect;
    private By expirationSelectLocator = By.xpath("//span[text()='Never']");

    private WebElement expirationChoice;
    private By expirationChoiceLocator = By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]");

    private WebElement nameInput;
    private By nameInputLocator = By.name("PostForm[name]");

    private WebElement createButton;
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
        expirationSelect = findElementByLocator(expirationSelectLocator);
        nameInput = findElementByLocator(nameInputLocator);
        createButton = findElementByLocator(createButtonLocator);
        return this;
    }

    public PastebinHomePage pasteCode(String code) {
        textArea.sendKeys(code);
        return this;
    }

    public PastebinHomePage selectExpiration() {
        expirationSelect.click();
        expirationChoice = findElementByLocator(expirationChoiceLocator);
        expirationChoice.click();
        return this;
    }

    public PastebinHomePage pasteName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public PastebinCreatePasteResultsPage createPaste() {
        createButton.click();
        return new PastebinCreatePasteResultsPage(driver);
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}
