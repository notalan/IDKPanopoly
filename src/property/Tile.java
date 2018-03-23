package property;

public class Tile implements Identifiable {

    String NAME;
    int XCO;
    int YCO;

    public String getIdentifier() {
        return NAME;
    }
    public int getXCo(){return XCO;}
    public int getYCo(){return YCO;}

}
