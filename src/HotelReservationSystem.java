import java.util.Scanner;

public class HotelReservationSystem {
    static String[][] standardRoom = new String[16][11];
    static String[][] deluxeRoom = new String[11][11];
    static String[][] suiteRoom = new String[6][11];

    static String[][] chosenRoom = new String[0][];

    static Scanner sc = new Scanner(System.in);

    static boolean loop = true;

    public static void main(String[] args) {
        int choiceType = 0, msgType = 0;
        char choice;

        while (loop) {
            hrLine();
            msgSelect(msgType, "Welcome to the Hotel Reservation System!\nPlease choose an option:");
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
        int choiceType = 1, msgType = 1, TotalRooms = 0, roomFee = 0;
        char roomType;
        String roomLabel = "";

        hrLine();
        msgSelect(msgType, "Please input the room type:");
        roomType = inputChar(choiceType,"Enter your choice here: ");
        hrLine();

        switch (roomType) {
            case 'A' -> {
                roomLabel = "Standard";
                TotalRooms = 15;
                roomFee = 2500;
            }
            case 'B' -> {
                roomLabel = "Deluxe";
                TotalRooms = 10;
                roomFee = 4000;
            }
            case 'C' -> {
                roomLabel = "Suite";
                TotalRooms = 5;
                roomFee = 8000;
            }
        }

        displayRoom(roomType);
        hrLine();
        roomInfo("Room Availability Status","Room Type: "+roomLabel+";Total Rooms: "+TotalRooms+";Available Rooms: "+";Price per Night: ₱"+roomFee);
    }

    static void displayRoom(char room){
        String roomLetter = "";

        switch (room) {
            case 'A' -> {
                chosenRoom = standardRoom;
                roomLetter = "S1";
            }
            case 'B' -> {
                chosenRoom = deluxeRoom;
                roomLetter = "D2";
            }
            case 'C' -> {
                chosenRoom = suiteRoom;
                roomLetter = "ST3";
            }
        }

        for (int row = 0; row < chosenRoom.length; row++) {
            for (int col = 0; col < chosenRoom[row].length; col++) {
                if (row == 0 && col == 0){
                    chosenRoom[row][col] = "     ";
                } else if (row == 0){
                    chosenRoom[row][col] = "Day "+col;
                } else if (col == 0){
                    chosenRoom[row][col] = roomCode(roomLetter,row);
                } else if (chosenRoom[row][col] == null) {
                    chosenRoom[row][col] = "Free";
                }

                System.out.print(chosenRoom[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public static void makeReservation(){
        int choiceType = 1, msgType = 1, roomMax = 0, bookDay, bookTime, roomNum, roomFee = 0, resFee;
        char roomType;
        String guestName, room = "";

        hrLine();
        msgSelect(msgType, "Please choose a room to reserve:");
        roomType = inputChar(choiceType,"Enter your choice here: ");

        switch (roomType) {
            case 'A' -> {
                room = "Standard";
                chosenRoom = standardRoom;
                roomFee = 2500;
                roomMax = 15;
            }
            case 'B' -> {
                room = "Deluxe";
                chosenRoom = deluxeRoom;
                roomFee = 4000;
                roomMax = 10;
            }
            case 'C' -> {
                room = "Suite";
                chosenRoom = suiteRoom;
                roomFee = 8000;
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

        resFee = roomFee * bookTime;

        hrLine();
        System.out.println("--- Reservation Summary ---");

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
        double roomRate = 0, roomFee, userPayment, change;
        char roomType;
        String guestName, roomLabel = "", roomCode;

        System.out.println("--- Check-In Guest (Walk-in) ---");

        guestName = inputName();

        hrLine();
        msgSelect(msgType, "Please input the room type:");
        roomType = inputChar(choiceType,"Enter your choice here: ");

        switch (roomType) {
            case 'A' -> {
                chosenRoom = standardRoom;
                roomLabel = "Standard Room";
                roomRate = 2500;
                roomMax = 15;
            }

            case 'B'-> {
                chosenRoom = deluxeRoom;
                roomLabel = "Deluxe Room";
                roomRate = 4000;
                roomMax = 10;
            }

            case 'C' -> {
                chosenRoom = suiteRoom;
                roomLabel = "Suite Room";
                roomRate = 8000;
                roomMax = 5;
            }
        }

        hrLine();
        System.out.println("You have selected " + roomLabel + ".\nRate per night: ₱" + roomRate);
        hrLine();
        displayRoom(roomType);
        hrLine();

        roomNum = inputNum(1,roomMax,"Enter Room Number: ");

        roomCode = chosenRoom[roomNum][0];

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
        roomFee = roomRate*bookedNights;
        System.out.println("Total Fee: " + roomFee);

        userPayment = inputPayment(roomFee);
        change = userPayment - roomRate;
        hrLine();
        roomInfo("Check-In Successful","Guest Name: "+guestName+";Room No.: "+roomCode+";Stay: Day "+startDay+" to Day "+(startDay+bookedNights)+";Room Type: "+roomLabel+";Payment Received: ₱"+userPayment+";Change: ₱"+change);
        chosenRoom[roomRow][1] = "Occupied";
    }

    public static void checkOutGuest() {
        int choiceType = 1, msgType = 1, bookDays = 0, roomFee = 0, serFee = 250, subFee = roomFee + serFee;
        double tax = 0.1 * subFee, totalAmt = tax + subFee, payment, change;
        char roomType;
        String guestName, roomCode = "";

        hrLine();
        msgSelect(msgType, "Please input the room type:");

        roomType = inputChar(choiceType,"Enter your choice here: ");

        switch(roomType) {
            case 'A' -> {
                chosenRoom = standardRoom;
                roomFee = 2500;
            }
            case 'B' -> {
                chosenRoom = deluxeRoom;
                roomFee = 4000;
            }
            case 'C' -> {
                chosenRoom = suiteRoom;
                roomFee = 8000;
            }
        }

        guestName = inputName();
        hrLine();
        displayRoom(roomType);

        for (int row = 0; row < chosenRoom.length; row++) {
            for (int col = 0; col < chosenRoom[row].length; col++) {

                boolean check = chosenRoom[row][col].equals(guestName);

                if (check) {
                    bookDays++;
                    roomCode = chosenRoom[row][0];
                }
            }
        }

        roomInfo("Bill Calculation","Subtotal (Room Rate Only): ₱"+roomFee+";Fixed Service Fee: ₱"+serFee+";Subtotal + fee: ₱"+subFee+";Tax (10%): ₱"+tax+";Total amount due: ₱"+totalAmt);

        payment = inputPayment(totalAmt);
        change = payment - totalAmt;

        displayRoom(roomType);

        hrLine();
        roomInfo("Receipt","Guest: "+guestName+" | Room: "+roomCode+";Total Amount Due: ₱"+totalAmt+";Amount Paid: ₱"+payment+";Change: ₱" + change);
        hrLine();

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

    static void msgSelect(int msgType, String msg){
        switch (msgType){
            case 0 -> {
                System.out.println(msg);
                System.out.println("""
                            A. Check Room Availability
                            B. Make New Reservation
                            C. Check-in Guest
                            D. Check-out Guest / Generate bill
                            E. Exit
                        """);
            }
            case 1 -> {
                System.out.println(msg);
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

            if (input.matches("[0-9]+")) {
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

            if (input.matches("[0-9]+(\\.[0-9]+)?")) {
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

    static void roomInfo(String infoType, String info){
        System.out.println("--- "+infoType+" ---");
        for (String infoSegment : info.split(";")) {
            System.out.println(infoSegment);
        }
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