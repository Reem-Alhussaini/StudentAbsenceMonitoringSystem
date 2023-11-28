package studentabsencemonitoringsystem_swe;

import java.util.Scanner;
import java.util.Date;
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

    public static void displayMenu() {
        System.out.println("Enter a number to select:");
        System.out.println("1. Register Absence or Evaluate Excuse (for Admin)");
        System.out.println("2. Submit Excuse or View Excuse Status (for Parent)");
        System.out.println("3. Quit");
    }

    //-----------------------------------------------------------------------------
    public static void handleChoice(Scanner scanner, int choice) {

        if(choice == 1){
            try {
                adminFunctions(scanner);
            } catch (ParseException e) {
                e.printStackTrace();
            }
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
    public static void adminFunctions(Scanner scanner) throws ParseException{
        System.out.println("You're choosing Register Absence or Evaluate Excuse (for Admin)");
        System.out.println("Enter a number to select:");
        System.out.println("1. Register Absence");
        System.out.println("2. Evaluate Excuse");
        int adminChoice = scanner.nextInt();

        if (adminChoice == 1) {
            //register absence
            Student student = Student.getStudentInfo(); //prompt admin for student info
            Absence absence = Absence.getAbsenceInfo(student); //prompt admin for absence info
            Admin.registerAbsence(absence, student);

        } else if (adminChoice == 2) {
            //evaluate absence

            //get Absences date
            System.out.println("Enter the date of the absences you want to evaluate in this format \"dd/MM/yyyy\": ");
            String strDate = scanner.nextLine();
            Date date=new SimpleDateFormat("dd/MM/yyyy").parse(strDate);  
            
            //dispaly all excuses with the entered date
            FileManagement.displayExcuses(date);
            
            //let admin choose which excuse to evaluate
            System.out.println("enter the id of the absence you want to evaluate: ");
            int id = scanner.nextInt();

            Admin.evaluateExcuse(id);

        } else {
            System.out.println("Invalid choice");
        }
        
    }
    //-----------------------------------------------------------------------------
    public static void parentFunctions(Scanner scanner){
        System.out.println("You're choosing Add Excuse or View Excuse Status (for Parent)");
        System.out.println("Enter a number to select:");
        System.out.println("1. Submit Excuse");
        System.out.println("2. View Excuse Status");
        int parentChoice = scanner.nextInt();

        if (parentChoice == 1) {
            //get excuse and student id and date of absence
            //Parent.submitExcuse();
        } else if (parentChoice == 2) {
            //get student id and date of absence
           //Parent.viewExcuseStatus();
        } else {
            System.out.println("Invalid choice");
        }
    }

}//c
