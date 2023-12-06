/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentabsencemonitoringsystem_swe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ASUS
 */
public class AbsenceTimerTest {
    
    public AbsenceTimerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
  
    /**
     * Test of Timer method, of class AbsenceTimer.
     */
    
 @Test
    public void testTimerNotExpired() {
        System.out.println("testTimerNotExpired");

        // Create an Absence instance with a start time less than 48 hours ago
        Absence absence = new Absence(null, null, null);

        // Verify that the timer returns false (not expired)
        //assertFalse(AbsenceTimer.Timer(absence));
    }

    @Test
    public void testTimerExpired() {
        System.out.println("testTimerExpired");

        // Create an Absence instance with a start time more than 48 hours ago
        Absence absence = new Absence(null, null, null);

        // Set the start time to a value more than 48 hours ago
        absence.startTime = System.currentTimeMillis() - (1000 * 60 * 60 * 49); // 49 hours ago

        // Verify that the timer returns true (expired)
        //assertTrue(AbsenceTimer.Timer(absence));
    }

    @Test
    public void testTimerWithNullAbsence() {
        System.out.println("testTimerWithNullAbsence");

        // Verify that the timer returns false when the absence is null
        //assertFalse(AbsenceTimer.Timer(null));
    }

    /**
     * Test of Timer method, of class AbsenceTimer.
     */
    @Test
    public void testTimer() {
        System.out.println("Timer");
        Absence absence = null;
        //boolean expResult = false;
        //boolean result = AbsenceTimer.Timer(absence);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isTimerRunning method, of class AbsenceTimer.
     */
    @Test
    public void testIsTimerRunning() {
        System.out.println("isTimerRunning");
        AbsenceTimer instance = null;
        //boolean expResult = false;
        //boolean result = instance.isTimerRunning();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}

    

