import java.util.*;

// Room class (Domain Model)
class Room {
    private String type;
    private double price;
    private String amenities;

    public Room(String type, double price, String amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getAmenities() {
        return amenities;
    }

    public void displayRoomDetails(int available) {
        System.out.println("Room Type: " + type);
        System.out.println("Price: $" + price);
        System.out.println("Amenities: " + amenities);
        System.out.println("Available Rooms: " + available);
        System.out.println("-----------------------------");
    }
}

// Inventory class (State Holder)
class Inventory {
    private Map<String, Integer> availability = new HashMap<>();

    public Inventory() {
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 0);
    }

    public int getAvailability(String type) {
        return availability.getOrDefault(type, 0);
    }

    public Set<String> getRoomTypes() {
        return availability.keySet();
    }
}

// Search Service (Read-only Access)
class SearchService {
    private Inventory inventory;
    private Map<String, Room> rooms;

    public SearchService(Inventory inventory, Map<String, Room> rooms) {
        this.inventory = inventory;
        this.rooms = rooms;
    }

    public void searchRooms() {

        for (String type : inventory.getRoomTypes()) {

            int available = inventory.getAvailability(type);

            // Only show available rooms
            if (available > 0) {
                Room room = rooms.get(type);

                if (room != null) {
                    room.displayRoomDetails(available);
                }
            }
        }
    }
}

// Main Class
public class Usecase4 {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Map<String, Room> rooms = new HashMap<>();

        rooms.put("Single", new Room("Single", 100, "WiFi, TV"));
        rooms.put("Double", new Room("Double", 150, "WiFi, TV, AC"));
        rooms.put("Suite", new Room("Suite", 300, "WiFi, TV, AC, Mini Bar"));

        SearchService searchService = new SearchService(inventory, rooms);

        System.out.println("Available Rooms");
        System.out.println("================");

        searchService.searchRooms();
    }
}