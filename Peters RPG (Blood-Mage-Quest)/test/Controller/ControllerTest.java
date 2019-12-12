/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PeterNB
 */
public class ControllerTest {
    
    public ControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isStatusscreen method, of class Controller.
     */
   /* @Test
    public void testIsStatusscreen() {
        System.out.println("isStatusscreen");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.isStatusscreen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/

    /**
     * Test of setStatusscreen method, of class Controller.
     */
    /*@Test
    public void testSetStatusscreen() {
        System.out.println("setStatusscreen");
        boolean statusscreen = false;
        Controller instance = new Controller();
        instance.setStatusscreen(statusscreen);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/

    /**
     * Test of isFightscreen method, of class Controller.
     */
   /* @Test
    public void testIsFightscreen() {
        System.out.println("isFightscreen");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.isFightscreen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/

    /**
     * Test of getGuiarray method, of class Controller.
     */
   /* @Test
    public void testGetGuiarray_0args() {
        System.out.println("getGuiarray");
        Controller instance = new Controller();
        String[][] expResult = null;
        String[][] result = instance.getGuiarray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/

    /**
     * Test of getModel method, of class Controller.
     */
    /*@Test
    public void testGetModel() {
        System.out.println("getModel");
        Controller instance = new Controller();
        Model expResult = null;
        Model result = instance.getModel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/

    /**
     * Test of keycontrol method, of class Controller.
     */
    @Test
    public void testKeycontrol1() {
        System.out.println("keycontrol");
        KeyEvent e = null;
        int test = 0;
        Controller instance = new Controller();
        instance.keycontrol(e);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(test, instance.getJutest());
        //fail("The test case is a prototype.");
    }
}
