package Gegner;

import Modelrest.Items;
import java.io.Serializable;
import java.util.ArrayList;

/**Eigenschaften und Positionen der Gegner.*/
public class Gegner implements Serializable {

    /**ArrayList gegnerList enthält Monster des jeweiligen Levels.*/
    private ArrayList<String> gegnerList = new ArrayList<String>();
    /**x-koord des gegners.*/
    private int xpos;
    /**y-koord des gegners.*/
    private int ypos;
    /**gibt gegnersymbol an.*/
    private String gegnersymbol;
    /**enthält items die thief aufgenommen hat.*/
    private ArrayList<Items> stolenitems;

    /**
     * Getter.
     * @return stolenitems
     */
    public final ArrayList<Items> getStolenitems() {
        return stolenitems;
    }

    /**
     * Getter.
     * @return gegnersymbol
     */
    public final String getGegnersymbol() {
        return gegnersymbol;
    }

    /**gegnerList @return .*/
    public final ArrayList<String> getGegnerList() {
        return gegnerList;
    }

    /**
     * ordnet dem jeweiligen Level die entsprechenden Gegner zu.
     * @param i levelnummer
     */
    public Gegner(final int i) {

        gegnerList = new ArrayList<String>();
        switch (i) {
            case 1:
                gegnerLevel1();
                break;
            case 2:
                gegnerLevel2();
                break;
            case 3:
                gegnerLevel3();
                break;
            case 4:
                gegnerLevel4();
                break;
            case 5:
                gegnerLevel5();
                break;
            case 6:
                gegnerLevel6();
                break;
            default:
                break;

        }
    }
    /**Lebenspunkte der Gegner.*/
    private int lifepoints;

    /**
     * Getter.
     * @return lifepoints
     */
    public final int getLifepoints() {
        return lifepoints;
    }

    /**
     * Setter.
     * @param lifepoints lifepoints
     */
    public final void setLifepoints(final int lifepoints) {
        this.lifepoints = lifepoints;
    }
    /**Zahlendarstellung der Gegnerbezeichnung.*/
    private int k;

    /**
     * Konstruktor erzeugt Gegnertyp b an position xpos, ypos.
     * @param b Gegnertyp
     * @param xpos xpos
     * @param ypos ypos
     */
    public Gegner(final String b, final int xpos, final int ypos) {
        Wolf wolf = new Wolf();
        UnDead undead = new UnDead();
        Dragon dragon = new Dragon();
        Mage mage = new Mage();
        Thief thief = new Thief();
        gegnerList = new ArrayList<String>();
        this.xpos = xpos;
        this.ypos = ypos;
        if (b.equals(Wolf.WOLFSYMBOL)) {
            k = 1;
        } else if (b.equals(Thief.THIEFSYMBOL)) {
            k = 2;
        } else if (b.equals(Mage.MAGESYMBOL)) {
            k = 4;
        } else if (b.equals(UnDead.UNDEADSYMBOL)) {
            k = 3;
        } else if (b.equals(Dragon.DRAGONSYMBOL)) {
            k = 5;
        }
        switch (k) {
            case 1:
                lifepoints = wolf.getWolflp();
                gegnersymbol = Wolf.WOLFSYMBOL;
                break;
            case 2:
                lifepoints = thief.getThieflp();
                gegnersymbol = Thief.THIEFSYMBOL;
                stolenitems = new ArrayList<Items>();
                break;
            case 3:
                lifepoints = undead.getUndeadlp();
                gegnersymbol = UnDead.UNDEADSYMBOL;
                break;
            case 4:
                lifepoints = mage.getMagelp();
                gegnersymbol = Mage.MAGESYMBOL;
                break;
            case 5:
                lifepoints = dragon.getDragonlp();
                gegnersymbol = Dragon.DRAGONSYMBOL;
                break;
            default:
                break;
        }
    }

    /**
     * Getter.
     * @return xpos
     */
    public final int getXpos() {
        return xpos;
    }

    /**
     * Setter.
     * @param xpos xpos
     */
    public final void setXpos(final int xpos) {
        this.xpos = xpos;
    }

    /**
     * Getter.
     * @return ypos
     */
    public final int getYpos() {
        return ypos;
    }

    /**
     * Setter.
     * @param ypos ypos
     */
    public final void setYpos(final int ypos) {
        this.ypos = ypos;
    }

    /**Gegner für Level 1.*/
    private void gegnerLevel1() {
        for (int u = 1; u <= 120; u++) {
            gegnerList.add(Wolf.WOLFSYMBOL);
            //gegnerList.add(Thief.THIEFSYMBOL);
            //gegnerList.add(Dragon.DRAGONSYMBOL);
            //gegnerList.add(Mage.MAGESYMBOL);
            //gegnerList.add(UnDead.UNDEADSYMBOL);
        }
    }

    /**Gegner für Level 2.*/
    private void gegnerLevel2() {
        for (int j = 1; j <= 30; j++) {
            gegnerList.add(Wolf.WOLFSYMBOL);
        }
        for (int u = 1; u <= 100; u++) {
            gegnerList.add(Thief.THIEFSYMBOL);
        }
    }

    /**Gegner für Level 3.*/
    private void gegnerLevel3() {
        for (int u = 1; u <= 120; u++) {
            gegnerList.add(UnDead.UNDEADSYMBOL);
        }
        for (int l = 1; l <= 40; l++) {
            gegnerList.add(Thief.THIEFSYMBOL);
        }
    }

    /**Gegner für Level 4.*/
    private void gegnerLevel4() {
        for (int u = 1; u <= 140; u++) {
            gegnerList.add(UnDead.UNDEADSYMBOL);
        }
        for (int l = 1; l <= 30; l++) {
            gegnerList.add(Mage.MAGESYMBOL);
        }
    }

    /**Gegner für Level 5.*/
    private void gegnerLevel5() {
        for (int u = 1; u <= 20; u++) {
            gegnerList.add(UnDead.UNDEADSYMBOL);
        }
        for (int l = 1; l <= 110; l++) {
            gegnerList.add(Mage.MAGESYMBOL);
        }
        gegnerList.add(Dragon.DRAGONSYMBOL);
        gegnerList.add(Dragon.DRAGONSYMBOL);
        gegnerList.add(Dragon.DRAGONSYMBOL);
    }

    /**Gegner für Level 6.*/
    private void gegnerLevel6() {
        for (int u = 1; u <= 100; u++) {
            gegnerList.add(Dragon.DRAGONSYMBOL);
        }
        for (int l = 1; l <= 50; l++) {
            gegnerList.add(Mage.MAGESYMBOL);
        }
        for (int u = 1; u <= 20; u++) {
            gegnerList.add(UnDead.UNDEADSYMBOL);
        }
    }
}
