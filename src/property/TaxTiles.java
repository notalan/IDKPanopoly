package property;

public class TaxTiles extends Tile implements Taxable {

    // alter constructor later on for when adding additional game features

    private double ITPercent;
    private int FlatITAmount;
    private int FlatLuxaryAmount;

    public TaxTiles(double ITPercentage, int getFlatIncomeTaxAmount, int getFlatLuxaryTaxAmount) {
        ITPercent = ITPercentage;
        FlatITAmount = getFlatIncomeTaxAmount;
        FlatLuxaryAmount = getFlatLuxaryTaxAmount;
    }

    @Override
    public double getIncomeTaxPercentage() { // takes 10% off
        return ITPercent;
    }

    @Override
    public int getFlatIncomeTaxAmount() { // takes 200 off
        return FlatITAmount;
    }

    @Override
    public int getFlatLuxaryTaxAmount() { // takes 75 off
        return FlatLuxaryAmount;
    }
}
