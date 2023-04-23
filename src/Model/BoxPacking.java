package Model;

import java.util.Random;
import static java.lang.Math.*;

public class BoxPacking {
    Random random = new Random();

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) round(random() * (end - start));
    }

    public static int createProductionDate(){
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(1000, 2022);
        String productDate = String.format("%d%02d%02d", year, month, day);
        return Integer.parseInt(productDate);
    }

}
