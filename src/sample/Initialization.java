package sample;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by terrabyte on 1/29/2017.
 */
public class Initialization {
    public Initialization() {}

    public ArrayList<Queen> Initialize(int qNumber){
        ArrayList<Queen> Queens = new ArrayList<Queen>();
        //Random random = new Random(System.currentTimeMillis());
        Random random = new Random(10);

        for(int i = 0; i < qNumber; i++){
            Queens.add(new Queen(random.nextInt(qNumber),i));
        }

        return Queens;
    }
}
