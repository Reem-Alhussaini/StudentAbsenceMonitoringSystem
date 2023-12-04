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
import static org.junit.Assert.*;

/**
 *
 * @author NOUR
 */
public class ParentTest {
    
    public ParentTest() {
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
     * Test of submitExcuse method, of class Parent.
     */
    @Test
    public void testSubmitExcuse() throws Exception {
        System.out.println("submitExcuse");
        String studentID = "2106814";
        String date = "3/11/2023";
        String reason = "Medical appointment";
        //FileManagement.insertExcuse
        
        //String result = Parent.submitExcuse(studentID, date, reason);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        //Parent.submitExcuse(studentID, date, reason);
        //assertEquals("excuse added sucessfully", result);
    }

    /**
     * Test of viewExcuseStatus method, of class Parent.
     */
    @Test
    public void testViewExcuseStatus() {
        System.out.println("viewExcuseStatus");
        String studentID = "2106814";
        String date = "3/11/2023";
        Parent.viewExcuseStatus(studentID, date);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
