import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);

        Queue<Reservation> queue = new LinkedList<>();
        queue.add(new Reservation("Alice", "Single Room"));
        queue.add(new Reservation("Bob", "Single Room"));
        queue.add(new Reservation("Charlie", "Single Room"));

        HashMap<String, Set<String>> allocatedRooms = new HashMap<>();
        allocatedRooms.put("Single Room", new HashSet<>());
        allocatedRooms.put("Double Room", new HashSet<>());

        int idCounter = 1;

        while (!queue.isEmpty()) {

            Reservation r = queue.poll();
            String type = r.roomType;

            if (inventory.getOrDefault(type, 0) > 0) {

                String roomId = type.substring(0, 2).toUpperCase() + idCounter++;

                allocatedRooms.get(type).add(roomId);
                inventory.put(type, inventory.get(type) - 1);

                System.out.println(r.guestName + " booked " + type + " | Room ID: " + roomId);

            } else {
                System.out.println(r.guestName + " booking failed (No availability)");
            }
        }
    }
}