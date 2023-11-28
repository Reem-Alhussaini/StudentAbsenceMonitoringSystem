package studentabsencemonitoringsystem_swe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

//deleted updateStatus 
    //deleted extractExcuse

    
public class FileManagement {

    private static final String FileName = "attendance.txt";//change in class

    //insert functions---------------------------------------------------------------------------------------------------------
    public static String insertStudent(Student student) {
        try (FileWriter myWriter = new FileWriter(FileName, true)) {
            myWriter.write("Student ID: " + student.getId()
                    + ", Name: " + student.F_name + " " + student.L_name + "\n");
            return "Student added successfully: " + student.F_name + " " + student.L_name;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to add student!";
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    public static String insertAbsence(Absence absence) {
        try (FileWriter myWriter = new FileWriter(FileName, true)) {
            myWriter.write("Student ID: " + absence.getStudent().id
                    + ", Absence Date: " + absence.getDate() + "\n");
            return "Absence added successfully for student: " + absence.getStudent().F_name + " " + absence.getStudent().L_name;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to add absence!";
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    public static String insertExcuse(Excuse excuse, Absence absence) {
        try (FileWriter myWriter = new FileWriter(FileName, true)) {
            // Writing excuse details to the file
            myWriter.write("Absence ID: " + absence.getId()
                    + ", Excuse Reason: " + excuse.getReason()
                    + ", Excuse Status: " + excuse.getStatus()
                    + ", Date: " + absence.getDate() + "\n");
            return "Excuse added successfully for Absence ID: " + absence.getId();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to add excuse!";
        }

        //return null;
    }
    //end of insert functions--------------------------------------------------------------------------------------------------
    
    public static Absence getStudentAbsenceID(String studentID, String date) {

        return null;

    }

    //----------------------------------------------------------------------------------
    public static void displayExcuses(Date date){
        //search in file using the date with a for loop
        // if(date == date in file && status == "waiting for evaluation") 
        //display the date, id, reason
    }
    //----------------------------------------------------------------------------------
    


}
