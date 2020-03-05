package FuramaResort.Views;

import FuramaResort.models.Services;
import FuramaResort.models.Villa;

public class Main {
    public static void main(String[] args) {
        Services villa = new Villa("001","villa cao cap",300,200,4,"day","3 sao",
                "phong karaoke",50,3);
        villa.showInfo();
    }
}
