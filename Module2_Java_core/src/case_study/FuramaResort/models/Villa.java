package case_study.FuramaResort.models;

import FuramaResort.models.Services;

public class Villa extends Services {
    private String roomStandard;
    private String otherFacility;
    private int floor;
    private double poolArea;

    public Villa() {
    }

    public Villa(String id, String serviceName, double usedArea, int cost, int maxPerson, String rentedType, String roomStandard, String otherFacility, int floor, double poolArea) {
        super(id, serviceName, usedArea, cost, maxPerson, rentedType);
        this.roomStandard = roomStandard;
        this.otherFacility = otherFacility;
        this.floor = floor;
        this.poolArea = poolArea;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherFacility() {
        return otherFacility;
    }

    public void setOtherFacility(String otherFacility) {
        this.otherFacility = otherFacility;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String showInfo() {
        return getId() + "\t" + getServiceName() + "\t" + getUsedArea() + "\t" +
                getCost() + "\t" + getMaxPerson() + "\t" + getRentedType() + "\t" +
                getRoomStandard() + "\t" + getOtherFacility() + "\t" + getFloor() +
                "\t" + getPoolArea();
    }
}
