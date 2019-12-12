package Modelrest;

import Gegner.Wolf;
import Gegner.UnDead;
import Gegner.Thief;
import Gegner.Mage;
import Gegner.Gegner;
import Gegner.Dragon;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**Klasse Model in der Abläufe und Regeln enthalten sind.*/
public class Model implements Serializable {

    /**test int.*/
    private int jutest;
    /**Instanzierung des LabyrinthGenerators.*/
    private LabyrinthGenerator lab;
    /**sagt Kampf-ereignisse an.*/
    private String[] kampfablauf;
    /**gibt kampfkommandoscreen an.*/
    private int action;
    /**Instanzierung on String[][] guiarray.*/
    private String[][] guiarray;
    /**Instanzierung von Reader reader.*/
    //private Reader reader;
    /**Instanzierung von Hero hero.*/
    private Hero hero;
    /**Instanzierung on Gegenstaende items.*/
    private Items items;
    /**position enthält Positionen aller möglichen Objekte.*/
    private String[][] position;
    /** JOption option wird verwendet um Nachrichten darzustellen.*/
    private JOptionPane option;
    /**Instanzierung von Wolf wolf.*/
    private Wolf wolf;
    /**Instanzierung von Mage mage.*/
    private Mage mage;
    /**Instanzierung von Dragon dragon.*/
    private Dragon dragon;
    /**Instanzierung von UnDead zombie.*/
    private UnDead zombie;
    /**Instanzierung von Thief thief.*/
    private Thief thief;
    /**currentLevel gibt an in welchem raum man sich befindet.*/
    private int currentLevel;
    /**gibt an ob das spiel verloren ist.*/
    private boolean notgameover;
    /**gibt derzeitigen Kampfgegner an.*/
    private int[] currentgegner;
    /**enthält räume.*/
    private ArrayList<String[][]> rooms = new ArrayList<String[][]>();
    /**enthält ausgänge.*/
    private ArrayList<int[]> coord = new ArrayList<int[]>();

    /**
     * Getter.
     * @return jutest
     */
    public final int getJutest() {
        return jutest;
    }

    /**
     * Getter.
     * @return kampfablauf
     */
    public final String[] getKampfablauf() {
        return kampfablauf;
    }

    /**
     * Getter.
     * @return action
     */
    public final int getAction() {
        return action;
    }

    /**
     * Setter.
     * @param action action
     */
    public final void setAction(final int action) {
        this.action = action;
    }

    /**
     * Getter.
     * @return currentgegner
     */
    public final int[] getCurrentgegner() {
        return currentgegner;
    }

    /**
     * Getter.
     * @return notgameover
     */
    public final boolean isNotgameover() {
        return notgameover;
    }
    /**
     *gegnerarray enthält Lebenpunkte der Gegner an den jeweiligen Koordinaten.
     */
    private ArrayList<Gegner> gegnerarray;
    /**Instanzierung von Feinde feinde.*/
    private Gegner feinde;
    /**itemarray enthält die jeweiligen items.*/
    private ArrayList<Items> itemarray;

    /**
     * Getter.
     * @return itemarray
     */
    public final ArrayList<Items> getItemarray() {
        return itemarray;
    }

    /**Konstruktor der Klasse Model.*/
    public Model() {
        lab = new LabyrinthGenerator();
        kampfablauf = new String[3];
        kampfablauf[0] = "";
        kampfablauf[1] = "";
        kampfablauf[2] = "";
        action = 0;
        currentLevel = 1;
        notgameover = true;
        currentgegner = new int[2];
        /* for (int i = 1; i <= Konstanten.LASTLEVEL; i++) {
        LabyrinthGenerator lab = new LabyrinthGenerator(i);
        }*/
        //reader = new Reader(currentLevel);
        guiarray = new String[Konstanten.GFIELDHEIGTH][Konstanten.GFIELDWIDTH];
        roomarrayConstructor();
        hero = new Hero();
        items = new Items(currentLevel);
        wolf = new Wolf();
        mage = new Mage();
        dragon = new Dragon();
        zombie = new UnDead();
        thief = new Thief();
        gegnerarray = new ArrayList<Gegner>();
        feinde = new Gegner(currentLevel);
        items = new Items(currentLevel);
        position = new String[Konstanten.GFIELDWIDTH][Konstanten.GFIELDWIDTH];
        initialposition();
    }

