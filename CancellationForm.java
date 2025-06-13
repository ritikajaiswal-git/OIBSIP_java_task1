import java.io.*;
import java.util.*;

public class CancellationForm {
    public static void cancelTicket(Scanner sc) {
        System.out.print("Enter your PNR number to cancel: ");
        String pnr = sc.nextLine();

        File inputFile = new File("reservations.txt");
        File tempFile = new File("temp.txt");

        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(pnr + ",")) {
                    System.out.println("Reservation Found: " + line);
                    found = true;
                    System.out.print("Are you sure to cancel this ticket? (yes/no): ");
                    if (!sc.nextLine().equalsIgnoreCase("yes")) {
                        writer.write(line);
                        writer.newLine();
                    } else {
                        System.out.println("Ticket Cancelled Successfully.");
                    }
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }

            if (!found) {
                System.out.println("No reservation found for given PNR.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Replace old file
        if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
            System.out.println("Could not update reservation records.");
        }
    }
}
