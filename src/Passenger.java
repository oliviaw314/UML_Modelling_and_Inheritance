import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private int number;
    private String status;
    private double balance;
    private List<Activity> activities = new ArrayList<>();

    //constructor if passenger is standard or senior - has a balance
    public Passenger(String name, int number, String status, double balance) {
        this.name=name;
        this.number=number;
        this.status=status;
        this.balance=balance;
    }

    //method overloading
    //constructor if passenger is premium - doesn't have a balance
    public Passenger(String name, int number, String status) {
        this.name=name;
        this.number=number;
        this.status=status;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void printPassengerInfo(CruiseShip cruiseShip) {
        StringBuilder activitiesInfo = new StringBuilder();
        activitiesInfo.append("Name: "+name+"\nNumber: "+number);

        // if passenger isn't premium - they have a balance
        if (!status.equalsIgnoreCase("Premium")) {
            activitiesInfo.append("\n Balance: "+balance);
        }
        activitiesInfo.append("\n Activities: ");
        int count = 1;
        for (Activity activity: activities) {
            activitiesInfo.append("\n"+count+". "+activity.getName());
            for (Destination destination : cruiseShip.getItinerary()) {
                if (destination.getActivities().contains(activity)) {
                    activitiesInfo.append("\n Destination: "+destination.getName());
                    break;
                }
            }
            // the price the passenger paid depending on their status
            if (status.equalsIgnoreCase("Premium")) {
                activitiesInfo.append("\n"+"Price: 0");
            }
            else if (status.equalsIgnoreCase("Standard")) {
                activitiesInfo.append("\n"+"Price: "+activity.getCost());
            }
            else if (status.equalsIgnoreCase("Senior")) {
                activitiesInfo.append("\n"+"Price: "+activity.getCost()*0.9);
            }

            count++;
        }
        System.out.println(activitiesInfo);
    }
}
