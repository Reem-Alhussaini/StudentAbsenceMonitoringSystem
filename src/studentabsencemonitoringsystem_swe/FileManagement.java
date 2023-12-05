package studentabsencemonitoringsystem_swe;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {

    private static String AttendanceFile = "AttendanceFile.txt";

    //store absences in an ArrayList to make accessing absences easier
    private static ArrayList<Absence> absences = new ArrayList<>();

    //Student_ID,Student_First_Name,Student_Last_Name,Date_of_absence,Reason_of_absence,Excuse_status
    
    //Getter---------------------------------------------------------------------------------------------------------
    public static ArrayList<Absence> getAbsences() {
        return absences;
    }
    //Getter---------------------------------------------------------------------------------------------------------

    //insert functions---------------------------------------------------------------------------------------------------------
    public static String insertStudent(Student student) { //COMPLETED
        try (PrintWriter write = new PrintWriter(new FileWriter(AttendanceFile, true))) {

            //add student info to the file
            write.printf("%s,%s,%s%n", student.getId(), student.getF_name(), student.getL_name());

            //let the admin know the student info was added successfully to the file
            return "Student added successfully: " + student.getId() + " "
                    + student.getF_name() + " " + student.getL_name();

        } catch (IOException e) {
            //let the admin know the student info couldent be added to the file
            return "Failed to add student!";
        }

    }

    //--------------------------------------------------------------------------------------------------------------------------
    public static String insertAbsence(Absence absence, Student student) throws IOException { //ABSENCETIMER REMAINING
        /*To insert the absence in the file by appending the absence 
        data to the student data, we need to rewrite the whole file */

        //store absences in an ArrayList to make accessing absences easier
        //storeAbsencesArrayList(absence);
        ArrayList<Absence> absencesArray = getAbsences();
        absencesArray.add(absence);

        //find the student data stored in the file
        String studentInfo = student.getId() + "," + student.getF_name() + "," + student.getL_name();

        //append the absence data to the student data
        String studentAndAbsenceInfo = studentInfo + "," + absence.getDate();

        //Use an ArrayList to store the file content by reading it using BufferedReader.
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line;
            //store file content in arrayList
            while ((line = reader.readLine()) != null) {
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
        if(absence != null){
            if (excuse.getStatus().equals("waiting for evaluation")) {

                //insert excuse object into absence object
                absence.setExcuse(excuse);

                ///find the line we want to append the excuse info into
                //the student object associated with the absence object received by the method
                Student student = absence.getStudent();
                //find the student data stored in the file
                String studentInfo = student.getId() + "," + student.getF_name() + "," + student.getL_name();
                //append the absence data to the student data
                String studentAndAbsenceInfo = studentInfo + "," + absence.getDate();

                //append the excuse info to the student and absence info (full attendance info)
                String fullAttendanceInfo = studentAndAbsenceInfo + "," + excuse.getReason() + "," + excuse.getStatus();

                List<String> lines = new ArrayList<>();

                try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
                    String line;
                    //store file content in arrayList
                    while ((line = reader.readLine()) != null) {
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

            } else {
                System.out.println("The excuse cannot be submit. The absence has been recorded as an unexcused absence");
                excuse.setStatus("unexcused absence");
                return "The period specified for including the excuse has been exceeded";
            }
        }
        else{
            return "no absence registred with the provided data";
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------
    public static String insertExcuseStatus(Absence absence, Excuse excuse, String status) {
        /*To insert the excuse new status in the file by appending the excuse status to the absence and
         student data, we need to rewrite the whole file */

        if(absence!= null || excuse != null){
        //get the line we want to insert the excuse status into
        //Student_ID,Student_First_Name,Student_Last_Name,Date_of_absence,Reason_of_absence,Excuse_status
        String studentData = absence.getStudent().getId() + "," + absence.getStudent().getF_name() + "," + absence.getStudent().getL_name();
        String studentAndAbsenceInfo = studentData + "," + absence.getDate();
        String excuseData = excuse.getReason() + "," + excuse.getStatus();
        String originalLine = studentAndAbsenceInfo + "," + excuseData;

        //insert status into excuse object
        excuse.setStatus(status);
        String modifiedLine = studentAndAbsenceInfo + "," + excuse.getReason() + "," + excuse.getStatus();

        //find the line and insert the new status
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line;
            //store file content in arrayList
            while ((line = reader.readLine()) != null) {
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
        else{
            return null;
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    public static String insertUnexcused(Absence absence, String status){
        /*To insert the excuse new status in the file by appending the excuse status to the absence and
         student data, we need to rewrite the whole file */

         //get the line we want to insert the excuse status into
        String studentData = absence.getStudent().getId() + "," + absence.getStudent().getF_name() + "," + absence.getStudent().getL_name();
        String originalLine = studentData + "," + absence.getDate();
        String modifiedLine = originalLine + "," + status;

        //find the line and insert the new status
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line;
            //store file content in arrayList
            while ((line = reader.readLine()) != null) {
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
        String success = "Status updated to \"unexcused\"";
        String fail = "couldent update status, IOException";
        return rewriteFileContent(lines, lineModified, absence.getStudent(), success, fail);


    }
    //--------------------------------------------------------------------------------------------------------------------------
    static String rewriteFileContent(List<String> lines, boolean lineModified, Student student, String success, String fail) { //COMPLETED
        
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
            return ("Data not found in the Attendance file.");
        }
    }
    //end of insert functions--------------------------------------------------------------------------------------------------

    public static void displayExcuses(String date) {
        //make sure to only print the lines with excuses "status and reason"
        //how? if the length of the array was 4, means no excuse was submitted.
        //else if the length of the array was 6, an excuse was surely submitted
        //we do this to avoid NullPointerExceptions
        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(",", 0);
                
                if(tokens.length == 6){
                    for (int token = 0; token < tokens.length; token++) {

                        if (date.equals(tokens[token])) {

                            System.out.println("Date of absence: " + date);
                            int reason = token + 1; 
                            int status = token + 2;
                            System.out.println("Reason for absence: " + tokens[reason]);
                            try {
                                System.out.println("Current status : " + tokens[status]);

                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("ArrayIndexOutOfBoundsException");
                                for (int i = 0; i < tokens.length; i++) {
                                    System.out.println(tokens[i] + ",");
                                }
                                //stop the run to check for errors
                                System.exit(0);
                            }
                            
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------
    public static Absence getAbsenceWExcuse(String studentID, String date) { 
        //when thid method is called, the user chose a Student id
        //we dont have to make sure that the status and the reason exist because we 
        //already checked in the displayExcuses method
        //which means the user could've never chosen an absence without an excuse submitted
        
        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(",", 0);
                boolean found =false;
                for (int token = 0; token < tokens.length; token++) {

                    if (studentID.equals(tokens[token]) && date.equals(tokens[token + 3])) {
                        found = true;
                        String F_name = tokens[token + 1];
                        String L_name = tokens[token + 2];
                        Student student = new Student(F_name, L_name, studentID);

                        if(!tokens[token+4].equals("unexcused")){
                            String status = tokens[token + 4];
                            String reason = tokens[token + 5];
                            Excuse excuse = new Excuse(reason, status);
                            return new Absence(student, date, excuse);
                        }
                        else if (tokens[token+4].equals("unexcused")) {
                            System.out.println("No excuse was submitted for this absence within 48 hours. Unexcused Absence");
                            return null;
                        } 
                    }
                }
                if(found == false){
                    System.out.println("couldent find an absence with the provided data");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("There is no absence registered in the file "
                    + "for the student ID: " + studentID + " on the date: " + date);
            e.printStackTrace();

        }
        return null;

    }

    //-----------------------------------------------------------------------------------
    public static Absence getAbsenceForParent(String studentID, String date) { 

        try (BufferedReader reader = new BufferedReader(new FileReader(AttendanceFile))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(",", 0);

                for (int token = 0; token < tokens.length; token++) {

                    if (studentID.equals(tokens[token]) && date.equals(tokens[token + 3])) {
                        Student student = new Student(tokens[token + 1], tokens[token + 2], tokens[token]);
                        Absence absence = new Absence(student, date, null);
                        return absence;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("There is no absence registered in the file "
                    + "for the student ID: " + studentID + " on the date: " + date);
            e.printStackTrace();

        }
        return null;
    }
}
