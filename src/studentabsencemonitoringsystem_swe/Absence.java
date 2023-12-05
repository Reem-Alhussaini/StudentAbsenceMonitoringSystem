package studentabsencemonitoringsystem_swe;

import java.util.Scanner;

//made a static counter to increment the id 
public class Absence {

    private String Date;
    private Student student;
    private Excuse excuse;
    long startTime;//Changed access level to package-private
    private AbsenceTimer timer;
 
//removed id from constructor 
    public Absence(Student student, String Date, Excuse excuse) {
        this.Date = Date;
        this.student = student;
        this.excuse = excuse;
        this.startTime = System.currentTimeMillis();
        this.timer = new AbsenceTimer(this);
    }
    
    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setExcuse(Excuse excuse) {
        this.excuse = excuse;
    }

    public String getDate() {
        return Date;
    }

    public Student getStudent() {
        return student;
    }

    public Excuse getExcuse() {
        return excuse;
    }

    public long getStartTime() {
        return startTime;
    }


//-----------------------------------------------------------------------------

    public static Absence getAbsenceInfo(Scanner scanner) {

        System.out.print("Enter Student first name:");
        String fname = scanner.next();
        System.out.print("Enter Student last name:");
        String lname = scanner.next();
        System.out.print("Enter Student ID:");
        String id = scanner.next();

        Student student = new Student(fname, lname, id);

        System.out.print("Enter absence Date in this format \"dd/MM/yyyy\": ");
        String date = scanner.next();

        Absence absence = new Absence(student, date, null);
        return absence;
    }
//-----------------------------------------------------------------------------

    public static String getAbsencesDate(Scanner scanner) {
        System.out.println("Enter the date of the absences you want to evaluate in this format \"dd/MM/yyyy\": ");
        String strDate = scanner.next();

        return strDate;
    }

}