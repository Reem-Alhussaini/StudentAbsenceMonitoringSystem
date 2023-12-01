package studentabsencemonitoringsystem_swe;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//made a static counter to increment the id 
public class Absence {

    private String Date;
    private static int counter = 0;
    private String id;
    private Student student;
    private Excuse excuse;
    

    //removed id from constructor 
    public Absence(Student student, String Date, Excuse excuse) {
        this.Date = Date;
        this.id = String.valueOf(counter++);
        this.student = student;
        this.excuse = excuse;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Excuse getExcuse() {
        return excuse;
    }
//-----------------------------------------------------------------------------
    public static Absence getAbsenceInfo(Student student) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter absence Date in this format \"dd/MM/yyyy\": ");
        String date = in.next();

        in.close();

        return new Absence(student, date, null); 
    }
//-----------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------
    public static String getAbsencesDate(Scanner scanner){
        System.out.println("Enter the date of the absences you want to evaluate in this format \"dd/MM/yyyy\": ");
        String strDate = scanner.nextLine();
        //Date date=new SimpleDateFormat("dd/MM/yyyy").parse(strDate);  

        return strDate;
    }

}