    /**
     * erstellt Räume.
     */
    private void roomarrayConstructor() {
        for (int k = 1; k <= Konstanten.LASTLEVEL; k++) {
            //reader = new Reader(k);
            String[][] roomarray =
                    new String[Konstanten.GFIELDHEIGTH][Konstanten.GFIELDWIDTH];
            int[] coordarr = new int[4];
            /* for (int i = 0; i < Konstanten.GFIELDHEIGTH; i++) {
            /*   for (int j = 0; j < Konstanten.GFIELDWIDTH; j++) {
            /*     roomarray[i][j] = reader.getLevel1upos(i, j);
            /*}
            /*}
             */
            roomarray = lab.labgenerator(k);
            //coordarr[0] = reader.getInx();
            //coordarr[1] = reader.getIny();
            //coordarr[2] = reader.getOutx();
            //coordarr[3] = reader.getOuty();
            if (k != 1) {
                coordarr[0] = lab.getDoorarraym()[0];
                coordarr[1] = lab.getDoorarraym()[1];
            } else {
                coordarr[0] = 0;
                coordarr[1] = 0;
            }
            if (k != Konstanten.LASTLEVEL) {
                coordarr[2] = lab.getDoorarraym()[2];
                coordarr[3] = lab.getDoorarraym()[3];
            } else {
                coordarr[2] = 0;
                coordarr[3] = 0;
            }
            rooms.add(roomarray);
            coord.add(coordarr);
        }
    }

    public ArrayList<Gegner> getGegnerarray() {
        return gegnerarray;
    }

