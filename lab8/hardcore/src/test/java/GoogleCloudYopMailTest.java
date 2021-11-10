import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GoogleCloudHomePage;
import page.YopMailGeneratePage;
import page.YopMailEmailPage;
import page.YopMailHomePage;

import java.util.Set;

public class GoogleCloudYopMailTest {
    private WebDriver driver;
    private final static String TERM = "Google Cloud Platform Pricing Calculator";
    private final static int NUMBER_OF_INSTANCES = 4;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1440, 900));
    }

    @Test
    void compareCostTest() {
        YopMailHomePage yopMailHomePage = new YopMailHomePage(driver);
        GoogleCloudHomePage GoogleCloudPage = new GoogleCloudHomePage(driver);

        String YopMailTab = driver.getWindowHandle();
        String GoogleCloudTab = "";
        YopMailGeneratePage generatePage = yopMailHomePage.openHomePage()
                .generateEmail();
        final String email = generatePage.copyEmail();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()", "");

        Set<String> tabs = driver.getWindowHandles();
        for (String tab: tabs) {
            if (!tab.equals(YopMailTab)) {
                GoogleCloudTab = tab;
                break;
            }
        }

        driver.switchTo().window(GoogleCloudTab);
        final String instancesCost = GoogleCloudPage.openHomePage()
                .searchTerm(TERM)
                .openCalculator()
                .pasteNumberOfInstances(NUMBER_OF_INSTANCES)
                .selectSeries()
                .selectMachineType()
                .addGPUs()
                .addSSD()
                .selectDatacenter()
                .selectCommittedUsage()
                .addToEstimate()
                .emailEstimate(email)
                .copyCost();

        Assert.assertTrue(yopMailHomePage.openHomePage()
                .openEmail(email)
                .compareCost(instancesCost));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver = null;
    }
}