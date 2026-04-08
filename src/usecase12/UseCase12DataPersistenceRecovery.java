package usecase12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Use Case 12:
 * Data Persistence & System Recovery
 */
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        PersistenceService service =
                new PersistenceService();

        // Create sample booking + inventory
        List<String> bookings =
                new ArrayList<>();

        bookings.add("RES101 - John");
        bookings.add("RES102 - Alice");

        Map<String, Integer> inventory =
                new HashMap<>();

        inventory.put("Single", 2);
        inventory.put("Double", 1);
        inventory.put("Suite", 0);

        // Save system state
        SystemState state =
                new SystemState(bookings, inventory);

        service.saveState(state);

        // Simulate restart and recovery
        SystemState recoveredState =
                service.loadState();

        if (recoveredState != null) {

            System.out.println(
                    "Recovered Booking History: "
                            + recoveredState.getBookingHistory());

            System.out.println(
                    "Recovered Inventory: "
                            + recoveredState.getInventory());
        }
    }
}