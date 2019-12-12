package Modelrest;

import Gegner.Gegner;
import java.io.Serializable;
import java.util.ArrayList;

/**Eigenschaften, Position der Spielfigur.*/
public class Hero implements Serializable {

    /**gibt charakterlevel an.*/
    private int level;
    /**gibt erfahrungspunkte an.*/
    private int efp;
    /**gibt maximale lp an.*/
    private int maxlp;
    /**gibt aktuelle stärke an.*/
    private int maxstrength;
    /**gibt aktuelle min-stärke an.*/
    private int minstrength;
    /**gibt aktuelle verteidigung an.*/
    private int defense;
    /**gibt aktuelle magie an.*/
    private int magic;
    /**gibt aktuelle magieverteidigung an.*/
    private int magicdefense;
    /**1. magischer Angriff.*/
    public static final String MAGIC1 = "HellFire";
    /**2. magischer Angriff.*/
    public static final String MAGIC2 = "Vacuum";
    /**3. magischer Angriff.*/
    public static final String MAGIC3 = "Ultima";
    /**lp-kosten des 1. zaubers bzw. eine phoenixfeder.*/
    public static final int MAGIC1COST = 60;
    /**lp-kosten des 2. zaubers bzw. eine phoenixfeder.*/
    public static final int MAGIC2COST = 140;
    /**lp-kosten des 3. zaubers bzw. eine phoenixfeder.*/
    public static final int MAGIC3COST = 300;
    /**gibt Anzahl an potions an.*/
    private int potioncount;
    /**gibt Anzahl an Phoenix-federn an.*/
    private int phoenixcount;
    /**gibt Anzahl an Dragonswords an.*/
    private int dragonswordcount;
    /** gibt an wie viele efp für das nächste level gebraucht werden.*/
    private int nextlevelefp;
    /** gibt an wie viel ein potion heilt.*/
    private final int potionlp = 40;
    /**gibt den zusätzlichen schutz beim verteidigen an.*/
    private int shielding;
    /** multiplikator für den magie-schaden der zauber.*/
    public static final double MAGICMULTIPLICATOR = 0.3;

    /**
     * Getter.
     * @return minstrength
     */
    public final int getMinstrength() {
        return minstrength;
    }

    /**
     * Getter.
     * @return shielding 
     */
    public final int getShielding() {
        return shielding;
    }

    /**
     * Getter.
     * @return nextlevelefp
     */
    public final int getNextlevelefp() {
        return nextlevelefp;
    }

    /**
     * Getter.
     * @return dragonswordcount
     */
    public final int getDragonswordcount() {
        return dragonswordcount;
    }

    /**
     * Setter
     * @param dragonswordcount dragonswordcount
     */
    public final void setDragonswordcount(final int dragonswordcount) {
        this.dragonswordcount = dragonswordcount;
    }

    /**
     * Getter
     * @return phoenixcount
     */
    public final int getPhoenixcount() {
        return phoenixcount;
    }

    /**
     * Setter
     * @param phoenixcount phoenixcount
     */
    public final void setPhoenixcount(final int phoenixcount) {
        this.phoenixcount = phoenixcount;
    }

    /**
     * Getter.
     * @return potioncount
     */
    public final int getPotioncount() {
        return potioncount;
    }

    /**
     * Setter
     * @param potioncount potioncount
     */
    public final void setPotioncount(final int potioncount) {
        this.potioncount = potioncount;
    }

    /**
     * Getter.
     * @return defense
     */
    public final int getDefense() {
        return defense;
    }

    /**
     * Setter.
     * @param defense defense
     */
    public final void setDefense(final int defense) {
        this.defense = defense;
    }

    /**
     * Getter.
     * @return magic
     */
    public final int getMagic() {
        return magic;
    }

    /**
     * Setter.
     * @param magic magic
     */
    public final void setMagic(final int magic) {
        this.magic = magic;
    }

    /**
     * Getter.
     * @return magicdefense
     */
    public final int getMagicdefense() {
        return magicdefense;
    }

    /**
     * Setter.
     * @param magicdefense magicdefense
     */
    public final void setMagicdefense(final int magicdefense) {
        this.magicdefense = magicdefense;
    }

    /**
     * Getter.
     * @return strength
     */
    public final int getStrength() {
        return maxstrength;
    }

    /**
     * Setter.
     * @param strength strength
     */
    public final void setStrength(final int strength) {
        this.maxstrength = strength;
    }

    /**
     * Getter.
     * @return maxlp
     */
    public final int getMaxlp() {
        return maxlp;
    }

    /**
     * Setter.
     * @param maxlp maxlp
     */
    public final void setMaxlp(final int maxlp) {
        this.maxlp = maxlp;
    }

