import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //setting up the objects
        CruiseShip cruiseShip = new CruiseShip("Bananas",500);
        //passengers
        Passenger passenger1 = new Passenger("Cindy",1,"premium");
        Passenger passenger2 = new Passenger("Brandon",2,"standard",3000);
        Passenger passenger3 = new Passenger("Bob",3,"senior",2000);
        cruiseShip.addPassenger(passenger1);
        cruiseShip.addPassenger(passenger2);
        cruiseShip.addPassenger(passenger3);

        //Destination number 1
        Destination destination1 = new Destination("Paris");
        //this ensures that the size is not fixed - can add to the list
        List<Star> stars = new ArrayList<>(Arrays.asList(new Star("George","Tom"), new Star("Shea","Sarah"), new Star("Karia","Penny"), new Star("Jack","Joshua")));
        //activities
        TheatreShow theatreShow = new TheatreShow("New Town","A girl finds her way around a new town",200,1, stars);
        WalkingTour walkingTour = new WalkingTour("Mountains","Traverse beautiful mountains",250,20,20);
        Attraction attraction = new Attraction("Eiffel Tower","Visit the iconic landmark from Paris",300,35);
        destination1.addActivities(theatreShow);
        destination1.addActivities(walkingTour);
        destination1.addActivities(attraction);
        cruiseShip.addDestination(destination1);

        System.out.println("DESTINATION PARIS");
        System.out.println("Scenario 1 - 3 passengers want to sign up to an activity.");
        System.out.println("Cindy signs up to two activities");
        theatreShow.signUp(passenger1, destination1);
        walkingTour.signUp(passenger1,destination1);
        System.out.println("Balance now: "+passenger1.getBalance());

        System.out.println("Brandon signs up to one activity twice");
        walkingTour.signUp(passenger2,destination1);
        walkingTour.signUp(passenger2,destination1);
        System.out.println("Balance now: "+passenger2.getBalance());

        System.out.println("Bob signs up to an activity that is full (New town theatre show capacity is 1 and Cindy already signed up to it)");
        theatreShow.signUp(passenger3,destination1);

        System.out.println("Bob signs up to an activity that is not full");
        attraction.signUp(passenger3,destination1);
        System.out.println("Balance now: "+passenger3.getBalance());

        //Destination number 2
        Destination destination2 = new Destination("Zurich");
        List<Star> stars2 = new ArrayList<>(Arrays.asList(new Star("Helena","Evelyn"), new Star("Mia","Ava")));
        //activities
        TheatreShow theatreShow2 = new TheatreShow("Friendship","A new friendship blooms between two girls",140,50, stars);
        WalkingTour walkingTour2 = new WalkingTour("Zurichberg","Wooded hill overlooking Lake Zurich",500,20,30);
        WalkingTour walkingTour3 = new WalkingTour("Old town","Discover the old towns in Zurich",150,30,15);
        destination2.addActivities(theatreShow2);
        destination2.addActivities(walkingTour2);
        destination2.addActivities(walkingTour3);
        cruiseShip.addDestination(destination2);

        System.out.println("DESTINATION ZURICH");
        System.out.println("Scenario 2 - Bob and Cindy sign up to the same activity");
        walkingTour2.signUp(passenger3,destination2);
        walkingTour2.signUp(passenger1,destination2);
        System.out.println("Passengers that signed up to walking tour 2: ");
        // to get the name of the passengers that signed up instead of printing out the passenger object itself
        for (Passenger passenger : walkingTour2.getPassengersSignedUp()) {
            System.out.println(passenger.getName());
        }
        System.out.println("Brandon signs up to the walking tour 3.");
        walkingTour3.signUp(passenger2,destination2);
        System.out.println("Passengers that signed up to walking tour 3: ");
        for (Passenger passenger : walkingTour3.getPassengersSignedUp()) {
            System.out.println(passenger.getName());
        }

        System.out.println("Testing if can successfully print out information");
        System.out.println("Scenario 4 - SHIP ITINERARY");
        cruiseShip.printShipInfo();
        System.out.println("Scenario 5 - PASSENGER LIST");
        cruiseShip.printPassengersInfo();
        System.out.println("Scenario 6 - PASSENGER INFO of Cindy");
        passenger1.printPassengerInfo(cruiseShip);
        System.out.println("Scenario 7 - PASSENGER INFO of Brandon");
        passenger2.printPassengerInfo(cruiseShip);
        System.out.println("Scenario 8 - ALL ACTIVITIES INFO");
        cruiseShip.printActivitiesInfo();

    }
}