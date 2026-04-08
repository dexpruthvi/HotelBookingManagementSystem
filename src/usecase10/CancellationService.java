package usecase10;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Handles booking cancellation and rollback.
 */
public class CancellationService {

    private Map<String, BookingRecord> bookings;
    private Map<String, Integer> inventory;
    private Stack<String> rollbackStack;

    public CancellationService() {

        bookings = new HashMap<>();
        inventory = new HashMap<>();
        rollbackStack = new Stack<>();

        inventory.put("Single", 2);
        inventory.put("Double", 2);
        inventory.put("Suite", 1);
    }

    // Add confirmed booking
    public void addBooking(BookingRecord booking) {
        bookings.put(booking.getReservationId(), booking);
        inventory.put(
                booking.getRoomType(),
                inventory.get(booking.getRoomType()) - 1
        );
    }

    // Cancel booking
    public void cancelBooking(String reservationId) {

        if (!bookings.containsKey(reservationId)) {
            System.out.println("Cancellation Failed: Reservation does not exist.");
            return;
        }

        BookingRecord booking = bookings.get(reservationId);

        if (!booking.isActive()) {
            System.out.println("Cancellation Failed: Booking already cancelled.");
            return;
        }

        rollbackStack.push(booking.getRoomId());

        inventory.put(
                booking.getRoomType(),
                inventory.get(booking.getRoomType()) + 1
        );

        booking.cancel();

        System.out.println("Booking Cancelled Successfully.");
        System.out.println("Released Room ID: " + rollbackStack.peek());
    }

    public void displayInventory() {
        System.out.println("Updated Inventory: " + inventory);
    }
}