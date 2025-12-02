import java.util.Scanner;

public class HotelReservationSystem {
    static String[][] standardRoom = new String[16][11];
    static String[][] deluxeRoom = new String[11][11];
    static String[][] suiteRoom = new String[6][11];

    static String[][] chosenRoom = null;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            msgSelect("Welcome to the Hotel Reservation System!\nPlease choose an option.","    A. Check Room Availability;    B. Make New Reservation;    C. Check-in Guest;    D. Check-out Guest / Generate bill;    E. Exit");
            char option = inputChar("ABCDE","Enter your choice here: ","A-E");
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
        msgSelect("Please choose a room to check","    A. Standard Room;    B. Deluxe Room;    C. Suite Room");
        char choice = inputChar("ABC","Enter your choice here: ","A-C");
        genRoom(choice);
        displayRoom(choice);
    }

    public static void makeReservation() {
        msgSelect("Please choose the type of room to reserve","    A. Standard Room;    B. Deluxe Room;    C. Suite Room");
        char choice = inputChar("ABC","Enter your choice here: ","A-C");
        genRoom(choice);
        displayRoom(choice);
        System.out.print("Please input your name: ");
        String name = sc.nextLine();
        System.out.print("Please input the last number of the room you would like to book: ");
        int roomNum = Integer.parseInt(sc.nextLine());
        System.out.print("Please input the day you want to book: ");
        int day = Integer.parseInt(sc.nextLine());
        System.out.print("Please input the number of days you want to book: ");
        int duration = Integer.parseInt(sc.nextLine());
        chosenRoom[roomNum][day] = name;
        for(int book = 1; book < duration; book++) {
            chosenRoom[roomNum][day + book] = name;
        }
        displayRoom(choice);
    }

    public static void checkIn() {
        msgSelect("Please choose the type of room to reserve","    A. Standard Room;    B. Deluxe Room;    C. Suite Room");
        char choice = inputChar("ABC","Enter your choice here: ","A-C");
        genRoom(choice);
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
        }

        System.out.print("Please input your name: ");
        String name = sc.nextLine();
        System.out.print("Please input the number of days you want to book: ");
        int duration = Integer.parseInt(sc.nextLine());
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
                }
            }
        }
        displayRoom(choice);
    }

    public static void checkOut() {
        int fee = 0, serFee = 250, duration = 0;
        msgSelect("Please input the room type you have booked:","    A. Standard Room;    B. Deluxe Room;    C. Suite Room");
        char choice = inputChar("ABC","Input your choice here: ","A-C");
        genRoom(choice);
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
        }
        System.out.print("Please input your name: ");
        String name = sc.nextLine();
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
        int roomFee = duration * fee;
        int subFee = roomFee + serFee;
        double tax = subFee * 0.1;
        double totalAmt = subFee + tax;
        finInfo("Bill Calculation","Subtotal: "+roomFee+";Service Charge: "+serFee+";Subtotal + Fee: "+subFee+";Tax: "+tax+";Total Amount Due: "+totalAmt);
        double finAmount = inputPayment(totalAmt);
        finInfo("Receipt","Guest:"+name+" | Room: "+room+";Total Amount Due: "+totalAmt+"'Amount paid "+finAmount+";Change: "+(totalAmt-finAmount));
    }

    static String roomCode(String roomLetter, int roomNumber){
        String roomExtra = "";
        if (roomNumber < 10){
            roomExtra = "0";
        }
        return roomLetter+roomExtra+roomNumber;
    }

    public static char inputChar(String choices, String msg, String range){
        char out = ' ';
        do {
            System.out.print(msg);
            String input = sc.nextLine();
            if (input.length() == 1) {
                out = input.toUpperCase().charAt(0);
                if (choices.indexOf(out) == -1) {
                    System.out.print("Invalid input! Please input a valid choice ("+range+"): ");
                }
            } else {
                System.out.print("Invalid input! Please input a valid choice ("+range+"): ");
            }
        } while (choices.indexOf(out) == -1);
        return out;
    }

    static double inputPayment(double due){
        double pay = 0;
        do {
            System.out.print("Input final payment amount: ₱");
            String input = sc.nextLine();
            if (input.matches("[0-9]+(\\.[0-9]+)?")) {
                pay = Double.parseDouble(input);
                if (pay < due) {
                    System.out.println("Payment is insufficient. Amount due: ₱\" + due");
                }
            } else {
                System.out.println("Payment is insufficient. Amount due: ₱\" + due");
            }
        } while (pay < due);
        return pay;
    }

    static void msgSelect(String msg, String msgChoices){
        System.out.println(msg);
        for (String infoSegment : msgChoices.split(";")) {
            System.out.println(infoSegment);
        }
    }

    static void finInfo(String infoType, String info){
        System.out.println("--- "+infoType+" ---");
        for (String infoSegment : info.split(";")) {
            System.out.println(infoSegment);
        }
    }

    static void genRoom(char room){
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
            }
        }
    }

    public static void displayRoom(char choice) {
        switch(choice) {
            case 'A' -> chosenRoom = standardRoom;
            case 'B' -> chosenRoom = deluxeRoom;
            case 'C' -> chosenRoom = suiteRoom;
        }
        for(String[] row : chosenRoom) {
            for(String col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }
}