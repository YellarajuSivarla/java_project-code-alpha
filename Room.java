import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    String type;
    double price;
    boolean isAvailable;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
        this.isAvailable = true; // Rooms are available by default
    }

    public void bookRoom() {
        isAvailable = false; // Mark room as booked
    }

    @Override
    public String toString() {
        return "Room Type: " + type + ", Price: $" + price + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

class Booking {
    String name;
    Room room;

    public Booking(String name, Room room) {
        this.name = name;
        this.room = room;
        room.bookRoom(); // Book the room
    }

    @Override
    public String toString() {
        return "Booking Name: " + name + ", Room Type: " + room.type + ", Price: $" + room.price;
    }
}

    class HotelReservationSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        initializeRooms(); // Initialize some rooms
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }

    private static void initializeRooms() {
        rooms.add(new Room("Single", 100));
        rooms.add(new Room("Double", 150));
        rooms.add(new Room("Suite", 250));
    }

    private static void searchAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        searchAvailableRooms();
        
        System.out.print("Enter the type of room you want to book: ");
        String roomType = scanner.nextLine();

        for (Room room : rooms) {
            if (room.type.equalsIgnoreCase(roomType) && room.isAvailable) {
                Booking booking = new Booking(name, room);
                bookings.add(booking);
                System.out.println("Reservation successful!");
                simulatePayment(room.price); // Simulate payment
                return;
            }
        }
        
        System.out.println("Sorry, the requested room type is not available.");
    }

    private static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        
        System.out.println("\nYour Bookings:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    private static void simulatePayment(double amount) {
        System.out.printf("Processing payment of $%.2f...\n", amount);
        // Simulate a successful payment process
        System.out.println("Payment successful!");
    }
}

