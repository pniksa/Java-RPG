package Modelrest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Klasse LabyrinthGenerator erzeugt Labyrinth.*/
public class LabyrinthGenerator implements Serializable{

    /**String der das labyrinth enthält.*/
    private String[][] labarray;
    /**Höchste Anzahl an Iterationen.*/
    private final int maxiterations = 100;
    /**Mindest Anzahl an Iterationen.*/
    private final int miniterations = 90;
    /**doorarray.*/
    private int[] doorarraym = new int[4];

    /**Default-Construktor.*/
    LabyrinthGenerator() {
    }

    /**
     * Getter.
     * @return doorarraym
     */
    public final int[] getDoorarraym() {
        return doorarraym;
    }

    /**
     * Methode die labyrinthe generiert.
     * @param s levelnummer
     * @return labarray
     */
    public final String[][] labgenerator(final int s) {
        final int arraylen = 4;
        final int roomwidth = 6;
        final int ly2 = 3;
        Random random = new Random();
        labarray = new String[Konstanten.GFIELDWIDTH][Konstanten.GFIELDHEIGTH];
        int i = 0;
        int j = 0;
        int k = 0;
        int[] roomarray = new int[arraylen];
        ArrayList<int[]> roomList = new ArrayList<int[]>();
        ArrayList<int[]> roomListzwischen = new ArrayList<int[]>();
        int iterations = maxiterations - miniterations;
        int teiler = 0;
        int change = 1;
        int door = 0;
        int rbx1 = 0;
        int rbx2 = Konstanten.GFIELDWIDTH - 1;
        int rby1 = 0;
        int rby2 = Konstanten.GFIELDHEIGTH - 1;
        int doordown = random.nextInt(rby2 - 1);
        doordown++;
        int doorup = random.nextInt(rby2 - 1);
        doorup++;
        doorarraym[0]=0;
        doorarraym[1]=0;
        doorarraym[2]=0;
        doorarraym[3]=0;
        while (i < Konstanten.GFIELDWIDTH) {
            if (i == doordown && s != 1) {
                labarray[0][i] = Konstanten.LB;
                doorarraym[0] = i;
                doorarraym[1] = 1;
            } else {
                labarray[0][i] = Konstanten.BORDER;
            }
            if (i == doorup && s != Konstanten.LASTLEVEL) {
                labarray[Konstanten.GFIELDHEIGTH - 1][i] = Konstanten.LF;
                doorarraym[2] = i;
                doorarraym[3] = Konstanten.GFIELDHEIGTH - 2;
            } else {
                labarray[Konstanten.GFIELDHEIGTH - 1][i] = Konstanten.BORDER;
            }
            i++;
        }
        while (j < Konstanten.GFIELDHEIGTH) {
            labarray[j][0] = Konstanten.BORDER;
            labarray[j][Konstanten.GFIELDWIDTH - 1] = Konstanten.BORDER;
            j++;
        }
        i = 1;
        j = 1;
        while (i < Konstanten.GFIELDHEIGTH - 1) {
            while (j < Konstanten.GFIELDWIDTH - 1) {
                labarray[j][i] = " ";
                j++;
            }
            j = 1;
            i++;
        }
        roomarray[0] = rbx1;
        roomarray[1] = rby1;
        roomarray[2] = rbx2;
        roomarray[ly2] = rby2;
        roomList.add(roomarray);
        iterations = random.nextInt(iterations);
        iterations = miniterations + iterations;
        while (k <= iterations) {
            if (change == 1) {
                change = 0;
            } else {
                change = 1;
            }
            for (int[] room : roomList) {
                int[] roomzwischen = new int[arraylen];
                i = 0;
                if (change == 0) {
                    do {
                        teiler = random.nextInt(room[2] - room[0]);
                        teiler = teiler + room[0];
                        if (teiler == room[0]) {
                            teiler = teiler + 2;
                        } else if (teiler == room[2]) {
                            teiler = teiler - 2;
                        } else if (teiler == room[0] + 1) {
                            teiler++;
                        } else if (teiler == room[2] - 1) {
                            teiler--;
                        }
                    } while (!labarray[teiler][room[1]].equals(Konstanten.BORDER)
                            || !labarray[teiler][room[ly2]].equals(Konstanten.BORDER));
                    do {
                        door = random.nextInt(room[ly2] - room[1]);
                        door = door + room[1];
                    } while (labarray[teiler + 1][door].equals(Konstanten.BORDER)
                            || labarray[teiler - 1][door].equals(Konstanten.BORDER));
                    i = room[1];
                    while (i <= room[ly2]) {
                        if (i != door) {
                            labarray[teiler][i] = Konstanten.BORDER;
                        } else {
                            labarray[teiler][i] = " ";
                        }
                        i++;
                    }
                    System.arraycopy(room, 0, roomzwischen, 0, 1);
                    System.arraycopy(room, 1, roomzwischen, 1, 1);
                    System.arraycopy(room, 0, roomzwischen, 2, 1);
                    roomzwischen[2] = teiler;
                    System.arraycopy(room, ly2, roomzwischen, ly2, 1);
                    if (teiler - room[0] >= roomwidth) {
                        roomListzwischen.add(roomzwischen);
                    }
                    roomzwischen = new int[arraylen];
                    System.arraycopy(room, 0, roomzwischen, 0, 1);
                    roomzwischen[0] = teiler;
                    System.arraycopy(room, 1, roomzwischen, 1, 1);
                    System.arraycopy(room, 2, roomzwischen, 2, 1);
                    System.arraycopy(room, ly2, roomzwischen, ly2, 1);
                    if (room[2] - teiler >= roomwidth) {
                        roomListzwischen.add(roomzwischen);
                    }
                    roomzwischen = new int[arraylen];
                } else if (change == 1) {
                    do {
                        teiler = random.nextInt(room[ly2] - room[1]);
                        teiler = teiler + room[1];
                        if (teiler == room[1]) {
                            teiler = teiler + 2;
                        } else if (teiler == room[ly2]) {
                            teiler = teiler - 2;
                        } else if (teiler == room[1] + 1) {
                            teiler++;
                        } else if (teiler == room[ly2] - 1) {
                            teiler--;
                        }
                    } while (!labarray[room[0]][teiler].equals(Konstanten.BORDER)
                            || !labarray[room[2]][teiler].equals(Konstanten.BORDER));
                    do {
                        door = random.nextInt(room[2] - room[0]);
                        door = door + room[0];
                    } while (labarray[door][teiler + 1].equals(Konstanten.BORDER)
                            || labarray[door][teiler - 1].equals(Konstanten.BORDER));
                    i = room[0];
                    while (i <= room[2]) {
                        if (i != door) {
                            labarray[i][teiler] = Konstanten.BORDER;
                        } else {
                            labarray[i][teiler] = " ";
                        }
                        i++;
                    }
                    System.arraycopy(room, 0, roomzwischen, 0, 1);
                    System.arraycopy(room, 1, roomzwischen, 1, 1);
                    System.arraycopy(room, 2, roomzwischen, 2, 1);
                    System.arraycopy(room, 1, roomzwischen, ly2, 1);
                    roomzwischen[ly2] = teiler;
                    if (teiler - room[1] >= roomwidth) {
                        roomListzwischen.add(roomzwischen);
                    }
                    roomzwischen = new int[arraylen];
                    System.arraycopy(room, 0, roomzwischen, 0, 1);
                    System.arraycopy(room, 1, roomzwischen, 1, 1);
                    roomzwischen[1] = teiler;
                    System.arraycopy(room, 2, roomzwischen, 2, 1);
                    System.arraycopy(room, ly2, roomzwischen, ly2, 1);
                    if (room[ly2] - teiler >= roomwidth) {
                        roomListzwischen.add(roomzwischen);
                    }
                    roomzwischen = new int[arraylen];
                }
            }
            roomList = new ArrayList<int[]>();
            roomList = roomListzwischen;
            roomListzwischen = new ArrayList<int[]>();
            k++;
        }
        return labarray;
    }

    /**
     * erstellt txt datei in der das level ist.
     * @param k dateinummerierung (name)
     * @throws IOException IOException standard
     */
    private void levelwrite(final int k) throws IOException {
        String out = "";
        BufferedWriter writer =
                new BufferedWriter(new FileWriter("level" + k + ".txt"));
        String line = "";
        for (int j = 0; j <= Konstanten.GFIELDHEIGTH - 1; j++) {
            line = "";
            for (int i = 0; i <= Konstanten.GFIELDWIDTH - 1; i++) {
                if (labarray[i][j] == null) {
                    line = line + " ";
                } else {
                    line = line + labarray[i][j];
                }
            }
            out = out + line + "\r\n";
        }
        writer.write(out);
        writer.close();
    }

    /**
     * Konstrukter der Klasse LabyrinthGenerator.
     * @param i levelnummerierung
     */
    public LabyrinthGenerator(final int i) {
        labgenerator(i);
        try {
            levelwrite(i);
        } catch (IOException ex) {
            Logger.getLogger(LabyrinthGenerator.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
}
