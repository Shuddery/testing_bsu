import model.Flight;
import org.testng.annotations.Test;
import page.KiwiHomePage;
import page.KiwiResultsPage;
import service.FlightCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class KiwiResultsPageTest extends CommonConditions{

    Flight testFlightWithEmptyPlaceOfDeparture = FlightCreator.withEmptyPlaceOfDeparture();
    Flight testFlightWithFullWay = FlightCreator.withFullWay();

    @Test
    void isTheBestOptionDisplayedFirstTest() {

        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);
        final KiwiResultsPage kiwiResultsPage = kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .enterDestination(testFlightWithEmptyPlaceOfDeparture)
                .searchFlights();

        final String priceOfTheBestOption = kiwiResultsPage.copyPriceOfTheBestOption();
        final String intermediateCost = kiwiResultsPage.copyIntermediateCost();

        assertThat(priceOfTheBestOption, is(equalTo(intermediateCost)));
    }

    @Test
    void isErrorMessageDisplayedWithIncorrectData() {

        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);
        final KiwiResultsPage kiwiResultsPage = kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .chooseFlightServiceClass()
                .acceptFlightServiceClass()
                .enterDestination(testFlightWithEmptyPlaceOfDeparture)
                .searchFlights();

        assertThat(kiwiResultsPage.isErrorMessageDisplayed(), is(true));

    }

    @Test
    void isDockingDisplayedWithFilterToAllowNightConnections() {

        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);
        final KiwiResultsPage kiwiResultsPage = kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .closeTheAutomaticDeparturePoint()
                .enterPlaceOfDeparture(testFlightWithFullWay)
                .enterDestination(testFlightWithFullWay)
                .searchFlights()
                .clickOnMoreDetails();

        assertThat(kiwiResultsPage.isDockingDisplayed(), is(true));

    }
}
