package GUI;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Controller.LoadO;
import Controller.SaveO;

/**Die Klasse Gui erzeugt den Frame.*/
public class Gui extends JFrame implements ActionListener, KeyListener {

    /** Erstellung des JButton Start.*/
    //private final JButton start = new JButton("Start");
    /** Erstellung des JButton Neu.*/
    private final JButton neu = new JButton("Neu");
    /** Erstellung des JButton Löschen.*/
    private final JButton laden = new JButton("Laden");
    /** Erstellung des JButton Löschen.*/
    private final JButton speichern = new JButton("Speichen");
    /** Breite des Frames.*/
    private final int framewidth = 600;
    /** Höhe des Frames.*/
    private final int frameheigth = 600;
    /** Erstellung des JPanel panel.*/
    private JPanel panel;
    /**Instanzierung von GuiKaestchen kaestchen.*/
    private GuiKaestchen kaestchen;

    /**
     * Konstrukter erstellt das JFrame.
     *@param kasten kaestchen
     */
    public Gui(final GuiKaestchen kasten) {
        super("RPG");
        panel = new JPanel();
        if (kasten == null) {
            kaestchen = new GuiKaestchen();
        } else {
            kaestchen = kasten;
        }
        this.setSize(framewidth, frameheigth);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(1, 3));
        //panel.add(start);
        panel.add(neu);
        panel.add(laden);
        panel.add(speichern);
        this.add(panel /*BorderLayout.NORTH*/);
        this.add(kaestchen /*BorderLayout.CENTER*/);

        panel.setSize(600, 20);
        panel.setLocation(0, 0);

        kaestchen.setLocation(0, 20);
        kaestchen.setSize(600, 580);
        // this.add(info /*BorderLayout.SOUTH*/);
        //start.addActionListener(this);
        //start.setActionCommand("start");
        neu.addActionListener(this);
        neu.setActionCommand("neu");
        laden.addActionListener(this);
        laden.setActionCommand("laden");
        speichern.addActionListener(this);
        speichern.setActionCommand("speichern");
        this.addKeyListener(this);
        this.setVisible(true);
        this.setFocusable(true);
        neu.setFocusable(false);
        speichern.setFocusable(false);
        laden.setFocusable(false);
        //start.setFocusable(false);
        this.setLocation(500, 200);
        this.setFocusTraversalKeysEnabled(true);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public final void actionPerformed(final ActionEvent e) {
        if (e.getActionCommand().equals("neu")) {
            this.dispose();
            Gui gui = new Gui(null);
        } else if (e.getActionCommand().equals("speichern")) {
            SaveO.writeO(kaestchen);
        } else if (e.getActionCommand().equals("laden")) {
                if(LoadO.readO() != null){
                    this.dispose();
                Gui gui = new Gui(LoadO.readO());
            }
        }
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        //      throw new UnsupportedOperationException("Not supported yet.");
    }

    boolean test = false;
    @Override
    public final void keyPressed(final KeyEvent e) {
        if (!e.isShiftDown()) {
            keyevent(e);
        }
    }

    @Override
    public final void keyReleased(final KeyEvent e) {
        if (e.isShiftDown()) {
            keyevent(e);
        }
    }

    /**
     * gibt anweisung des keylisteners an.
     * @param e keyevent e
     */
    private void keyevent(final KeyEvent e) {
        kaestchen.getController().keycontrol(e);
        kaestchen.repaint();
        this.setFocusTraversalKeysEnabled(true);
        this.setFocusable(true);
    }
}
