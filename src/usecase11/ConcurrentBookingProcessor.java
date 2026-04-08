package usecase11;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

/**
 * Handles concurrent booking requests safely using synchronization.
 */
public class ConcurrentBookingProcessor {

    private Queue<BookingRequest> bookingQueue;
    private Map<String, Integer> inventory;

    public ConcurrentBookingProcessor() {

        bookingQueue = new LinkedList<>();
        inventory = new HashMap<>();

        inventory.put("Single", 2);
        inventory.put("Double", 2);
        inventory.put("Suite", 1);
    }

    // Add request to shared queue
    public synchronized void addBookingRequest(BookingRequest request) {
        bookingQueue.add(request);
    }

    // Process booking safely
    public synchronized void processBooking() {

        if (bookingQueue.isEmpty()) {
            return;
        }

        BookingRequest request = bookingQueue.poll();

        String roomType = request.getRoomType();

        if (inventory.get(roomType) > 0) {

            inventory.put(roomType, inventory.get(roomType) - 1);

            System.out.println(
                    Thread.currentThread().getName()
                            + " processed booking for "
                            + request.getGuestName()
                            + " (" + roomType + ")"
            );

        } else {

            System.out.println(
                    Thread.currentThread().getName()
                            + ": No rooms available for "
                            + roomType
            );
        }
    }

    public void displayInventory() {
        System.out.println("Final Inventory: " + inventory);
    }
}