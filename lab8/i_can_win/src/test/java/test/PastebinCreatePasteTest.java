package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinCreatePasteResultsPage;
import page.PastebinHomePage;

import java.util.concurrent.TimeUnit;


public class PastebinCreatePasteTest {

    private WebDriver driver;
    private static final String CODE = "Hello from WebDriver";
    private static final String NAME = "helloweb";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void createPasteTest() {
        PastebinHomePage homePage = new PastebinHomePage(driver);
        PastebinCreatePasteResultsPage resultsPage = homePage
                .openHomePage()
                .pasteCode(CODE)
                .selectExpiration()
                .pasteName(NAME)
                .createPaste();
        Assert.assertTrue(resultsPage.isInitialized());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver = null;
    }
}
