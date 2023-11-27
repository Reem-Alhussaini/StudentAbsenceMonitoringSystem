package studentabsencemonitoringsystem_swe;

import java.util.Scanner;

public class StudentAbsenceMonitoringSystem_SWE {

    public static void main(String[] args) {
        System.out.println("****** Student Absence Monitoring System ******");
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            displayMenu();
            choice = input.nextInt();
            handleChoice(choice);
        } while (choice != 3);

        input.close();

    }//mian 

    public static void displayMenu() {
        System.out.println("Enter a number to select:");
        System.out.println("1. Register Absence or Evaluate Excuse (for Admin)");
        System.out.println("2.Submit Excuse or View Excuse Status (for Parent)");
        System.out.println("3. Quit");
    }

    //-----------------------------------------------------------------------------
    public static void handleChoice(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.println("You're choosing Register Absence or Evaluate Excuse (for Admin)");
                System.out.println("Enter a number to select:");
                System.out.println("1. Register Absence");
                System.out.println("2. Evaluate Excuse");
                int adminChoice = scanner.nextInt();

                if (adminChoice == 1) {
                 //  Admin.registerAbsence(absence, student);
                } else if (adminChoice == 2) {
                   
                } else {
                    System.out.println("Invalid choice");
                }
                break;
            case 2:
                System.out.println("You're choosing Add Excuse or View Excuse Status (for Parent)");
                System.out.println("Enter a number to select:");
                System.out.println("1. Submit Excuse");
                System.out.println("2. View Excuse Status");
                int parentChoice = scanner.nextInt();

                if (parentChoice == 1) {
                   //Parent.submitExcuse();
                } else if (parentChoice == 2) {
                   // viewExcuseStatus();
                } else {
                    System.out.println("Invalid choice");
                }
                break;
            case 3:
                System.out.println("Quitting the program");
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }

}//c
