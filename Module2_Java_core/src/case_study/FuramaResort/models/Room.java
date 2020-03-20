package case_study.FuramaResort.models;

import FuramaResort.models.Services;

public class Room extends Services {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String id, String serviceName, double usedArea, int cost, int maxPerson, String rentedType, String freeService) {
        super(id, serviceName, usedArea, cost, maxPerson, rentedType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String showInfo() {
        return getId() + "\t" + getServiceName() + "\t" + getUsedArea() + "\t" +
                getCost() + "\t" + getMaxPerson() + "\t" + getRentedType() + "\t" +
                getFreeService();

    }
}
