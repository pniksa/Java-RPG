/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gegner;

import Modelrest.Model;
import Modelrest.Hero;
import java.awt.event.InputEvent;
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
public class DragonTest {

    public DragonTest() {
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
     * Test of getEfp method, of class Dragon.
     */
    /*  @Test
    public void testGetEfp() {
    System.out.println("getEfp");
    Dragon instance = new Dragon();
    int expResult = 0;
    int result = instance.getEfp();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of getDragonlp method, of class Dragon.
     */
    /*@Test
    public void testGetDragonlp() {
    System.out.println("getDragonlp");
    Dragon instance = new Dragon();
    int expResult = 0;
    int result = instance.getDragonlp();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of dragonmove method, of class Dragon.
     */
    @Test
    public void testDragonmove() {
        System.out.println("dragonmove");
        int i = 0;
        int j = 0;
        Model model = new Model();
        Hero hero = model.getHero();
        String[][] guiarray = model.getGuiarray();
        while (!guiarray[i][j].equals(" ")) {
            j++;
            while (!guiarray[i][j].equals(" ")) {
                i++;
            }
        }
        Dragon instance = new Dragon();
        int[] expResult = new int[2];
        int[] result = instance.dragonmove(i, j, hero, guiarray);
        //assertEquals(expResult, result);
        if(result[0]!=i && result[1]!=j) {
        assertEquals(" ", guiarray[result[0]][result[1]]);
        }
        assertTrue(Math.abs(result[0] - i) < 7);
        assertTrue(Math.abs(result[1] - j) < 7);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of attacked method, of class Dragon.
     */
    @Test
    public void testAttacked() {
        System.out.println("attacked");
        Hero hero = new Hero();
        Gegner gegner = new Gegner("D", 1, 1);
        int test = gegner.getLifepoints();
        int action = 0;
        int e = 0;
        Dragon instance = new Dragon();
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
        action = 1;
        e = KeyEvent.VK_1;
        result = instance.attacked(hero, gegner, action, e);
        expResult = "Dein Zauber hat einen Schaden von 0 beim Gegner"
                + " verursacht.";
        assertEquals(expResult, result);
        assertEquals(test, gegner.getLifepoints());
    }

    /**
     * Test of fight method, of class Dragon.
     */
    @Test
    public void testFight() {
        System.out.println("fight");
        Hero hero = new Hero();
        Gegner gegner = new Gegner("D", 1, 1);
        hero.setLifepoints(1);
        int action = 0;
        int e = 0;
        Dragon instance = new Dragon();
        String expResult = "";
        String result = instance.fight(hero, gegner, action, e);
        assertNotSame(expResult, result);
        assertTrue(hero.getLifepoints() <= 0);
        hero.setMagicdefense(10000000);
        hero.setLifepoints(1);
        result = instance.fight(hero, gegner, action, e);
        assertTrue(hero.getLifepoints() > 0);
    }
}