    /**currentLevel @return .*/
    public final int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * set currentLevel.
     * @param currentLevel Raumnummer
     */
    public final void setCurrentLevel(final int currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**guiarray @return .*/
    public final String[][] getGuiarray() {
        return guiarray;
    }

    /**reader @return .*/
    //public final Reader getReader() {
//        return reader;
    //  }
    /**feinde @return .*/
    public final Gegner getFeinde() {
        return feinde;
    }

    /**hero @return .*/
    public final Hero getHero() {
        return hero;
    }

    /**items @return .*/
    public final Items getItems() {
        return items;
    }

    /**position @return .*/
    public final String[][] getPosition() {
        return position;
    }
    /**testkoord.*/
    private int posxtest;
    /**testkoord.*/
    private int posytest;

    /**
     * Getter.
     * @return posxtest
     */
    public final int getPosxtest() {
        return posxtest;
    }

    /**
     * Getter.
     * @return posytest
     */
    public final int getPoytest() {
        return posytest;
    }

    /**
     * Untermethode zu Movement.
     * @param i richtung der x-änderung
     * @param j richtung der y-änderung
     */
    public final void movementman(final int i, final int j) {
        jutest = 0;
        if (guiarray[hero.getHeroxpos() + j][hero.getHeroypos()
                + i].equals(" ")) {
            getPosition()[hero.getHeroxpos()][hero.getHeroypos()] = null;
            hero.setHeroypos(hero.getHeroypos() + i);
            hero.setHeroxpos(hero.getHeroxpos() + j);
            getPosition()[hero.getHeroxpos()][hero.getHeroypos()] =
                    Hero.HEROSYMBOL;
            jutest = 1;
            posxtest = hero.getHeroxpos();
            posytest = hero.getHeroxpos();
        } else if (guiarray[hero.getHeroxpos() + j][hero.getHeroypos()
                + i].equals(Konstanten.LF)) {
            levelchange(1);
            jutest = 2;
        } else if (guiarray[hero.getHeroxpos() + j][hero.getHeroypos()
                + i].equals(Konstanten.LB)) {
            levelchange(-1);
            jutest = 2;
        }
        guiarrayConstructor();
    }

    /**
     * Methode zum Wechsel des Levels.
     * @param s Raumnummer
     */
    private void levelchange(final int s) {
        getPosition()[hero.getHeroxpos()][hero.getHeroypos()] = null;
        currentLevel = currentLevel + s;
        //reader = new Reader(currentLevel);
        switch (s) {
            case 1:
                hero.setHeroypos(coord.get(currentLevel - 1)[0]);
                hero.setHeroxpos(coord.get(currentLevel - 1)[1]);
                break;
            case -1:
                hero.setHeroypos(coord.get(currentLevel - 1)[2]);
                hero.setHeroxpos(coord.get(currentLevel - 1)[3]);
                break;
            default:
                break;
        }
        position = new String[Konstanten.GFIELDWIDTH][Konstanten.GFIELDWIDTH];
        getPosition()[hero.getHeroxpos()][hero.getHeroypos()] = Hero.HEROSYMBOL;
        feinde = new Gegner(currentLevel);
        items = new Items(currentLevel);
        gegnerposition();
        itemsposition();
    }

    /**generiert zufällig die Spawning-position der Gegner.*/
    private void gegnerposition() {
        Random zufall = new Random();
        int i = 1;
        gegnerarray = new ArrayList<Gegner>();
        guiarrayConstructor();
        while (i <= feinde.getGegnerList().size()) {
            int k = zufall.nextInt(Konstanten.GFIELDWIDTH);
            int j = zufall.nextInt(Konstanten.GFIELDHEIGTH);
            if (guiarray[k][j].equals(" ")) {
                position[k][j] = (String) feinde.getGegnerList().get(i - 1);
                gegnerarray.add(new Gegner(feinde.getGegnerList().get(i - 1),
                        k, j));
                i++;
                guiarrayConstructor();
            }
        }
    }

    /**ruft die position der gegner, des helden und der items auf.*/
    private void initialposition() {
        position[hero.getHeroxpos()][hero.getHeroypos()] = Hero.HEROSYMBOL;
        gegnerposition();
        itemsposition();
        guiarrayConstructor();
    }

    /**
     * Gegnerermittlung.
     * @param i zum ermitteln des gegners
     * @param j zum ermitteln des gegners
     * @return gibt gegner an pos i,j zurück
     */
    private Gegner gegnersearch(final int i, final int j) {
        for (Gegner gegner : gegnerarray) {
            if (gegner.getXpos() == i && gegner.getYpos() == j) {
                return (gegner);
            }
        }
        return (null);
    }

    /**ordnet dem guiarray die anzuzeigenden werte zu.*/
    private void guiarrayConstructor() {
        for (int i = 0; i < Konstanten.GFIELDHEIGTH; i++) {
            for (int j = 0; j < Konstanten.GFIELDWIDTH; j++) {
                if (position[i][j] != null) {
                    guiarray[i][j] = position[i][j];
                } else {
                    guiarray[i][j] = rooms.get(currentLevel - 1)[i][j];
                }
            }
        }
    }

    /**Methode Gegnerverschmelzung.*/
    public final void fusion() {
        // throw new UnsupportedOperationException("Not yet implemented");
    }

    /**Methode GegnerKampf.*/
    public final void gegnerfight() {
        // throw new UnsupportedOperationException("Not yet implemented");
    }
    /**testet textnachrichten.*/
    private String juteststring;

    /**
     * Getter.
     * @return guteststring
     */
    public final String getJuteststring() {
        return juteststring;
    }

    /**
     * Methode itemfound.
     * @param x x-koord.
     * @param y y-koord.
     */
    public final void itemfound(final int x, final int y) {
        jutest = 0;
        juteststring = "";
        if (itemsearch(x, y).getCurrentItem().equals(Items.POTION)) {
            hero.setPotioncount(hero.getPotioncount() + 1);
            jutest = 1;
            juteststring = Items.POTION;
        } else if (itemsearch(x, y).getCurrentItem().equals(
                Items.PHOENIXFEATHER)) {
            hero.setPhoenixcount(hero.getPhoenixcount() + 1);
            jutest = 1;
            juteststring = Items.PHOENIXFEATHER;
        } else if (itemsearch(x, y).getCurrentItem().equals(
                Items.DRAGONSWORD)) {
            hero.setDragonswordcount(hero.getDragonswordcount() + 1);
            jutest = 1;
            juteststring = Items.DRAGONSWORD;
        }
        itemarray.remove(itemsearch(x, y));
        position[x][y] = null;
        guiarrayConstructor();
    }

    /**
     * gibt item.
     * @param i bei i = x,
     * @param j und bei j = y
     * @return zurück
     */
    private Items itemsearch(final int i, final int j) {
        for (Items item : itemarray) {
            if (item.getXpos() == i && item.getYpos() == j) {
                return (item);
            }
        }
        return (null);
    }
    /**test arraylists.*/
    ArrayList<String> testarr = new ArrayList<String>();

    /**
     * Getter.
     * @return testarr
     */
    public ArrayList<String> getTestarr() {
        return testarr;
    }

    /**führt gegnerbewegungen durch.*/
    public final void gegnermovement() {
        int i;
        int j;
        int[] possave = new int[2];
        for (Gegner gegner : gegnerarray) {
            i = gegner.getXpos();
            j = gegner.getYpos();
            testarr.add(position[i][j]);
            if (position[i][j].equals(Wolf.WOLFSYMBOL)) {
                possave = wolf.wolfmove(i, j, hero, guiarray);
                setposgegnermov(i, j, possave[0], possave[1],
                        gegner, Wolf.WOLFSYMBOL);
            } else if (position[i][j].equals(UnDead.UNDEADSYMBOL)) {
                possave = zombie.unDeadmove(i, j, guiarray);
                setposgegnermov(i, j, possave[0], possave[1],
                        gegner, UnDead.UNDEADSYMBOL);
            } else if (position[i][j].equals(Thief.THIEFSYMBOL)) {
                possave = thief.thiefmove(i, j, guiarray);
                setposgegnermov(i, j, possave[0], possave[1],
                        gegner, Thief.THIEFSYMBOL);
                itemstealing(i, j, gegner);
            } else if (position[i][j].equals(Dragon.DRAGONSYMBOL)) {
                possave = dragon.dragonmove(i, j, hero, guiarray);
                setposgegnermov(i, j, possave[0], possave[1],
                        gegner, Dragon.DRAGONSYMBOL);
            } else if (position[i][j].equals(Mage.MAGESYMBOL)) {
                possave = mage.magemove(i, j, guiarray);
                setposgegnermov(i, j, possave[0], possave[1],
                        gegner, Mage.MAGESYMBOL);
            }
            guiarrayConstructor();
        }
    }

    /**
     * ändert position des gegners.
     * @param i vorige x-koord.
     * @param j vorige y-koord.
     * @param t neue x-koord.
     * @param s neue y-koord.
     * @param gegner bewegender gegner
     * @param type monstertyp magier etc.
     */
    private void setposgegnermov(final int i, final int j, final int t,
            final int s, final Gegner gegner, final String type) {
        position[i][j] = null;
        position[t][s] = type;
        gegner.setXpos(t);
        gegner.setYpos(s);
    }

    /**
     * generiert zufällig items.
     */
    private void itemsposition() {
        Random zufall = new Random();
        int i = 1;
        itemarray = new ArrayList<Items>();
        guiarrayConstructor();
        while (i <= items.getItemsList().size()) {
            int k = zufall.nextInt(Konstanten.GFIELDWIDTH);
            int j = zufall.nextInt(Konstanten.GFIELDHEIGTH);
            if (guiarray[k][j].equals(" ")) {
                position[k][j] = Items.ITEMSYMBOL;
                itemarray.add(new Items(items.getItemsList().get(i - 1), k, j));
                i++;
                guiarrayConstructor();
            }
        }
    }

    /**
     * Kampfablauf.
     * @param e gedrückte taste
     * @return kampfscreen an oder aus
     */
    public final boolean fight(final int e) {
        if (action == 0 && e == KeyEvent.VK_3) {
            action = 1;
            return true;
        } else if (action == 0 && e == KeyEvent.VK_4) {
            action = 2;
            return true;
        } else if ((action == 2 || action == 1)
                && e == KeyEvent.VK_0) {
            action = 0;
            return true;
        } else if ((action == 0 && (e == KeyEvent.VK_1 || e == KeyEvent.VK_2))
                || (action == 1 && (e == KeyEvent.VK_1 || e == KeyEvent.VK_2
                || e == KeyEvent.VK_3)) || (action == 2
                && (e == KeyEvent.VK_1 || e == KeyEvent.VK_2))) {
            return kampfzuweisung(e);
        } else if (action == 0 && e == KeyEvent.VK_0) {
            return !flucht();
        } else {
            return true;
        }
    }

    /**
     * weist kampfanweisungen zu.
     * @param e kampfanweisung zur jeweiligen "action"
     * @return ob kampf zu ende oder nicht
     */
    private boolean kampfzuweisung(final int e) {
        Gegner gegner = gegnersearch(currentgegner[0], currentgegner[1]);
        //gegner.setLifepoints(0);
        if (gegner.getGegnersymbol().equals(Wolf.WOLFSYMBOL)) {
            kampfablaufchange(wolf.attacked(hero, gegner, action, e));
            if (gegner.getLifepoints() > 0) {
                kampfablaufchange(wolf.fight(hero, gegner, action, e));
            } else {
                hero.setEfp(hero.getEfp() + wolf.getEfp());
                hero.levelup();
            }
        } else if (gegner.getGegnersymbol().equals(UnDead.UNDEADSYMBOL)) {
            kampfablaufchange(zombie.attacked(hero, gegner, action, e));
            if (gegner.getLifepoints() > 0) {
                kampfablaufchange(zombie.fight(hero, gegner, action, e));
            } else {
                hero.setEfp(hero.getEfp() + zombie.getEfp());
                hero.levelup();
            }
        } else if (gegner.getGegnersymbol().equals(Mage.MAGESYMBOL)) {
            kampfablaufchange(mage.attacked(hero, gegner, action, e));
            if (gegner.getLifepoints() > 0) {
                kampfablaufchange(mage.fight(hero, gegner, action, e));
            } else {
                hero.setEfp(hero.getEfp() + mage.getEfp());
                hero.levelup();
            }
        } else if (gegner.getGegnersymbol().equals(Thief.THIEFSYMBOL)) {
            kampfablaufchange(thief.attacked(hero, gegner, action, e));
            if (gegner.getLifepoints() > 0) {
                kampfablaufchange(thief.fight(hero, gegner, action, e));
            } else {
                hero.setEfp(hero.getEfp() + thief.getEfp());
                hero.levelup();
                hero.getItems(gegner.getStolenitems());
            }
        } else if (gegner.getGegnersymbol().equals(Dragon.DRAGONSYMBOL)) {
            kampfablaufchange(dragon.attacked(hero, gegner, action, e));
            if (gegner.getLifepoints() > 0) {
                kampfablaufchange(dragon.fight(hero, gegner, action, e));
            } else {
                hero.setEfp(hero.getEfp() + dragon.getEfp());
                hero.levelup();
            }
        }
        rip();
        if (gegner.getLifepoints() <= 0) {
            gegnerarray.remove(gegnerarray.indexOf(gegner));
            position[currentgegner[0]][currentgegner[1]] = null;
            guiarrayConstructor();
            currentgegner = new int[2];
            defaultkampfablauf();
            return false;
        } else {
            return true;
        }
    }

    private void rip() {
        if (hero.getLifepoints() <= 0) {
            System.out.println("true");
            if (hero.getPhoenixcount() > 0) {
                hero.resurrection();
            } else {
                notgameover = false;
            }
        }
    }

    /**
     * Methode flucht ermöglicht aus Kampf zu fliehen.
     * @return flucht ja oder nein
     */
    private boolean flucht() {
        if (guiarray[hero.getHeroxpos()][hero.getHeroypos()
                - 1].equals(" ")) {
            movementman(-1, 0);
            defaultkampfablauf();
            return true;
        } else if (guiarray[hero.getHeroxpos()][hero.getHeroypos()
                + 1].equals(" ")) {
            movementman(1, 0);
            defaultkampfablauf();
            return true;
        } else if (guiarray[hero.getHeroxpos()
                - 1][hero.getHeroypos()].equals(" ")) {
            movementman(0, -1);
            defaultkampfablauf();
            return true;
        } else if (guiarray[hero.getHeroxpos()
                + 1][hero.getHeroypos()].equals(" ")) {
            movementman(0, 1);
            defaultkampfablauf();
            return true;
        } else {
            kampfablaufchange("Du kannst nicht fliehen. Pech gehabt.");
            return false;
        }
    }

    /**setzt kampfablauf auf default.*/
    private void defaultkampfablauf() {
        kampfablauf[0] = "";
        kampfablauf[1] = "";
        kampfablauf[2] = "";
    }

    /**
     * setzt den neuen kampfablauftext.
     * @param text neuer ausgabetext
     */
    private void kampfablaufchange(final String text) {
        kampfablauf[0] = kampfablauf[1];
        kampfablauf[1] = kampfablauf[2];
        kampfablauf[2] = text;
    }

    /**
     * Methode mit der gegner gegstände aufnimmt.
     * @param i x-pos gegner
     * @param j y-pos gegner
     * @param gegner Gegner (Thief)
     */
    private void itemstealing(final int i, final int j, final Gegner gegner) {
        if (guiarray[i + 1][j].equals(Items.ITEMSYMBOL)) {
            gegner.getStolenitems().add(itemsearch(i + 1, j));
            itemarray.remove(itemsearch(i + 1, j));
            position[i + 1][j] = null;
        }
        if (guiarray[i - 1][j].equals(Items.ITEMSYMBOL)) {
            gegner.getStolenitems().add(itemsearch(i - 1, j));
            itemarray.remove(itemsearch(i - 1, j));
            position[i - 1][j] = null;
        }
        if (guiarray[i][j + 1].equals(Items.ITEMSYMBOL)) {
            gegner.getStolenitems().add(itemsearch(i, j + 1));
            itemarray.remove(itemsearch(i, j + 1));
            position[i][j + 1] = null;
        }
        if (guiarray[i][j - 1].equals(Items.ITEMSYMBOL)) {
            gegner.getStolenitems().add(itemsearch(i, j - 1));
            itemarray.remove(itemsearch(i, j - 1));
            position[i][j - 1] = null;
        }
    }
}
