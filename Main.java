import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean loggedIn = false;
        while (!loggedIn) {
            loggedIn = LoginForm.login(sc);
        }

        while (true) {
            System.out.println("\n---- Online Reservation System ----");
            System.out.println("1. Reserve Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    ReservationSystem.reserveTicket(sc);
                    break;
                case 2:
                    CancellationForm.cancelTicket(sc);
                    break;
                case 3:
                    System.out.println("Thank you for using the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}

