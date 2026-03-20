import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);

        System.out.println("Current Room Availability:");
        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " -> " + inventory.get(roomType));
        }

        inventory.put("Single Room", inventory.get("Single Room") - 1);

        System.out.println("\nAfter Booking 1 Single Room:");
        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " -> " + inventory.get(roomType));
        }
    }
}