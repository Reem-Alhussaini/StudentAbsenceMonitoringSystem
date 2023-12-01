package studentabsencemonitoringsystem_swe;

import java.util.Scanner;
import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentAbsenceMonitoringSystem_SWE {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("****** Student Absence Monitoring System ******");
        int choice;
        
        do {
            displayMenu();
            choice = input.nextInt();
            handleChoice(input,choice);
        } while (choice != 3);

        input.close();

    }
    //-----------------------------------------------------------------------------
    static void displayMenu() {
        System.out.println("Enter a number to select:");
        System.out.println("1. Register Absence or Evaluate Excuse (for Admin)");
        System.out.println("2. Submit Excuse or View Excuse Status (for Parent)");
        System.out.println("3. Quit");
    }
    //-----------------------------------------------------------------------------
    static void handleChoice(Scanner scanner, int choice) {

        if(choice == 1){
            adminFunctions(scanner);
        }
        else if (choice == 2) {
            parentFunctions(scanner);
        }
        else if (choice == 3) {
            System.out.println("Quitting the program");
        }
        else{
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
    //-----------------------------------------------------------------------------
    static void adminFunctions(Scanner scanner) {
        System.out.println("You're choosing Register Absence or Evaluate Excuse (for Admin)");
        System.out.println("Enter a number to select:");
        System.out.println("1. Register Absence");
        System.out.println("2. Evaluate Excuse");
        int adminChoice = scanner.nextInt();

        //-------------------------------------------
        if (adminChoice == 1) {
            //register absence
            try {
                callRegisterAbsence();
            } catch (IOException e) {
                System.out.println("Error: couldent register absence");
            }
        //-------------------------------------------   
        } else if (adminChoice == 2) {
            //evaluate excuse
            callEvaluateExcuse(scanner);
        //-------------------------------------------
        } else {
            System.out.println("Invalid choice");
        }
        //-------------------------------------------
    }
    //-----------------------------------------------------------------------------
    static void parentFunctions(Scanner scanner){
        System.out.println("You're choosing Add Excuse or View Excuse Status (for Parent)");
        System.out.println("Enter a number to select:");
        System.out.println("1. Submit Excuse");
        System.out.println("2. View Excuse Status");
        int parentChoice = scanner.nextInt();

        if (parentChoice == 1) {
            //submit excuse
            callSubmitExcuse(scanner);
        //-------------------------------------------    
        } else if (parentChoice == 2) {
            //view excuse status
           //Parent.viewExcuseStatus();
        //-------------------------------------------
        } else {
            System.out.println("Invalid choice");
        }
    }
    //-----------------------------------------------------------------------------
    static void callRegisterAbsence() throws IOException{  //AbsenceTimer Remaining

        //prompt admin for student info
        Student student = Student.getStudentInfo(); 

        //prompt admin for absence info
        Absence absence = Absence.getAbsenceInfo(student); 

        //register absence in file
        Admin.registerAbsence(absence, student);
    }
    //-----------------------------------------------------------------------------
    static void callEvaluateExcuse(Scanner scanner){ 

        //get Absences date
         String date = Absence.getAbsencesDate(scanner);
            
        //dispaly all excuses with the entered date
        FileManagement.displayExcuses(date);
        
        //let admin choose which excuse to evaluate
        System.out.println("Enter the id of the absence excuse you want to evaluate: ");
        String id = scanner.nextLine();

        Admin.evaluateExcuse(id);
    }
    //-----------------------------------------------------------------------------
    static void callSubmitExcuse(Scanner scanner){
        
        //get Student ID
        System.out.println("Enter the ID of the student you want to submit an excuse for: ");
        String id = scanner.nextLine();

        //get absence date
        System.out.println("Enter the date of absence in this format \"dd/MM/yyyy\": ");
        String date = scanner.nextLine();

        //get excuse reason
        System.out.println("Enter absence reason: ");
        String reason = scanner.nextLine();

        //submit excuse
        try {
            Parent.submitExcuse(id, date, reason);
        } catch (IOException e) {
            System.out.println("Error: Failed to submit excuse!");
        }
    }
    //-----------------------------------------------------------------------------
    static void callViewExcuseStatus(Scanner scanner){

        //get Student ID
        System.out.println("Enter the ID of the student you want to submit an excuse for: ");
        String id = scanner.nextLine();

        //get absence date
        System.out.println("Enter the date of absence in this format \"dd/MM/yyyy\": ");
        String date = scanner.nextLine();

        //view excuse status
        Parent.viewExcuseStatus(id, date);
    }

}//c
