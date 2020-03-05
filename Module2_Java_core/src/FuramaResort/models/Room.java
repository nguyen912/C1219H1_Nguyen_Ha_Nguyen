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
    public void showInfo() {
        System.out.println(
                "Room information: " +
                        "\n1. ID: " +
                        "\n2. Service name: " +
                        "\n3. Used area: " +
                        "\n4. Cost: " +
                        "\n5. Max person: " +
                        "\n6. Rented type: " +
                        "\n7. Free service: "
        );

    }
}
