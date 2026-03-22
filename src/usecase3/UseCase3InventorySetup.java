package usecase3;


 // Use Case 3: Centralized Room Inventory Management

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display current inventory
        inventory.displayInventory();

        System.out.println("\nUpdating availability...\n");

        // Update values
        inventory.updateAvailability("Single Room", 8);
        inventory.updateAvailability("Suite Room", 1);

        // Display again
        inventory.displayInventory();
    }
}