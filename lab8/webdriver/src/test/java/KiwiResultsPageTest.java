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

    @Test
    void intermediateCostBecomesHigherWithPassengersIncrementTest() {

        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);
        final KiwiResultsPage kiwiResultsPage = kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .enterDestination(testFlightWithEmptyPlaceOfDeparture)
                .searchFlights();

        final double intermediateCost = Double.parseDouble(kiwiResultsPage.copyIntermediateCost().replace(",", ".").trim());

        final double changedIntermediateCost = Double.parseDouble(kiwiResultsPage.openPassengersAndBagsField()
                .incrementAmountOfPassengers()
                .closePassengersAndBagsField()
                .searchFlightsWithChangedAmountOfPassengers()
                .copyIntermediateCost()
                .replace(",", ".").trim());

        assertThat(intermediateCost, is(lessThan(changedIntermediateCost)));

    }
}
