import java.io.*;
import java.util.*;

class Reservation implements Serializable {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> inventory = new HashMap<>();
        List<Reservation> history = new ArrayList<>();

        // Restore data if file exists
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.ser"))) {
            inventory = (Map<String, Integer>) in.readObject();
            history = (List<Reservation>) in.readObject();
            System.out.println("Data restored successfully");
        } catch (Exception e) {
            System.out.println("No previous data found, starting fresh");
        }

        // Add sample data
        inventory.put("Single Room", 2);
        history.add(new Reservation("Alice", "Single Room"));

        // Save data
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            out.writeObject(inventory);
            out.writeObject(history);
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Error saving data");
        }

        // Display data
        System.out.println("Inventory: " + inventory);
        System.out.println("Bookings: " + history.size());
    }
}