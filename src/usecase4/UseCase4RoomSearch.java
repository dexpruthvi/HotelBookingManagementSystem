package usecase4;

import usecase3.RoomInventory;

/**
  Use Case 4: Room Search & Availability Check
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        RoomSearchService service = new RoomSearchService(inventory);

        service.searchAvailableRooms();
    }
}