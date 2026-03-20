import java.util.*;

class Service {
    String name;
    double price;

    Service(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class Main {

    public static void main(String[] args) {

        Map<String, List<Service>> addOns = new HashMap<>();

        String reservationId = "SI1";

        List<Service> services = new ArrayList<>();
        services.add(new Service("Breakfast", 200));
        services.add(new Service("Airport Pickup", 500));

        addOns.put(reservationId, services);

        double totalCost = 0;

        System.out.println("Services for Reservation " + reservationId + ":");

        for (Service s : addOns.get(reservationId)) {
            System.out.println(s.name + " - ₹" + s.price);
            totalCost += s.price;
        }

        System.out.println("Total Add-On Cost: ₹" + totalCost);
    }
}