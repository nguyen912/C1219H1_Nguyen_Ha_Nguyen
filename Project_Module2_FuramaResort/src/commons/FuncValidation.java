package commons;

import models.House;
import models.Room;
import models.Services;
import models.Villa;

public class FuncValidation {
    private static String pattern = "";

    public static boolean isValidIdServices(Services service, String str) {
        if (service instanceof Villa) {
            pattern = "^SVVL\\d{4}$";
        }
        else if (service instanceof House) {
            pattern = "^SVHO\\d{4}$";
        }
        else if (service instanceof Room) {
            pattern = "^SVRO\\d{4}$";
        }
        return str.matches(pattern);
    }

    public static boolean isValidNameServices(String str) {
        pattern = "^([A-Z][a-z]*\\s?)+$";
        return str.matches(pattern);
    }

    public static boolean isValidFreeServices(String str) {
        pattern = "^massage|karaoke|food|drink|car$";
        return str.matches(pattern);
    }

    public static String getValidIdService(Services services, String strDisplay, String errMess) {
        System.out.println(strDisplay);
        String result = ScannerUtils.scanner.nextLine();
        if (!isValidIdServices(services, result)) {
            System.out.println(errMess);
            result = getValidIdService(services, strDisplay, errMess);
        }
        return result;
    }

    public static String getValidName(String strDisplay, String errMess) {
        System.out.println(strDisplay);
        String result = ScannerUtils.scanner.nextLine();
        if (!isValidNameServices(result)) {
            System.out.println(errMess);
            result = getValidName(strDisplay, errMess);
        }
        return result;
    }

    public static String getValidFreeServices(String strDisplay, String errMess) {
        System.out.println(strDisplay);
        String result = ScannerUtils.scanner.nextLine();
        if (!isValidFreeServices(result)) {
            System.out.println(errMess);
            result = getValidFreeServices(strDisplay, errMess);
        }
        return result;
    }

    public static double getValidNumberDouble(String strDisplay, String errMess) {
        return getValidNumberDouble(strDisplay, errMess, null);
    }

    public static double getValidNumberDouble(String strDisplay, String errMess, Double min) {
        double result = 0;
        System.out.println(strDisplay);
        try {
            result = Double.parseDouble(ScannerUtils.scanner.nextLine());
            if (min != null && result <= min) {
                throw new Exception(errMess);
            }
        }
        catch (Exception e) {
            System.out.println(errMess);
            result = getValidNumberDouble(strDisplay, errMess, min);
        }
        return result;
    }

    public static Integer getValidNumberInteger(String strDisplay, String errMess, Integer min) {
        return getValidNumberInteger(strDisplay, errMess, min, null);
    }

    public static Integer getValidNumberInteger(String strDisplay, String errMess, Integer min, Integer max) {
        int result = 0;
        System.out.println(strDisplay);
        try {
            result = Integer.parseInt(ScannerUtils.scanner.nextLine());
            if (min != null && result <= min) {
                throw new Exception(errMess);
            }
            if (max != null && result >= max) {
                throw new Exception(errMess);
            }
        }
        catch (Exception e) {
            System.out.println(errMess);
            result = getValidNumberInteger(strDisplay, errMess, min, max);
        }
        return result;
    }

}
