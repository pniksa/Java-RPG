/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelrest;

import java.awt.event.KeyEvent;
import Gegner.Gegner;
import java.util.ArrayList;
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
public class ModelTest {

    public ModelTest() {
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
     * Test of getKampfablauf method, of class Model.
     */
    /*   @Test
    public void testGetKampfablauf() {
    System.out.println("getKampfablauf");
    Model instance = new Model();
    String[] expResult = null;
    String[] result = instance.getKampfablauf();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of getAction method, of class Model.
     */
    /*  @Test
    public void testGetAction() {
    System.out.println("getAction");
    Model instance = new Model();
    int expResult = 0;
    int result = instance.getAction();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of setAction method, of class Model.
     */
    /*@Test
    public void testSetAction() {
    System.out.println("setAction");
    int action = 0;
    Model instance = new Model();
    instance.setAction(action);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of getCurrentgegner method, of class Model.
     */
    /*  @Test
    public void testGetCurrentgegner() {
    System.out.println("getCurrentgegner");
    Model instance = new Model();
    int[] expResult = null;
    int[] result = instance.getCurrentgegner();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of isNotgameover method, of class Model.
     */
    /* @Test
    public void testIsNotgameover() {
    System.out.println("isNotgameover");
    Model instance = new Model();
    boolean expResult = false;
    boolean result = instance.isNotgameover();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of getGegnerarray method, of class Model.
     */
    /*  @Test
    public void testGetGegnerarray() {
    System.out.println("getGegnerarray");
    Model instance = new Model();
    ArrayList expResult = null;
    ArrayList result = instance.getGegnerarray();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of getCurrentLevel method, of class Model.
     */
    /*  @Test
    public void testGetCurrentLevel() {
    System.out.println("getCurrentLevel");
    Model instance = new Model();
    int expResult = 0;
    int result = instance.getCurrentLevel();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of setCurrentLevel method, of class Model.
     */
    /*  @Test
    public void testSetCurrentLevel() {
    System.out.println("setCurrentLevel");
    int currentLevel = 0;
    Model instance = new Model();
    instance.setCurrentLevel(currentLevel);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of getGuiarray method, of class Model.
     */
    //   @Test
   /* public void testGetGuiarray() {
    System.out.println("getGuiarray");
    Model instance = new Model();
    String[][] expResult = null;
    String[][] result = instance.getGuiarray();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of getFeinde method, of class Model.
     */
    /*   @Test
    public void testGetFeinde() {
    System.out.println("getFeinde");
    Model instance = new Model();
    Gegner expResult = null;
    Gegner result = instance.getFeinde();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of getHero method, of class Model.
     */
    /*   @Test
    public void testGetHero() {
    System.out.println("getHero");
    Model instance = new Model();
    Hero expResult = null;
    Hero result = instance.getHero();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of getItems method, of class Model.
     */
    /*@Test
    public void testGetItems() {
    System.out.println("getItems");
    Model instance = new Model();
    Items expResult = null;
    Items result = instance.getItems();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of getPosition method, of class Model.
     */
    /*@Test
    public void testGetPosition() {
    System.out.println("getPosition");
    Model instance = new Model();
    String[][] expResult = null;
    String[][] result = instance.getPosition();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of movementman method, of class Model.
     */
    @Test
    public void testMovementman1() {
        System.out.println("movementman");
        int x = 1;
        int y = 1;
        int i = 0;
        int j = 0;
        int test = 0;
        Model instance = new Model();
        instance.movementman(i, j);
        assertEquals(test, instance.getJutest());
        assertEquals(x, instance.getHero().getHeroxpos());
        assertEquals(y, instance.getHero().getHeroypos());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testMovementman2() {
        System.out.println("movementman");
        int i = 0;
        int j = 0;
        int test = 1;
        Model instance = new Model();
        i = 1;
        instance.movementman(i, j);
        int y = 2;
        int x = 1;
        //System.out.println(instance.getJutest());
        if (instance.getJutest() == 0) {
            j = 1;
            i = 0;

            instance.movementman(i, j);
            y = 1;
            x = 2;
            //  System.out.println(instance.getJutest());
        }
        if (instance.getJutest() == 0) {
            j = -1;
            i = 0;
            instance.movementman(i, j);
            y = 1;
            x = 1;
            //System.out.println(instance.getJutest());
        }
        if (instance.getJutest() == 0) {
            j = 0;
            i = -1;
            instance.movementman(i, j);
            y = 1;
            x = 1;
            // System.out.println(instance.getJutest());
        }
        if (instance.getJutest() == 0) {
            test = 0;
        }
        //instance.movementman(i, j);
        assertEquals(test, instance.getJutest());
        assertEquals(x, instance.getHero().getHeroxpos());
        assertEquals(y, instance.getHero().getHeroypos());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of fusion method, of class Model.
     */
    /*  @Test
    public void testFusion() {
    System.out.println("fusion");
    Model instance = new Model();
    instance.fusion();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of gegnerfight method, of class Model.
     */
    /* @Test
    public void testGegnerfight() {
    System.out.println("gegnerfight");
    Model instance = new Model();
    instance.gegnerfight();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of itemfound method, of class Model.
     */
    @Test
    public void testItemfound() {
        System.out.println("itemfound");
        Model instance = new Model();
        int test = 1;
        int counterp = instance.getHero().getPotioncount();
        int counterph = instance.getHero().getPhoenixcount();
        int counterd = instance.getHero().getDragonswordcount();
        int x = instance.getItemarray().get(0).getXpos();
        int y = instance.getItemarray().get(0).getYpos();
        String teststr = instance.getItemarray().get(0).getCurrentItem();
        if (teststr.equals(Items.POTION)) {
            counterp++;
        } else if (teststr.equals(Items.PHOENIXFEATHER)) {
            counterph++;
        } else if (teststr.equals(Items.POTION)) {
            counterd++;
        }
        instance.itemfound(x, y);
        assertEquals(test, instance.getJutest());
        assertEquals(teststr, instance.getJuteststring());
        assertEquals(counterp, instance.getHero().getPotioncount());
        assertEquals(counterph, instance.getHero().getPhoenixcount());
        assertEquals(counterd, instance.getHero().getDragonswordcount());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of gegnermovement method, of class Model.
     */
    @Test
    public void testGegnermovement() {
        System.out.println("gegnermovement");
        Model instance = new Model();
        instance.gegnermovement();
        int i = 0;
        for (String teststr : instance.getTestarr()) {
            assertEquals(teststr,
                    instance.getGegnerarray().get(i).getGegnersymbol());
            i++;
        }

        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of fight method, of class Model.
     */
    @Test
    public void testFight() {
        System.out.println("fight");
        int e = 0;
        Model instance = new Model();
        boolean expResult = true;
        boolean result = instance.fight(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        e = KeyEvent.VK_0;
        instance = new Model();
        if (instance.getGuiarray()[instance.getHero().getHeroxpos()
                + 1][instance.getHero().getHeroypos()].equals(" ")
                || instance.getGuiarray()[instance.getHero().getHeroxpos()
                - 1][instance.getHero().getHeroypos()].equals(" ")
                || instance.getGuiarray()[instance.getHero().getHeroxpos()]
                [instance.getHero().getHeroypos() + 1].equals(" ")
                || instance.getGuiarray()[instance.getHero().getHeroxpos()]
                [instance.getHero().getHeroypos() - 1].equals(" ")) {
            expResult = false;
        } else {
            expResult = true;
        }
        result = instance.fight(e);
        assertEquals(expResult, result);
    }
}
