package Controller;

import Modelrest.Hero;
import Modelrest.Items;
import Modelrest.Konstanten;
import java.io.Serializable;
import Modelrest.Model;
import java.awt.event.KeyEvent;

/**Der Controller enthält den KeyListener, ActionListener und überwacht
 * die Actionen und ordnet die Regeln aus dem Model zu.*/
public class Controller implements Serializable {

    /**schaltet das fight-screen an.*/
    private boolean fightscreen = false;
    /**schaltet den status-screen an.*/
    private boolean statusscreen = false;
    /**testinter.*/
    private int jutest;

    /**
     * Getter.
     * @return jutest
     */
    public final int getJutest() {
        return jutest;
    }

    /**
     * Getter.
     * @return statusscreen
     */
    public final boolean isStatusscreen() {
        return statusscreen;
    }

    /**
     *Setter.
     * @param statusscreen aktuelle anzeige
     */
    public final void setStatusscreen(final boolean statusscreen) {
        this.statusscreen = statusscreen;
    }

    /**
     * Getter.
     * @return fightscreen
     */
    public boolean isFightscreen() {
        return fightscreen;
    }
    /**Instanzierung und Initialisierung von String[][] guiarray.*/
    private String[][] guiarray;

    /**guiarray @return .*/
    public final String[][] getGuiarray() {
        return guiarray;
    }
    /**Instanzierung von Model model.*/
    private Model model;

    /**model @return .*/
    public final Model getModel() {
        return model;
    }

    /**
     * Durchführung der Bewegung.
     * @param i x-Richtung
     * @param j y-Richtung
     */
    private void movement(final int i, final int j) {
        switch (i) {
            case 1:
                model.movementman(1, 0);
                collission();
                if (!fightscreen) {
                    model.gegnermovement();
                    collission();
                }
                break;
            case -1:
                model.movementman(-1, 0);
                collission();
                if (!fightscreen) {
                    model.gegnermovement();
                    collission();
                }
                break;
            default:
                break;
        }
        switch (j) {
            case 1:
                model.movementman(0, -1);
                collission();
                if (!fightscreen) {
                    model.gegnermovement();
                    collission();
                }
                break;
            case -1:
                model.movementman(0, 1);
                collission();
                if (!fightscreen) {
                    model.gegnermovement();
                    collission();
                }
                break;
            default:
                break;
        }
    }

    /**Überprüfung einer Kollision.*/
    private void collission() {
        for (int i = 0; i < Konstanten.GFIELDWIDTH; i++) {
            for (int j = 0; j < Konstanten.GFIELDHEIGTH; j++) {
                if (model.getPosition()[i][j] != null) {
                    if (model.getPosition()[i + 1][j] != null) {
                        collission2(model.getPosition()[i][j],
                                model.getPosition()[i + 1][j], i + 1, j, i, j);
                    }
                    if (model.getPosition()[i - 1][j] != null) {
                        collission2(model.getPosition()[i][j],
                                model.getPosition()[i - 1][j], i - 1, j, i, j);
                    }
                    if (model.getPosition()[i][j + 1] != null) {
                        collission2(model.getPosition()[i][j],
                                model.getPosition()[i][j + 1], i, j + 1, i, j);
                    }
                    if (model.getPosition()[i][j - 1] != null) {
                        collission2(model.getPosition()[i][j],
                                model.getPosition()[i][j - 1], i, j - 1, i, j);
                    }
                }
            }
        }
    }

    /**
     * Vergleich der Strings.
     * @param a String a
     * @param b String b
     * @param c2 xpos b
     * @param d2 ypos b
     * @param c1 xpos a
     * @param d1 ypos a
     */
    private void collission2(final String a, final String b, final int c2,
            final int d2, final int c1, final int d1) {
        if (a.equals(b)) {
            model.fusion();
        }
        if ((!(a.equals(Hero.HEROSYMBOL)) && !(b.equals(Hero.HEROSYMBOL)))
                || (!(a.equals(Items.ITEMSYMBOL))
                || !(b.equals(Items.ITEMSYMBOL)))) {
            model.gegnerfight();
        }
        if (a.equals(Hero.HEROSYMBOL) && !(b.equals(Items.ITEMSYMBOL))) {
            fightscreen = true;
            model.getCurrentgegner()[0] = c2;
            model.getCurrentgegner()[1] = d2;
            model.setAction(0);
        }
        if (a.equals(Hero.HEROSYMBOL) && b.equals(Items.ITEMSYMBOL)) {
            model.itemfound(c2, d2);
        }
    }

    /**Konstruktor der Klasse Controller.*/
    public Controller() {
        guiarray = new String[Konstanten.GFIELDHEIGTH][Konstanten.GFIELDWIDTH];
        model = new Model();
//        model.initialposition();
        guiarray = model.getGuiarray();
    }

    /**
     * ordnet tasten standardbefehle zu.
     * @param e gedrückte taste
     */
    public final void keycontrol(final KeyEvent e) {
        final int up1 = 38;
        final int down1 = 40;
        final int left1 = 37;
        final int right1 = 39;
        final int up2 = 87;
        final int down2 = 83;
        final int left2 = 65;
        final int right2 = 68;
        final int q = 81;
        if (e == null) {
            jutest = 0;
        } else {
            if (model.isNotgameover()) {
                if (!fightscreen) {
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE
                            && !statusscreen) {
                        statusscreen = true;
                        jutest = 10;
                    } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE
                            && statusscreen) {
                        statusscreen = false;
                        jutest = 11;
                    }
                }
                if (!fightscreen
                        && !statusscreen) {
                    switch (e.getKeyCode()) {
                        case up1:
                            movement(0, 1);
                            jutest = 3;
                            break;
                        case down1:
                            movement(0, -1);
                            jutest = 4;
                            break;
                        case left1:
                            movement(-1, 0);
                            jutest = 5;
                            break;
                        case right1:
                            movement(1, 0);
                            jutest = 6;
                            break;
                        case up2:
                            movement(0, 1);
                            jutest = 3;
                            break;
                        case down2:
                            movement(0, -1);
                            jutest = 4;
                            break;
                        case left2:
                            movement(-1, 0);
                            jutest = 5;
                            break;
                        case right2:
                            movement(1, 0);
                            jutest = 6;
                            break;
                        case q:
                            model.getHero().usepotion();
                            jutest = 2;
                            break;
                        default:
                            break;
                    }
                } else if (fightscreen
                        && !statusscreen) {
                    fightscreen = model.fight(e.getKeyCode());
                }
            }
        }
    }
}
