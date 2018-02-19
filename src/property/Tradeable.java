package property;

public interface Tradeable extends Identifiable {
    public boolean getTradeable(); // Is this tile tradeable (can trade properties with other players but not get out of jail cards)
    public String transfer(); // Transfers the property to another player
}
