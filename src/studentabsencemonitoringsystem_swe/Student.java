package studentabsencemonitoringsystem_swe;

public class Student extends User {

    public Student(String F_name, String L_name, String id) {
        super(F_name, L_name, id);
    }

    @Override
    public String getF_name() {
        return super.getF_name();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getL_name() {
        return super.getL_name();
    }

    @Override
    public void setF_name(String F_name) {
        super.setF_name(F_name);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public void setL_name(String L_name) {
        super.setL_name(L_name);
    }

}
