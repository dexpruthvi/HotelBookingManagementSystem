package usecase7;

/**
 * Use Case 7:
 * Add-On Service Selection
 */
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        String reservationId = "RES101";

        // Guest selects services
        manager.addService(reservationId, new AddOnService("Breakfast", 20));
        manager.addService(reservationId, new AddOnService("Airport Pickup", 50));
        manager.addService(reservationId, new AddOnService("Spa Access", 100));

        // Display selected services
        manager.displayServices(reservationId);

        // Show total cost
        double total = manager.calculateTotalCost(reservationId);

        System.out.println("Total Additional Cost: $" + total);
    }
}