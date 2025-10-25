
import java.io.Serializable;
@SuppressWarnings("unused")
public class Passenger implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ticketId;
    private String name;
    private int age;
    private String gender;
    private String source;
    private String destination;
    private double fare;

    public Passenger(int ticketId, String name, int age, String gender, String source, String destination, double fare) {
        this.ticketId = ticketId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
    }

    public int getTicketId() { return ticketId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public double getFare() { return fare; }

    @Override
    public String toString() {
        return String.format(
            "Ticket ID: %d | Name: %s | Age: %d | Gender: %s | From: %s | To: %s | Fare: ₹%.2f",
            ticketId, name, age, gender, source, destination, fare
        );
    }
}
