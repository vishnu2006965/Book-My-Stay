

// Abstract class representing a generic room
abstract class Room {

        protected String roomType;
        protected int beds;
        protected double size;
        protected double price;

        // Constructor
        public Room(String roomType, int beds, double size, double price) {
            this.roomType = roomType;
            this.beds = beds;
            this.size = size;
            this.price = price;
        }

        // Method to display room details
        public void displayRoomDetails() {
            System.out.println("Room Type: " + roomType);
            System.out.println("Beds: " + beds);
            System.out.println("Size: " + size + " sq ft");
            System.out.println("Price per night: $" + price);
        }
    }


    // Single Room class
    class SingleRoom extends Room {

        public SingleRoom() {
            super("Single Room", 1, 200, 100);
        }
    }


    // Double Room class
    class DoubleRoom extends Room {

        public DoubleRoom() {
            super("Double Room", 2, 350, 180);
        }
    }


    // Suite Room class
    class SuiteRoom extends Room {

        public SuiteRoom() {
            super("Suite Room", 3, 600, 350);
        }
    }


    // Main Application Class
    public class UseCase2 {

        public static void main(String[] args) {

            System.out.println("======================================");
            System.out.println(" Hotel Booking System - Version 2.1 ");
            System.out.println(" Basic Room Types & Availability ");
            System.out.println("======================================");

            // Create room objects (Polymorphism)
            Room singleRoom = new SingleRoom();
            Room doubleRoom = new DoubleRoom();
            Room suiteRoom = new SuiteRoom();

            // Static availability variables
            int singleRoomAvailable = 5;
            int doubleRoomAvailable = 3;
            int suiteRoomAvailable = 2;

            // Display Single Room details
            System.out.println("\n--- Single Room ---");
            singleRoom.displayRoomDetails();
            System.out.println("Available Rooms: " + singleRoomAvailable);

            // Display Double Room details
            System.out.println("\n--- Double Room ---");
            doubleRoom.displayRoomDetails();
            System.out.println("Available Rooms: " + doubleRoomAvailable);

            // Display Suite Room details
            System.out.println("\n--- Suite Room ---");
            suiteRoom.displayRoomDetails();
            System.out.println("Available Rooms: " + suiteRoomAvailable);

            System.out.println("\nApplication execution completed.");
        }
    }

