package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinCreatePasteResultsPage {
    private WebDriver driver;

    private WebElement titleResult;
    private By titleResultLocator = By.xpath("//div[@class='info-top']/h1");

    private WebElement syntaxHighlightingResult;
    private By syntaxHighlightingResultLocator = By.xpath("//div[@class='left']/a[@class='btn -small h_800']");

    private WebElement textareaResult;
    private By textareaResultLocator = By.xpath("//textarea[@class='textarea']");

    public PastebinCreatePasteResultsPage(WebDriver driver) {
        this.driver = driver;
        titleResult = findElementByLocator(titleResultLocator);
        syntaxHighlightingResult = findElementByLocator(syntaxHighlightingResultLocator);
        textareaResult = findElementByLocator(textareaResultLocator);
    }

    public String getTitleResultText() {
        return titleResult.getText();
    }

    public String getSyntaxHighlightingResultText() {
        return syntaxHighlightingResult.getText();
    }

    public String getTextareaResultText() {
        return textareaResult.getText();
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}
