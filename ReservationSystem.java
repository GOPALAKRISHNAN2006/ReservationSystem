import java.io.*;
import java.util.*;

public class ReservationSystem {
    private static final String FILE_NAME = "bookings.dat";
    private List<Passenger> bookings;
    private int totalSeats = 40;

    public ReservationSystem() {
        bookings = loadBookings();
    }

    // -------- Load Bookings from File --------
    @SuppressWarnings("unchecked")

    private List<Passenger> loadBookings() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Passenger>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // -------- Save Bookings to File --------

    private void saveBookings() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(bookings);
        } catch (IOException e) {
            System.out.println("Error saving bookings: " + e.getMessage());
        }
    }

    // -------- Book Ticket --------
    public void bookTicket(Scanner sc) {
        if (bookings.size() >= totalSeats) {
            System.out.println("⚠️  All seats are booked!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter Source: ");
        String source = sc.nextLine();
        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();

        double fare = calculateFare(source, destination);
        int ticketId = new Random().nextInt(10000) + 1000;

        Passenger p = new Passenger(ticketId, name, age, gender, source, destination, fare);
        bookings.add(p);
        saveBookings();
        System.out.println("\n✅ Ticket booked successfully!");
        System.out.println(p);
    }

    // -------- Cancel Ticket --------
    public void cancelTicket(Scanner sc) {
        System.out.print("Enter Ticket ID to cancel: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean removed = bookings.removeIf(p -> p.getTicketId() == id);

        if (removed) {
            saveBookings();
            System.out.println("❌ Ticket cancelled successfully.");
        } else {
            System.out.println("⚠️ Ticket ID not found.");
        }
    }

    // -------- View All Bookings --------
    public void viewAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            System.out.println("\n--- All Bookings ---");
            bookings.forEach(System.out::println);
        }
    }

    // -------- View Available Seats --------
    public void viewAvailableSeats() {
        int available = totalSeats - bookings.size();
        System.out.println("Available Seats: " + available + "/" + totalSeats);
    }

    // -------- Fare Calculation --------
    private double calculateFare(String source, String destination) {
        int distance = Math.abs(source.hashCode() - destination.hashCode()) % 300 + 50; // randomize distance
        return distance * 1.5; // ₹1.5 per km (example)
    }
}
