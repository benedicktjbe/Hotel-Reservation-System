import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char choice;

        do {
        System.out.println("-----------------------------------------");
        System.out.println("Welcome to the Hotel Reservation System!");
        System.out.println("Please choose an option: ");
        System.out.println("A. Check Room Availability");
        System.out.println("B. Make New Reservation");
        System.out.println("C. Check-in Guest");
        System.out.println("D. Check-out Guest / Generate bill");
        System.out.println("E. Exit");
        System.out.print("Enter your choice here: ");
        choice = sc.nextLine().toUpperCase().charAt(0);
        System.out.println("-----------------------------------------");
        if (choice != 'A' && choice != 'B' && choice != 'C' && choice != 'D' && choice != 'E') {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 'A' && choice != 'B' && choice != 'C' && choice != 'D' && choice != 'E');

        switch (choice) {
            case 'A' -> {
                //Check Room Availability Method
            }
            case 'B' -> {
                //Make New Reservation Method
            }
            case 'C' -> {
                //Check-in Guest Method
            }
            case 'D' -> {
                //Check-out Guest Method
            }
            case 'E' -> {
                System.out.println("Thank you for using our Hotel Reservatiuon System!");
                System.exit(0);
            }
        }
    }
}
