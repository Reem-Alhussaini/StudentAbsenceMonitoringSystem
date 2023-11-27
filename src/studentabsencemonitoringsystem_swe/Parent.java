package studentabsencemonitoringsystem_swe;
import java.util.Scanner;

public class Parent extends User {

    public Parent(String F_name, String L_name, String id) {
        super(F_name, L_name, id);
    }
    
    public static void submitExcuse() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the parent to enter the student ID, reason for absence, and date of absence
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter the reason for the absence: ");
        String reason = scanner.nextLine();
        System.out.print("Enter the date of absence (e.g., 2023-11-25): ");
        String date = scanner.nextLine();

        // Create an Excuse object
        Excuse excuse = new Excuse(reason, "needs evaluation");

        // Call FileManagement to get the Absence object
        Absence absence = FileManagement.getStudentAbsenceID(studentID, date);

        // Check if absence is found
        if (absence != null) {
            // Insert the excuse into the Absence object and store it in the Attendance file
            String message = FileManagement.insertExcuse(excuse, absence);

            // Display the message
            System.out.println(message);
        } else {
            System.out.println("No absence found for the provided details.");
        }
    }

}
