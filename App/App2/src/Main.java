import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println(guestName + " requested " + roomType);
    }
}

public class Main {

    public static void main(String[] args) {

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Alice", "Single Room"));
        bookingQueue.add(new Reservation("Bob", "Suite Room"));
        bookingQueue.add(new Reservation("Charlie", "Double Room"));

        System.out.println("Booking Requests in Order:");

        for (Reservation r : bookingQueue) {
            r.display();
        }
    }
}