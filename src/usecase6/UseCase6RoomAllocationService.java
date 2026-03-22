package usecase6;

import usecase3.RoomInventory;
import usecase5.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 */
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Queue (from UC5)
        Queue<Reservation> queue = new LinkedList<>();

        queue.add(new Reservation("Alice", "Single Room"));
        queue.add(new Reservation("Bob", "Double Room"));
        queue.add(new Reservation("Charlie", "Suite Room"));
        queue.add(new Reservation("David", "Suite Room")); // may fail if limited

        // Allocation service
        RoomAllocationService service = new RoomAllocationService(inventory, queue);

        service.processBookings();
    }
}