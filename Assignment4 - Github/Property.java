
public class Property {

    private String city;
    private String owner;
    private Plot plot;
    private String propertyName;
    private double rentAmount;

    public Property(){}
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        plot = new Plot();
    }
    public Property(String propertyName, String city, double rentAmount, String owner,
                    int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }
    public Property(Property property) {
        this.city = property.city;
        this.owner = property.owner;
        this.plot = new Plot(property.plot);
        this.propertyName = property.propertyName;
        this.rentAmount = property.rentAmount;
    }
    public String getCity() {
        return city;
    }
    public String getOwner() {
        return owner;
    }
    public Plot getPlot() {
        return plot;
    }
    public String getPropertyName() {
        return propertyName;
    }
    public double getRentAmount() {
        return rentAmount;
    }

    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }





}
