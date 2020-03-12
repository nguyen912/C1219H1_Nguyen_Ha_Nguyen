package FuramaResort.models;

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
    public String toString() {
        return getId() + "\t" + getServiceName() + "\t" + getUsedArea() + "\t" +
                getCost() + "\t" + getMaxPerson() + "\t" + getRentedType() + "\t" +
                getFreeService();

    }
}
