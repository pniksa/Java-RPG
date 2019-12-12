package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import Controller.Controller;
import Modelrest.Konstanten;
import Controller.Reader;
import Modelrest.Hero;
import Modelrest.Model;
import java.io.Serializable;

/**GuiKaestchen erstellt das JLabel in dem das Spiel abläuft.*/
public class GuiKaestchen extends JLabel implements Serializable {

    /**instanziert und initialisiert Model model.*/
    // private Model model = new Model();
    private Controller controller;
    /**instanziert Reader reader.*/
    private Reader reader;
    /**größe des zu zeichnenden feldes.*/
    private static final int SIZE = 600;

    /**Default-Constructor von GuiKaestchen.*/
    public GuiKaestchen() {
        controller = new Controller();
    }

    /**controller @return .*/
    public final Controller getController() {
        return controller;
    }
    /**Schriftgröße.*/
    private int font = 20;
    /** Breite eines Kästchens.*/
    private int fieldwidth = 18;
    /**Schriftgröße der Status-Anzeige.*/
    private final int font2 = 18;
    /**Initialisierung des Zeichen-Arrays drawArray.*/
    private String[][] drawArray;

    @Override
    public final void paint(final Graphics stift1) {
        final double factor = 0.2;
        Hero hero = controller.getModel().getHero();
        int y = hero.getHeroxpos();
        int x = hero.getHeroypos();
        final int ver = 16;
        reader = new Reader("GameOver.txt");
        if (controller.getModel().isNotgameover()) {
            drawArray = controller.getGuiarray();
        } else {
            drawArray = reader.getLevelu();
            y = 13;
            x = 15;
            font = 15;
            fieldwidth = 12;
        }
        Graphics2D stift = (Graphics2D) stift1;
        stift.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        if (hero.getLifepoints() > hero.getMaxlp() * factor) {
            stift.setColor(Color.white);
            stift.fillRect(0, 0, SIZE, SIZE);
        } else {
            stift.setColor(Color.red);
            stift.fillRect(0, 0, SIZE, SIZE);
        }
        stift.setColor(Color.black);
        stift.setFont(new Font("Arial", Font.PLAIN, font));
        for (int i = 0; i < Konstanten.GFIELDWIDTH; i++) {
            for (int j = 0; j < Konstanten.GFIELDHEIGTH; j++) {
                stift.drawString(drawArray[j][i], (i + ver - x)
                        * fieldwidth, (j + ver - y) * fieldwidth);
            }
        }
        if (controller.getModel().isNotgameover()
                && controller.isStatusscreen()) {
            statustext(stift);
        }
        if (controller.getModel().isNotgameover()
                && controller.isFightscreen()) {
            fighttext(stift);
        }
    }

    /**
     * zeichnen des "Statusschirms".
     * @param stift stift
     */
    private void statustext(final Graphics2D stift) {
        Hero hero = controller.getModel().getHero();
        final int dis = 20;
        final int xan = 5;
        final int yan = 35;
        int i = 2;
        final int xsize = 300;
        final int ysize = 240;
        stift.setColor(Color.darkGray);
        stift.fillRect(0, 0, xsize, ysize);
        stift.setFont(new Font("Arial", Font.PLAIN, font2));
        stift.setColor(Color.white);
        stift.drawString("Lebenspunkte: " + hero.getLifepoints() + "/"
                + hero.getMaxlp(), xan, yan);
        stift.drawString("Level: " + hero.getLevel(), xan, yan + dis);
        stift.drawString("Erfahrungspunkte: " + hero.getEfp() + "/"
                + hero.getNextlevelefp(), xan, yan + dis * i);
        i++;
        stift.drawString("Angriffs-Stärke: " + hero.getStrength(),
                xan, yan + dis * i);
        i++;
        stift.drawString("Verteidigung: " + hero.getDefense(),
                xan, yan + dis * i);
        i++;
        stift.drawString("Magie-Angriffs-Stärke: " + hero.getMagic(),
                xan, yan + dis * i);
        i++;
        stift.drawString("Magie-Verteidigung: " + hero.getMagicdefense(),
                xan, yan + dis * i);
        i++;
        stift.drawString("Raumnummer: "
                + controller.getModel().getCurrentLevel(),
                xan, yan + dis * i);
        i++;
        stift.drawString("Anzahl Potion: " + hero.getPotioncount(),
                xan, yan + dis * i);
        i++;
        stift.drawString("Anzahl Phoenix-Federn: " + hero.getPhoenixcount(),
                xan, yan + dis * i);
        i++;
        stift.drawString("Anzahl Drachenschwerter: "
                + hero.getDragonswordcount(), xan, yan + dis * i);
    }
/**
 * stellt kampfscreen dar.
 * @param stift stift
 */
    private void fighttext(final Graphics2D stift) {
        Model model = controller.getModel();
        Hero hero = model.getHero();
        final int dis = 20;
        final int xan = 5;
        final int yan = 35;
        final int k = 23;
        int i = k;
        final int grey = 130;
        stift.setColor(Color.darkGray);
        stift.fillRect(0, 0, SIZE, grey);
        stift.fillRect(0, SIZE - grey, SIZE, SIZE);
        stift.setFont(new Font("Arial", Font.PLAIN, font2));
        stift.setColor(Color.white);
        stift.drawString("Lebenspunkte: " + hero.getLifepoints() + "/"
                + hero.getMaxlp(), xan, yan + dis * i);
        i++;
        stift.drawString(model.getKampfablauf()[0], xan, yan + dis * i);
        i++;
        stift.drawString(model.getKampfablauf()[1], xan, yan + dis * i);
        i++;
        stift.drawString(model.getKampfablauf()[2], xan, yan + dis * i);
        if (controller.getModel().getAction() == 0) {
            stift.drawString("(1) Angriff", xan, yan);
            i = 2;
            stift.drawString("(2) Verteidigung", xan, yan + dis);
            stift.drawString("(3) Zauber", xan, yan + dis * i);
            i++;
            stift.drawString("(4) Items", xan, yan + dis * i);
            i++;
            stift.drawString("(0) Flucht", xan, yan + dis * i);
            i++;
        } else if (controller.getModel().getAction() == 1) {
            stift.drawString("(1) " + Hero.MAGIC1 + ": Kosten (LP): "
                    + Hero.MAGIC1COST, xan, yan);
            stift.drawString("(2) " + Hero.MAGIC2 + ": Kosten (LP): "
                    + Hero.MAGIC2COST, xan, yan + dis);
            i = 2;
            stift.drawString("(3) " + Hero.MAGIC3 + ": Kosten (LP): "
                    + Hero.MAGIC3COST, xan, yan + dis * i);
            i++;
            i++;
            stift.drawString("(0) zurück", xan, yan + dis * i);
        } else if (controller.getModel().getAction() == 2) {
            stift.drawString("(1) Potion (Anzahl): " + hero.getPotioncount(),
                    xan, yan);
            stift.drawString("(2) Drachenschwerter (Anzahl): "
                    + hero.getDragonswordcount(), xan, yan + dis);
            i = 4;
            stift.drawString("(0) zurück", xan, yan + dis * i);
        }
    }
}
