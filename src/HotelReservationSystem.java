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

    static String[][] chosenRoom = new String[0][];

    static Scanner sc = new Scanner(System.in);

    static boolean loop = true;

    public static void main(String[] args) {
        int choiceType = 0, msgType = 0;
        char choice;

        while (loop) {
            hrLine();
            msgSelect(msgType);
            choice = inputChar(choiceType,"Enter your choice here: ");

            switch (choice) {
                case 'A' -> checkRoomAvailability();
                case 'B' -> makeReservation();
                case 'C' -> checkInGuest();
                case 'D' -> checkOutGuest();
                case 'E' -> thankYou();
            }
            hrLine();
            loop();
        }
    }

    public static void checkRoomAvailability(){
        int choiceType = 1, msgType = 1, TotalRooms = 0, PricePerNight = 0;
        char roomType;
        String RoomType = "";

        hrLine();
        msgSelect(msgType);
        roomType = inputChar(choiceType,"Enter your choice here: ");
        hrLine();

        switch (roomType) {
            case 'A' -> {
                RoomType = "Standard";
                TotalRooms = 15;
                PricePerNight = 2500;
            }
            case 'B' -> {
                RoomType = "Deluxe";
                TotalRooms = 10;
                PricePerNight = 4000;
            }
            case 'C' -> {
                RoomType = "Suite";
                TotalRooms = 5;
                PricePerNight = 8000;
            }
        }

        System.out.println("Room Availability Status");
        System.out.println("Room Type: " + RoomType);
        System.out.println("Total Rooms: " + TotalRooms);
        System.out.println("Available Rooms: ");
        System.out.println("Price per Night: ₱" + PricePerNight);

        displayRoom(roomType);
    }

    public static void displayRoom(char room){
        switch (room) {
            case 'A' -> chosenRoom = standardRoom;
            case 'B' -> chosenRoom = deluxeRoom;
            case 'C' -> chosenRoom = suiteRoom;
        }

        for (String[] row : chosenRoom) {
            for (String col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }

    public static void makeReservation(){
        int choiceType = 1, msgType = 2, roomMax = 0, bookDay, bookTime, roomNum, fee = 0, resFee;
        char roomType;
        String guestName, room = "";

        hrLine();
        msgSelect(msgType);
        roomType = inputChar(choiceType,"Enter your choice here: ");

        switch (roomType) {
            case 'A' -> {
                room = "Standard";
                chosenRoom = standardRoom;
                fee = 2500;
                roomMax = 15;
            }
            case 'B' -> {
                room = "Deluxe";
                chosenRoom = deluxeRoom;
                fee = 4000;
                roomMax = 10;
            }
            case 'C' -> {
                room = "Suite";
                chosenRoom = suiteRoom;
                fee = 8000;
                roomMax = 5;
            }
        }

        hrLine();
        System.out.println("You have selected " + room + " room");
        hrLine();
        guestName = inputName();
        bookDay = inputNum(1,10,"Please input the day you would like to book (1-10): ");
        bookTime = inputNum(1,10,"Please input how many days you would like to book: ");
        roomNum = inputNum(1,roomMax,"Please input the last number of the room you would like to book: ");

        resFee = fee * bookTime;

        hrLine();
        System.out.println("Reservation Summary");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + room);
        System.out.println("Room number assigned: " + chosenRoom[roomNum][0]);
        System.out.println("Nights booked: " + bookTime);
        System.out.println("Total Reservation Fee (Due Now): ₱" + resFee);
        hrLine();

        chosenRoom[roomNum][bookDay] = guestName;

        for (int book = 1; book < bookTime; book++) {
            chosenRoom[roomNum][bookDay + book] = guestName;
        }

        displayRoom(roomType);

        hrLine();
        System.out.println("Booking Successful!");
    }

    public static void checkInGuest() {
        int choiceType = 1, msgType = 1, roomNum, roomMax = 0, roomRow = -1, bookedNights, startDay;
        double roomRate = 0, fee, userPayment, change;
        char roomType;
        String guestName, roomLabel = "", roomLetter = "", roomCode;

        System.out.println("--- Check-In Guest (Walk-in) ---");

        guestName = inputName();

        hrLine();
        msgSelect(msgType);

        roomType = inputChar(choiceType,"Enter your choice here: ");

        switch (roomType) {
            case 'A' -> {
                chosenRoom = standardRoom;
                roomLabel = "Standard Room";
                roomLetter = "S1";
                roomRate = 2500;
                roomMax = 15;
            }

            case 'B'-> {
                chosenRoom = deluxeRoom;
                roomLabel = "Deluxe Room";
                roomLetter = "D2";
                roomRate = 4000;
                roomMax = 10;
            }

            case 'C' -> {
                chosenRoom = suiteRoom;
                roomLabel = "Suite Room";
                roomLetter = "ST3";
                roomRate = 8000;
                roomMax = 5;
            }
        }

        hrLine();
        System.out.println("You have selected " + roomLabel + ". Rate per night: ₱" + roomRate);
        displayRoom(roomType);
        hrLine();

        roomNum = inputNum(1,roomMax,"Enter Room Number: ");

        roomCode = roomCode(roomLetter, roomNum);

        for (int row = 1; row < chosenRoom.length; row++) {
            if (chosenRoom[row][0].equalsIgnoreCase(roomCode)) {
                roomRow = row;
                break;
            }
        }

        bookedNights = nightValidator();
        startDay = dayValidator(bookedNights);
        roomRow = findAvailableRoomRow(chosenRoom, startDay, bookedNights);

        if (roomRow == -1) {
            System.out.println("Invalid room number for " + roomLabel + ".");
            return;
        }

        if (!chosenRoom[roomRow][1].equalsIgnoreCase("Free")) {
            System.out.println("Room " + roomCode + " is not available. Current status: " + chosenRoom[roomRow][1]);
            return;
        }

        hrLine();
        fee = roomRate*bookedNights;
        System.out.println("Total Fee: " + fee);

        userPayment = inputPayment(fee);
        change = userPayment - roomRate;

        System.out.println("--- Check-In Successful ---");

        System.out.println("Guest Name: " + guestName);
        System.out.println("Room No.: " + roomCode);
        System.out.println("Stay: Day " + startDay + " to Day " + (startDay + bookedNights));
        System.out.println("Room Type: " + roomLabel);
        System.out.println("Payment Received: ₱" + userPayment);
        System.out.println("Change: ₱" + change);
        chosenRoom[roomRow][1] = "Occupied";
    }

    public static void checkOutGuest() {
        int choiceType = 1, msgType = 1, bookDays = 0, fee = 0, serFee = 250, subFee = fee + serFee;
        double tax = 0.1 * subFee, totalAmt = tax + subFee, payment, change;
        char roomType;
        String guestName, roomCode = "";

        hrLine();
        msgSelect(msgType);

        roomType = inputChar(choiceType,"Enter your choice here: ");

        guestName = inputName();

        switch(roomType) {
            case 'A' -> {
                chosenRoom = standardRoom;
                fee = 2500;
            }
            case 'B' -> {
                chosenRoom = deluxeRoom;
                fee = 4000;
            }
            case 'C' -> {
                chosenRoom = suiteRoom;
                fee = 8000;
            }
        }

        for (int row = 0; row < chosenRoom.length; row++) {
            for (int col = 0; col < chosenRoom[row].length; col++) {

                boolean check = chosenRoom[row][col].equals(guestName);

                if (check) {
                    bookDays++;
                    roomCode = chosenRoom[row][0];
                }
            }
        }

        System.out.println("--- Bill Calculation ---");
        System.out.println("Subtotal (Room Rate Only): ₱" + fee);
        System.out.println("Fixed Service Fee: ₱" + serFee);
        System.out.println("Subtotal + fee: ₱" + subFee);
        System.out.println("Tax (10%): ₱" + tax);
        System.out.println("Total amount due: ₱" + totalAmt);

        payment = inputPayment(totalAmt);

        change = payment - totalAmt;

        displayRoom(roomType);

        System.out.println("--- Receipt ---");
        System.out.println("Guest: " + guestName + " | Room: " + roomCode);
        System.out.println("Total Amount Due: ₱" + totalAmt);
        System.out.println("Amount Paid: ₱" + payment);
        System.out.println("Change: ₱" + change);
        System.out.println("Checkout complete. Room " + roomCode + " is now available.");

        for (int row = 0; row < chosenRoom.length; row++) {
            for (int col = 0; col < chosenRoom[row].length; col++) {

                boolean check = chosenRoom[row][col].equals(guestName);

                if (check) {
                    chosenRoom[row][col] = "Free";
                }
            }
        }
    }

    static void hrLine(){
        System.out.println("-----------------------------------------");
    }

    static void msgSelect(int msgType){
        switch (msgType){
            case 0 ->
                System.out.println("""
                        Welcome to the Hotel Reservation System!
                        Please choose an option:
                            A. Check Room Availability
                            B. Make New Reservation
                            C. Check-in Guest
                            D. Check-out Guest / Generate bill
                            E. Exit
                        """);
            case 1 -> {
                System.out.println("Please input the room type:");
                System.out.println("""
                            A. Standard Room
                            B. Deluxe Room
                            C. Suite Room
                        """);
            }
            case 2 -> {
                System.out.println("Please choose a room to reserve:");
                System.out.println("""
                            A. Standard Room
                            B. Deluxe Room
                            C. Suite Room
                        """);
            }
        }
    }

    static String choiceType(int type){
        String[] choices = new String[]{"ABCDE", "ABC", "YN"};
        return choices[type];
    }

    public static char inputChar(int type, String msg){
        char out = ' ';

        do {
            System.out.print(msg);
            String input = sc.nextLine();

            if (input.length() == 1) {
                out = input.toUpperCase().charAt(0);

                if (choiceType(type).indexOf(out) == -1) {
                    invalidInput();
                }
            } else {
                invalidInput();
            }
        } while (choiceType(type).indexOf(out) == -1);
        return out;
    }

    static boolean numCondition(int num, int min, int max){
        return (num < min || num > max);
    }

    public static int inputNum(int min, int max, String msg){
        int num = 0;

        do {
            System.out.print(msg);
            String input = sc.nextLine();

            if (input.matches("\\d+")) {
                num = Integer.parseInt(input);

                if (numCondition(num, min, max)) {
                    invalidInput();
                }
            } else {
                invalidInput();
            }
        } while (numCondition(num, min, max));
        return num;
    }

    static boolean paymentCondition(double pay, double due){
        return (pay < due);
    }

    public static double inputPayment(double due){
        double pay = 0;

        hrLine();

        do {
            System.out.print("Input payment amount: ₱");
            String input = sc.nextLine();

            if (input.matches("\\d+(.\\d+)?")) {
                pay = Double.parseDouble(input);

                if (paymentCondition(pay,due)) {
                    invalidPayment(due);
                }
            } else {
                invalidInput();
            }
        } while (paymentCondition(pay,due));
        return pay;
    }

    static String inputName(){
        String guestName;

        System.out.print("Please input the guest's name: ");
        guestName = sc.nextLine();

        while (guestName.length() < 4){
            guestName = guestName+" ";
        }

        return guestName;
    }

    static String roomCode(String roomLetter, int roomNumber){
        String roomExtra = "";

        if (roomNumber < 10){
            roomExtra = "0";
        }

        return roomLetter+roomExtra+roomNumber;
    }

    static void invalidInput(){
        textBanner("Invalid input. Please try again.");
    }

    static void invalidPayment(double due){
        textBanner("Payment is insufficient. Amount due: ₱" + due);
    }

    static void thankYou(){
        textBanner("Thank you for using our Hotel Reservation System!");
        loop = false;
        System.exit(0);
    }

    static void textBanner(String msg){
        hrLine();
        System.out.println(msg);
        hrLine();
    }

    static void loop(){
        char loopChoice;
        int choiceType = 2;

        loopChoice = inputChar(choiceType,"Run System Again? (Y/N): ");

        if (loopChoice == 'N'){
            thankYou();
        }
    }

    public static int nightValidator(){
        return inputNum(1,10,"Enter number of nights booked (1-10): ");
    }

    public static int dayValidator(int nights) {
        return inputNum(1,10,"Enter starting day (1-10): ");
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
}