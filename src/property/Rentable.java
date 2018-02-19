package property;

public interface Rentable extends Identifiable {
    public boolean getRentable(); // Is it possible to pay rent to this property
    public double getRent(); // Get the rental rate for this property
    public double payRent(); // Pays rent from one player to another
}