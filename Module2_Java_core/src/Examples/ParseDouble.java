package Examples;

public class ParseDouble {
    public static void main(String[] args) {
        String[] ds = {"1000.0","893","3234.423"};
        String d = "1000";
        System.out.println(Double.parseDouble(d));
        for (String dou : ds) {
            System.out.println(Double.parseDouble(dou));
        }
    }
}
