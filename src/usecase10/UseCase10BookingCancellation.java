package usecase10;

/**
 * Use Case 10:
 * Booking Cancellation & Inventory Rollback
 */
public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        CancellationService service = new CancellationService();

        BookingRecord booking1 =
                new BookingRecord("RES101", "Suite", "SUITE-001");

        service.addBooking(booking1);

        service.cancelBooking("RES101");

        service.displayInventory();

        service.cancelBooking("RES101"); // already cancelled

        service.cancelBooking("RES999"); // doesn't exist
    }
}