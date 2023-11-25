package studentabsencemonitoringsystem_swe;

import java.io.FileWriter;
import java.io.IOException;

public class FileManagement {

    private static final String FileName = "attendance.txt";//change in class

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

    public static String insertAbsence(Absence absence) {
        try (FileWriter myWriter = new FileWriter(FileName, true)) {
            myWriter.write("Student ID: " + absence.getStudent().id
                    + ", Absence Date: " + absence.getDate()+ "\n");
            return "Absence added successfully for student: " + absence.getStudent().F_name + " " + absence.getStudent().L_name;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to add absence!";
        }
    }

    static void updateStatus(String newStatus, int absenceID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Excuse extractExcuse(Absence absence) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String insertExcuse(Excuse excuse, Absence absence) {

        return null;

    }

    public static Absence getStudentAbsenceID(String studentID, String date) {

        return null;

    }

    public String updateStatus(//excuse,absenceID
            ) {

        return null;

    }

}
