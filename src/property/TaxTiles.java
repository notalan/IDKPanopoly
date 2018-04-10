package property;

public class TaxTiles extends Tile implements Taxable {

    // alter constructor later on for when adding additional game features
    private String name;
    private double typeOfTax;
    private double ITPercent;
    private double FlatITAmount;
    private double FlatLuxaryAmount;

    public TaxTiles(String name, int xco, int yco, double taxType, double ITPercentage, double getFlatIncomeTaxAmount, double getFlatLuxaryTaxAmount) {
        super.NAME = name;
        super.XCO = xco;
        super.YCO = yco;
        typeOfTax = taxType;
        ITPercent = ITPercentage;
        FlatITAmount = getFlatIncomeTaxAmount;
        FlatLuxaryAmount = getFlatLuxaryTaxAmount;
    }


    @Override
    public double getTypeOfTax(){
        if(typeOfTax == 1)
            return ITPercent;

        if(typeOfTax == 2)
            return FlatITAmount;

        else return FlatLuxaryAmount;
    }

    @Override
    public double getIncomeTaxPercentage() { // takes 10% off
        return ITPercent; }

    @Override
    public double getFlatIncomeTaxAmount() { // takes 200 off
        return FlatITAmount;
    }

    @Override
    public double getFlatLuxaryTaxAmount() { // takes 75 off
        return FlatLuxaryAmount;
    }
}

