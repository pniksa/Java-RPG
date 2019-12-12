/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gegner;

import java.awt.event.KeyEvent;
import Modelrest.Model;
import Modelrest.Hero;
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
public class ThiefTest {
    
    public ThiefTest() {
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
     * Test of getEfp method, of class Thief.
     */
  /*  @Test
    public void testGetEfp() {
        System.out.println("getEfp");
        Thief instance = new Thief();
        int expResult = 0;
        int result = instance.getEfp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getThieflp method, of class Thief.
     */
    /*@Test
    public void testGetThieflp() {
        System.out.println("getThieflp");
        Thief instance = new Thief();
        int expResult = 0;
        int result = instance.getThieflp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of thiefmove method, of class Thief.
     */
    @Test
    public void testThiefmove() {
        System.out.println("thiefmove");
        int i = 0;
        int j = 0;
        Model model = new Model();
        String[][] guiarray = guiarray = model.getGuiarray();
        Thief instance = new Thief();
        while (!guiarray[i][j].equals(" ")) {
            j++;
            while (!guiarray[i][j].equals(" ")) {
                i++;
            }
        }
        int[] expResult = new int[2];
        int[] result = instance.thiefmove(i, j, guiarray);
        if(result[0]!=i && result[1]!=j) {
        assertEquals(" ", guiarray[result[0]][result[1]]);
        }
        assertTrue(Math.abs(result[0] - i) < 3);
        assertTrue(Math.abs(result[1] - j) < 3);
    }

    /**
     * Test of attacked method, of class Thief.
     */
    @Test
    public void testAttacked() {
        System.out.println("attacked");
        Hero hero = new Hero();
        Gegner gegner = new Gegner("T", 1, 1);
        int action = 0;
        int e = 0;
        Thief instance = new Thief();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        int test = gegner.getLifepoints();
        String expResult = "";
        String result = instance.attacked(hero, gegner, action, e);
        assertEquals(expResult, result);
        hero = new Hero();
        e = KeyEvent.VK_1;
        result = instance.attacked(hero, gegner, action, e);
        expResult = "Du hast dem Gegner einen Schaden von 0 zugefügt.";
        assertEquals(expResult, result);
        e = KeyEvent.VK_2;
        result = instance.attacked(hero, gegner, action, e);
        expResult = "Verteidigung eingesetzt.";
        assertEquals(expResult, result);
    }

    /**
     * Test of fight method, of class Thief.
     */
    @Test
    public void testFight() {
        System.out.println("fight");
        Hero hero = new Hero();
        Gegner gegner = new Gegner("T", 1, 1);
        int action = 0;
        int e = 0;
        Thief instance = new Thief();
        hero.setLifepoints(1);
        String expResult = "";
        String result = instance.fight(hero, gegner, action, e);
        assertNotSame(expResult, result);
        assertTrue(hero.getLifepoints() <= 0);
        hero.setDefense(10000000);
        hero.setLifepoints(1);
        result = instance.fight(hero, gegner, action, e);
        assertTrue(hero.getLifepoints() > 0);
    }
}
