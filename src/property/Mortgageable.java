package property;

public interface Mortgageable extends Ownable {
    public boolean getMortgageable(); // Checks if the property is already mortgaged (cant be mortgaged if its already mortgaged)
    public void mortgageProperty(); // Mortgages the property
    public void unMortgageProperty(); // Unmortgages the property
    public double getMortgageAmount(); // Gets the amount of money you will get from mortgaging the property
}

