import java.util.HashMap;
import java.util.Map;

/**
 * Hotel Booking Management System
 * Use Case 3: Centralized Room Inventory Management
 *
 * Demonstrates how a HashMap can be used to centralize
 * room availability management in a scalable way.
 *
 * @author Vishnu
 * @version 3.1
 */

/* RoomInventory class manages room availability */
class RoomInventory {

    // HashMap to store room type and available count
    private HashMap<String, Integer> inventory;

    // Constructor initializes inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        // Register room types with availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Method to get availability of a room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Method to update availability
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Display complete inventory
    public void displayInventory() {
        System.out.println("\nCurrent Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " rooms available");
        }
    }
}


/* Main application class */
public class UseCase3 {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" Hotel Booking System - Version 3.1 ");
        System.out.println(" Centralized Room Inventory ");
        System.out.println("======================================");

        // Initialize inventory system
        RoomInventory inventory = new RoomInventory();

        // Display current inventory
        inventory.displayInventory();

        // Example availability lookup
        System.out.println("\nChecking availability for Single Room...");
        System.out.println("Available: " + inventory.getAvailability("Single Room"));

        // Update availability
        System.out.println("\nUpdating Single Room availability...");
        inventory.updateAvailability("Single Room", 4);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\nApplication execution completed.");
    }
}