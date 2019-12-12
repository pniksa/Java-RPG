/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelrest;

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
public class LabyrinthGeneratorTest {

    public LabyrinthGeneratorTest() {
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
     * Test of getDoorarraym method, of class LabyrinthGenerator.
     */
    /* @Test
    public void testGetDoorarraym() {
    System.out.println("getDoorarraym");
    LabyrinthGenerator instance = new LabyrinthGenerator();
    int[] expResult = null;
    int[] result = instance.getDoorarraym();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of labgenerator method, of class LabyrinthGenerator.
     */
    @Test
    public void testLabgenerator() {
        /**Es wird nicht getestet ob das lab lösbar ist!*/
        System.out.println("labgenerator");
        int s = 1;
        LabyrinthGenerator instance = new LabyrinthGenerator();
        String[][] expResult = null;
        String[][] result = instance.labgenerator(s);
        for(int i = 0; i < Konstanten.GFIELDHEIGTH; i++) {
            for(int j = 0; j < Konstanten.GFIELDWIDTH; j++) {
                assertNotNull(result[i][j]);
            }
        }
        assertEquals(0, instance.getDoorarraym()[0]);
        assertEquals(0, instance.getDoorarraym()[1]);
        assertEquals(result[0][0], Konstanten.BORDER);
        assertEquals(result[instance.getDoorarraym()[
                3] + 1][instance.getDoorarraym()[2]], Konstanten.LF);
        assertEquals(result[instance.getDoorarraym()[
                3]][instance.getDoorarraym()[2]], " ");
        assertEquals(Konstanten.GFIELDHEIGTH - 2, instance.getDoorarraym()[3]);
        s = Konstanten.LASTLEVEL;
        result = instance.labgenerator(s);
        assertEquals(0, instance.getDoorarraym()[2]);
        assertEquals(0, instance.getDoorarraym()[3]);
        assertEquals(result[0][0], Konstanten.BORDER);
        assertEquals(1, instance.getDoorarraym()[1]);
        assertEquals(result[instance.getDoorarraym()[
                1] - 1][instance.getDoorarraym()[0]], Konstanten.LB);
        assertEquals(result[instance.getDoorarraym()[
                1]][instance.getDoorarraym()[0]], " ");
        for(int i = 0; i < Konstanten.GFIELDHEIGTH; i++) {
            for(int j = 0; j < Konstanten.GFIELDWIDTH; j++) {
                assertNotNull(result[i][j]);
            }
        }
        s = 2;
        result = instance.labgenerator(s);
        assertNotSame(0, instance.getDoorarraym()[0]);
        assertNotSame(0, instance.getDoorarraym()[2]);
        assertNotSame(Konstanten.GFIELDWIDTH - 1, instance.getDoorarraym()[0]);
        assertNotSame(Konstanten.GFIELDWIDTH - 1, instance.getDoorarraym()[2]);
        assertEquals(1, instance.getDoorarraym()[1]);
        assertEquals(Konstanten.GFIELDHEIGTH - 2, instance.getDoorarraym()[3]);
        assertEquals(result[instance.getDoorarraym()[
                1] - 1][instance.getDoorarraym()[0]], Konstanten.LB);
        assertEquals(result[instance.getDoorarraym()[
                3] + 1][instance.getDoorarraym()[2]], Konstanten.LF);
        assertEquals(result[instance.getDoorarraym()[
                1]][instance.getDoorarraym()[0]], " ");
        assertEquals(result[instance.getDoorarraym()[
                3]][instance.getDoorarraym()[2]], " ");
        for(int i = 0; i < Konstanten.GFIELDHEIGTH; i++) {
            for(int j = 0; j < Konstanten.GFIELDWIDTH; j++) {
                assertNotNull(result[i][j]);
            }
        }

        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
