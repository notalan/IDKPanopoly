package property;

public class Jail extends Tile {
    private boolean justVisiting = true;
    private boolean inJail = false;

    public Jail(String name, int xco, int yco) {
        super.NAME = name;
        super.XCO = xco;
        super.YCO = yco;
    }

}
