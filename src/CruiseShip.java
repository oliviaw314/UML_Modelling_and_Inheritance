import java.util.ArrayList;
import java.util.List;

public class CruiseShip {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public CruiseShip(String name, int passengerCapacity) {
        this.name=name;
        this.passengerCapacity=passengerCapacity;
        itinerary = new ArrayList<>();
        passengers = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public void printShipInfo() {
        StringBuilder destinations = new StringBuilder();
        for (Destination destination : itinerary) {
            destinations.append("\n"+destination.getName());

            // to make it more readable - keep count of how many activities there are
            int count = 1;
            // looping through each activity at one destination to get information about it
            for (Activity activity: destination.getActivities()) {
                destinations.append("\n"+count+". "+activity.getName());
                destinations.append("\nCost: "+activity.getCost());
                destinations.append("\nCapacity: "+activity.getCapacity());

                //print out distance if the activity is a walking tour
                if (activity instanceof WalkingTour) {
                    destinations.append("\nDistance: "+((WalkingTour) activity).getDistance());
                }

                //print out stars if activity is a theatre show
                if (activity instanceof TheatreShow) {
                    destinations.append("\nStars: ");
                    for (Star star : ((TheatreShow) activity).getStars()) {
                        destinations.append("\n"+star.getActorName()+" acting as "+star.getCharacterName());
                    }
                }

                count++;
            }
        }
        String allDestinations = destinations.toString();
        System.out.println("Ship name: "+name+"\nDestinations & Activities:"+allDestinations);
    }

    public void printPassengersInfo(){
        StringBuilder passengersInfo = new StringBuilder();
        for (Passenger passenger : passengers) {
            passengersInfo.append("\n"+passenger.getName()+" - "+passenger.getNumber());
        }
        System.out.println("Ship name: "+name+"\nPassenger capacity: "+passengerCapacity+"\nNumber of passengers on the cruise: "
                +passengers.size()+"\nPassengers: "+passengersInfo);
    }

    public void printActivitiesInfo() {
        StringBuilder activitiesInfo = new StringBuilder();
        activitiesInfo.append("All activities that have spaces available: ");
        // looping through each destination
        int count = 1;
        for (Destination destination : itinerary) {
            // looping through each activity in the destination
            for (Activity activity : destination.getActivities()) {
                //if there are still spots available
                if (activity.getPassengersSignedUp().size()<activity.getCapacity()) {
                    activitiesInfo.append("\n"+count+". "+activity.getName());
                    activitiesInfo.append("\n"+"Description: "+activity.getDescription());
                    activitiesInfo.append("\n"+"Cost: "+activity.getCost());
                    activitiesInfo.append("\n"+"Spots remaining: "+(activity.getCapacity()-activity.getPassengersSignedUp().size()));
                    count++;
                }
            }
        }
        System.out.println(activitiesInfo);
    }
}
