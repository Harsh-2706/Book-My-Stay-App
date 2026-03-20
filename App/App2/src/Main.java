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

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 1);

        List<Reservation> bookingHistory = new ArrayList<>();
        bookingHistory.add(new Reservation("Alice", "Single Room", "SI1"));

        Stack<String> rollbackStack = new Stack<>();
        rollbackStack.push("SI1");

        String cancelRoomId = "SI1";

        boolean found = false;

        for (Reservation r : bookingHistory) {
            if (r.roomId.equals(cancelRoomId)) {

                found = true;

                inventory.put(r.roomType, inventory.get(r.roomType) + 1);

                rollbackStack.pop();

                System.out.println("Booking cancelled for " + r.guestName + " | Room ID: " + r.roomId);
                break;
            }
        }

        if (!found) {
            System.out.println("Cancellation failed: Invalid reservation");
        }

        System.out.println("Updated Inventory: " + inventory);
    }
}