package studentabsencemonitoringsystem_swe;

import java.io.IOException;

public class Parent extends User {

    public Parent(String F_name, String L_name, String id) {
        super(F_name, L_name, id);
    }

    public static void submitExcuse(String studentID, String date, String reason) throws IOException { //COMPLETED

        //find the absence assoiciated with the student id and date
        Absence absence = FileManagement.getAbsenceForParent(studentID, date);
        Excuse excuse = new Excuse(reason, "waiting for evaluation");
        // Check if absence was found
        try {
            String message = FileManagement.insertExcuse(excuse, absence);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("No absence found for the provided details.");
            e.printStackTrace();
        }
    }

    //---------------------------------------------------------------------------------------------------
    public static void viewExcuseStatus(String studentID, String date) {

        //find the absence assoiciated with the student id and date
        Absence absence = FileManagement.getAbsenceWExcuse(studentID, date);

        // Check if absence was found
        if (absence != null) {

            //get excuse status
            String status = absence.getExcuse().getStatus();

            System.out.println("The excuse status is: " + status);
            
        }
    }
    //---------------------------------------------------------------------------------------------------
}
