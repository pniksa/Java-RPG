package Controller;

import Modelrest.Konstanten;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Klasse Reader liest Daten ein.*/
public class Reader implements Serializable {

    /** Instanzierung von BufferedReader reader.*/
    private transient BufferedReader reader;
    /** Instanzierung von String[][] level1u.*/
    private final String[][] level1u;
    /** Instanzierung von String line.*/
    private String line;

    /**level1u @return .*/
    public final String[][] getLevelu() {
        return level1u;
    }

    /**level1u[@param i][@param j] @return .*/
    /**
     * gibt level1u.
     * @param i bei x = i
     * @param j und y = j an
     * @return level1u[i][j]
     */
    public final String getLevel1upos(final int i, final int j) {
        return level1u[i][j];
    }
    /**gibt spawn x-position des heros im nächsten Raum an.*/
    private int inx;
    /**gibt spawn y-position des heros im nächsten Raum an.*/
    private int iny;
    /**gibt spawn x-position des heros im vorigen Raum an.*/
    private int outx;
    /**gibt spawn y-position des heros im vorigen Raum an.*/
    private int outy;

    /**outx @return .*/
    public final int getOutx() {
        return outx;
    }

    /**outy @return .*/
    public final int getOuty() {
        return outy;
    }

    /**inx @return .*/
    public final int getInx() {
        return inx;
    }

    /**iny @return .*/
    public final int getIny() {
        return iny;
    }

    /**Konstruktor der Klasse Reader.
     * @param a zu öffnende datei
     */
    public Reader(final String a) {
        level1u = new String[Konstanten.GFIELDWIDTH][Konstanten.GFIELDHEIGTH];
        try {
            reader = new BufferedReader(new FileReader(a));
            //line = reader.readLine();
            for (int i = 0; i < Konstanten.GFIELDWIDTH; i++) {
                line = reader.readLine();
                for (int j = 0; j < Konstanten.GFIELDHEIGTH; j++) {
                    level1u[i][j] = line.substring(j, j + 1);
                }
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

    }

    /**Konstruktor liest die level datei für den Raum @param a ein.*/
    public Reader(final int a) {
        level1u = new String[Konstanten.GFIELDWIDTH][Konstanten.GFIELDHEIGTH];
        try {
            reader = new BufferedReader(new FileReader("level" + a + ".txt"));
            for (int i = 0; i < Konstanten.GFIELDWIDTH; i++) {
                line = reader.readLine();
                for (int j = 0; j < Konstanten.GFIELDHEIGTH; j++) {
                    level1u[i][j] = line.substring(j, j + 1);
                    if (line.substring(j, j + 1).equals(Konstanten.LB)) {
                        inx = j;
                        iny = i + 1;
                    }
                    if (line.substring(j, j + 1).equals(Konstanten.LF)) {
                        outx = j;
                        outy = i - 1;
                    }
                }
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

    }
}
