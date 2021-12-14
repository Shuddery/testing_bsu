import model.Flight;
import org.testng.annotations.Test;
import page.KiwiBookingPage;
import page.KiwiHomePage;
import page.KiwiResultsPage;
import service.FlightCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class KiwiBookingPageTest extends CommonConditions{

    Flight testFlightWithEmptyPlaceOfDeparture = FlightCreator.withEmptyPlaceOfDeparture();

    @Test
    void theTotalPriceWithInsuranceIsCalculatedCorrectlyTest() {

        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);
        final KiwiResultsPage kiwiResultsPage = kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .enterDestination(testFlightWithEmptyPlaceOfDeparture)
                .searchFlights();

        final KiwiBookingPage kiwiBookingPage = kiwiResultsPage.openPage()
                .moveToTravelPlusInsurance()
                .addTravelPlusInsurance();

        final double priceForTicket = Double.parseDouble(kiwiBookingPage.copyPriceForTicket());
        final double priceForInsurance = Double.parseDouble(kiwiBookingPage.copyPriceForInsurance().replace(",", ".").trim());
        final double totalPrice = Double.parseDouble(kiwiBookingPage.copyTotalCost().replace(",", ".").trim());

        assertThat(priceForTicket + priceForInsurance, is(equalTo(totalPrice)));

    }

    @Test
    void compareIntermediateCostToTotalPriceTest() {

        KiwiHomePage kiwiHomePage = new KiwiHomePage(driver);
        final KiwiResultsPage kiwiResultsPage = kiwiHomePage.openPage()
                .acceptCookies()
                .turnOffBookingHotelCheckbox()
                .enterDestination(testFlightWithEmptyPlaceOfDeparture)
                .searchFlights();

        final String intermediateCost = kiwiResultsPage.copyIntermediateCost();
        final KiwiBookingPage kiwiBookingPage = kiwiResultsPage.openPage();

        assertThat(intermediateCost, is(equalTo(kiwiBookingPage.copyTotalCost())));

    }

}
