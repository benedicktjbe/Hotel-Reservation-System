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

    static boolean loop = true;

    public static void main(String[] args) {
        char choice;
        int choiceType = 0;

        while (loop) {

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
                enterChoice();
                choice = inputChar(choiceType);
            } while (choiceType(choiceType).indexOf(choice) == -1);

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
        char checkRoom;
        int choiceType = 1;

        hrLine();
        System.out.println("""
                            Please input the room type:
                                A. Standard
                                B. Deluxe
                                C. Suite
                            """);

        do {
            enterChoice();
            checkRoom = inputChar(choiceType);
        } while (choiceType(choiceType).indexOf(checkRoom) == -1);

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

    public static void makeReservation(){
        String room = "";
        String[][] arrRoom = null;

        char roomType;
        int choiceType = 1;

        int bookDay, bookTime, roomNum, fee = 0, resFee;

        System.out.println("""
                               Please choose a room to reserve:
                                    A. Standard Room
                                    B. Deluxe Room
                                    C. Suite Room
                               """);
        do {
            enterChoice();
            roomType = inputChar(choiceType);
        } while (choiceType(choiceType).indexOf(roomType) == -1);

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

        hrLine();
        System.out.println("You have selected " + room + " room");
        hrLine();

        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        while (name.length() < 4){
            name = name+" ";
        }

        do {
            System.out.print("Please input the day you would like to book (1-10): ");
            bookDay = inputNum(1,10);
        } while (numCondition(bookDay,1,10));

        do {
            System.out.print("Please input how many days you would like to book: ");
            bookTime = inputNum(1,11-bookDay);
        } while (numCondition(bookTime,1,11-bookDay));

        do {
            System.out.print("Please input the last number of the room you would like to book: ");
            roomNum = inputNum(1,10);
        } while (numCondition(roomNum,1,10));

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

        displayRoom(arrRoom);

        hrLine();
        System.out.println("Booking Successful!");
    }

    static void hrLine(){
        System.out.println("-----------------------------------------");
    }

    static void enterChoice(){
        System.out.print("Enter your choice here: ");
    }

    static String choiceType(int type){
        String[] choices = new String[]{"ABCDE", "ABC", "YN"};
        return choices[type];
    }

    public static char inputChar(int type){
        char out = ' ';

        String input = sc.nextLine();

        if (input.length() == 1) {
            out = input.toUpperCase().charAt(0);

            if (choiceType(type).indexOf(out) == -1) {
                invalidInput();
            }
        } else {
            invalidInput();
        }
        return out;
    }

    static boolean numCondition(int num, int cond1, int cond2){
        return (num < cond1 || num > cond2);
    }

    public static int inputNum(int cond1, int cond2){
        int num = 0;

        String input = sc.nextLine();

        if (input.matches("\\d+")){
            num = Integer.parseInt(input);

            if (numCondition(num, cond1, cond2)) {
                invalidInput();
            }
        } else {
            invalidInput();
        }

        return num;
    }

    static void invalidInput(){
        hrLine();
        System.out.println("Invalid input. Please try again.");
        hrLine();
    }

    static void thankYou(){
        hrLine();
        System.out.println("Thank you for using our Hotel Reservation System!");
        hrLine();
        loop = false;
    }

    static void loop(){
        char loopChoice;
        int choiceType = 2;

        do {
            System.out.print("Run System Again? (Y/N): ");

            loopChoice = inputChar(choiceType);
        } while (choiceType(choiceType).indexOf(loopChoice) == -1);

        if (loopChoice == 'N'){
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
