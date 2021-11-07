package airport;

import models.ClassificationLevel;
import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;

public class Airport{
    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> listOfPassengerPlanes = new ArrayList<>();
        for (Plane plane : this.planes) {
            if (plane instanceof PassengerPlane) { listOfPassengerPlanes.add((PassengerPlane) plane);} }
        return listOfPassengerPlanes;
    }

    public List<? extends Plane> getPlanes() { return planes; }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> listOfMilitaryPlanes = new ArrayList<>();
        for (Plane plane : this.planes) {
            if (plane instanceof MilitaryPlane) { listOfMilitaryPlanes.add((MilitaryPlane) plane);} }
        return listOfMilitaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getMilitaryPlanesByCertainType(MilitaryType militaryType) {
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        List<MilitaryPlane> militaryPlanesByCertainType = new ArrayList<>();

        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getType() == militaryType) {
                militaryPlanesByCertainType.add(militaryPlane);
            }
        }

        return militaryPlanesByCertainType;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public List<ClassificationLevel> getClassificationLevelsInExperimentalPlanes() {
        List<ClassificationLevel> classificationLevels = new ArrayList<>();
        List<ExperimentalPlane> experimentalPlanes = getExperimentalPlanes();
        for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
            classificationLevels.add(experimentalPlane.getClassificationLevel());
        }
        return classificationLevels;
    }

    public void sortPlanesByMaxFlightDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public void sortPlanesByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
    }

    public void sortPlanesByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }

    @Override
    public String toString() {
        return "airport.Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(planes, airport.planes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planes);
    }

}
