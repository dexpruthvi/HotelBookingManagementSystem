package usecase5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages booking requests using FIFO queue
 */
public class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add request
    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Request added:");
        reservation.displayReservation();
    }

    // Display all requests
    public void displayQueue() {
        System.out.println("\n===== Booking Requests (FIFO Order) =====");

        for (Reservation r : queue) {
            r.displayReservation();
        }
    }
}