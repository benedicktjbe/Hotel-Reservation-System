/*
* Project Name: Hotel Reservation System Simulation
* Date: December 3, 2025, WS 8:30-10:00 AM (Laboratory) / 1:30-2:30 PM (Lecture)
* Instructor: Janet V. Itliong
*
* Group 6 Members:
* 1. Estangki, Joshua
* 2. Mendoza, Kim
* 3. Mercado, Dylan
* 4. Ramos, Dylan
* 5. Requillas, Ava
* 6. Vailoces, Jamilla
* 7. Yocogan, Eugene

*/

import java.util.Scanner;

/*
Algorithm: Hotel Reservation System

1. Initialize the Hotel Reservation System with three types of rooms: 
   Standard, Deluxe, and Suite, each represented as a 2D array to track 
   room numbers and occupancy for days 1–10.

2. Display a main menu allowing the user to select one of the following options:
   A. Check Room Availability
   B. Make New Reservation
   C. Check-In Guest
   D. Check-Out Guest
   E. Exit

3. Create separate methods for each menu option. Include a displayRoom() 
   method to show room status for the selected room type.

4. Check Room Availability:
   4.1 Ask the user to choose a room type.
   4.2 Display the room status, including each room’s occupancy for days 1–10.
   4.3 Display total rooms, available rooms, and occupied rooms for the selected type.

5. Make a New Reservation:
   5.1 Ask the user for the room type and display its status.
   5.2 Prompt the user to input:
       - Guest name
       - Room number
       - Number of days to book
       - Specific day(s) for booking
   5.3 Validate all inputs:
       - Guest name cannot be empty or already in use
       - Room number must be within valid range
       - Number of days must be 1–10
       - Selected days must not already be occupied
       - If invalid, prompt the user to re-enter the input
   5.4 Update the room status to mark booked days as occupied by the guest.

6. Check-In Guest:
   6.1 Ask for room type, guest name, and duration of stay.
   6.2 Validate all inputs; prompt again if invalid.
   6.3 Display total room fee based on room type and duration.
   6.4 Prompt the user for payment and validate if it is sufficient.
   6.5 If payment is successful, reserve an available room for the user.
       Otherwise, prompt again until payment is sufficient.

7. Check-Out Guest:
   7.1 Ask for room type and guest name.
   7.2 Validate that the guest exists; if not, prompt again.
   7.3 Calculate the total bill including:
       - Room fee (based on duration)
       - Service fee of ₱250
       - Tax of 10%
   7.4 Prompt the user to pay the total amount and validate payment.
   7.5 If payment is successful, free up the reserved days in the room array.
       Otherwise, prompt again until payment is sufficient.

8. Exit:
   8.1 Thank the user for using the system and terminate the program.

9. Loop:
   9.1 The program continues to loop through the main menu until the user 
       chooses the exit option.
*/

public class FinalGroupProjectGroup6 {
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
            System.out.println("=========================================");
            System.out.println("Welcome to the Hotel Reservation System!");
            System.out.println();
            System.out.println("Please choose an option.");
            System.out.println("A. Check room availability");
            System.out.println("B. Make new reservation");
            System.out.println("C. Check-In Guest");
            System.out.println("D. Check-Out Guest");
            System.out.println("E. Exit");
            System.out.println("=========================================");
            System.out.print("Enter your choice here: ");
            char option = sc.nextLine().toUpperCase().charAt(0);
            System.out.println();

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
            System.out.println("================================");
            System.out.println("Please choose a room to check");
            System.out.println("A. Standard Room");
            System.out.println("B. Deluxe Room");
            System.out.println("C. Suite Room");
            System.out.println("================================");
            System.out.print("Enter your choice here: ");
            choice = sc.nextLine().toUpperCase().charAt(0);
            System.out.println();

