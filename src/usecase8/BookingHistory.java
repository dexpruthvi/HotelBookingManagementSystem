package usecase8;

import java.util.ArrayList;
import java.util.List;

/**
 * Maintains booking history in insertion order.
 */
public class BookingHistory {

    private List<String> confirmedBookings;

    public BookingHistory() {
        confirmedBookings = new ArrayList<>();
    }

    // Add confirmed booking to history
    public void addBooking(String reservation) {
        confirmedBookings.add(reservation);
    }

    // Retrieve all bookings
    public List<String> getBookingHistory() {
        return confirmedBookings;
    }
}