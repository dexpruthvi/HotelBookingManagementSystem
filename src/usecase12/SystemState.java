package usecase12;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Represents the complete system state.
 */
public class SystemState implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> bookingHistory;
    private Map<String, Integer> inventory;

    public SystemState(List<String> bookingHistory,
                       Map<String, Integer> inventory) {

        this.bookingHistory = bookingHistory;
        this.inventory = inventory;
    }

    public List<String> getBookingHistory() {
        return bookingHistory;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}