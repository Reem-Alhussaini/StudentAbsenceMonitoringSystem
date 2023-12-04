/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentabsencemonitoringsystem_swe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ASUS
 */
public class AbsenceTimerTest {
    
    public AbsenceTimerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
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
        assertFalse(AbsenceTimer.Timer(absence));
    }

    @Test
    public void testTimerExpired() {
        System.out.println("testTimerExpired");

        // Create an Absence instance with a start time more than 48 hours ago
        Absence absence = new Absence(null, null, null);

        // Set the start time to a value more than 48 hours ago
        absence.startTime = System.currentTimeMillis() - (1000 * 60 * 60 * 49); // 49 hours ago

        // Verify that the timer returns true (expired)
        assertTrue(AbsenceTimer.Timer(absence));
    }

    @Test
    public void testTimerWithNullAbsence() {
        System.out.println("testTimerWithNullAbsence");

        // Verify that the timer returns false when the absence is null
        assertFalse(AbsenceTimer.Timer(null));
    }
}

    

