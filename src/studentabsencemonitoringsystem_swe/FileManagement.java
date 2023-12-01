package studentabsencemonitoringsystem_swe;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;


public class FileManagement {

    //Attendance file
   private static String AttendanceFile = "AttendanceFile.csv";
    //to read from Attendance file
    //BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile));
    
    //Student_ID,Student_First_Name,Student_Last_Name,Absence_ID,Date_of_absence,Reason_of_absence,Excuse_status

    //insert functions---------------------------------------------------------------------------------------------------------
    public static String insertStudent(Student student)   {
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
    public static String insertAbsence(Absence absence) throws IOException {
        /*To insert the absence in the file by appending the absence 
        data to the student data, we need to rewrite the whole file */

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

        return rewriteFileContent(content, student,success, fail);

    }
    //--------------------------------------------------------------------------------------------------------------------------
    public static String insertExcuse(Excuse excuse, Absence absence) throws IOException {
        /*To insert the excuse in the file by appending the excuse date to the absence and
         student data, we need to rewrite the whole file */

        //insert excuse object into absence object
        absence.setExcuse(excuse);

        ///find the line we want to append the excuse info into

        //the student object associated with the absence object received by the method
        Student student = absence.getStudent();
        //find the student data stored in the file
        String studentInfo = student.getId()+ "," +student.getF_name()+ "," +student.getL_name() ;
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
    static String rewriteFileContent(StringBuilder content, Student student, String success, String fail){
        try (PrintWriter writer = new PrintWriter(new FileWriter(AttendanceFile))) {
            writer.print(content);
            return success;
        } catch (IOException e) {
            return fail;
        }
    }


}
