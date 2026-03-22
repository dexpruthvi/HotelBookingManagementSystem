package usecase6;

import usecase3.RoomInventory;
import usecase5.*;

import java.util.*;

/**
 * Handles booking confirmation and room allocation
 */
public class RoomAllocationService {

    private RoomInventory inventory;
    private Queue<Reservation> queue;

    // Map: RoomType → Set of allocated room IDs
    private Map<String, Set<String>> allocatedRooms;

    public RoomAllocationService(RoomInventory inventory, Queue<Reservation> queue) {
        this.inventory = inventory;
        this.queue = queue;
        this.allocatedRooms = new HashMap<>();
    }

    public void processBookings() {

        System.out.println("===== Processing Bookings =====");

        while (!queue.isEmpty()) {

            Reservation r = queue.poll(); // FIFO

            String roomType = r.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique room ID
                String roomId = roomType.substring(0, 2).toUpperCase() + "_" + UUID.randomUUID().toString().substring(0, 5);

                // Store in Set (no duplicates)
                allocatedRooms.putIfAbsent(roomType, new HashSet<>());
                allocatedRooms.get(roomType).add(roomId);

                // Update inventory
                inventory.updateAvailability(roomType, available - 1);

                System.out.println("Booking Confirmed:");
                System.out.println("Guest: " + r.getGuestName());
                System.out.println("Room Type: " + roomType);
                System.out.println("Room ID: " + roomId);
                System.out.println();

            } else {
                System.out.println("Booking Failed (No availability): " + r.getGuestName());
            }
        }
    }
}