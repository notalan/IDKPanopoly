package player;
import property.Property;
import java.util.ArrayList;
public interface Identifiable {
    String name();
    ArrayList<Property> properties();
    double balance();
}
