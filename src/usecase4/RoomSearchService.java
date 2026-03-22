package usecase4;

import usecase2.*;
import usecase3.RoomInventory;

/**
 * Handles read-only room search functionality
 */
public class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms() {

        System.out.println("===== Available Rooms =====");

        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            if (available > 0) {
                room.displayRoomDetails();
                System.out.println("Available: " + available);
                System.out.println();
            }
        }
    }
}