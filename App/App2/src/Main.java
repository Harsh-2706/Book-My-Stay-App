import java.util.*;

class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 1);
        inventory.put("Double Room", 0);

        String guestName = "Alice";
        String requestedRoom = "Double Room";

        try {
            validateBooking(requestedRoom, inventory);

            inventory.put(requestedRoom, inventory.get(requestedRoom) - 1);
            System.out.println(guestName + " booking confirmed for " + requestedRoom);

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        System.out.println("System running safely...");
    }

    static void validateBooking(String roomType, Map<String, Integer> inventory)
            throws InvalidBookingException {

        if (!inventory.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type");
        }

        if (inventory.get(roomType) <= 0) {
            throw new InvalidBookingException("No rooms available");
        }
    }
}