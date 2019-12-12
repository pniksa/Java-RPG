/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gegner;

import Modelrest.Model;
import java.awt.event.KeyEvent;
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
public class WolfTest {
    
    public WolfTest() {
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
     * Test of getEfp method, of class Wolf.
     */
   /* @Test
    public void testGetEfp() {
        System.out.println("getEfp");
        Wolf instance = new Wolf();
        int expResult = 0;
        int result = instance.getEfp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWolflp method, of class Wolf.
     */
   /* @Test
    public void testGetWolflp() {
        System.out.println("getWolflp");
        Wolf instance = new Wolf();
        int expResult = 0;
        int result = instance.getWolflp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wolfmove method, of class Wolf.
     */
    @Test
    public void testWolfmove() {
        System.out.println("wolfmove");
        Model model = new Model();
        Hero hero = model.getHero();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        int i = 0;
        int j = 0;
        String[][] guiarray = model.getGuiarray();
        while (!guiarray[i][j].equals(" ")) {
            j++;
            while (!guiarray[i][j].equals(" ")) {
                i++;
            }
        }
        Wolf instance = new Wolf();
        int[] expResult = new int[2];
        int[] result = instance.wolfmove(i, j, hero, guiarray);
        //assertEquals(expResult, result);
        if(result[0]!=i && result[1]!=j) {
        assertEquals(" ", guiarray[result[0]][result[1]]);
        }
        assertTrue(Math.abs(result[0] - i) < 2);
        assertTrue(Math.abs(result[1] - j) < 2);
    }

    /**
     * Test of fight method, of class Wolf.
     */
    @Test
    public void testFight() {
        System.out.println("fight");
        Hero hero = new Hero();
        Gegner gegner = new Gegner("W", 1, 1);
        int action = 0;
        int button = 0;
        Wolf instance = new Wolf();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        hero.setLifepoints(1);
        hero.setDefense(0);
        String expResult = "";
        String result = instance.fight(hero, gegner, action, button);
        assertNotSame(expResult, result);
        assertTrue(hero.getLifepoints() <= 0);
        hero.setDefense(10000000);
        hero.setLifepoints(1);
        result = instance.fight(hero, gegner, action, button);
        assertTrue(hero.getLifepoints() > 0);
    }

    /**
     * Test of attacked method, of class Wolf.
     */
    @Test
    public void testAttacked() {
        System.out.println("attacked");
        Hero hero = new Hero();
        Gegner gegner = new Gegner("W", 1, 1);
        int action = 0;
        int e = 0;
        Wolf instance = new Wolf();
        int test = gegner.getLifepoints();
        String expResult = "";
        String result = instance.attacked(hero, gegner, action, e);
        assertEquals(expResult, result);
        hero = new Hero();
        e = KeyEvent.VK_2;
        result = instance.attacked(hero, gegner, action, e);
        expResult = "Verteidigung eingesetzt.";
        assertEquals(expResult, result);

    }
}
