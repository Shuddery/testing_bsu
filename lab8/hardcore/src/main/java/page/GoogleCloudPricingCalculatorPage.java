package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPricingCalculatorPage {
    private WebDriver driver;

    private WebElement frameCalculator;
    private By frameCalculatorLocator = By.xpath("//iframe[contains(@src,'index_d6a98ba38837346d20babc06ff2153b68c2990fa24322fe52c5f83ec3a78c6a0')]");

    private WebElement innerFrameCalculator;
    private By innerFrameCalculatorLocator = By.id("myFrame");

    private WebElement numberOfInstancesInput;
    private By numberOfInstancesInputLocator = By.id("input_74");

    private WebElement seriesSelect;
    private By seriesSelectLocator = By.xpath("//md-select-value[@id='select_value_label_69']");

    private WebElement seriesChoice;
    private By seriesChoiceLocator = By.xpath("//md-option[@id='select_option_214']/div");

    private WebElement machineTypeSelect;
    private By machineTypeSelectLocator = By.xpath("//md-select-value[@id='select_value_label_70']");

    private WebElement machineTypeChoice;
    private By machineTypeChoiceLocator = By.xpath("//md-option[@id='select_option_417']/div");

    private WebElement addGPUsCheckbox;
    private By addGPUsCheckboxLocator = By.xpath("/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[11]/div[1]/md-input-container/md-checkbox/div[2]");

    private WebElement numberOfGPUsSelect;
    private By numberOfGPUsSelectLocator = By.id("select_451");

    private WebElement numberOfGPUsChoice;
    private By numberOfGPUsChoiceLocator = By.xpath("//md-option[@id='select_option_456']/div");

    private WebElement GPUTypeSelect;
    private By GPUTypeSelectLocator = By.id("select_453");

    private WebElement GPUTypeChoice;
    private By GPUTypeChoiceLocator = By.xpath("//md-option[@id='select_option_463']/div");

    private WebElement localSSDSelect;
    private By localSSDSelectLocator = By.id("select_412");

    private WebElement localSSDChoice;
    private By localSSDChoiceLocator = By.xpath("//md-option[@id='select_option_438']/div");

    private WebElement datacenterLocationSelect;
    private By datacenterLocationSelectLocator = By.id("select_107");

    private WebElement datacenterLocationChoice;
    private By datacenterLocationChoiceLocator = By.xpath("//md-option[@id='select_option_235']/div");

    private WebElement committedUsageSelect;
    private By committedUsageSelectLocator = By.id("select_114");

    private WebElement committedUsageChoice;
    private By committedUsageChoiceLocator = By.xpath("//md-option[@id='select_option_112']/div");

    private WebElement addToEstimateButton;
    private By addToEstimateButtonLocator = By.xpath("//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']");

    private WebElement emailEstimateButton;
    private By emailEstimateButtonLocator = By.id("email_quote");

    private WebElement emailInput;
    private By emailInputLocator = By.xpath("//input[@ng-model='emailQuote.user.email']");

    private WebElement sendEmailButton;
    private By sendEmailButtonLocator = By.xpath("//button[@aria-label='Send Email']");

    private WebElement copyCostField;
    private By copyCostFieldLocator = By.xpath("//b[@class='ng-binding']");

    public boolean isInitialized() {
        return numberOfInstancesInput.isDisplayed();
    }

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        frameCalculator = findElementByLocator(frameCalculatorLocator);
        driver.switchTo().frame(frameCalculator);
        innerFrameCalculator = findElementByLocator(innerFrameCalculatorLocator);
        driver.switchTo().frame(innerFrameCalculator);
        numberOfInstancesInput = findElementByLocator(numberOfInstancesInputLocator);
        seriesSelect = findElementByLocator(seriesSelectLocator);
        machineTypeSelect = findElementByLocator(machineTypeSelectLocator);
        datacenterLocationSelect = findElementByLocator(datacenterLocationSelectLocator);
        committedUsageSelect = findElementByLocator(committedUsageSelectLocator);
        addToEstimateButton = findElementByLocator(addToEstimateButtonLocator);
    }

    public GoogleCloudPricingCalculatorPage pasteNumberOfInstances(int numberOfInstances) {
        numberOfInstancesInput.sendKeys(String.valueOf(numberOfInstances));
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectSeries() {
        seriesSelect.click();
        seriesChoice = findElementByLocator(seriesChoiceLocator);
        seriesChoice.click();
        addGPUsCheckbox = findElementByLocator(addGPUsCheckboxLocator);
        localSSDSelect = findElementByLocator(localSSDSelectLocator);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineType() {
        machineTypeSelect.click();
        machineTypeChoice = findElementByLocator(machineTypeChoiceLocator);
        machineTypeChoice.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage addGPUs() {
        addGPUsCheckbox.click();
        numberOfGPUsSelect = findElementByLocator(numberOfGPUsSelectLocator);
        numberOfGPUsSelect.click();
        numberOfGPUsChoice = findElementByLocator(numberOfGPUsChoiceLocator);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .elementToBeClickable(numberOfGPUsChoice));
        numberOfGPUsChoice.click();
        GPUTypeSelect = findElementByLocator(GPUTypeSelectLocator);
        GPUTypeSelect.click();
        GPUTypeChoice = findElementByLocator(GPUTypeChoiceLocator);
        GPUTypeChoice.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage addSSD() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .elementToBeClickable(localSSDSelect));
        localSSDSelect.click();
        localSSDChoice = findElementByLocator(localSSDChoiceLocator);
        localSSDChoice.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDatacenter() {
        datacenterLocationSelect.click();
        datacenterLocationChoice = findElementByLocator(datacenterLocationChoiceLocator);
        datacenterLocationChoice.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCommittedUsage() {
        committedUsageSelect.click();
        committedUsageChoice = findElementByLocator(committedUsageChoiceLocator);
        committedUsageChoice.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage addToEstimate() {
        addToEstimateButton.click();
        emailEstimateButton = findElementByLocator(emailEstimateButtonLocator);
        return this;
    }

    public GoogleCloudPricingCalculatorPage emailEstimate(String email) {
        emailEstimateButton.click();
        emailInput = findElementByLocator(emailInputLocator);
        emailInput.sendKeys(email);
        sendEmailButton = findElementByLocator(sendEmailButtonLocator);
        sendEmailButton.click();
        copyCostField = driver.findElements(copyCostFieldLocator).get(2);
        return this;
    }

    public String copyCost() {
        return copyCostField.getText();
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 25)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
}
