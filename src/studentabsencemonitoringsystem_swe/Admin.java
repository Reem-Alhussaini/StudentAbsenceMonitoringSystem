package studentabsencemonitoringsystem_swe;

public class Admin extends User {

    public Admin(String F_name, String L_name, String id) {
        super(F_name, L_name, id);
    }

    public static void registerAbsence(Absence absence, Student student) {
        System.out.println(FileManagement.insertStudent(student));
        System.out.println(FileManagement.insertAbsence(absence));

    }

}
