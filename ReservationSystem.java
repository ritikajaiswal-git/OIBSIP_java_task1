import java.util.*;
import java.io.*;

public class ReservationSystem {
    public static void reserveTicket(Scanner sc) {
        try {
            System.out.print("Enter your Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Train Number: ");
            String trainNo = sc.nextLine();

            System.out.print("Enter Train Name: ");
            String trainName = sc.nextLine();

            System.out.print("Enter Class Type (e.g., Sleeper/AC): ");
            String classType = sc.nextLine();

            System.out.print("Enter Date of Journey (dd-mm-yyyy): ");
            String date = sc.nextLine();

            System.out.print("From: ");
            String from = sc.nextLine();

            System.out.print("To: ");
            String to = sc.nextLine();

            Random rand = new Random();
            int pnr = 100000 + rand.nextInt(900000); // Generate 6-digit PNR

            BufferedWriter writer = new BufferedWriter(new FileWriter("reservations.txt", true));
            writer.write(pnr + "," + name + "," + age + "," + trainNo + "," + trainName + "," + classType + "," + date + "," + from + "," + to);
            writer.newLine();
            writer.close();

            System.out.println("Reservation successful! Your PNR is: " + pnr);
        } catch (Exception e) {
            System.out.println("Error while reserving: " + e.getMessage());
        }
    }
}