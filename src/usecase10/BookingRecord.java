package usecase10;

/**
 * Represents a confirmed booking.
 */
public class BookingRecord {

    private String reservationId;
    private String roomType;
    private String roomId;
    private boolean active;

    public BookingRecord(String reservationId, String roomType, String roomId) {
        this.reservationId = reservationId;
        this.roomType = roomType;
        this.roomId = roomId;
        this.active = true;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomId() {
        return roomId;
    }

    public boolean isActive() {
        return active;
    }

    public void cancel() {
        active = false;
    }
}