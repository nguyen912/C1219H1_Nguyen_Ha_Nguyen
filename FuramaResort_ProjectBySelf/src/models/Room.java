package models;

public class Room extends Services {
    private String freeServicesIncluded;

    public Room() {

    }

    public Room(String freeServicesIncluded) {
        this.freeServicesIncluded = freeServicesIncluded;
    }

    public Room(String serviceId, String serviceName, double usableArea, int rentalCost, int maxPeople, String typeOfRent, String freeServicesIncluded) {
        super(serviceId, serviceName, usableArea, rentalCost, maxPeople, typeOfRent);
        this.freeServicesIncluded = freeServicesIncluded;
    }

    public String getFreeServicesIncluded() {
        return freeServicesIncluded;
    }

    public void setFreeServicesIncluded(String freeServicesIncluded) {
        this.freeServicesIncluded = freeServicesIncluded;
    }

    @Override
    public String showInfo() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() +
                "freeServicesIncluded=" + freeServicesIncluded;
    }
}
