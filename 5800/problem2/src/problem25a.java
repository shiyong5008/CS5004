
import java.util.concurrent.ThreadLocalRandom;
        import java.util.*;

        import java.util.concurrent.ThreadLocalRandom;
        import java.util.*;

/* MonteCarlo for N-GON where N = 4 */
public class problem25a {
    public static void main(String[] args) {

        // We will calculate the hits based on for how many points P,
        // do we get PC < PQ
        int hits = 0;
        int attempts = 1000000;

        for(int i = 0; i < attempts; i++) {

            //Point P : Getting random coordinates between -1 to 1 for Point P.
            double pX = getRandom();
            double pY = getRandom();

//Point C at (0,0)
            double cX = 0;
            double cY = 0;

//Point Q on perimeter
            double qX = 0, qY = 0;
            if(Math.abs(pY) == Math.min(Math.abs(pX), Math.abs(pY))) {
                qY = pY;
                qX = pX > 0 ? 1 : -1;
            } else {
                qX = pX;
                qY = pY > 0 ? 1 : -1;
            }

            //Finding distance between PC and PQ using distance formula.
            double PC = Math.sqrt((pY - cY) * (pY - cY) + (pX - cX) * (pX - cX));
            double PQ = Math.sqrt((pY - qY) * (pY - qY)+ (pX - qX) * (pX - qX));
            if(PC < PQ)  {
                hits++;
            }
        }

        // Finding probability where PC < PQ out of total attempts.
        double probability = (double) hits / attempts;
        System.out.println("Probability : " + probability);
    }

    /* Randomly find X and Y coordinates for Point P using Random class */
    private static double getRandom() {
        Random r = new Random();
        int rangeMin = -1;
        int rangeMax = 1;
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        return randomValue;
    }
}

