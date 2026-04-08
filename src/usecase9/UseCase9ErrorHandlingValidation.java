package usecase9;

/**
 * Use Case 9:
 * Error Handling & Validation
 */
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        InvalidBookingValidator validator = new InvalidBookingValidator();

        try {

            validator.validateBooking("Suite");
            validator.validateBooking("Suite"); // should fail
            validator.validateBooking("Luxury"); // invalid type

        } catch (InvalidBookingException e) {

            System.out.println("Booking Failed: " + e.getMessage());
        }

        System.out.println("System continues running safely.");
    }
}