package usecase5;

/**
 * Use Case 5: Booking Request Queue (FIFO)
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();

        // Add booking requests
        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Double Room"));
        queue.addRequest(new Reservation("Charlie", "Suite Room"));

        // Display queue
        queue.displayQueue();
    }
}