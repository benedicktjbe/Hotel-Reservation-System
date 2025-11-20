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
                case 'B' -> newReservation();
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

    public static void newReservation(){
        char roomType = ' '; 
        String guestName = "";
        double resvFee = 0.0;
        double userPayment = 0.0;
        double change = 0.0;
        double totalRFee = 0.0;
        int bookedNights = 0;

        System.out.println("\n--- Make New Reservation ---\n");
        System.out.println("Enter Guest Name:");
        guestName = sc.nextLine();

        hrLine();
        System.out.println("""
                            Please input the room type:
                                A. Standard
                                B. Deluxe
                                C. Suite
                            """);
        roomType = sc.nextLine().toUpperCase().charAt(0);
        
        switch (roomType) {
            case 'A' ->  {
                System.out.println("You have selected Standard Room. Reservation Fee: 2500");
                displayRoom(standardRoom);  
                resvFee = 2500.00;
                
                System.out.println("Enter number of nights booked: ");
                bookedNights = Integer.parseInt(sc.nextLine());

                totalRFee = resvFee*bookedNights;
            
                //update room status to 'booked'
                //assihn guestname and details to room

                do{
                    System.out.println("Fee: " + totalRFee);                    
                    System.out.println("Enter reservation payment: ");
                    userPayment = Double.parseDouble(sc.nextLine());                    
                    if(userPayment < totalRFee){
                        System.out.println("Reservation payment is insufficient.");
                    }
                }while(userPayment < totalRFee);
 
                change = userPayment - totalRFee;                

                System.out.println("\n --- Reservation Booked ---");
                System.out.println("Guest Name: " + guestName);
                System.out.println("Room Type: Standard Room");
                System.out.println("Room No.:");
                System.out.println("Total Reservation Fee: " + totalRFee);
                System.out.println("Change: " + change);
                    
}   
            

            case 'B' -> { 
                System.out.println("You have selected Deluxe Room.");
                displayRoom(deluxeRoom);
                resvFee = 4000.00;

                System.out.println("Enter number of nights booked: ");
                bookedNights = Integer.parseInt(sc.nextLine());

                totalRFee = resvFee*bookedNights;

                do{
                    System.out.println("Fee: " + totalRFee);                    
                    System.out.println("Enter reservation payment: ");
                    userPayment = Double.parseDouble(sc.nextLine());                    
                    if(userPayment < totalRFee){
                        System.out.println("Reservation payment is insufficient.");
                    }
                }while(userPayment < totalRFee);
                
                change = userPayment - totalRFee;
                
                System.out.println("\n --- Reservation Booked ---");
                System.out.println("Guest Name: " + guestName);
                System.out.println("Room Type: Deluxe Room");
                System.out.println("Room No.:");
                System.out.println("Total Reservation Fee: " + totalRFee);
                System.out.println("Change: " + change);
            }
                
                
            case 'C' -> { 
                System.out.println("You have selected Suite Room.");
                displayRoom(suiteRoom);
                resvFee = 8000.00;

                System.out.println("Enter number of nights booked: ");
                bookedNights = Integer.parseInt(sc.nextLine());

                totalRFee = resvFee*bookedNights;

                do{
                    System.out.println("Fee: " + totalRFee);                    
                    System.out.println("Enter reservation payment: ");
                    userPayment = Double.parseDouble(sc.nextLine());                    
                    if(userPayment < totalRFee){
                        System.out.println("Reservation payment is insufficient.");
                    }
                }while(userPayment < totalRFee);
                
                change = userPayment - totalRFee;
                
                System.out.println("\n --- Reservation Booked ---");
                System.out.println("Guest Name: " + guestName);
                System.out.println("Room Type: Suite Room");
                System.out.println("Room No.:");
                System.out.println("Total Reservation Fee: " + totalRFee);
                System.out.println("Change: " + change);
            }

            default ->  {
                invalidChoice();
            }    
        }

    }

    public static void checkInGuest(){

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
