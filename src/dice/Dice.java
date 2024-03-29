package dice;

import java.util.Random;

public class Dice implements Rollable {
    private final static Random RND = new Random();

    public int rollDice(int numDice, int numSides){
        int sum = 0;
        for(int i = 0; i < numDice; i++)
            sum += RND.nextInt(numSides)+1;
            return sum;
    }
}
