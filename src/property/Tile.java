package property;

public class Tile implements Identifiable {

    String NAME;
    String XCO;
    String YCO;

    public String getIdentifier() {
        return NAME;
    }
    public String getXCo(){return XCO;}
    public String getYCo(){return YCO;}

}
