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
                    + ", Absence Date: " + absence.getDate()
                    + ", Excuse Reason: " + absence.getExcuse().getExcuseReason()
                    + ", Excuse ID: " + absence.getExcuseId() + "\n");
            return "Absence added successfully for student: " + absence.getStudent().F_name + " " + absence.getStudent().L_name;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to add absence!";
        }
    }

    public String insertExcuse(//excuse,Absence absence
            ) {

        return null;

    }

    public String getStudentAbsenceID(//StudentID,date
            ) {

        return null;

    }

    public String updateStatus(//excuse,absenceID
            ) {

        return null;

    }

}