    /**
     * Getter.
     * @return efp
     */
    public final int getEfp() {
        return efp;
    }

    /**
     * Setter.
     * @param efp efp
     */
    public final void setEfp(final int efp) {
        this.efp = efp;
    }

    /**
     * Getter.
     * @return level
     */
    public final int getLevel() {
        return level;
    }

    /**
     * Setter.
     * @param level level
     */
    public final void setLevel(final int level) {
        this.level = level;
    }
    /**herosymbol ist "H".*/
    public static final String HEROSYMBOL = "H";
    /**x-pos. der Spielfigur.*/
    private int heroxpos;
    /**y-pos der Spielfigur.*/
    private int heroypos;
    /**lifepoints gibt lebenspunkte an, wobei 50 am anfang angegeben werden.*/
    private int lifepoints;

    /**lifepoints @return .*/
    public final int getLifepoints() {
        return lifepoints;
    }

    /**
     * set lifepoints.
     *  @param lifepoints lifepoints
     */
    public final void setLifepoints(final int lifepoints) {
        this.lifepoints = lifepoints;
    }

    /**heroxpos @return .*/
    public final int getHeroxpos() {
        return heroxpos;
    }

    /**
     * xpos der Spielfigur ändern.
     * @param heroxpos  heroxpos
     */
    public final void setHeroxpos(final int heroxpos) {
        this.heroxpos = heroxpos;
    }

    /**heroypos @return .*/
    public final int getHeroypos() {
        return heroypos;
    }

    /**
     * ypos der Spielfigur ändern.
     * @param heroypos heroypos
     */
    public final void setHeroypos(final int heroypos) {
        this.heroypos = heroypos;
    }

    /**Konstruktor der Klasse Hero.*/
    public Hero() {
        nextlevelefp = 10;
        potioncount = 2;
        phoenixcount = 0;
        dragonswordcount = 0;
        defense = 9;
        magicdefense = 9;
        maxstrength = 15;
        minstrength = 10;
        magic = 5;
        maxlp = 100;
        lifepoints = maxlp;
        heroxpos = 1;
        heroypos = 1;
        level = 1;
        efp = 0;
        shielding = defense * 10;
    }

    /**führt Wiederbelebung durch.*/
    public final void resurrection() {
        final double factor = 0.5;
        lifepoints = (int) (maxlp * factor);
        phoenixcount--;
    }

    /**setzt potion im freien feld ein.*/
    public final void usepotion() {
        if (potioncount > 0 && lifepoints > 0) {
            potioncount--;
            if (lifepoints + potionlp > maxlp) {
                lifepoints = maxlp;
            } else {
                lifepoints = lifepoints + potionlp;
            }
        }
    }

    /**levelaufstieg.*/
    public final void levelup() {
        final double factor = 1.3;
        while (efp >= nextlevelefp) {
            efp = efp - nextlevelefp;
            nextlevelefp = (int) (nextlevelefp * 1.5);
            maxlp = (int) (maxlp * factor);
            lifepoints = maxlp;
            maxstrength = (int) (maxstrength * factor);
            minstrength = (int) (minstrength * factor);
            defense = (int) (defense * factor);
            magic = (int) (magic * factor);
            magicdefense = (int) (magicdefense * factor);
            shielding = defense * 3;
            level++;
        }
    }

    /**
     * Drachenschwerter einsetzen.
     * @param gegner fight gegner
     * @return ausgabe
     */
    public final String useDragonsword(final Gegner gegner) {
        if (dragonswordcount > 0) {
            gegner.setLifepoints(0);
            dragonswordcount--;
            return ("Drachenschwert eingesetzt.");
        } else {
            return ("Du hast anscheinend keine Drachenschwerter.");
        }
    }

    public final String usepotion1() {
        if (potioncount > 0 && lifepoints > 0) {
            potioncount--;
            if (lifepoints + potionlp > maxlp) {
                lifepoints = maxlp;
            } else {
                lifepoints = lifepoints + potionlp;
            }
            return ("Potion eingesetzt und " + potionlp + " LP geheilt.");
        }
        return ("Du hast anscheinend keine Potions mehr.");
    }

    /**
     * gestohlene gegenstände erhalten.
     * @param stolenitems enthält gestohlene items
     */
    public final void getItems(final ArrayList<Items> stolenitems) {
        for (Items item : stolenitems) {
            if (item.getCurrentItem().equals(Items.DRAGONSWORD)) {
                dragonswordcount++;
            } else if (item.getCurrentItem().equals(Items.POTION)) {
                potioncount++;
            } else if (item.getCurrentItem().equals(Items.PHOENIXFEATHER)) {
                phoenixcount++;
            }
        }
    }
}
