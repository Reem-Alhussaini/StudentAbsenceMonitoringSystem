package studentabsencemonitoringsystem_swe;

public class Excuse {

    private String reason;
    private String status;

    public Excuse(String reason, String status) {
        this.reason = reason;
        this.status = status;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

}
