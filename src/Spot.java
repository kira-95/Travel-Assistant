/**
 * @author Xijie Guo
 */
public class Spot {

    private String name, address;
    private boolean isFirstSpot;

    public Spot(String name) {
        this.name = name;
        isFirstSpot = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFirstSpot() {
        return isFirstSpot;
    }

    public void setFirstSpot(boolean isFirstSpot) {
        this.isFirstSpot = isFirstSpot;
    }

    /**
     * Get the distance from the spot specified by parameter to this spot
     */
    public int getDistanceFrom(Spot spot) {
        int distance = 0;
        return distance;
    }

    /**
     * Get the distance from this spot to the spot specified by parameter
     */
    public int getDistanceTo(Spot spot) {
        int distance = 0;
        return distance;
    }
}
