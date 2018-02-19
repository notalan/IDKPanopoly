package property;

public interface Actionable {
    public boolean performActionOn(Playable player); // Does the action of the card to the player(s)
    public String explainAction(); // Explains what the chance/community chest card does
}
