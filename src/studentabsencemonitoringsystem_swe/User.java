package studentabsencemonitoringsystem_swe;

public class User {
    String F_name;
    String L_name;
    String id;

    public User(String F_name, String L_name, String id) {
        this.F_name = F_name;
        this.L_name = L_name;
        this.id = id;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String F_name) {
        this.F_name = F_name;
    }

    public String getL_name() {
        return L_name;
    }

    public void setL_name(String L_name) {
        this.L_name = L_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
