package studentabsencemonitoringsystem_swe;

public class AbsenceTimer {

    public static boolean Timer(Absence absence) {
        long currentTime = System.currentTimeMillis();
        long hoursPassed = (currentTime - absence.getStartTime()) / (1000 * 60 * 60);
        return hoursPassed >= 48;
    }

}
