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
            { "S110", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S111", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S112", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S113", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S114", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "S115", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" }
    };

    static String[][] deluxeRoom = {
            { "     ", "Day 1","Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Day 8", "Day 9", "Day 10" },
            { "D201", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D202", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D203", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D204", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D205", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D206", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D207", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D208", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D209", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "D210", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" }
    };

    static String[][] suiteRoom = {
            { "     ", "Day 1","Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Day 8", "Day 9", "Day 10" },
            { "ST301", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST302", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST303", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST304", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" },
            { "ST305", "Free","Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free", "Free" }
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
                case 'B' -> makeReservation();
                case 'C' -> checkInGuest();
                case 'D' -> checkOutGuest();
                case 'E' -> thankYou();
            }

            loop();

        }
    }

    public static void checkRoomAvailability(){
        char checkRoomChoice = ' ';
        String RoomType = " ";
        int TotalRooms = 0, fee = 0;

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

        switch (checkRoomChoice) {
            case 'A' -> {
                RoomType = "Standard";
                TotalRooms = 15;
                fee = 2500;
            }
            case 'B' -> {
                RoomType = "Deluxe";
                TotalRooms = 10;
                fee = 4000;
            }
            case 'C' -> {
                RoomType = "Suite";
                TotalRooms = 5;
                fee = 8000;
            } 
        }

        System.out.println("Room Availability Status");
        System.out.println("Room Type: " + RoomType);
        System.out.println("Total Rooms: " + TotalRooms);
        System.out.println("Available Rooms: ");
        System.out.println("Price per Night: " + fee);
        System.out.println();

        displayRoom(checkRoomChoice);
    }

    public static void displayRoom(char room){
        String[][] arrRoom = null;

        switch (room) {
            case 'A' -> {
                arrRoom = standardRoom;
            }
            case 'B' -> {
                arrRoom = deluxeRoom;
            }
            case 'C' -> {
                arrRoom = suiteRoom;
            }
        }

        for (String[] row : arrRoom) {
            for (String col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }

    public static void makeReservation(){
        String room = null;
        String[][] arrRoom = null;

        int bookDay, bookTime, roomNum, fee, resFee = 0;

        boolean logic = true;

        System.out.println("""
                               Please choose a room to reserve:
                                    A. Standard Room
                                    B. Deluxe Room
                                    C. Suite Room
                               """);

        char roomType = sc.nextLine().toUpperCase().charAt(0);
        
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
            default -> {
                System.out.println("Invalid room type selected! ");
                return;
            }
        }

        System.out.println("You have selected " + room + "room");
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        do {
            System.out.print("Please input the day you would like to book: ");
            bookDay = Integer.parseInt(sc.nextLine());
            System.out.print("Please input how many days you would like to book: ");
            bookTime = Integer.parseInt(sc.nextLine());

            if (bookTime > 11 - bookDay || bookTime < 0 || bookDay < 0) {
                logic = false;
                invalidChoice();
            }
        } while (!logic);
        
        System.out.print("Please input the last number of the room you would like to book: ");
        roomNum = Integer.parseInt(sc.nextLine());

        resFee = fee * bookTime;

        hrLine();

        System.out.println("Reservation Summary");
        System.out.println("Guest Name: " + name);
        System.out.println("Room Type: " + room);
        System.out.println("Room number assigned: " + arrRoom[roomNum][0]);
        System.out.println("Nights booked: " + bookTime);
        System.out.println("Total Reservation Fee (Due Now): " + resFee);
        System.out.println();

        arrRoom[roomNum][bookDay] = name;

        for (int book = 1; book < bookTime; book++) {
            arrRoom[roomNum][bookDay + book] = name;
        }

        for (String[] row : arrRoom) {
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

    public static void checkInGuest() {
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
                displayRoom(roomType);
                break;

            case 'B':
                chosenRooms = deluxeRoom;
                roomLabel = "Deluxe Room";
                roomRate = 4000.00;
                System.out.println("You have selected Deluxe Room. Rate per night: " + roomRate);
                displayRoom(roomType);
                break;

            case 'C':
                chosenRooms = suiteRoom;
                roomLabel = "Suite Room";
                roomRate = 8000.00;
                System.out.println("You have selected Suite Room. Rate per night: " + roomRate);
                displayRoom(roomType);
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

    public static void checkOutGuest() {
        String[][] arrRoom = null;
        System.out.print("Please select your room type: ");
        System.out.println("A. Standard Room");
        System.out.println("B. Deluxe Room");
        System.out.println("C. Suite Room");
        char room = sc.nextLine().toUpperCase().charAt(0);
        System.out.print("Please input guest name: ");
        String name = sc.nextLine();

        int bookDays = 0;
        int fee = 0;
        int serFee = 250;
        int subFee = fee + serFee;
        double tax = 0.1 * subFee;
        double totalAmt = tax + subFee;
        String roomNum = null;

        switch(room) {
            case 'A' -> { 
                arrRoom = standardRoom;
                fee = 2500;
            }
            case 'B' -> {
                arrRoom = deluxeRoom;
                fee = 4000;
            }
            case 'C' -> {
                arrRoom = suiteRoom;
                fee = 8000;
            }
        }
        
        for (int row = 0; row < arrRoom.length; row++) {
            for (int col = 0; col < arrRoom[row].length; col++) {
                
                boolean check = arrRoom[row][col].equals(name);

                if (check) {
                    bookDays++;
                    roomNum = arrRoom[row][0];
                }
            }
        }

        hrLine();
        System.out.println("Bill Calculation");
        System.out.println("Subtotal (Room Rate Only): " + fee);
        System.out.println("Fixed Service Fee: " + serFee);
        System.out.println("Subtotal + fee: " + subFee);
        System.out.println("Tax (10%): " + tax);
        System.out.println("Total amount due: " + totalAmt);
        System.out.print("Input payment amount: ");
        double payment = Double.parseDouble(sc.nextLine());

        do { 
            if (payment < totalAmt) {
                System.out.println("Insufficient amount!");
                System.out.print("Please re-enter payment amount: ");
                payment = Double.parseDouble(sc.nextLine());
            } 

        } while (payment < totalAmt); 

        double change = payment - totalAmt;

        System.out.println("Change: " + change);

        System.out.println();
        System.out.println("Receipt");
        System.out.println("Guest: " + name + " | Room: " + roomNum);
        System.out.println("Total Amount Due: " + totalAmt);
        System.out.println("Amount Paid: " + payment);
        System.out.println("Change: " + change);
        System.out.println("Checkout complete. Room " + roomNum + " is now available.");

        for (int row = 0; row < arrRoom.length; row++) {
            for (int col = 0; col < arrRoom[row].length; col++) {
                
                boolean check = arrRoom[row][col].equals(name);

                if (check) {
                    arrRoom[row][col] = "Free";
                }
            }
        }

        displayRoom(room);
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
}
