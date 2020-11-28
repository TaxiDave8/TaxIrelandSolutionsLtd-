import java.util.ArrayList;

public class Owner {
    private ArrayList<Property> properties;
    private String name;

    public Owner(String name) {
        properties = new ArrayList<Property>();
        name = name;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public String getName() {
        return name;
    }

    public void addProperty(Property p){
        properties.add(p);
    }
}
