package property;

public class ImproveProperty extends Property implements Constructable, Sellable{

    int numberOfHouses;
    int numberOfHotels;
    int housePrices;
    int hotelPrices;

    ImproveProperty(String name, int price, double mortgagePrice, double rent, int housePrice, int hotelPrice)
    {
        super(name,price,mortgagePrice,rent);
        housePrices = housePrice;
        hotelPrices = hotelPrice;
    }

    @Override
    public boolean getConstructable() {
        if (countHouses() == 4 && countHotels() == 1)
        {
            return false;
        }
        else return true;
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
        if(numberOfHouses > 0 && numberOfHotels > 0)
        {
            return true;
        }
        else return false;
    }

    @Override
    public void sellHouse() {
        numberOfHouses--;
    }

    @Override
    public void sellHotel() {
        numberOfHotels--;
    }
}
