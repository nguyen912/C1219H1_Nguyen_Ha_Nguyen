package commons;

import customer_exceptions.*;
import models.House;
import models.Room;
import models.Services;
import models.Villa;

import java.util.Calendar;

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

    public static String getValidCustomerName(String strDisplay, String errMess) {
        String result = "";
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidNameServices(result)) {
                throw new NameException(errMess);
            }
        }
        catch (NameException e) {
            System.out.println(errMess);
            result = getValidCustomerName(strDisplay, errMess);
        }
        return result;
    }

    public static boolean isValidBirthday(String str) {
        pattern = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
        return str.matches(pattern);
    }
    public static String getValidBirthday(String strDisplay, String errMess) {
        String result = null;
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidBirthday(result)) {
                throw new BirthdayException(errMess);
            }
            int year = Integer.parseInt(result.substring(6,10));
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (year <= 1900 || currentYear - year <= 18) {
                throw new BirthdayException(errMess);
            }
        }
        catch (BirthdayException e) {
            System.out.println(errMess);
            result = getValidBirthday(strDisplay, errMess);
        }
        return result;
    }

    public static boolean isValidGender(String str) {
        pattern = "^(?i:Male|Female|Unknown)$";
        return str.matches(pattern);
    }

    public static String getValidGender(String strDisplay, String errMess) {
        String result = null;
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidGender(result)) {
                throw new GenderException(errMess);
            }
        }
        catch (GenderException e) {
            System.out.println(errMess);
            result = getValidGender(strDisplay, errMess);
        }
        return result;
    }

    public static boolean isValidIdCard(String str) {
        pattern = "^\\d{9}$";
        return str.matches(pattern);
    }
    public static String getValidIdCard(String strDisplay, String errMess) {
        String result = null;
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidIdCard(result)) {
                throw new IdCardException(errMess);
            }
        }
        catch (IdCardException e) {
            System.out.println(errMess);
            result = getValidIdCard(strDisplay, errMess);
        }
        return result;
    }

    public static boolean isValidEmail(String str) {
        pattern = "^[A-Z0-9._%+-]++@[A-Z0-9.-]++\\.[A-Z]{2,}+$";
        return str.matches(pattern);
    }
    public static String getValidEmail(String strDisplay, String errMess) {
        String result = null;
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidEmail(result)) {
                throw new EmailException(errMess);
            }
        }
        catch (EmailException e) {
            System.out.println(errMess);
            result = getValidEmail(strDisplay, errMess);
        }
        return result;
    }
}
