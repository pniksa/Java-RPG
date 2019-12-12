/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelrest;

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
public class HeroTest {

    public HeroTest() {
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
     * Test of getMinstrength method, of class Hero.
     */
    /* @Test
    public void testGetMinstrength() {
    System.out.println("getMinstrength");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getMinstrength();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of getShielding method, of class Hero.
     */
    /*@Test
    public void testGetShielding() {
    System.out.println("getShielding");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getShielding();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getNextlevelefp method, of class Hero.
     */
    /* @Test
    public void testGetNextlevelefp() {
    System.out.println("getNextlevelefp");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getNextlevelefp();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getDragonswordcount method, of class Hero.
     */
    /*  @Test
    public void testGetDragonswordcount() {
    System.out.println("getDragonswordcount");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getDragonswordcount();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setDragonswordcount method, of class Hero.
     */
    /*  @Test
    public void testSetDragonswordcount() {
    System.out.println("setDragonswordcount");
    int dragonswordcount = 0;
    Hero instance = new Hero();
    instance.setDragonswordcount(dragonswordcount);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getPhoenixcount method, of class Hero.
     */
    /* @Test
    public void testGetPhoenixcount() {
    System.out.println("getPhoenixcount");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getPhoenixcount();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setPhoenixcount method, of class Hero.
     */
    /*  @Test
    public void testSetPhoenixcount() {
    System.out.println("setPhoenixcount");
    int phoenixcount = 0;
    Hero instance = new Hero();
    instance.setPhoenixcount(phoenixcount);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getPotioncount method, of class Hero.
     */
    /*  @Test
    public void testGetPotioncount() {
    System.out.println("getPotioncount");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getPotioncount();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setPotioncount method, of class Hero.
     */
    /*@Test
    public void testSetPotioncount() {
    System.out.println("setPotioncount");
    int potioncount = 0;
    Hero instance = new Hero();
    instance.setPotioncount(potioncount);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getDefense method, of class Hero.
     */
    /* @Test
    public void testGetDefense() {
    System.out.println("getDefense");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getDefense();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setDefense method, of class Hero.
     */
    /* @Test
    public void testSetDefense() {
    System.out.println("setDefense");
    int defense = 0;
    Hero instance = new Hero();
    instance.setDefense(defense);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getMagic method, of class Hero.
     */
    /*  @Test
    public void testGetMagic() {
    System.out.println("getMagic");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getMagic();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setMagic method, of class Hero.
     */
    /* @Test
    public void testSetMagic() {
    System.out.println("setMagic");
    int magic = 0;
    Hero instance = new Hero();
    instance.setMagic(magic);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getMagicdefense method, of class Hero.
     */
    /* @Test
    public void testGetMagicdefense() {
    System.out.println("getMagicdefense");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getMagicdefense();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setMagicdefense method, of class Hero.
     */
    /*  @Test
    public void testSetMagicdefense() {
    System.out.println("setMagicdefense");
    int magicdefense = 0;
    Hero instance = new Hero();
    instance.setMagicdefense(magicdefense);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getStrength method, of class Hero.
     */
    /* @Test
    public void testGetStrength() {
    System.out.println("getStrength");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getStrength();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setStrength method, of class Hero.
     */
    /* @Test
    public void testSetStrength() {
    System.out.println("setStrength");
    int strength = 0;
    Hero instance = new Hero();
    instance.setStrength(strength);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxlp method, of class Hero.
     */
    /*  @Test
    public void testGetMaxlp() {
    System.out.println("getMaxlp");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getMaxlp();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxlp method, of class Hero.
     */
    /*  @Test
    public void testSetMaxlp() {
    System.out.println("setMaxlp");
    int maxlp = 0;
    Hero instance = new Hero();
    instance.setMaxlp(maxlp);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getEfp method, of class Hero.
     */
    /* @Test
    public void testGetEfp() {
    System.out.println("getEfp");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getEfp();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setEfp method, of class Hero.
     */
    /*  @Test
    public void testSetEfp() {
    System.out.println("setEfp");
    int efp = 0;
    Hero instance = new Hero();
    instance.setEfp(efp);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getLevel method, of class Hero.
     */
    /*  @Test
    public void testGetLevel() {
    System.out.println("getLevel");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getLevel();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setLevel method, of class Hero.
     */
    /* @Test
    public void testSetLevel() {
    System.out.println("setLevel");
    int level = 0;
    Hero instance = new Hero();
    instance.setLevel(level);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getLifepoints method, of class Hero.
     */
    /*  @Test
    public void testGetLifepoints() {
    System.out.println("getLifepoints");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getLifepoints();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setLifepoints method, of class Hero.
     */
    /* @Test
    public void testSetLifepoints() {
    System.out.println("setLifepoints");
    int lifepoints = 0;
    Hero instance = new Hero();
    instance.setLifepoints(lifepoints);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getHeroxpos method, of class Hero.
     */
    /*  @Test
    public void testGetHeroxpos() {
    System.out.println("getHeroxpos");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getHeroxpos();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setHeroxpos method, of class Hero.
     */
    /*  @Test
    public void testSetHeroxpos() {
    System.out.println("setHeroxpos");
    int heroxpos = 0;
    Hero instance = new Hero();
    instance.setHeroxpos(heroxpos);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of getHeroypos method, of class Hero.
     */
    /*  @Test
    public void testGetHeroypos() {
    System.out.println("getHeroypos");
    Hero instance = new Hero();
    int expResult = 0;
    int result = instance.getHeroypos();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of setHeroypos method, of class Hero.
     */
    /* @Test
    public void testSetHeroypos() {
    System.out.println("setHeroypos");
    int heroypos = 0;
    Hero instance = new Hero();
    instance.setHeroypos(heroypos);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of resurrection method, of class Hero.
     */
    @Test
    public void testResurrection() {
        System.out.println("resurrection");
        Hero instance = new Hero();
        int test1 = 0;
        instance.setLifepoints(0);
        instance.setPhoenixcount(1);
        int test2 = (int) (instance.getMaxlp() * 0.5);
        instance.resurrection();
        assertEquals(test1, instance.getPhoenixcount());
        assertEquals(instance.getLifepoints(), test2);
    }

    /**
     * Test of usepotion method, of class Hero.
     */
    @Test
    public void testUsepotion() {
        System.out.println("usepotion");
        Hero instance = new Hero();
        int test2 = 1;
        int test1 = 100;
        instance.setLifepoints(80);
        instance.usepotion();
        assertEquals(test1, instance.getLifepoints());
        assertEquals(test2, instance.getPotioncount());
        test1 = 50;
        instance.setLifepoints(50 - 40);
        test2 = 0;
        instance.usepotion();
        assertEquals(test1, instance.getLifepoints());
        assertEquals(test2, instance.getPotioncount());
    }

    /**
     * Test of levelup method, of class Hero.
     */
    @Test
    public void testLevelup() {
        System.out.println("levelup");
        int test1 = 1;
        Hero instance = new Hero();
        instance.setEfp(0);
        instance.levelup();
        assertEquals(test1, instance.getLevel());
        test1 = 2;
        int test2 = 0;
        int test3 = 130;
        instance.setEfp(instance.getNextlevelefp());
        instance.levelup();
        assertEquals(test1, instance.getLevel());
        assertEquals(test2, instance.getEfp());
        assertEquals(test3, instance.getLifepoints());
        instance.setEfp(instance.getNextlevelefp()
                + instance.getNextlevelefp() * 2);
        test1 = 4;
        instance.levelup();
        assertEquals(test1, instance.getLevel());
    }

    /**
     * Test of useDragonsword method, of class Hero.
     */
    @Test
    public void testUseDragonsword() {
        System.out.println("useDragonsword");
        Gegner gegner = new Gegner("W", 0, 0);
        Hero instance = new Hero();
        String expResult = "Drachenschwert eingesetzt.";
        instance.setDragonswordcount(1);
        String result = instance.useDragonsword(gegner);
        assertEquals(expResult, result);
        expResult = "Du hast anscheinend keine Drachenschwerter.";
        result = instance.useDragonsword(gegner);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of usepotion1 method, of class Hero.
     */
    @Test
    public void testUsepotion1() {
        //usepotion mit String-rückgabe.
        System.out.println("usepotion1");
        Hero instance = new Hero();
        instance.setPotioncount(1);
        String expResult = "Potion eingesetzt und 40 LP geheilt.";
        String result = instance.usepotion1();
        assertEquals(expResult, result);
        expResult = "Du hast anscheinend keine Potions mehr.";
        result = instance.usepotion1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getItems method, of class Hero.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        ArrayList<Items> stolenitems = new ArrayList<Items>();
        int test1 = 3;
        Hero instance = new Hero();
        stolenitems.add(new Items("p",0,0));
        instance.getItems(stolenitems);
        assertEquals(test1, instance.getPotioncount());
        test1 = 1;
        stolenitems = new ArrayList<Items>();
        stolenitems.add(new Items("d",0,0));
        instance.getItems(stolenitems);
        assertEquals(test1, instance.getDragonswordcount());
        test1 = 1;
        instance.setDragonswordcount(0);
        stolenitems = new ArrayList<Items>();
        stolenitems.add(new Items("ph",0,0));
        instance.getItems(stolenitems);
        assertEquals(test1, instance.getPhoenixcount());
    }
}
