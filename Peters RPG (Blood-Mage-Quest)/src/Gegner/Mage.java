package Gegner;

import Modelrest.Hero;
import Modelrest.Konstanten;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.Random;

/**KI und sonstige Eigenschaften des Mage.*/
public class Mage implements Serializable {

    /**legt magesymbol als M fest.*/
    public static final String MAGESYMBOL = "M";
    /**legt maximale lp des magiers fest.*/
    private int magelp = 2000;
    /**legt fest wie viel efp ein besiegter magier gibt.*/
    private int efp = 1100;
    /**magischer schaden.*/
    private int magicattackstrength = 1000;
    /**Verteidigungswert des Magiers.*/
    private int defense = 500;
    /**Magie-Verteidigungswert des Magiers.*/
    private int magicdefense = 1400;

    /**
     * Getter.
     * @return efp
     */
    public final int getEfp() {
        return efp;
    }

    /**
     * Getter.
     * @return magelp
     */
    public final int getMagelp() {
        return magelp;
    }

    /**
     * führt magier-bewegung aus.
     * @param i alte x-pos.
     * @param j alte y-pos
     * @param guiarray guiarray
     * @return neue koord.
     */
    public final int[] magemove(final int i, final int j,
            final String[][] guiarray) {
        Random random = new Random();
        int[] ret = new int[2];
        ret[0] = i;
        ret[1] = j;
        int vs = random.nextInt(2);
        int k = random.nextInt(3);
        switch (k) {
            case 0:
                if (i + vs < Konstanten.GFIELDWIDTH) {
                    if (guiarray[i + vs][j].equals(" ")) {
                        ret[0] = ret[0] + vs;
                    }
                }
                break;
            case 1:
                if (i - 1 > 0) {
                    if (guiarray[i - vs][j].equals(" ")) {
                        ret[0] = ret[0] - vs;
                        break;
                    }
                }
            case 2:
                if (j - 1 > 0) {
                    if (guiarray[i][j - vs].equals(" ")) {
                        ret[1] = ret[1] - vs;
                        break;
                    }
                }
            case 3:
                if (j + 1 < Konstanten.GFIELDHEIGTH) {
                    if (guiarray[i][j + vs].equals(" ")) {
                        ret[1] = ret[1] + vs;
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
                        * hero.getMagic()) - magicdefense;
                hero.setLifepoints(hero.getLifepoints() - Hero.MAGIC1COST);
            } else if (e == KeyEvent.VK_2) {
                dmg = (int) (Hero.MAGIC2COST * Hero.MAGICMULTIPLICATOR
                        * hero.getMagic() - magicdefense);
                hero.setLifepoints(hero.getLifepoints() - Hero.MAGIC2COST);
            } else if (e == KeyEvent.VK_3) {
                dmg = (int) (Hero.MAGIC3COST * Hero.MAGICMULTIPLICATOR
                        * hero.getMagic() - magicdefense);
                hero.setLifepoints(hero.getLifepoints() - Hero.MAGIC3COST);
            }
            if (dmg > 0) {
                System.out.println(dmg);
                gegner.setLifepoints(gegner.getLifepoints() - dmg);
            } else {
                dmg = 0;
            }
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
     * gegner greift an.
     * @param hero model hero
     * @param gegner gegnersearch gegner
     * @param action model action
     * @param e tastendruck
     * @return ausgabe
     */
    public final String fight(final Hero hero, final Gegner gegner, final int action, final int e) {
        Random random = new Random();
        int dmg = magicattackstrength;
        dmg = dmg - hero.getMagicdefense();
        if (dmg <= 0) {
            dmg = 0;
        }
        hero.setLifepoints(hero.getLifepoints() - dmg);
        return ("Magier hat Ulitma auf dich gewirkt. Erlittener Schaden: "
                + dmg);
    }
}
