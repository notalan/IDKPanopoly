package player;
import property.Property;

public interface Identifiable {
    String name();
    Property[] properties();
    double balance();
}
