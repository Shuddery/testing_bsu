import model.Flight;
import org.testng.annotations.Test;
import page.KiwiHomePage;
import page.KiwiResultsPage;
import service.FlightCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class KiwiBookingPageTest extends CommonConditions{

    @Test
    void compareIntermediateCostToTotalPriceTest() {
        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);

        Flight testFlight = FlightCreator.withEmptyPlaceOfDeparture();
        final KiwiResultsPage kiwiResultsPage  = kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .enterDestination(testFlight)
                .searchFlights();

        final String intermediateCost = kiwiResultsPage.copyIntermediateCost();
        final String totalCost = kiwiResultsPage.openPage().copyTotalCost();

        assertThat(intermediateCost, is(equalTo(totalCost)));

    }

}
