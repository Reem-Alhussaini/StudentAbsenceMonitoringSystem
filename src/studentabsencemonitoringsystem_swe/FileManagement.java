package studentabsencemonitoringsystem_swe;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public static String insertAbsence(Absence absence, Student student) throws IOException { //ABSENCETIMER REMAINING
        /*To insert the absence in the file by appending the absence 
        data to the student data, we need to rewrite the whole file */

        //store absences in an ArrayList to make accessing absences easier
        storeAbsencesArrayList(absence);

        //find the student data stored in the file
        String studentInfo = student.getId()+ "," +student.getF_name()+ "," +student.getL_name() ;

        //append the absence data to the student data
        String studentAndAbsenceInfo = studentInfo +","+absence.getId()+","+absence.getDate();

        //Use an ArrayList to store the file content by reading it using BufferedReader.

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line;
            //store file content in arrayList
            while ((line= reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //modify the specified line
        boolean lineModified = false;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).equals(studentInfo)) {
                lines.set(i, studentAndAbsenceInfo);
                lineModified = true;
                break;  
            }
        }

        //rewrite file content
        String success = "absence added sucessfully";
        String fail = "couldent add absence, try again";
        return rewriteFileContent(lines, lineModified, student, success, fail);
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


        
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line;
            //store file content in arrayList
            while ((line= reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //modify the specified line
        boolean lineModified = false;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).equals(studentAndAbsenceInfo)) {
                lines.set(i, fullAttendanceInfo);
                lineModified = true;
                break;  
            }
        }
        
        //rewrite file content
        String success = "excuse added sucessfully";
        String fail = "couldent add excuse, try again";
        return rewriteFileContent(lines, lineModified, absence.getStudent(), success, fail);
        
    }
    //--------------------------------------------------------------------------------------------------------------------------
    public static String insertExcuseStatus(Absence absence, Excuse excuse, String status){
        /*To insert the excuse new status in the file by appending the excuse status to the absence and
         student data, we need to rewrite the whole file */

        //get the line we want to insert the excuse status into
        //Student_ID,Student_First_Name,Student_Last_Name,Absence_ID,Date_of_absence,Reason_of_absence,Excuse_status
        String studentData = absence.getStudent().getId()+","+absence.getStudent().getF_name()+","+absence.getStudent().getL_name();
        String absenceData = absence.getId()+","+absence.getDate();
        String studentAndAbsenceInfo = studentData +","+ absenceData;
        String excuseData = excuse.getReason()+ ","+ excuse.getStatus();
        String originalLine = studentAndAbsenceInfo + ","+ excuseData;

        //insert status into excuse object
        excuse.setStatus(status);
        String modifiedLine = studentAndAbsenceInfo + "," +  excuse.getReason()+ ","+ excuse.getStatus();

        //find the line and insert the new status
        
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line;
            //store file content in arrayList
            while ((line= reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //modify the specified line
        boolean lineModified = false;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).equals(originalLine)) {
                lines.set(i, modifiedLine);
                lineModified = true;
                break;  
            }
        }
        //rewrite file content
        String success = "Status updated sucessfully";
        String fail = "couldent update status, try again";
        return rewriteFileContent(lines, lineModified, absence.getStudent(), success, fail);
    }
    //--------------------------------------------------------------------------------------------------------------------------
    static String rewriteFileContent(List<String> lines , boolean lineModified, Student student, String success, String fail){ //COMPLETED
        
       if (lineModified) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(AttendanceFile))) {
                for (String line : lines) {
                    writer.println(line);
                }
                return success;
            } catch (IOException e) {
                e.printStackTrace();
                return fail;
            }
        } else {
            return("Data not found in the Attendance file.");
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
