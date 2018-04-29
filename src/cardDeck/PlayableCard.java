package cardDeck;

import javax.swing.ImageIcon;

public interface PlayableCard {
    String getName();
    String getEffect();
    void use();
    ImageIcon getIcon();
    int getWorth();

}
