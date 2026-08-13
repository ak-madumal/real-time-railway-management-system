import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


// Interface for seat services
interface SeatService {
    boolean checkAvailability(int seatsRequired);
    void bookSeats(int seats) throws Exception;
    void cancelBooking(int seats) throws Exception;
    void displaySeatStatus();
}

// Abstract class for base train details
abstract class TrainBase implements SeatService {
    private String trainName;
    private int totalSeats;
    private int bookedSeats;

    TrainBase(String trainName, int totalSeats) {
        this.trainName = trainName;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    protected void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    // Abstraction for displaying train info
    public abstract void displayTrainInfo();

    
    public boolean checkAvailability(int seatsRequired) {
        return (totalSeats - bookedSeats) >= seatsRequired;
    }

   
    public void bookSeats(int seats) throws Exception {
        if (checkAvailability(seats)) {
            setBookedSeats(getBookedSeats() + seats);
            System.out.println(seats + " seat(s) successfully booked.");
        } else {
            throw new Exception("Not enough seats available!");
        }
    }

    @Override
    public void cancelBooking(int seats) throws Exception {
        if (bookedSeats >= seats) {
            setBookedSeats(getBookedSeats() - seats);
            System.out.println(seats + " seat(s) successfully canceled.");
        } else {
            throw new Exception("You cannot cancel more seats than booked!");
        }
    }

    
    public void displaySeatStatus() {
        System.out.println("Train: " + trainName);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Booked Seats: " + bookedSeats);
        System.out.println("Available Seats: " + (totalSeats - bookedSeats));
    }
}

// Subclass for a specific train - Inheritance
class ExpressTrain extends TrainBase {
    private String route;

    ExpressTrain(String trainName, int totalSeats, String route) {
        super(trainName, totalSeats);
        this.route = route;
    }

    
    public void displayTrainInfo() {
        System.out.println("Train Name: " + getTrainName());
        System.out.println("Route: " + route);
    }
}

// Train Management System using ArrayList - Collections
class RailwaySystem {
    private ArrayList<TrainBase> trainList = new ArrayList<>();

    public void addTrain(TrainBase train) {
        trainList.add(train);
    }

    public void listTrains() {
        System.out.println("\nAvailable Trains:");
        for (int i = 0; i < trainList.size(); i++) {
            System.out.print((i + 1) + ". ");
            trainList.get(i).displayTrainInfo();
        }
    }

    public TrainBase selectTrain(int index) {
        if (index >= 0 && index < trainList.size()) {
            return trainList.get(index);
        }
        return null;
    }
}

// Main class to simulate booking
public class RealTimeRailwaySystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RailwaySystem system = new RailwaySystem();

        // Polymorphism in action
        TrainBase train1 = new ExpressTrain("Colombo Express", 100, "Colombo - Galle");
        TrainBase train2 = new ExpressTrain("Kandy Intercity", 80, "Kandy - Colombo");
        TrainBase train3 = new ExpressTrain("Yarl Express", 100, "Colombo- Jaffna");

        system.addTrain(train1);
        system.addTrain(train2);
        system.addTrain(train3);

        while (true) {
            System.out.println("\n--- Railway Booking System ---");
            system.listTrains();
            System.out.print("Select train number (0 to exit): ");
            int choice = scan.nextInt();

            if (choice == 0) break;

            TrainBase selectedTrain = system.selectTrain(choice - 1);
            if (selectedTrain == null) {
                System.out.println("Invalid train selection.");
                continue;
            }

            selectedTrain.displaySeatStatus();

            System.out.print("Enter 1 to Book | 2 to Cancel | 0 to Back: ");
            int action = scan.nextInt();
            if (action == 0) continue;

            System.out.print("Enter number of seats: ");
            int seats = scan.nextInt();

            try {
                if (action == 1) {
                    selectedTrain.bookSeats(seats);
                } else if (action == 2) {
                    selectedTrain.cancelBooking(seats);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            selectedTrain.displaySeatStatus();
        }

      
        System.out.println("Thank you for using the Railway Booking System!");
    }
}

 
