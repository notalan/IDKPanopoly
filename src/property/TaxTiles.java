package property;

public class TaxTiles extends Tile implements Taxable {

    // add a constructor later on for when adding additional game features

    @Override
    public double getIncomeTaxPercentage() { // takes 10% off
        return 0.1;
    }

    @Override
    public int getFlatIncomeTaxAmount() { // takes 200 off
        return 200;
    }

    @Override
    public int getFlatLuxaryTaxAmount() { // takes 75 off
        return 75;
    }
}
