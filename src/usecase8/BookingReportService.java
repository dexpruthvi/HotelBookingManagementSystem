package usecase8;

import java.util.List;

/**
 * Generates booking reports.
 */
public class BookingReportService {

    public void generateReport(List<String> bookings) {

        System.out.println("===== BOOKING HISTORY REPORT =====");

        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (int i = 0; i < bookings.size(); i++) {
            System.out.println((i + 1) + ". " + bookings.get(i));
        }

        System.out.println("Total Confirmed Bookings: " + bookings.size());
    }
}