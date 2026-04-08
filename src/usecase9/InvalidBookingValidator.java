package usecase9;

import java.util.HashMap;
import java.util.Map;

/**
 * Validates booking inputs and inventory constraints.
 */
public class InvalidBookingValidator {

    private Map<String, Integer> inventory;

    public InvalidBookingValidator() {
        inventory = new HashMap<>();

        inventory.put("Single", 2);
        inventory.put("Double", 2);
        inventory.put("Suite", 1);
    }

    public void validateBooking(String roomType) throws InvalidBookingException {

        // Validate room type exists
        if (!inventory.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid Room Type: " + roomType);
        }

        // Validate inventory available
        if (inventory.get(roomType) <= 0) {
            throw new InvalidBookingException("No Available Rooms for: " + roomType);
        }

        // Reduce inventory after valid booking
        inventory.put(roomType, inventory.get(roomType) - 1);

        System.out.println("Booking Confirmed for " + roomType);
    }
}