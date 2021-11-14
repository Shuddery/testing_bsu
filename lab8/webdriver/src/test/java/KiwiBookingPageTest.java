import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.KiwiHomePage;
import page.KiwiResultsPage;

import java.util.concurrent.TimeUnit;


public class KiwiBookingPageTest {

    private WebDriver driver;
    private final static String DESTINATION = "Istanbul";

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    void compareIntermediateCostToTotalPriceTest() {
        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);

        final KiwiResultsPage kiwiResultsPage  = kiwiHomePage.openHomePage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .enterDestination(DESTINATION)
                .searchFlights();

        final String intermediateCost = kiwiResultsPage.copyIntermediateCost();
        final String totalCost = kiwiResultsPage.openBookingPage().copyTotalCost();

        Assert.assertEquals(intermediateCost, totalCost);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver.quit();
        driver = null;
    }
}
