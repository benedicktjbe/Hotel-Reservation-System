import java.util.Scanner;

public class HotelReservationSystem {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String tempchoice;
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
                tempchoice = sc.nextLine();

                if (tempchoice.length() == 1) {
                    choice = tempchoice.toUpperCase().charAt(0);

                    if (choice != 'A' && choice != 'B' && choice != 'C' && choice != 'D' && choice != 'E') {
                        invalidChoice();
                    }
                } else {
                    invalidChoice();
                }
            } while (choice != 'A' && choice != 'B' && choice != 'C' && choice != 'D' && choice != 'E');

            switch (choice) {
                case 'A' -> checkRoomAvailability();
                case 'B' -> newReservation();
                case 'C' -> checkInGuest();
                case 'D' -> checkOutGuest();
                case 'E' -> thankYou();
            }

            loop();
        }
    }

    public static String[][] standardRoom = {
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

    public static String[][] deluxeRoom = {
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

    public static String[][] suiteRoom = {
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

    public static void checkRoomAvailability(){
        String tempcheckRoom;
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
            tempcheckRoom = sc.nextLine();

            if (tempcheckRoom.length() == 1) {
                checkRoom = tempcheckRoom.toUpperCase().charAt(0);
                if (checkRoom != 'A' && checkRoom != 'B' && checkRoom != 'C') {
                    invalidChoice();
                }
            } else {
                invalidChoice();
            }
        } while (checkRoom != 'A' && checkRoom != 'B' && checkRoom != 'C');

        hrLine();

        switch (checkRoom) {
            case 'A' -> displayRoom(standardRoom);
            case 'B' -> displayRoom(deluxeRoom);
            case 'C' -> displayRoom(suiteRoom);
        }
    }

    public static void displayRoom(String[][] displayRoom){
        for (int rows = 0; rows < displayRoom.length; rows++) {
            for (int col = 0; col < displayRoom[rows].length; col++) {
                System.out.print(displayRoom[rows][col] + "\t");
            }
            System.out.println();
        }
    }

    public static void newReservation(){
        char roomType = ' ';
        String guestName = "";
        double resvFee = 0.0;
        double userPayment = 0.0;
        double change = 0.0;
        double totalRFee = 0.0;
        int bookedNights = 0;

        System.out.println("\n--- Make New Reservation ---\n");
        System.out.print("Enter Guest Name: ");
        guestName = sc.nextLine();

        hrLine();
        System.out.println("""
                            Please input the room type:
                                A. Standard
                                B. Deluxe
                                C. Suite
                            """);
        do {
            System.out.print("Enter your choice here: ");
            String typeInput = sc.nextLine();
            if (typeInput.length() == 1) {
                roomType = typeInput.toUpperCase().charAt(0);
            }
            if (roomType != 'A' && roomType != 'B' && roomType != 'C') {
                invalidChoice();
            }
        } while (roomType != 'A' && roomType != 'B' && roomType != 'C');

        String[][] chosenRooms = null;
        String roomLabel = "";

        switch (roomType) {
            case 'A': {
                System.out.println("You have selected Standard Room. Reservation Fee: 2500");
                displayRoom(standardRoom);
                resvFee = 2500.00;
                chosenRooms = standardRoom;
                roomLabel = "Standard Room";
                break;
            }

            case 'B':
                System.out.println("You have selected Deluxe Room.");
                displayRoom(deluxeRoom);
                resvFee = 4000.00;
                chosenRooms = deluxeRoom;
                roomLabel = "Deluxe Room";
                break;


            case 'C':
                System.out.println("You have selected Suite Room.");
                displayRoom(suiteRoom);
                resvFee = 8000.00;
                chosenRooms = suiteRoom;
                roomLabel = "Suite Room";
                break;

            default: {
                invalidChoice();
                return;
            }
        }

        bookedNights = nightValidator();
        int startDay = dayValidator(bookedNights);
        int roomRow = findAvailableRoomRow(chosenRooms, startDay, bookedNights);

        if (roomRow == -1) {
            System.out.println("No " + roomLabel + " available for those dates.");
            return;
        }

        totalRFee = resvFee*bookedNights;

        System.out.println("Fee: " + totalRFee);
        userPayment = readPayment(totalRFee);

        change = userPayment - totalRFee;
        markBooking(chosenRooms, roomRow, startDay, bookedNights, guestName);

        System.out.println("\n --- Reservation Booked ---");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomLabel);
        System.out.println("Room No.: " + chosenRooms[roomRow][0]);
        System.out.println("Stay: Day " + startDay + " to Day " + (startDay + bookedNights));
        System.out.println("Total Reservation Fee: " + totalRFee);
        System.out.println("Change: " + change);
    }

    public static boolean isWholeNumber(String input){
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int nightValidator(){
        int nights = 0;
        while (nights <= 0 || nights > 10) {
            System.out.print("Enter number of nights booked (1-10): ");
            String input = sc.nextLine();
            if (isWholeNumber(input)) {
                nights = Integer.parseInt(input);
            }
            if (nights <= 0 || nights > 10) {
                System.out.println("Please enter between 1 and 10 nights.");
            }
        }
        return nights;
    }

    public static int dayValidator(int nights) {
        int startDay = 0;

        while (startDay < 1 || startDay > 10) {
            System.out.print("Enter starting day (1-10): ");
            String input = sc.nextLine();

            if (isWholeNumber(input)) {
                startDay = Integer.parseInt(input);
            }

            if (startDay < 1 || startDay > 10) {
                System.out.println("Please enter a number between 1 and 10.");
            }
        }

        return startDay;
    }

    public static int findAvailableRoomRow(String[][] rooms, int startDay, int nights){
        for (int row = 1; row < rooms.length; row++) {
            boolean free = true;
            for (int day = startDay; day < startDay + nights; day++) {
                if (!rooms[row][day].equalsIgnoreCase("Free")) {
                    free = false;
                    break;
                }
            }
            if (free) {
                return row;
            }
        }
        return -1;
    }

    public static void markBooking(String[][] rooms, int row, int startDay, int nights, String guestName){
        for (int day = startDay; day < startDay + nights; day++) {
            rooms[row][day] = "Booked";
        }
    }

    public static double readPayment(double due){
        double pay = -1;
        while (pay < due) {
            System.out.print("Enter payment: ");
            String input = sc.nextLine();
            pay = Double.parseDouble(input);
            if (pay < due) {
                System.out.println("Payment is insufficient. Amount due: " + due);
            }
        }
        return pay;
    }

    public static void checkInGuest(){
        char roomType = ' ';
        String guestName = "";
        String roomNumber = "";
        double roomRate = 0.0;
        double userPayment = 0.0;
        double change = 0.0;

        System.out.println("\n--- Check-In Guest (Walk-in) ---\n");
        System.out.print("Enter Guest Name: ");
        guestName = sc.nextLine();

        hrLine();
        System.out.println("""
                        Please input the room type:
                            A. Standard
                            B. Deluxe
                            C. Suite
                        """);

        do {
            System.out.print("Enter your choice here: ");
            String typeInput = sc.nextLine();

            if (typeInput.length() == 1) {
                roomType = typeInput.toUpperCase().charAt(0);
            }
            if (roomType != 'A' && roomType != 'B' && roomType != 'C') {
                invalidChoice();
            }

        } while (roomType != 'A' && roomType != 'B' && roomType != 'C');

        String[][] chosenRooms = null;
        String roomLabel = "";

        switch (roomType) {
            case 'A':
                chosenRooms = standardRoom;
                roomLabel = "Standard Room";
                roomRate = 2500.00;
                System.out.println("You have selected Standard Room. Rate per night: " + roomRate);
                displayRoom(standardRoom);
                break;

            case 'B':
                chosenRooms = deluxeRoom;
                roomLabel = "Deluxe Room";
                roomRate = 4000.00;
                System.out.println("You have selected Deluxe Room. Rate per night: " + roomRate);
                displayRoom(deluxeRoom);
                break;

            case 'C':
                chosenRooms = suiteRoom;
                roomLabel = "Suite Room";
                roomRate = 8000.00;
                System.out.println("You have selected Suite Room. Rate per night: " + roomRate);
                displayRoom(suiteRoom);
                break;
        }

        System.out.print("\nEnter Room Number: ");
        roomNumber = sc.nextLine().toUpperCase();

        int roomRow = -1;
        for (int row = 1; row < chosenRooms.length; row++) {
            if (chosenRooms[row][0].equalsIgnoreCase(roomNumber)) {
                roomRow = row;
                break;
            }
        }
        int bookedNights = nightValidator();
        int startDay = dayValidator(bookedNights);
        roomRow = findAvailableRoomRow(chosenRooms, startDay, bookedNights);

        if (roomRow == -1) {
            System.out.println("Invalid room number for " + roomLabel + ".");
            return;
        }

        if (!chosenRooms[roomRow][1].equalsIgnoreCase("Free")) {
            System.out.println("Room " + roomNumber + " is not available. Current status: " + chosenRooms[roomRow][1]);
            return;
        }

        System.out.println("\nTotal Fee: " + roomRate*bookedNights);
        userPayment = readPayment(roomRate);
        change = userPayment - roomRate;

        hrLine();
        System.out.println("\n--- Check-In Successful ---");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room No.: " + roomNumber);
        System.out.println("Stay: Day " + startDay + " to Day " + (startDay + bookedNights));
        System.out.println("Room Type: " + roomLabel);
        System.out.println("Payment Received: " + userPayment);
        System.out.println("Change: " + change);
        chosenRooms[roomRow][1] = "Occupied";

    }

    public static void checkOutGuest(){

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
}