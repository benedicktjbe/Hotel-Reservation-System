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

    static String[][] chosenRoom = null;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Hotel Reservation System!");
            System.out.println("Please choose an option.");
            System.out.println("A. Check room availability");
            System.out.println("B. Make new reservation");
            System.out.println("C. Check-In Guest");
            System.out.println("D. Check-Out Guest");
            System.out.println("E. Exit");
            System.out.print("Enter your choice here: ");
            char option = sc.nextLine().toUpperCase().charAt(0);

            switch (option) {
                case 'A' -> checkRoom();
                case 'B' -> makeReservation();
                case 'C' -> checkIn();
                case 'D' -> checkOut();
                case 'E' -> {
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    return;
                }
            }
        }
    }

    public static void checkRoom() {
        char choice;

        do {
            System.out.println("Please choose a room to check");
            System.out.println("A. Standard Room");
            System.out.println("B. Deluxe Room");
            System.out.println("C. Suite Room");
            System.out.print("Enter your choice here: ");
            choice = sc.nextLine().toUpperCase().charAt(0);

            if (choice != 'A' && choice!= 'B' && choice != 'C') {
                System.out.println("Invalid input! Please input a valid choice (A-C)");
            }

        } while (choice != 'A' && choice!= 'B' && choice != 'C');

        displayRoom(choice);
    }

    public static void makeReservation() {
        char choice;

        do {
            System.out.println("Please choose the type of room to reserve");
            System.out.println("A. Standard Room");
            System.out.println("B. Deluxe Room");
            System.out.println("C. Suite Room");
            System.out.print("Enter your choice here: ");
            choice = sc.nextLine().toUpperCase().charAt(0);

            if (choice != 'A' && choice!= 'B' && choice != 'C') {
                System.out.println("Invalid input! Please input a valid choice (A-C)");
            }

        } while (choice != 'A' && choice!= 'B' && choice != 'C');

        displayRoom(choice);

        System.out.print("Please input your name: ");
        String name = sc.nextLine();
        System.out.print("Please input the last number of the room you would like to book: ");
        int roomNum = Integer.parseInt(sc.nextLine());
    
        boolean check;
        int day = 0;
        int duration = 0;

        do { 
            check = true;

            System.out.print("Please input the day you want to book: ");
            day = Integer.parseInt(sc.nextLine());
            System.out.print("Please input the number of days you want to book: ");
            duration = Integer.parseInt(sc.nextLine());

            if (day < 1 || day > 10) {
                System.out.println("Invalid Input! Day must be between 1-10!");
                check = false;
            } else if (duration < 1){
                System.out.println("Invalid Input! Duration must be greater than 0!");
                check = false;
            } else if (duration + day > 11) {
                System.out.println("Invalid input! The reservation end day exceeds the 10-day limit!");
                check = false;
            }

            if (check == true) {
                for(int book = 0; book < duration; book++) {
                    if (!chosenRoom[roomNum][day + book].equals("Free")) {
                        System.out.println("Someone has already occupied the day you are trying to book! Please make a reservation for another day.");
                        check = false;
                        break;
                    } 
                }
            }
            
        } while (check == false);

        for(int book = 0; book < duration; book++) {
            chosenRoom[roomNum][day + book] = name;
        }

        displayRoom(choice);
    }

    public static void checkIn() {
        char choice;
        double payment = 0.0;

        do {
            System.out.println("Please choose the type of room to reserve");
            System.out.println("A. Standard Room");
            System.out.println("B. Deluxe Room");
            System.out.println("C. Suite Room");
            System.out.print("Enter your choice here: ");
            choice = sc.nextLine().toUpperCase().charAt(0);

            if (choice != 'A' && choice!= 'B' && choice != 'C') {
                System.out.println("Invalid input! Please input a valid choice (A-C)");
            }

        } while (choice != 'A' && choice!= 'B' && choice != 'C');

        double fee = 0.0;

        switch (choice) {
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
            default -> {
                System.out.print("Invalid input! Please input a valid choice (A-C): ");
            }
        }

        System.out.print("Please input your name: ");
        String name = sc.nextLine();

        int duration = 0;

        do {
            System.out.print("Please input the number of days you want to book: ");
            duration = Integer.parseInt(sc.nextLine());

            if (duration < 1 || duration > 10) {
                System.out.println("Duration must be between 1-10 days only!");
            }
        } while (duration < 1 || duration > 10);

        fee = fee * duration;

        do {
        System.out.print("Please input your payment of " + fee + ": ");
        payment = Integer.parseInt(sc.nextLine());

            if (payment < fee) {
            System.out.println("Insufficient payment! Please try again.");
            }
        } while (payment < fee);

        boolean check = false;

        for(int room = 1; room < chosenRoom.length; room++) {
            int consecutive = 0;

            for(int day = 1; day < chosenRoom[room].length; day++) {
                if(chosenRoom[room][day].equals("Free")) {
                    consecutive++;
                } else {
                    consecutive = 0;
                }

                if(consecutive == duration) {
                    int startDay = day - duration + 1;

                    for(int book = startDay; book < startDay + duration; book++) {
                        chosenRoom[room][book] = name;
                    }
                    check = true;
                    break;
                }
            }

            if(check){ 
                break;

            }
        }

        if(check) {
            System.out.println("Successfully booked!");
        } else {
            System.out.println("Sorry!");
        }

        displayRoom(choice);
    }

    public static void checkOut() {

        char choice;

        do {
            System.out.println("Please input the room type you have booked:");
            System.out.println("A. Standard Room");
            System.out.println("B. Deluxe Room");
            System.out.println("C. Suite Room");
            System.out.print("Input your choice here: ");
            choice = sc.nextLine().toUpperCase().charAt(0);

            if (choice != 'A' && choice!= 'B' && choice != 'C') {
                System.out.println("Invalid input! Please input a valid choice (A-C)");
            }

        } while (choice != 'A' && choice!= 'B' && choice != 'C');

        int fee = 0;
        int serFee = 250;

        switch (choice) {
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
            default -> {
                System.out.print("Invalid input! Please input a valid choice (A-C): ");
            }
        }

        System.out.print("Please input your name: ");
        String name = sc.nextLine();

        int duration = 0;
        String room = null;

        for (int row = 0; row < chosenRoom.length; row++) {
            for (int col = 0; col < chosenRoom[row].length; col++) {
                if (chosenRoom[row][col].equals(name)) {
                    duration++;
                    room = chosenRoom[row][0];
                    chosenRoom[row][col] = "Free";
                }
            }
        }

        if (duration == 0) {
            System.out.println("Guest not found.");
            return;
        }

        int roomFee = duration * fee;
        int subFee = roomFee + serFee;
        double tax = subFee * 0.1;
        double totalAmt = subFee + tax;
        double finAmount = 0.0;

        System.out.println("Bill Calculation");
        System.out.println("Subtotal: " + roomFee);
        System.out.println("Service Charge: " + serFee);
        System.out.println("Subtotal + Fee: " + subFee);
        System.out.println("Tax: " + tax);
        System.out.println("Total Amount Due: " + totalAmt);

        do {
            System.out.print("Input Final Payment Amount: ");
            finAmount = Double.parseDouble(sc.nextLine());
        } while (finAmount < totalAmt);

        System.out.println("Payment: " + finAmount);
        System.out.println("Change: " + (totalAmt - finAmount));

        System.out.println("Receipt");
        System.out.println("Guest: " + name + " | Room: " + room);
        System.out.println("Total Amount Due: " + totalAmt);
        System.out.println("Amount paid " + finAmount);
        System.out.println("Change: " + (totalAmt - finAmount));
    }

    public static void displayRoom(char choice) {
        switch(choice) {
            case 'A' -> chosenRoom = standardRoom;
            case 'B' -> chosenRoom = deluxeRoom;
            case 'C' -> chosenRoom = suiteRoom;
            default -> {
                System.out.print("Invalid input! Please input a valid choice (A-C): ");
            }
        }

        for(String[] row : chosenRoom) {
            for(String col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }

        int freeRoomCount = 0;
        int occRoomCount = 0;
        for (int row = 1; row < chosenRoom.length; row++) {
            boolean isRoomFree = true;
                for (int col = 1; col < chosenRoom[row].length; col++){
                    if (!chosenRoom[row][col].equalsIgnoreCase("Free")) {
                        isRoomFree = false;
                        break;
                    }
                }
            if (isRoomFree) {
                    freeRoomCount++;
            }
            if (!isRoomFree) {
                    occRoomCount++;
            }
        }

        int ttlRooms = chosenRoom.length - 1;

        if (choice == 'A') {
            System.out.println("Room Type: Standard");
            System.out.println("Total Rooms: " + ttlRooms);
            System.out.println("Available Rooms: " + freeRoomCount);
            System.out.println("Occupied Rooms: " + occRoomCount);
            System.out.println("Price per night: P2500\n");
        }
        if (choice == 'B') {
            System.out.println("Room Type: Deluxe");
            System.out.println("Total Rooms: " + ttlRooms);
            System.out.println("Available Rooms: " + freeRoomCount);
            System.out.println("Occupied Rooms: " + occRoomCount);
            System.out.println("Price per night: P4000\n");
        }
        if (choice == 'C') {
            System.out.println("Room Type: Suite");
            System.out.println("Total Rooms: " + ttlRooms);
            System.out.println("Available Rooms: " + freeRoomCount);
            System.out.println("Occupied Rooms: " + occRoomCount);
            System.out.println("Price per night: P8000 \n");
        }
    }
}
