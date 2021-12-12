import model.Flight;
import org.testng.annotations.Test;
import page.KiwiHomePage;
import page.KiwiResultsPage;
import service.FlightCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class KiwiResultsPageTest extends CommonConditions{

    final String ERROR_MESSAGE = "Извините, нам не удалось ничего найти по вашему запросу";
    Flight testFlight = FlightCreator.withEmptyPlaceOfDeparture();

    @Test
    void isTheBestOptionDisplayedFirstTest() {

        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);
        final KiwiResultsPage kiwiResultsPage = kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .enterDestination(testFlight)
                .searchFlights();

        final String priceOfTheBestOption = kiwiResultsPage.copyPriceOfTheBestOption();
        final String intermediateCost = kiwiResultsPage.copyIntermediateCost();

        assertThat(priceOfTheBestOption, is(equalTo(intermediateCost)));
    }

    @Test
    void isErrorMessageDisplayed() {

        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);
        final KiwiResultsPage kiwiResultsPage = kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .chooseFlightServiceClass()
                .acceptFlightServiceClass()
                .enterDestination(testFlight)
                .searchFlights();

        assertThat(kiwiResultsPage.isErrorMessageDisplayed(), is(true));

    }
}
