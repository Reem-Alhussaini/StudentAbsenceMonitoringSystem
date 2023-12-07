package studentabsencemonitoringsystem_swe;

//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.Test;


import java.util.Scanner;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

//import static org.junit.jupiter.api.Assertions.*;

public class AbsenceTest {

    //@BeforeAll
    public static void setUpClass() {
        // Setup code that runs once before any test method
    }

    //@AfterAll
    public static void tearDownClass() {
        // Cleanup code that runs once after all test methods
    }

    //@BeforeEach
    public void setUp() {
        // Setup code that runs before each test method
    }

    //@AfterEach
    public void tearDown() {
        // Cleanup code that runs after each test method
    }

    @Test
    public void testGetAbsenceInfo() {
        System.out.println("testGetAbsenceInfo");
        // Mocking user input for testing
        String mockInput = "Lama \nAlamri\n2107528\n01/01/2023";
        Scanner scanner = new Scanner(mockInput);
        // Call the static method to get Absence information
        Absence result = Absence.getAbsenceInfo(scanner);
        // Verify that the result is not null
        assertNotNull(result);
        // Verify the expected values based on the mock input
        assertEquals("Lama", result.getStudent().getF_name());
        assertEquals("Alamri", result.getStudent().getL_name());
        assertEquals("2107528", result.getStudent().getId());
        assertEquals("01/01/2023", result.getDate());
        // Close the scanner
        scanner.close();
    }

    @Test
    public void testGetAbsencesDate() {
        System.out.println("testGetAbsencesDate");
        // Mocking user input for testing
        String mockInput = "01/01/2023";
        Scanner scanner = new Scanner(mockInput);
        // Call the static method to get the absence date
        String result = Absence.getAbsencesDate(scanner);
        // Verify that the result is not null
        assertNotNull(result);
        // Verify the expected date based on the mock input
        assertEquals("01/01/2023", result);
        // Close the scanner
        scanner.close();
    }
}
