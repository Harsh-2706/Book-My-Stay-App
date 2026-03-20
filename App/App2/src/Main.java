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

    static Map<String, Integer> inventory = new HashMap<>();
    static Queue<Reservation> queue = new LinkedList<>();

    public static void main(String[] args) {

        inventory.put("Single Room", 2);

        queue.add(new Reservation("Alice", "Single Room"));
        queue.add(new Reservation("Bob", "Single Room"));
        queue.add(new Reservation("Charlie", "Single Room"));

        Runnable task = () -> {
            while (true) {
                processBooking();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }

    static synchronized void processBooking() {

        if (queue.isEmpty()) return;

        Reservation r = queue.poll();

        if (inventory.getOrDefault(r.roomType, 0) > 0) {
            inventory.put(r.roomType, inventory.get(r.roomType) - 1);
            System.out.println(Thread.currentThread().getName() +
                    " booked for " + r.guestName);
        } else {
            System.out.println(r.guestName + " failed (No rooms)");
        }
    }
}