import java.util.*;

class Reservation {
    String guestName;
    String roomType;
    String roomId;

    Reservation(String guestName, String roomType, String roomId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }
}

public class Main {

    public static void main(String[] args) {

        List<Reservation> bookingHistory = new ArrayList<>();

        bookingHistory.add(new Reservation("Alice", "Single Room", "SI1"));
        bookingHistory.add(new Reservation("Bob", "Double Room", "DO1"));
        bookingHistory.add(new Reservation("Charlie", "Suite Room", "SU1"));

        System.out.println("Booking History:");

        for (Reservation r : bookingHistory) {
            System.out.println(r.guestName + " | " + r.roomType + " | " + r.roomId);
        }

        System.out.println("\nTotal Bookings: " + bookingHistory.size());
    }
}