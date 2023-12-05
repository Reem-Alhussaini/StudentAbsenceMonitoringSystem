package studentabsencemonitoringsystem_swe;

import java.util.Timer;
import java.util.TimerTask;

public class AbsenceTimer {

    static boolean Timer(Absence absence) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Timer timer;
    private Absence absence;
    private static final long TIMEOUT =2*60*100;//48 * 60 * 60 * 1000; // 48 hours in milliseconds

    public AbsenceTimer(Absence absence) {
        this.absence = absence;
        startTimer();
    }



 private void startTimer() {
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handleTimeout();
            }
        }, TIMEOUT);
    }
public boolean isTimerRunning() {
        return timer != null; // Adjust this condition based on your actual timer logic
    }

    private void handleTimeout() {
        
        if (absence.getExcuse() == null && !absence.getExcuse().getStatus().equalsIgnoreCase("waiting for evaluation")) {
            System.out.println("Absence without excuse recorded due to timeout.");
            // Handle the absence without excuse, e.g., store it in a file/database
            absence .getExcuse().setStatus("unexcused absence");
        }
        timer.cancel();
    }
}