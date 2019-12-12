package Gegner;

import Modelrest.Hero;
import Modelrest.Konstanten;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.Random;

/**KI und sonstige Eigenschaften des Thief.*/
public class Thief implements Serializable {

    /**legt thiefsymbol als T fest.*/
    public static final String THIEFSYMBOL = "T";
    /**legt maximale lp des diebes fest.*/
    private int thieflp = 120;
    /**gibt an wie viel efp ein besiegter dieb gibt.*/
    private int efp = 80;
    /** maximaler schaden.*/
    private int maxattackstrength = 40;
    /**minimaler schaden.*/
    private int minattackstrength = 25;
    /** Verteidigungswert des Diebes.*/
    private int defense = 20;

    /**
     * Getter.
     * @return efp
     */
    public final int getEfp() {
        return efp;
    }

    /**
     * Getter.
     * @return thieflp
     */
    public final int getThieflp() {
        return thieflp;
    }

    /**
     * Bewegung des Diebes
     * @param i alte x-pos
     * @param j alte y-pos
     * @param guiarray guiarray
     * @return neue koord.
     */
    public final int[] thiefmove(final int i, final int j,
            final String[][] guiarray) {
        Random random = new Random();
        int[] ret = new int[2];
        ret[0] = i;
        ret[1] = j;
        int vs = random.nextInt(1);
        vs++;
        int k = random.nextInt(3);
        switch (k) {
            case 0:
                if (i + vs < Konstanten.GFIELDWIDTH) {
                    if (guiarray[i + vs][j].equals(" ")) {
                        ret[0] = i + vs;
                    }
                }
                break;
            case 1:
                if (i - 1 > 0) {
                    if (guiarray[i - vs][j].equals(" ")) {
                        ret[0] = i - vs;
                        break;
                    }
                }
            case 2:
                if (j - 1 > 0) {
                    if (guiarray[i][j - vs].equals(" ")) {
                        ret[1] = j - vs;
                        break;
                    }
                }
            case 3:
                if (j + 1 < Konstanten.GFIELDHEIGTH) {
                    if (guiarray[i][j + vs].equals(" ")) {
                        ret[1] = j + vs;
                    }
                }
            default:
                break;
        }
        return ret;
    }

    /**
     * gegner wird angegriffen.
     * @param hero model hero
     * @param gegner gegnersearch gegner
     * @param action model action
     * @param e tastendruck
     * @return ausgabe
     */
    public final String attacked(final Hero hero, final Gegner gegner,
            final int action, final int e) {
        Random random = new Random();
        int dmg;
        if (action == 0 && e == KeyEvent.VK_1) {
            dmg = random.nextInt(hero.getStrength() - hero.getMinstrength());
            dmg = hero.getStrength() - dmg - defense;
            if (dmg <= 0) {
                dmg = 0;
            }
            gegner.setLifepoints(gegner.getLifepoints() - dmg);
            return ("Du hast dem Gegner einen Schaden"
                    + " von " + dmg + " zugefügt.");
        } else if (action == 0 && e == KeyEvent.VK_2) {
            return ("Verteidigung eingesetzt.");
        } else if (action == 1) {
            dmg = 0;
            if (e == KeyEvent.VK_1) {
                dmg = (int) (Hero.MAGIC1COST * Hero.MAGICMULTIPLICATOR
                        * hero.getMagic());
                hero.setLifepoints(hero.getLifepoints() - Hero.MAGIC1COST);
            } else if (e == KeyEvent.VK_2) {
                dmg = (int) (Hero.MAGIC2COST * Hero.MAGICMULTIPLICATOR
                        * hero.getMagic());
                hero.setLifepoints(hero.getLifepoints() - Hero.MAGIC2COST);
            } else if (e == KeyEvent.VK_3) {
                dmg = (int) (Hero.MAGIC3COST * Hero.MAGICMULTIPLICATOR
                        * hero.getMagic());
                hero.setLifepoints(hero.getLifepoints() - Hero.MAGIC3COST);
            }
            gegner.setLifepoints(gegner.getLifepoints() - dmg);
            return ("Dein Zauber hat einen Schaden von " + dmg + " beim Gegner"
                    + " verursacht.");
        } else if (action == 2 && e == KeyEvent.VK_1) {
            return hero.usepotion1();
        } else if (action == 2 && e == KeyEvent.VK_2) {
            return hero.useDragonsword(gegner);
        }
        return "";
    }

    /**
     * hero greift an.
     * @param hero model hero
     * @param gegner gegnersearch gegner
     * @param action model action
     * @param e tastendruck
     * @return ausgabe;
     */
    public final String fight(final Hero hero, final Gegner gegner,
            final int action, final int e) {
        Random random = new Random();
        int dmg = random.nextInt(maxattackstrength - minattackstrength);
        dmg = maxattackstrength - dmg;
        if (action == 0 && e == KeyEvent.VK_2) {
            dmg = dmg - hero.getDefense() - hero.getShielding();
            //System.out.println(her);
        } else {
            dmg = dmg - hero.getDefense();
        }
        if (dmg <= 0) {
            dmg = 0;
        }
        hero.setLifepoints(hero.getLifepoints() - dmg);
        return ("Dieb hat dich attackiert. Erlittener Schaden: " + dmg);
    }
}
