package Controller;

import GUI.GuiKaestchen;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**Klasse zum Laden.*/
public class LoadO {

    /**
     * ladet spiel.
     * @return gespeicherte Instanz kaestchen
     * @throws IOException IOException standard
     * @throws ClassNotFoundException ClassNotFoundException standard
     */
    public static GuiKaestchen readO(){
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream("Save.ser"));
            try {
                return (GuiKaestchen) input.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoadO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Keine Speicher-Datei "
                        + "vorhanden.");
        } 
        return null;
    }
}
