import model.Flight;
import org.testng.annotations.Test;
import page.KiwiHomePage;
import page.KiwiResultsPage;
import service.FlightCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class KiwiResultsPageTest extends CommonConditions{

    @Test
    public void theBestOptionIsDisplayedFirstTest() {
        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);

        Flight testFlight = FlightCreator.withEmptyPlaceOfDeparture();
        final KiwiResultsPage kiwiResultsPage = kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .enterDestination(testFlight)
                .searchFlights();

        final String priceOfTheBestOption = kiwiResultsPage.copyPriceOfTheBestOption();
        final String intermediateCost = kiwiResultsPage.copyIntermediateCost();

        assertThat(priceOfTheBestOption, is(equalTo(intermediateCost)));
    }
}
