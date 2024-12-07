public class WalkingTour extends Activity {
    private int distance;

    public WalkingTour(String name, String description, int cost, int capacity, int distance) {
        super(name, description, cost, capacity);
        this.distance=distance;
    }

    public int getDistance() {
        return distance;
    }
}
