import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String name;
    private String description;
    private int cost;
    private int capacity;
    private List<Passenger> passengersSignedUp = new ArrayList<>();

    public Activity(String name, String description, int cost, int capacity) {
        this.name=name;
        this.description=description;
        this.cost=cost;
        this.capacity=capacity;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Passenger> getPassengersSignedUp() {
        return passengersSignedUp;
    }

    public String getDescription() {
        return description;
    }

    public void signUp(Passenger passenger, Destination destination) {
        // check if already is in this activity
        if (passengersSignedUp.contains(passenger)) {
            System.out.println("Participant has already signed up for this activity");
            return;
        }

        //check if is in any activity in this destination
        for (Activity activity : passenger.getActivities()) {
            if (destination.getActivities().contains(activity)) {
                System.out.println("Participant has already signed up for another activity.");
                return;
            }
        }

        //check capacity
        if (passengersSignedUp.size()==capacity) {
            System.out.println("This activity is full.");
            return;
        }

        //check status + balance
        if (passenger.getStatus().equalsIgnoreCase("Standard")) {
            if (passenger.getBalance()<cost) {
                System.out.println("The cost of this activity exceeds the participant's balance.");
                return;
            }
            passenger.setBalance(passenger.getBalance()-cost);
        }

        if (passenger.getStatus().equalsIgnoreCase("Senior")) {
            if (passenger.getBalance()<cost*0.09) {
                System.out.println("The cost of this activity exceeds the participant's balance");
                return;
            }
            passenger.setBalance(passenger.getBalance()-cost*0.9);
        }

        passengersSignedUp.add(passenger);
        // this equals to this object i.e. activity
        passenger.addActivity(this);

    }
}
