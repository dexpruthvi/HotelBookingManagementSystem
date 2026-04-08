package usecase11;

/**
 * Use Case 11:
 * Concurrent Booking Simulation
 */
public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        ConcurrentBookingProcessor processor =
                new ConcurrentBookingProcessor();

        processor.addBookingRequest(
                new BookingRequest("John", "Suite"));

        processor.addBookingRequest(
                new BookingRequest("Alice", "Suite"));

        processor.addBookingRequest(
                new BookingRequest("Bob", "Single"));

        processor.addBookingRequest(
                new BookingRequest("David", "Double"));

        // Create multiple threads
        Thread t1 = new Thread(() -> processor.processBooking());
        Thread t2 = new Thread(() -> processor.processBooking());
        Thread t3 = new Thread(() -> processor.processBooking());
        Thread t4 = new Thread(() -> processor.processBooking());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        processor.displayInventory();
    }
}