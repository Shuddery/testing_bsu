import model.Flight;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.KiwiHomePage;
import page.KiwiResultsPage;
import service.FlightCreator;

public class KiwiHomePageTest extends CommonConditions{

    @Test
    void isSearchButtonDisabled() {
        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);

        kiwiHomePage.openPage()
                .acceptCookies()
                .closeTheAutomaticDeparturePoint();

        Assert.assertFalse(kiwiHomePage.isSearchButtonEnabled());
    }
}
