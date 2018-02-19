package property;

public interface Taxable {
    public int getIncomeTaxPercentage(); // checks the 10% of their total assets for income tax
    public int getFlatIncomeTaxAmount(); // Choose the 200 option for income tax and pay
    public int getFlatLuxaryTaxAmount(); // 75 for luxary tax and pay
}
