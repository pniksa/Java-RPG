/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.GuiKaestchen;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**SaveO ist die Speicher-Klasse.*/
public class SaveO {

    /**
     * speichert Spiel.
     * @param kaestchen instanz die abgespeichert wird
     */
    public static void writeO(final GuiKaestchen kaestchen) {
        ObjectOutputStream output = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Save.ser");
            output = new ObjectOutputStream(fos);
            output.writeObject(kaestchen);
            output.close();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
