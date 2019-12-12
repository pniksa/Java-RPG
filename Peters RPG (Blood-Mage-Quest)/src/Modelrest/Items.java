package Modelrest;

import java.io.Serializable;
import java.util.ArrayList;

/**Eigenschaften und Positionen der Gegenstände.*/
public class Items implements Serializable {

    /** legt Itemsymbol fest als i.*/
    public static final String ITEMSYMBOL = "i";
    /**legt potion fest als p.*/
    public static final String POTION = "p";
    /**legt dragonsword fest als d.*/
    public static final String DRAGONSWORD = "d";
    /**legt phonixfeather fest als ph.*/
    public static final String PHOENIXFEATHER = "ph";
    /**Instanzierung der itme-arraylist.*/
    private ArrayList<String> itemsList;
    /**Instanzierung der Itemzuordnung.*/
    private String currentItem;
    /**legt x-koord. des items fest.*/
    private int xpos;
    /**legt y-koord. des items fest.*/
    private int ypos;

    /**
     * Getter.
     * @return currentItem
     */
    public final String getCurrentItem() {
        return currentItem;
    }

    /**
     * Setter.
     * @param currentItem currentItem
     */
    public final void setCurrentItem(final String currentItem) {
        this.currentItem = currentItem;
    }

    /**
     * Getter.
     * @return xpos
     */
    public final int getXpos() {
        return xpos;
    }

    /**
     * Setter.
     * @param xpos xpos
     */
    public final void setXpos(final int xpos) {
        this.xpos = xpos;
    }

    /**
     * Getter.
     * @return ypos
     */
    public final int getYpos() {
        return ypos;
    }

    /**
     * Setter.
     * @param ypos ypos
     */
    public final void setYpos(final int ypos) {
        this.ypos = ypos;
    }

    /**
     * erstellt item.
     * @param itemsss bezeichnung des item
     * @param xpos x-koord
     * @param ypos y-koord
     */
    public Items(final String itemsss, final int xpos, final int ypos) {
        currentItem = itemsss;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    /**
     * Getter.
     * @return itemsList
     */
    public final ArrayList<String> getItemsList() {
        return itemsList;
    }

    /**
     * erzeugt itemsLevel.
     * @param currentLevel für das jeweilige Level
     */
    public Items(final int currentLevel) {
        itemsList = new ArrayList();
        switch (currentLevel) {
            case 1:
                itemsLevel1();
                break;
            case 2:
                itemsLevel2();
                break;
            case 3:
                itemsLevel3();
                break;
            case 4:
                itemsLevel4();
                break;
            case 5:
                itemsLevel5();
                break;
            case 6:
                itemsLevel6();
                break;
            default:
                break;
        }
    }

    /**Gegenstände des ersten Levels.*/
    private void itemsLevel1() {
        for (int i = 1; i < 30; i++) {
            itemsList.add(POTION);
        }
        for (int j = 1; j < 2; j++) {
            itemsList.add(PHOENIXFEATHER);
        }
    }

    /**Gegenstände des zweiten Levels.*/
    private void itemsLevel2() {
        for (int i = 1; i < 50; i++) {
            itemsList.add(POTION);
        }
        for (int j = 1; j < 5; j++) {
            itemsList.add(PHOENIXFEATHER);
        }
    }

    /**Gegenstände des dritten Levels.*/
    private void itemsLevel3() {
        for (int i = 1; i < 70; i++) {
            itemsList.add(POTION);
        }
        for (int j = 1; j < 5; j++) {
            itemsList.add(PHOENIXFEATHER);
        }
    }

    /**Gegenstände des vierten Levels.*/
    private void itemsLevel4() {
        for (int i = 1; i < 80; i++) {
            itemsList.add(POTION);
        }
        for (int j = 1; j < 5; j++) {
            itemsList.add(PHOENIXFEATHER);
        }
        for (int j = 1; j < 1; j++) {
            itemsList.add(DRAGONSWORD);
        }
    }

    /**Gegenstände des fünften Levels.*/
    private void itemsLevel5() {
        for (int i = 1; i < 100; i++) {
            itemsList.add(POTION);
        }
        for (int j = 1; j < 6; j++) {
            itemsList.add(PHOENIXFEATHER);
        }
        for (int j = 1; j < 4; j++) {
            itemsList.add(DRAGONSWORD);
        }
    }

    /**Gegenstände des sechsten Levels.*/
    private void itemsLevel6() {
        for (int i = 1; i < 120; i++) {
            itemsList.add(POTION);
        }
        for (int j = 1; j < 6; j++) {
            itemsList.add(PHOENIXFEATHER);
        }
        for (int j = 1; j < 10; j++) {
            itemsList.add(DRAGONSWORD);
        }
    }
}
