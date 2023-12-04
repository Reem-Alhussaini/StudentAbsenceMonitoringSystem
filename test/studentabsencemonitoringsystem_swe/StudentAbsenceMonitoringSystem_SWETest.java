/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentabsencemonitoringsystem_swe;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NOUR
 */
public class StudentAbsenceMonitoringSystem_SWETest {
    
    public StudentAbsenceMonitoringSystem_SWETest() {
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
     * Test of main method, of class StudentAbsenceMonitoringSystem_SWE.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StudentAbsenceMonitoringSystem_SWE.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMenu method, of class StudentAbsenceMonitoringSystem_SWE.
     */
    @Test
    public void testDisplayMenu() {
        System.out.println("displayMenu");
        StudentAbsenceMonitoringSystem_SWE.displayMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleChoice method, of class StudentAbsenceMonitoringSystem_SWE.
     */
    @Test
    public void testHandleChoice() {
        System.out.println("handleChoice");
        Scanner scanner = null;
        int choice = 0;
        StudentAbsenceMonitoringSystem_SWE.handleChoice(scanner, choice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adminFunctions method, of class StudentAbsenceMonitoringSystem_SWE.
     */
    @Test
    public void testAdminFunctions() {
        System.out.println("adminFunctions");
        Scanner scanner = null;
        StudentAbsenceMonitoringSystem_SWE.adminFunctions(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parentFunctions method, of class StudentAbsenceMonitoringSystem_SWE.
     */
    @Test
    public void testParentFunctions() {
        System.out.println("parentFunctions");
        Scanner scanner = null;
        StudentAbsenceMonitoringSystem_SWE.parentFunctions(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of callRegisterAbsence method, of class StudentAbsenceMonitoringSystem_SWE.
     */
    @Test
    public void testCallRegisterAbsence() throws Exception {
        System.out.println("callRegisterAbsence");
        StudentAbsenceMonitoringSystem_SWE.callRegisterAbsence();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of callEvaluateExcuse method, of class StudentAbsenceMonitoringSystem_SWE.
     */
    @Test
    public void testCallEvaluateExcuse() {
        System.out.println("callEvaluateExcuse");
        Scanner scanner = null;
        StudentAbsenceMonitoringSystem_SWE.callEvaluateExcuse(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of callSubmitExcuse method, of class StudentAbsenceMonitoringSystem_SWE.
     */
    @Test
    public void testCallSubmitExcuse() {
        System.out.println("callSubmitExcuse");
        Scanner scanner = null;
        StudentAbsenceMonitoringSystem_SWE.callSubmitExcuse(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of callViewExcuseStatus method, of class StudentAbsenceMonitoringSystem_SWE.
     */
    @Test
    public void testCallViewExcuseStatus() {
        System.out.println("callViewExcuseStatus");
        Scanner scanner = null;
        StudentAbsenceMonitoringSystem_SWE.callViewExcuseStatus(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
