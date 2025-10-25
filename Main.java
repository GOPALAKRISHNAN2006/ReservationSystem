import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservationSystem rs = new ReservationSystem();
        int choice;
        
        do {
            System.out.println("\n===== RAILWAY RESERVATION SYSTEM =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View All Bookings");
            System.out.println("4. View Available Seats");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> rs.bookTicket(sc);
                case 2 -> rs.cancelTicket(sc);
                case 3 -> rs.viewAllBookings();
                case 4 -> rs.viewAvailableSeats();
                case 5 -> System.out.println("Thank you for using the system!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
        sc.close();
    }
}
