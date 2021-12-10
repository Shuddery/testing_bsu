package service;

import model.Flight;

public class FlightCreator {

    private final static String TESTDATA_DESTINATION = "testdata.flight.destination";
    private final static String TESTDATA_PLACE_OF_DEPARTURE = "testdata.flight.placeOfDeparture";

    public static Flight withFullWay() {
        return new Flight(TestDataReader.getTestData(TESTDATA_PLACE_OF_DEPARTURE),
                TestDataReader.getTestData(TESTDATA_DESTINATION));
    }

    public static Flight withEmptyPlaceOfDeparture() {
        return new Flight("", TestDataReader.getTestData(TESTDATA_DESTINATION));
    }

    public static Flight withEmptyDestination() {
        return new Flight(TestDataReader.getTestData(TESTDATA_PLACE_OF_DEPARTURE), "");
    }
}
