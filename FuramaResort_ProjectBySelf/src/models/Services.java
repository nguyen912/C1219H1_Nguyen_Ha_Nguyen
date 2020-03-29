package models;

public abstract class Services {
    private String serviceId;
    private String serviceName;
    private double usableArea;
    private int rentalCost;
    private int maxPeople;
    private String typeOfRent;

    public Services() {

    }

    public Services(String serviceId, String serviceName, double usableArea, int rentalCost, int maxPeople, String typeOfRent) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCost = rentalCost;
        this.maxPeople = maxPeople;
        this.typeOfRent = typeOfRent;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public int getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(int rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public abstract String showInfo();

    @Override
    public String toString() {
        return
                "serviceId=" + serviceId + "\n" +
                "serviceName='" + serviceName + "\n" +
                "usableArea=" + usableArea + "\n" +
                "rentalCost=" + rentalCost + "\n" +
                "maxPeople=" + maxPeople + "\n" +
                "typeOfRent='" + typeOfRent + "\n";
    }
}
