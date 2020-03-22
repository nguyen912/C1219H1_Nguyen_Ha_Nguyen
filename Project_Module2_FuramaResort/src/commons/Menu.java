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
                        "        7.\tBooking Movie Ticket 4D\n" +
                        "        8.\tFind Employee From Resume\n" +
                        "        9.\tExit");
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

    public static void displayMenuShowServices() {
        System.out.println("Show the services: \n" +
                "1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Room Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "8.\tExit\n");
    }

    public static void displayMenuBooking() {
        System.out.println("1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");
        System.out.println("Choose services booking.");
    }

    public static void displayMenuBookingMovieTicket4D() {
        System.out.println(
                "1. Booking movie ticket.\n" +
                "2. Show customer booking movie ticket.\n" +
                "3. Exit."
        );
        System.out.println("Please select one function!");
    }
}