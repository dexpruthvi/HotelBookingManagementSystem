package usecase8;

/**
 * Use Case 8:
 * Booking History & Reporting
 */
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        // Simulating confirmed bookings
        history.addBooking("RES101 - Deluxe Room - John");
        history.addBooking("RES102 - Suite Room - Alice");
        history.addBooking("RES103 - Single Room - Bob");

        BookingReportService reportService = new BookingReportService();

        // Generate report
        reportService.generateReport(history.getBookingHistory());
    }
}