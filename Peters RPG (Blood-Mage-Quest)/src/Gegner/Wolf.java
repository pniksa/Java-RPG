package Gegner;

import Modelrest.Hero;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.Random;

/**KI und sonstige Eigenschaften des Wolf.*/
public class Wolf implements Serializable {

    /**legt "Suchradius" des Wolfs fest.*/
    private final int searchradius = 6;
    /**legt wolfsymbol als W fest.*/
    public static final String WOLFSYMBOL = "W";
    /**legt max lp des wolfes fest.*/
    private int wolflp = 50;
    /**gibt an wie viel erfahrungpunkte ein besiegter wolf gibt.*/
    private int efp = 10;
    /**gibt maximale angriffsstärke des gegners an.*/
    private int maxattackstrength = 20;
    /**gibt minimale angriffstärke an.*/
    private int minattackstrength = 15;
    /**gibt verteidigung des gegners an.*/
    private int defense = 4;

    /**
     * Getter.
     * @return efp
     */
    public final int getEfp() {
        return efp;
    }

    /**
     * Getter.
     * @return wolflp
     */
    public final int getWolflp() {
        return wolflp;
    }

    /**
     * Kampfbefehl des Wolfs (Test).
     * @param j hero-lp
     * @return geminderte hero-lp
     */
    /**
     * Bewegungen des Wolfs.
     * @param i alte x-pos
     * @param j alte y-pos
     * @param hero hero
     * @param guiarray guiarray
     * @return neue koord.
     */
    public final int[] wolfmove(final int i, final int j,
            final Hero hero, final String[][] guiarray) {
        int x1;
        int y1;
        int s;
        int[] ret = new int[2];
        ret[1] = j;
        ret[0] = i;
        x1 = hero.getHeroxpos() - i;
        y1 = hero.getHeroypos() - j;
        s = Math.abs(x1) + Math.abs(y1);
        if (s <= searchradius) {
            if (Math.abs(x1) < Math.abs(y1)) {
                if (y1 > 0) {
                    if (guiarray[i][j + 1].equals(" ")) {
                        ret[1] = j + 1;
                    }
                } else {
                    if (guiarray[i][j - 1].equals(" ")) {
                        ret[1] = j - 1;
                    }
                }
            } else {
                if (x1 > 0) {
                    if (guiarray[i + 1][j].equals(" ")) {
                        ret[0] = i + 1;
                    }
                } else {
                    if (guiarray[i - 1][j].equals(" ")) {
                        ret[0] = i - 1;
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Angriff des Wolfs.
     * @param hero Model.hero
     * @return kampftext
     * @param hero model hero
     * @param gegner gegnersearch gegner
     * @param action model action
     * @param button gedrückte taste
     */
    public final String fight(final Hero hero, final Gegner gegner,
            final int action, final int button) {
        Random random = new Random();
        int dmg = random.nextInt(maxattackstrength - minattackstrength);
        dmg = maxattackstrength - dmg;
        if (action == 0 && button == KeyEvent.VK_2) {
            dmg = dmg - hero.getDefense() - hero.getShielding();
            //System.out.println(her);
        } else {
            dmg = dmg - hero.getDefense();
        }
        if (dmg <= 0) {
            dmg = 0;
        }
        hero.setLifepoints(hero.getLifepoints() - dmg);
        return ("Wolf hat dich gebissen. Erlittener Schaden: " + dmg);
    }

    /**
     * Held greift wolf an.
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
}
