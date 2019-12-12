package Gegner;

import Modelrest.Hero;
import Modelrest.Konstanten;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.Random;

/**KI und sonstige Eigenschaften des Dragon.*/
public class Dragon implements Serializable {

    /**gibt den "suchradius" des drachen an.*/
    private final int searchradius = 16;
    /**gibt die maximale bewegung an.*/
    private final int movemax = 6;
    /**legt dragonsymbol als D fest.*/
    public static final String DRAGONSYMBOL = "D";
    /**legt die maximalen lp des drachen fest.*/
    private int dragonlp = 9000;
    /**legt fest wie viel efp ein besiegter drache gibt.*/
    private int efp = 6000;
    /**Verteidigungswert des Drachen.*/
    private int defense = 7000;
    /**Magieverteidigungs-wert des Drachen.*/
    private int magicdefense = 16000;
    /**durch drachen verursachter schaden.*/
    private int magicattackstrength = 9000;

    /**
     * Getter.
     * @return efp
     */
    public final int getEfp() {
        return efp;
    }

    /**
     * Getter.
     * @return dragonlp
     */
    public final int getDragonlp() {
        return dragonlp;
    }

    /**Default-Konstruktor der Klasse Dragon.*/
    public Dragon() {
    }

    /**
     * Bewegungspattern des Drachen.
     * @param i x-ausgangspos
     * @param j y-ausgangspos
     * @param hero Held
     * @param guiarray guiarray
     * @return neue koord.
     */
    public final int[] dragonmove(final int i, final int j, final Hero hero,
            final String[][] guiarray) {
        Random random = new Random();
        int vs;
        int x1;
        int y1;
        int s;
        int[] ret = new int[2];
        ret[1] = j;
        ret[0] = i;
        x1 = hero.getHeroxpos() - i;
        y1 = hero.getHeroypos() - j;
        s = Math.abs(x1) + Math.abs(y1);
        vs = random.nextInt(movemax);
        vs++;
        if (s <= searchradius) {
            if (Math.abs(x1) < Math.abs(y1)) {
                if (y1 > 0) {
                    if (j + vs < Konstanten.GFIELDHEIGTH) {
                        if (guiarray[i][j + vs].equals(" ")) {
                            ret[1] = j + vs;
                        }
                    }
                } else {
                    if (j - vs > 0) {
                        if (guiarray[i][j - vs].equals(" ")) {
                            ret[1] = j - vs;
                        }
                    }
                }
            } else {
                if (x1 > 0) {
                    if (i + vs < Konstanten.GFIELDWIDTH) {
                        if (guiarray[i + vs][j].equals(" ")) {
                            ret[0] = i + vs;
                        }
                    }
                } else {
                    if (i - vs > 0) {
                        if (guiarray[i - vs][j].equals(" ")) {
                            ret[0] = i - vs;
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * held greif an.
     * @param hero model hero
     * @param gegner gegnersearch gegner
     * @param action model action
     * @param e gedrückte taste
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
            return ("Du hast dem Gegner einen Schaden von "
                    + dmg + " zugefügt.");
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
     * drache greift an.
     * @param hero model hero
     * @param gegner gegnersearch gegner
     * @param action model action
     * @param e gedrückte taste
     * @return ausgabe
     */
    public final String fight(final Hero hero, final Gegner gegner,
            final int action, final int e) {
        Random random = new Random();
        int dmg = magicattackstrength;
        dmg = dmg - hero.getMagicdefense();
        if (dmg <= 0) {
            dmg = 0;
        }
        hero.setLifepoints(hero.getLifepoints() - dmg);
        return ("Drache speit mit magischem Feuer. Erlittener Schaden: " + dmg);
    }
}
