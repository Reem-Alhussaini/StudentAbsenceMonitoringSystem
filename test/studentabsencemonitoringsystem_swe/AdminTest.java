package studentabsencemonitoringsystem_swe;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdminTest {

    public AdminTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of registerAbsence method, of class Admin.
     */
    @Test
    public void testRegisterAbsence() throws Exception {
        Student student = new Student("Lama", "Aljohani", "2105999");
        Excuse excuse = new Excuse("sick", "waiting for evaluation");
        Absence absence = new Absence(student, "AbsenceReason", excuse);

        try {

            Admin.registerAbsence(absence, student);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Test of evaluateExcuse method, of class Admin.
     */
    @Test
    public void testEvaluateExcuse() {
        String input = "accepted";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        String absenceID = "123";
        String date = "2023-12-05";

        Admin.evaluateExcuse(absenceID, date, scanner);

    }

}
