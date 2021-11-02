package airport;

import models.ClassificationLevel;
import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;

public class Airport{
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<? extends Plane> listOfPlanes = this.planes;
        List<PassengerPlane> listOfPassengerPlanes = new ArrayList<>();
        for (Plane plane : listOfPlanes) {
            if (plane instanceof PassengerPlane) { listOfPassengerPlanes.add((PassengerPlane) plane);} }
        return listOfPassengerPlanes;
    }

    public List<? extends Plane> getPlanes() { return planes; }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<? extends Plane> listOfPlanes = this.planes;
        List<MilitaryPlane> listOfMilitaryPlanes = new ArrayList<>();
        for (Plane plane : listOfPlanes) {
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

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;
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

    public Airport sortByMaxFlightDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
        return this;
    }

    @Override
    public String toString() {
        return "airport.Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
