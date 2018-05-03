package cardDeck;

import javax.swing.*;

public class LeapCard implements PlayableCard {
    @Override
    public String getName() {
        return "Leap Card";
    }

    @Override
    public String getEffect() {
        return "!Discount Trains!";
    }

    @Override
    public void use() {

    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("Resources/Images/LeapCardImage.png");
    }

    @Override
    public int getWorth() {
        return 51;
    }
}
