package usecase12;

import java.io.*;

/**
 * Handles saving and loading system state.
 */
public class PersistenceService {

    private static final String FILE_NAME =
            "hotel_system_state.dat";

    // Save state to file
    public void saveState(SystemState state) {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            output.writeObject(state);

            System.out.println("System state saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving system state.");
        }
    }

    // Load state from file
    public SystemState loadState() {

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            System.out.println("System state restored successfully.");

            return (SystemState) input.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println(
                    "No saved data found or file corrupted."
            );

            return null;
        }
    }
}