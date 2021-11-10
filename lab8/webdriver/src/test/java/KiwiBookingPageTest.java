import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.KiwiHomePage;
import page.KiwiResultsPage;


public class KiwiBookingPageTest {

    private WebDriver driver;
    private final static String DESTINATION = "Istanbul";

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 900));
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
