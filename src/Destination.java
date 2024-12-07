import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Activity> activities = new ArrayList<>();

    public Destination(String name) {
        this.name=name;
    }

    public void addActivities(Activity activity) {
        activities.add(activity);
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public String getName() {
        return name;
    }
}
