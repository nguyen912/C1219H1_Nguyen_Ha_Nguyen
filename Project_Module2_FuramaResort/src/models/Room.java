package models;


public class Room extends Services {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String id, String name, double usedArea, int cost, int maxPeople, String type, String freeService) {
        super(id, name, usedArea, cost, maxPeople, type);
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
        return getId() + "\t" + getName() + "\t" + getUsedArea() + "\t" +
                getCost() + "\t" + getMaxPeople() + "\t" + getType() + "\t" +
                getFreeService();

    }
}