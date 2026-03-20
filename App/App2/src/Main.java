import java.util.HashMap;

abstract class Room {
    String type;
    double price;

    Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    void display() {
        System.out.println(type + " | Price: ₹" + price);
    }
}

class SingleRoom extends Room {
    SingleRoom() { super("Single Room", 1000); }
}

class DoubleRoom extends Room {
    DoubleRoom() { super("Double Room", 1800); }
}

class SuiteRoom extends Room {
    SuiteRoom() { super("Suite Room", 3000); }
}

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);

        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        HashMap<String, Room> rooms = new HashMap<>();
        rooms.put("Single Room", r1);
        rooms.put("Double Room", r2);
        rooms.put("Suite Room", r3);

        System.out.println("Available Rooms:");

        for (String type : inventory.keySet()) {
            if (inventory.get(type) > 0) {
                rooms.get(type).display();
                System.out.println("Available: " + inventory.get(type));
            }
        }
    }
}