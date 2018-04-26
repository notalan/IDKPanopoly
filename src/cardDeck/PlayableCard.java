package cardDeck;

import javax.swing.ImageIcon;

public interface PlayableCard {
    public String getName();
    public String getEffect();
    public void use();
    public ImageIcon getIcon();
}
