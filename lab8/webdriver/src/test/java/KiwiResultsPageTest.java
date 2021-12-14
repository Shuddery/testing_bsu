import model.Flight;
import org.testng.annotations.Test;
import page.KiwiHomePage;
import page.KiwiResultsPage;
import service.FlightCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class KiwiResultsPageTest extends CommonConditions{

    Flight testFlightWithEmptyPlaceOfDeparture = FlightCreator.withEmptyPlaceOfDeparture();

    @Test
    void intermediateCostBecomesHigherWithPassengersIncrementTest() {

        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);
        final KiwiResultsPage kiwiResultsPage = kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .enterDestination(testFlightWithEmptyPlaceOfDeparture)
                .searchFlights();

        final int intermediateCost = Integer.parseInt(kiwiResultsPage.copyIntermediateCost());

        final int changedIntermediateCost = Integer.parseInt(kiwiResultsPage.openPassengersAndBagsField()
                .incrementAmountOfPassengers()
                .closePassengersAndBagsField()
                .searchFlightsWithChangedAmountOfPassengers()
                .copyIntermediateCost());

        assertThat(intermediateCost, is(lessThan(changedIntermediateCost)));

    }

    @Test
    void theBestOptionIsDisplayedFirstTest() {

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
    void errorMessageIsDisplayedWithIncorrectData() {

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
    void dockingIsDisplayedWithFilterToAllowNightConnections() {

        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);
        final KiwiResultsPage kiwiResultsPage =  kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .enterDestination(testFlightWithEmptyPlaceOfDeparture)
                .searchFlights()
                .clickOnMoreDetails();

        assertThat(kiwiResultsPage.isDockingDisplayed(), is(true));

    }

}
