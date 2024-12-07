import java.util.List;

public class TheatreShow extends Activity {
    private List<Star> stars;

    public TheatreShow(String name, String description, int cost, int capacity, List<Star> stars) {
        super(name, description, cost, capacity);
        this.stars=stars;
    }

    public List<Star> getStars() {
        return stars;
    }
}
