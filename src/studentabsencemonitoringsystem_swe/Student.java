package studentabsencemonitoringsystem_swe;

import java.util.Scanner;

public class Student extends User {
    
    public Student(String F_name, String L_name, String id) {
        super(F_name, L_name, id);
    }

    @Override
    public String getF_name() {
        // TODO Auto-generated method stub
        return super.getF_name();
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }

    @Override
    public String getL_name() {
        // TODO Auto-generated method stub
        return super.getL_name();
    }

    @Override
    public void setF_name(String F_name) {
        // TODO Auto-generated method stub
        super.setF_name(F_name);
    }

    @Override
    public void setId(String id) {
        // TODO Auto-generated method stub
        super.setId(id);
    }

    @Override
    public void setL_name(String L_name) {
        // TODO Auto-generated method stub
        super.setL_name(L_name);
    }

     public static Student getStudentInfo() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Student first name:");
        String fname = in.next();
        System.out.print("Enter Student last name:");
        String lname = in.next();
        System.out.print("Enter Student ID:");
        String id = in.next();

        in.close();
        return new Student(fname, lname, id);
    }
}
