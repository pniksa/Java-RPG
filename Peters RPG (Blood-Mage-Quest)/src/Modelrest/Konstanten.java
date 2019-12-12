package Modelrest;

import java.io.Serializable;

/**Klasse Konstanten enthält Werte auf die mehrere Klassen Zugriff brauchen.*/
public class Konstanten implements Serializable {

    /**Anzahl der Kästchen in einer Spalte.*/
    public static final int GFIELDHEIGTH = 50;
    /**Anzahl der Kästchen in einer Zeile.*/
    public static final int GFIELDWIDTH = 50;
    /**Zeichen für Mauern.*/
    public static final String BORDER = "#";
    /**Zeichen für Level zurück.*/
    public static final String LB = "↑";
    /**Zeichen für Level weiter.*/
    public static final String LF = "↓";
    /**Anzahl an Räumen.*/
    public static final int LASTLEVEL = 6;
}
