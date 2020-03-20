package commons;

public class Menu {
    public static void displayMainMenu() {
        System.out.println(
                "Choose these options below: \n" +
                        "        1.\t Add New Services\n" +
                        "        2.\tShow Services\n" +
                        "        3.\tAdd New Customer\n" +
                        "        4.\tShow Information of Customer\n" +
                        "        5.\tAdd New Booking\n" +
                        "        6.\tShow Information of Employee\n" +
                        "        7.\tExit");
    }

    public static void displayMenuAddNewServices() {
        System.out.println(
                "Choose these options below: \n" +
                        "1.\tAdd New Villa\n" +
                        "2.\tAdd New House\n" +
                        "3.\tAdd New Room\n" +
                        "4.\tBack to menu\n" +
                        "5.\tExit\n");
    }

    public static void displayMenuBackToMain() {
        System.out.println("Enter to continue!");
        ScannerUtils.scanner.nextLine();
    }
}