            if (choice != 'A' && choice!= 'B' && choice != 'C') {
                System.out.println("Invalid input! Please input a valid choice (A-C)");
            }

        } while (choice != 'A' && choice!= 'B' && choice != 'C');

        displayRoom(choice);
    }

    public static void makeReservation() {
        char choice;

        do {
            System.out.println("================================");
            System.out.println("Please choose the type of room to reserve");
            System.out.println("A. Standard Room");
            System.out.println("B. Deluxe Room");
            System.out.println("C. Suite Room");
            System.out.println("================================");
            System.out.print("Enter your choice here: ");
            choice = sc.nextLine().toUpperCase().charAt(0);
            System.out.println();

            if (choice != 'A' && choice!= 'B' && choice != 'C') {
                System.out.println("Invalid input! Please input a valid choice (A-C)");
            }

        } while (choice != 'A' && choice!= 'B' && choice != 'C');

        displayRoom(choice);

        String name;

        do {
            System.out.print("Please input your name: ");
            name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Guest name cannot be empty!");
            } else if (isGuestNameTaken(name)) {
                System.out.println("Guest name is already in use! Please use a different name!");
            }

        } while (name.isEmpty() || isGuestNameTaken(name));

        int roomNum = 0;
        int max = chosenRoom.length - 1;

        do {
            if (chosenRoom.length == 16) {
                System.out.print("Please input the last number of the room you would like to book. For rooms S110 - S115, please input the last 2 digits: ");
            } else if (chosenRoom.length < 16) {
                System.out.print("Please input the last number of the room you would like to book: ");
            }

            roomNum = Integer.parseInt(sc.nextLine());

            if (roomNum < 1 || roomNum > max) {
                System.out.println("Invalid Input! Room number must only be between 1-" + max);
            }
        } while (roomNum < 1 || roomNum > max);

        int duration = 0;

        do { 
            System.out.print("Please input the number of days you want to book: ");
            duration = Integer.parseInt(sc.nextLine());

            if (duration < 1 || duration > 10){
                System.out.println("Invalid Input! Duration must be between 1-10!");
            } 
        } while (duration < 1 || duration > 10);

        int[] selectedDays = new int[duration];

        for (int book = 0; book < duration; book++) {

        int day = 0;
        boolean validDay = false;

        do {
            System.out.print("Date " + (book + 1) + " (choose a day 1-10): ");
            day = Integer.parseInt(sc.nextLine());

            validDay = true;

            if (day < 1 || day > 10) {
                System.out.println("Invalid day! Please choose between 1-10.");
                validDay = false;
                continue;
            }

            for (int checkDay = 0; checkDay < book; checkDay++) {
                if (selectedDays[checkDay] == day) {
                    System.out.println("You already selected this day. Please choose another day.");
                    validDay = false;
                    break;
                }
            }

            if (validDay && !chosenRoom[roomNum][day].equals("Free")) {
                System.out.println("Day " + day + " is already occupied! Choose another day.");
                validDay = false;
            }

        } while (!validDay);

        selectedDays[book] = day;
    }


        for (int booked : selectedDays) {
            chosenRoom[roomNum][booked] = name;
        }

        int fee = 0;

        switch (choice) {
            case 'A' -> {
                fee = 2500;
            }
            case 'B' -> {
                fee = 4000;
            }
            case 'C' -> {
                fee = 8000;
            }
            
        }

        int roomFee = duration * fee;
        double payment = 0.0;

        do { 
            System.out.print("Please input your payment for the fee of " + roomFee + ": ");
            payment = Double.parseDouble(sc.nextLine());

            if (payment < roomFee) {
                System.out.println("Invalid amount! Payment should be greater than the fee!");
            }
        } while (payment < roomFee);

        System.out.println("Reservation successful!");
        displayRoom(choice);
    }


    public static void checkIn() {
        char choice;
        double payment = 0.0;

        do {
            System.out.println("================================");
            System.out.println("Please choose the type of room to reserve");
            System.out.println("A. Standard Room");
            System.out.println("B. Deluxe Room");
            System.out.println("C. Suite Room");
            System.out.println("================================");
            System.out.print("Enter your choice here: ");
            System.out.println();
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

        String name;

        do {
            System.out.print("Please input your name: ");
            name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Guest name cannot be empty!");
            } else if (isGuestNameTaken(name)) {
                System.out.println("Guest name is already in use! Please use a different name!");
            }

        } while (name.isEmpty() || isGuestNameTaken(name));

        int duration = 0;

        do {
            System.out.print("Please input the number of days you want to book: ");
            duration = Integer.parseInt(sc.nextLine());

            if (duration < 1 || duration > 10) {
                System.out.println("Duration must be between 1-10 days only!");
            }
        } while (duration < 1 || duration > 10);

        boolean check = false;
        boolean avail = true;

        for (int day = 1; day <= 10 - duration + 1; day++) {
            for(int room = 1; room < chosenRoom.length; room++) {
                int consecutive = 0;

                for(int bookDay = 0; bookDay < duration; bookDay++) {
                    if(chosenRoom[room][day + bookDay].equals("Free")){
                        consecutive++;
                    } else {
                        break;
                    }
                }

                if(consecutive == duration) {
                    for (int book = 0; book < duration; book++) {
                        chosenRoom[room][day + book] = name;
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
            System.out.println("Sorry! No rooms are available to accomodate your schedule!");
            avail = false;
        }

        fee = fee * duration;
        if (avail == true) {
            do {
                System.out.print("Please input your payment of " + fee + ": ");
                payment = Double.parseDouble(sc.nextLine());

                if (payment < fee) {
                System.out.println("Insufficient payment! Please try again.");
                }
            } while (payment < fee);

            displayRoom(choice);

        }
    }

    public static void checkOut() {

        char choice;

        do {
            System.out.println("================================");
            System.out.println("Please input the room type you have booked:");
            System.out.println("A. Standard Room");
            System.out.println("B. Deluxe Room");
            System.out.println("C. Suite Room");
            System.out.println("================================");
            System.out.print("Input your choice here: ");
            choice = sc.nextLine().toUpperCase().charAt(0);
            System.out.println();

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

        int duration = 0;
        String room = null;
        String name;

        do { 
            System.out.print("Please input your name: ");
            name = sc.nextLine().trim();

            duration = 0;
            room = null;

            for (int row = 1; row < chosenRoom.length; row++) {
                int bookedDays = 0;

                for (int col = 1; col < chosenRoom[row].length; col++) {
                    if (chosenRoom[row][col].equalsIgnoreCase(name)) {
                        bookedDays++;
                    }
                }

                if (bookedDays > 0) {
                    room = chosenRoom[row][0];
                    duration = bookedDays;

                    for (int column = 1; column < chosenRoom[row].length; column++){
                        if (chosenRoom[row][column].equalsIgnoreCase(name)) {
                            chosenRoom[row][column] = "Free";
                        }
                    }
                    break;
                }
            }

            if (duration == 0) {
                System.out.print("Guest not found! ");
            }
        } while (duration == 0);
        
        

        int roomFee = duration * fee;
        int subFee = roomFee + serFee;
        double tax = subFee * 0.1;
        double totalAmt = tax + serFee;
        double finAmount = 0.0;

        System.out.println("======================================================");
        System.out.println("Bill Calculation");
        System.out.println("Subtotal: " + roomFee + " (Paid)");
        System.out.println("Service Charge: " + serFee);
        System.out.println("Subtotal + Fee: " + subFee + " (Room Fee already paid)");
        System.out.println("Tax: " + tax);
        System.out.println("Total Amount Due: " + totalAmt);

        do {
            System.out.print("Input Final Payment Amount: ");
            finAmount = Double.parseDouble(sc.nextLine());
        } while (finAmount < totalAmt);

        System.out.println("Payment: " + finAmount);
        System.out.println("Change: " + (finAmount - totalAmt));
        System.out.println("======================================================");
        System.out.println();

        System.out.println("======================================================");
        System.out.println("Receipt");
        System.out.println("Guest: " + name + " | Room: " + room);
        System.out.println("Total Amount Due: " + totalAmt);
        System.out.println("Amount paid " + finAmount);
        System.out.println("Change: " + (totalAmt - finAmount));
        System.out.println("Check out complete. Room " + room + "is now available!");
        System.out.println("======================================================");
    }

    public static void displayRoom(char choice) {
        switch(choice) {
            case 'A' -> {
                chosenRoom = standardRoom;
            }
            case 'B' -> {
                chosenRoom = deluxeRoom;
            }
            case 'C' -> {
                chosenRoom = suiteRoom;
            }
            default -> {
                System.out.print("Invalid input! Please input a valid choice (A-C): ");
            }
        }

        System.out.println("===================================================================================================");

        for(String[] row : chosenRoom) {
            for(String col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }

        System.out.println("===================================================================================================");
        System.out.println();

        int freeRoomCount = 0;
        int occRoomCount = 0;

        for (int row = 1; row < chosenRoom.length; row++) {
            boolean isRoomFree = true;

            for (int col = 1; col < chosenRoom[row].length; col++){
                if (chosenRoom[row][col].equalsIgnoreCase("Free")) {
                    isRoomFree = false;
                    break;
                }
            }

            if (isRoomFree) {
                    occRoomCount++;
            }
            if (!isRoomFree) {
                    freeRoomCount++;
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

    public static boolean isGuestNameTaken(String name) {
    for (int rows = 1; rows < chosenRoom.length; rows++) {
        for (int col = 1; col < chosenRoom[rows].length; col++) {
            if (chosenRoom[rows][col].equalsIgnoreCase(name)) {
                return true;
            }
        }
    }
    return false;
    }
}