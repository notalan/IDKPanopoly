package property;

public interface Taxable {

    public double getTypeOfTax(); // This is checking the type of tax it is 1 = Income
    public double getIncomeTaxPercentage(); // checks the 10% of their total assets for income tax
    public double getFlatIncomeTaxAmount(); // Choose the 200 option for income tax and pay
    public double getFlatLuxaryTaxAmount(); // 75 for luxary tax and pay
}

