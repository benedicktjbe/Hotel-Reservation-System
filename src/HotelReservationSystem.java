import java.util.Scanner;

public class HotelReservationSystem {
    static String[][] standardRoom = {
            { "     ", "Day 1","Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Day 8", "Day 9", "Day 10" },
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

    static String[][] deluxeRoom = {
            { "     ", "Day 1","Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Day 8", "Day 9", "Day 10" },
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

    static String[][] suiteRoom = {
            { "     ", "Day 1","Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Day 8", "Day 9", "Day 10" },
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

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char choice = ' ';

        while (true) {

            hrLine();

            System.out.println("""
                               Welcome to the Hotel Reservation System!
                               Please choose an option:
                                    A. Check Room Availability
                                    B. Make New Reservation
                                    C. Check-in Guest
                                    D. Check-out Guest / Generate bill
                                    E. Exit
                               """);

            do {
                System.out.print("Enter your choice here: ");
                choice = sc.nextLine().toUpperCase().charAt(0);

                if ("ABCDE".indexOf(choice) == -1) {
                        invalidChoice();
                } 

            } while ("ABCDE".indexOf(choice) == -1);

            switch (choice) {
                case 'A' -> checkRoomAvailability();
                case 'B' -> {
                    System.out.println("""
                               Please choose a room to reserve:
                                    A. Standard Room
                                    B. Deluxe Room
                                    C. Suite Room
                               """);
                    char roomType = sc.nextLine().toUpperCase().charAt(0);
                    
                    makeReservation(roomType);
                } 
                case 'C' -> checkInGuest();
                case 'D' -> checkOutGuest();
                case 'E' -> thankYou();
            }

            loop();

        }
    }

    public static void checkRoomAvailability(){
        char checkRoomChoice = ' ';
        char checkRoom = ' ';

        hrLine();
        System.out.println("""
                            Please input the room type:
                                A. Standard
                                B. Deluxe
                                C. Suite
                            """);

        do {
            System.out.print("Enter your choice here: ");
            checkRoomChoice = sc.nextLine().toUpperCase().charAt(0);

            
            if ("ABC".indexOf(checkRoomChoice) == -1) {
                invalidChoice();
            } 

        } while ("ABC".indexOf(checkRoomChoice) == -1);

        hrLine();

        switch (checkRoom) {
            case 'A' -> displayRoom(standardRoom);
            case 'B' -> displayRoom(deluxeRoom);
            case 'C' -> displayRoom(suiteRoom);
        }
    }

    public static void displayRoom(String[][] displayRoom){
        for (String[] rows : displayRoom) {
            for (String col : rows) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }

    public static void makeReservation(char roomType){
        String room = " ";
        String[][] arrRoom = null;

        int fee = 0;
        
        switch (roomType) {
            case 'A' -> {
                room = "Standard";
                arrRoom = standardRoom;
                fee = 2500;
            }
            case 'B' -> {
                room = "Deluxe";
                arrRoom = deluxeRoom;
                fee = 4000;
            }
            case 'C' -> {
                room = "Suite";
                arrRoom = suiteRoom;
                fee = 8000;
            }
        }

        System.out.println("You have selected " + room + "room");
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        System.out.print("Please input the day you would like to book (1-10): ");
        int bookDay = Integer.parseInt(sc.nextLine());
        System.out.print("Please input how many days you would like to book: ");
        int bookTime = Integer.parseInt(sc.nextLine());
        System.out.print("Please input the last number of the room you would like to book: ");
        int roomNum = Integer.parseInt(sc.nextLine());

        int resFee = fee * bookTime;

        hrLine();

        System.out.println("Reservation Summary");
        System.out.println("Guest Name: " + name);
        System.out.println("Room Type: " + room);
        System.out.println("Room number assigned: " + arrRoom[roomNum][0]);
        System.out.println("Nights booked: " + bookTime);
        System.out.println("Total Reservation Fee (Due Now): " + resFee);
        System.out.println();

        arrRoom[roomNum][bookDay] = "Booked";

        for (int book = 1; book < bookTime; book++) {
            arrRoom[roomNum][bookDay + 1] = "Booked";
        }

        for (String[] row : standardRoom) {
            for (String col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
        
        System.out.println("Booking Successful!");
    }

    public static void hrLine(){
        System.out.println("-----------------------------------------");
    }

    public static void invalidChoice(){
        hrLine();
        System.out.println("Invalid choice. Please try again.");
        hrLine();
    }

    public static void thankYou(){
        hrLine();
        System.out.println("Thank you for using our Hotel Reservation System!");
        hrLine();
        System.exit(0);
    }

    public static void loop(){
        String temploopchoice;
        char loopchoice = ' ';

        do {
            hrLine();
            System.out.print("Run System Again? (Y/N): ");

            temploopchoice = sc.nextLine();

            if (temploopchoice.length() == 1) {
                loopchoice = temploopchoice.toUpperCase().charAt(0);

                if (loopchoice != 'Y' && loopchoice != 'N') {
                    invalidChoice();
                }
            } else {
                invalidChoice();
            }
        } while (loopchoice != 'Y' && loopchoice != 'N');

        if (loopchoice == 'N'){
            thankYou();
        }
    }

    private static void checkInGuest() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void checkOutGuest() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
