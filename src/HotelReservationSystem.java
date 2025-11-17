import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char choice;

        String[][] standardRoom = { 
            { " ", "Day 1","Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Day 8", "Day 9", "Day 10" },
            { "S101", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S102", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S103", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S104", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S105", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S106", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S107", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S108", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S109", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S110", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" }
        };

        String[][] deluxeRoom = { 
            { " ", "Day 1","Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Day 8", "Day 9", "Day 10" },
            { "D101", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D102", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D103", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D104", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D105", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D106", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D107", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D108", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D109", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D110", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" }
        };

        String[][] suiteRoom = { 
            { " ", "Day 1","Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Day 8", "Day 9", "Day 10" },
            { "ST101", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST102", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST103", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST104", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST105", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST106", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST107", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST108", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST109", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST110", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" }
         };

        do {

        System.out.println("-----------------------------------------");
        System.out.println("Welcome to the Hotel Reservation System!");
        System.out.println("Please choose an option: ");
        System.out.println("A. Check Room Availability");
        System.out.println("B. Make New Reservation");
        System.out.println("C. Check-in Guest");
        System.out.println("D. Check-out Guest / Generate bill");
        System.out.println("E. Exit");
        System.out.print("Enter your choice here: ");
        choice = sc.nextLine().toUpperCase().charAt(0);
        System.out.println("-----------------------------------------");

        if (choice != 'A' && choice != 'B' && choice != 'C' && choice != 'D' && choice != 'E') {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 'A' && choice != 'B' && choice != 'C' && choice != 'D' && choice != 'E');

        switch (choice) {

            case 'A' -> {
                System.out.println("Please input the room type:");
                System.out.println("A. Standard");
                System.out.println("B. Deluxe");
                System.out.println("C. Suite");
                System.out.print("Enter your choice here: ");
                char checkRoom = sc.nextLine().toUpperCase().charAt(0);

                switch (checkRoom) {
                    case 'A' -> {
                        for (int rows = 0; rows < standardRoom.length; rows++) {
                            for (int col = 0; col < standardRoom[rows].length; col++) {
                                System.out.print(standardRoom[rows][col] + "\t");
                            }
                            System.out.println();
                        }
                    }
                    case 'B' -> {
                        
                    }
                    case 'C' -> {
                        
                    }
                }
            }
            case 'B' -> {
                newReservation();
            }
            case 'C' -> {
                checkInGuest();
            }
            case 'D' -> {
                checkOutGuest();
            }
            case 'E' -> {
                System.out.println("Thank you for using our Hotel Reservation System!");
                System.exit(0);
            }

        }
    }

    public static void checkStandardRoom(){
        
    }

    public static void checkDeluxeRoom(){
        
    }

    public static void checkSuiteRoom(){
        
    }

    public static void newReservation(){

    }

    public static void checkInGuest(){

    }

    public static void checkOutGuest(){

    }

}
