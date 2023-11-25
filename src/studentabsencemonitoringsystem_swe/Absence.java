package studentabsencemonitoringsystem_swe;

import java.util.Scanner;

public class Absence {

    private String Date;
    private int id = 0;
    private Student student;
    private Excuse execuse;

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setExecuse(Excuse execuse) {
        this.execuse = execuse;
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

    public Excuse getExecuse() {
        return execuse;
    }

    public Absence(Student student, String Date, Excuse execuse, int id) {
        this.Date = Date;
        this.id = id;
        this.student = student;
        this.execuse = execuse;
    }

    public void getStudentInfo() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Student first name:");
        String fname = in.next();
        System.out.print("Enter Student last name:");
        String lname = in.next();
        System.out.print("Enter Student ID:");
        String id = in.next();

        Student student = new Student(fname, lname, id);
    }

    public void getAbsenceInfo(Student student) {
        id++;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter absence Date:");
        String date = in.next();

        Absence absence = new Absence(student, date, null, id);
        Admin.registerAbsence(absence, student);
    }
}
