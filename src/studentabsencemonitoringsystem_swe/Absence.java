package studentabsencemonitoringsystem_swe;

import java.util.Scanner;
import java.util.ArrayList;

//made a static counter to increment the id 
public class Absence {

    private String Date;
    private static int counter = 0;
    private int id;
    private Student student;
    private Excuse excuse;
    public static ArrayList<Absence> absences;

    //removed id from constructor 
    public Absence(Student student, String Date, Excuse excuse) {
        this.Date = Date;
        this.id = counter++;
        this.student = student;
        this.excuse = excuse;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setId(int id) {
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

    public int getId() {
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
        System.out.print("Enter absence Date:");
        String date = in.next();

        in.close();
        Absence absence = new Absence(student, date, null);   
        absences.add(absence);
        return absence;
    }
//-----------------------------------------------------------------------------
    public static Absence getAbsenceViaAbsenceID(int id){
        for(int i = 0; i < absences.size(); i++){
            if(id == absences.get(i).getId()){
                return absences.get(i);
            }
            else{
                System.out.println("invalid id number");
            }
        }
        return null;
    }

}
