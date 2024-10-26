import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Destination {
    String name;
    String date;
    String preferences;

    public Destination(String name, String date, String preferences) {
        this.name = name;
        this.date = date;
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Date: " + date + ", Preferences: " + preferences;
    }
}

        class TravelItineraryPlanner {
    private static List<Destination> itinerary = new ArrayList<>();
    private static double budget = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Travel Itinerary Planner");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Set Budget");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addDestination(scanner);
                    break;
                case 2:
                    viewItinerary();
                    break;
                case 3:
                    setBudget(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the planner. Safe travels!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }

    private static void addDestination(Scanner scanner) {
        System.out.print("Enter destination name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter travel date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        
        System.out.print("Enter your preferences (e.g., budget-friendly, adventure): ");
        String preferences = scanner.nextLine();

        itinerary.add(new Destination(name, date, preferences));
        System.out.println("Destination added successfully!");
    }

    private static void viewItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("Your itinerary is empty.");
            return;
        }
        
        System.out.println("\nYour Travel Itinerary:");
        for (Destination dest : itinerary) {
            System.out.println(dest);
        }
        
        if (budget > 0) {
            System.out.printf("Total Budget: $%.2f\n", budget);
        }
    }

    private static void setBudget(Scanner scanner) {
        System.out.print("Enter your total budget: $");
        budget = scanner.nextDouble();
        System.out.println("Budget set to $" + budget);
    }
}
