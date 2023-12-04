package studentabsencemonitoringsystem_swe;

import java.io.IOException;
import java.util.Scanner;

public class Admin extends User {

    public Admin(String F_name, String L_name, String id) {
        super(F_name, L_name, id);
    }

    public static void registerAbsence(Absence absence, Student student) throws IOException {
        System.out.println(FileManagement.insertStudent(student));
        System.out.println(FileManagement.insertAbsence(absence, student));
    }

    public static void evaluateExcuse(String absenceID, String date, Scanner scanner) {
        // Step 1: find absence object associated with the id given by admin
        Absence absence = FileManagement.getAbsenceForAdmin(absenceID, date);

        // Step 2: get excuse object from absence object
        if (absence != null) {
            Excuse excuse = absence.getExcuse();

            // Step 3: Display reason for absence and current status of the excuse
            System.out.println("Reason for absence: " + excuse.getReason());
            System.out.println("Current status: " + excuse.getStatus());

            // update the excuse status "only if" the excuse was not evaluated yet
            if (excuse.getStatus().equals("waiting for evaluation")) {

                // Step 4: Prompt admin to enter the evaluation of the excuse
                System.out.print("Evaluate excuse (accepted/rejected): ");
                String newStatus = scanner.next();

                // Step 5: Update excuse status
                FileManagement.insertExcuseStatus(absence, excuse, newStatus);
            } else {
                System.out.println("The excuse for the student with the ID " + absence.getStudent().getId() + " was already evaluated");
            }
        }//if
        else {
            System.out.println("not found absence");
        }
    }
}
