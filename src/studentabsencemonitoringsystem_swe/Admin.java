package studentabsencemonitoringsystem_swe;

import java.util.Scanner;

public class Admin extends User {

    public Admin(String F_name, String L_name, String id) {
        super(F_name, L_name, id);
    }

    public static void registerAbsence(Absence absence, Student student) {
        System.out.println(FileManagement.insertStudent(student));
        System.out.println(FileManagement.insertAbsence(absence));
    }

    public void evaluateExcuse(Absence absence) {
        // Step 1: Get Absence id and store it for later use
        int absenceID = absence.getId();

        // Step 2: Call extractExcuse method from FileManagement class
        Excuse excuse = FileManagement.extractExcuse(absence);

        // Step 3: Display reason for absence and current status of the excuse
        System.out.println("Reason for absence: " + excuse.getReason());
        System.out.println("Current status: " + excuse.getStatus());

        // Step 4: Prompt admin to enter the evaluation of the excuse
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter evaluation (accepted/rejected): ");
        String newStatus = scanner.nextLine();

        // Step 5: Call updateStatus method from FileManagement class
        FileManagement.updateStatus(newStatus, absenceID);

        // Step 6: Receive message that the status was updated successfully
        System.out.println("Excuse status updated successfully.");
    }
}

