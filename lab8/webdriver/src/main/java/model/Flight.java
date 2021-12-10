package model;

import java.util.Objects;

public class Flight {

    private String placeOfDeparture;
    private String destination;

    public Flight(String placeOfDeparture, String destination) {
        this.placeOfDeparture = placeOfDeparture;
        this.destination = destination;
    }

    public String getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public void setPlaceOfDeparture(String placeOfDeparture) {
        this.placeOfDeparture = placeOfDeparture;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "placeOfDeparture='" + placeOfDeparture + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight trip = (Flight) o;
        return Objects.equals(getPlaceOfDeparture(), trip.getPlaceOfDeparture()) &&
                Objects.equals(getDestination(), trip.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDestination(), getPlaceOfDeparture());
    }
}
