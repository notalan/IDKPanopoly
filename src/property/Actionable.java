package property;

import player.Player;

public interface Actionable {
    public boolean performActionOn(Player p); // Does the action of the card to the player(s)
    public String explainAction(); // Explains what the chance/community chest card does
}
