package property;

public class ImproveProperty extends Property implements Constructable, Sellable {

    private int numberOfHouses;
    private int numberOfHotels;
    private int housePrices;
    public String colourOfTiles;
    private boolean monopolied;

    public ImproveProperty(String name, String colourOfTile, int xco, int yco, int price, double mortgagePrice, double rent, int housePrice) {
        super(name, xco, yco, price, mortgagePrice, rent);
        housePrices = housePrice;
        colourOfTiles = colourOfTile;

    }

    @Override
    public boolean getConstructable() {
        if (countHouses() == 4 && countHotels() == 1 && monopolied) {
            return false;
        } else return true;
    }

    @Override
    public int countHouses() {
        return numberOfHouses;
    }

    @Override
    public int countHotels() {
        return numberOfHotels;
    }

    @Override
    public void buildHouse() {
        numberOfHouses++;
    }

    @Override
    public void buildHotel() {
        numberOfHotels++;
    }

    @Override
    public int housePrice() {
        return housePrices;
    }

    @Override
    public boolean getSellable() {
        if (numberOfHouses > 0 || numberOfHotels > 0) {
            return true;
        } else return false;
    }

    @Override
    public void sellHouse() {
        numberOfHouses--;
    }

    @Override
    public void sellHotel() {
        numberOfHotels--;
    }


    public boolean monopolySet() // Colour Check
    {
        return monopolied = true;
    }

    public boolean monopolyCheck()
    {
        return monopolied;
    }

    // monopoly function boolean here

}
