package studentabsencemonitoringsystem_swe;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

//insert functions completed

public class FileManagement {

    private static String AttendanceFile = "AttendanceFile.csv";
    //store absences in an ArrayList to make accessing absences easier
    private static ArrayList<Absence> absences = new ArrayList<>();

    //to read from Attendance file
    //BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile));    
    //Student_ID,Student_First_Name,Student_Last_Name,Absence_ID,Date_of_absence,Reason_of_absence,Excuse_status

    //Getter---------------------------------------------------------------------------------------------------------
    public static ArrayList<Absence> getAbsences() {
        return absences;
    }
    //insert functions---------------------------------------------------------------------------------------------------------
    public static String insertStudent(Student student){ //COMPLETED
        try(PrintWriter write = new PrintWriter(new FileWriter(AttendanceFile,true))){

            //add student info to the file
            write.printf("%s,%s,%s%n", student.getId(),student.getF_name(),student.getL_name());

            //let the admin know the student info was added successfully to the file
            return "Student added successfully: " + student.getId()+ " " 
            +student.getF_name()+ " " +student.getL_name() ;
        
        }catch(IOException e){
            //let the admin know the student info couldent be added to the file
            return "Failed to add student!";
        }

    }
    //--------------------------------------------------------------------------------------------------------------------------
    public static String insertAbsence(Absence absence) throws IOException { //ABSENCETIMER REMAINING
        /*To insert the absence in the file by appending the absence 
        data to the student data, we need to rewrite the whole file */

        //store absences in an ArrayList to make accessing absences easier
        storeAbsencesArrayList(absence);

        //find the student object associated with the absence object received by the method
        Student student = absence.getStudent();
        //find the student data stored in the file
        String studentInfo = student.getId()+ "," +student.getF_name()+ "," +student.getL_name() ;
        //append the absence data to the student data
        String studentAndAbsenceInfo = studentInfo +","+absence.getId()+","+absence.getDate();

        //Use a StringBuilder to store the file content by reading it using BufferedReader.
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line = reader.readLine();

            while (line != null) {
                //if the line with the specified student info is found, append the absence info
                if(line == studentInfo){
                    content.append(studentAndAbsenceInfo).append(System.lineSeparator());
                }
                else{
                    //append the file content to the StringBuilder
                    content.append(line).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: couldent append the file to StringBuilder");
        }

        //rewrite the file content with the new absence data
        String success ="Absence added successfully for student: "+student.getF_name()+" "
            +student.getL_name()+" "+student.getId();
        String fail = "Failed to add absence!";

        //start timer here

        return rewriteFileContent(content, student,success, fail);

    }
    //--------------------------------------------------------------------------------------------------------------------------
    public static String insertExcuse(Excuse excuse, Absence absence) throws IOException { //COMPLETED
        /*To insert the excuse in the file by appending the excuse data to the absence and
         student data, we need to rewrite the whole file */

        //insert excuse object into absence object
        absence.setExcuse(excuse);

        ///find the line we want to append the excuse info into

        //the student object associated with the absence object received by the method
        Student student = absence.getStudent();
        //find the student data stored in the file
        String studentInfo = student.getId()+ "," +student.getF_name()+ "," +student.getL_name();
        //append the absence data to the student data
        String studentAndAbsenceInfo = studentInfo +","+absence.getId()+","+absence.getDate();

        //append the excuse info to the student and absence info (full attendance info)
        String fullAttendanceInfo = studentAndAbsenceInfo+","+excuse.getReason()+","+excuse.getStatus();


        //Use a StringBuilder to store the file content by reading it using BufferedReader.
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line = reader.readLine();

            while (line != null) {
                //if the line with the specified student info is found, append the absence info
                if(line == studentAndAbsenceInfo){
                    content.append(fullAttendanceInfo).append(System.lineSeparator());
                }
                else{
                    //append the file content to the StringBuilder
                    content.append(line).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: couldent append the file to StringBuilder");
        }

        //rewrite the file content with the new excuse data
        String success = "Excuse added successfully for student: "+student.getF_name()+" "
            +student.getL_name()+" "+student.getId();
        String fail = "Failed to add excuse!";

        return rewriteFileContent(content, student,success, fail);
        
    }
    //--------------------------------------------------------------------------------------------------------------------------
    public static String insertExcuseStatus(Absence absence, Excuse excuse, String status){
        /*To insert the excuse new status in the file by appending the excuse status to the absence and
         student data, we need to rewrite the whole file */

        //get the line we want to insert the excuse status into
        //Student_ID,Student_First_Name,Student_Last_Name,Absence_ID,Date_of_absence,Reason_of_absence,Excuse_status
        String studentData = absence.getStudent().getId()+","+absence.getStudent()+","+absence.getStudent().getL_name()+",";
        String absenceData = absence.getId()+","+absence.getDate()+",";
        String excuseData = excuse.getReason()+excuse.getStatus();
        String targetLine = studentData + absenceData + excuseData;

        //insert status into excuse object
        excuse.setStatus(status);

        //find the line and insert the new status
        //Use a StringBuilder to store the file content by reading it using BufferedReader.
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line = reader.readLine();

            while (line != null) {
                //if the line with the specified student info is found, append the absence info
                if(line == targetLine){
                    content.append(excuse.getStatus()).append(System.lineSeparator());
                }
                else{
                    //append the file content to the StringBuilder
                    content.append(line).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: couldent append the file to StringBuilder");
        }

        //rewrite the file content with the new excuse data
        String success = "Excuse status added successfully for student: "+absence.getStudent().getF_name()+" "
            +absence.getStudent().getL_name()+" "+absence.getStudent().getId();
        String fail = "Failed to add excuse status!";
        return rewriteFileContent(content, absence.getStudent(),success, fail);
    }
    //--------------------------------------------------------------------------------------------------------------------------
    static String rewriteFileContent(StringBuilder content, Student student, String success, String fail){ //COMPLETED
        try (PrintWriter writer = new PrintWriter(new FileWriter(AttendanceFile))) {
            writer.print(content);
            return success;
        } catch (IOException e) {
            return fail;
        }
    }
    //end of insert functions--------------------------------------------------------------------------------------------------
    
    public static void displayExcuses(String date){
        ArrayList<Absence> absences = getAbsences();

        for(Absence absence : absences){
            if(date == absence.getDate()){
                System.out.printf("Date of absence: %s%n", absence.getDate());
                System.out.printf("Reason for absence: %s%n", absence.getExcuse().getReason());
                System.out.printf("Current status : %s%n", absence.getExcuse().getStatus());
            }
            else{
                System.out.println("There is no absence registered in the file in the date: "+ date);
            }
        }
    }
    //----------------------------------------------------------------------------------
    public static void storeAbsencesArrayList(Absence absence){ //COMPLETED
        absences.add(absence);
    }
    
    //search in ArrayList---------------------------------------------------------------

    //find absence id for admin
    public static Absence getAbsenceViaAbsenceID(String id){ //COMPLETED

        ArrayList<Absence> absences = getAbsences();

        for(Absence absence : absences){
            if(id == absence.getId()){
                return absence;
            }
            else{
                System.out.println("There is no absence registered in the file "+
                "with the ID: "+ id);
            }
        }
        return null;
    }
    //----------------------------------------------------------------------------------
    //find absence id for parent
    public static Absence getAbsenceIDviaStudentID(String studentID, String date) { //COMPLETED

        ArrayList<Absence> absences = getAbsences();

        for(Absence absence : absences){
            if(studentID == absence.getStudent().getId() && date == absence.getDate()){
                return absence;
            }
            else{
                System.out.println("There is no absence registered in the file "+
                "for the student ID: "+ studentID +" on the date: "+ date);
            }
        }
        return null;

    }
    //end of search in ArrayList--------------------------------------------------------

}
