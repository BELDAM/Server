package characters;

import Interface.FightInterface;
import items.BodyPart;
import items.Item;

import java.util.LinkedList;

/**
 * Created by bastiangardel on 25.05.15.
 */
public abstract class Character implements FightInterface {

    private int level;
    private int xp;
    private static final int XPtoLevel = 100;
    private String name;
    private char symbol;
    private int HP;

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    private static final int LIFE = 10;
    private boolean dead;
    private int strength;
    private static final int STRENGTH = 10;
    private int intelligence;
    private static final int INTELLIGENCE = 10;

    protected int physicalDefence;
    private static final int PHYSICAL_DEFENCE = 10;

    protected int magicalDefence;
    private static final int MAGICAL_DEFENCE = 10;

    private LinkedList<Item> items;

    protected Character(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        dead = false;
        xp = 0;
        items = new LinkedList<>();
        HP = LIFE;
        strength = STRENGTH;
        physicalDefence = PHYSICAL_DEFENCE;
        magicalDefence = MAGICAL_DEFENCE;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getMagicalDefence() {
        return magicalDefence;
    }

    public void setMagicalDefence(int magicalDefence) {
        this.magicalDefence = magicalDefence;
    }

    public int getPhysicalDefence() {
        return physicalDefence;
    }

    public void setPhysicalDefence(int physicalDefence) {
        this.physicalDefence = physicalDefence;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getAvatar() {
        return symbol;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void addItem(Item newItem) {
        BodyPart newPart = newItem.getBodyPart();

        // Check if the slot is empty so the character can carry the new item
        for (Item item : items) {
            BodyPart usedPart = item.getBodyPart();
            if (newPart == usedPart
                    || ((newPart == BodyPart.RIGHT_HAND || newPart == BodyPart.LEFT_HAND) && usedPart == BodyPart.BOTH_HANDS)
                    || ((usedPart == BodyPart.RIGHT_HAND || usedPart == BodyPart.LEFT_HAND) && newPart == BodyPart.BOTH_HANDS)) {
                // TODO Send error to the player (Slot "Right hand" already used by item.toString())
                System.out.println("Slot '" + newPart + "' already used by " + item.toString());
            }
        }

        items.add(newItem);
    }

    public void removeItems(Item item) {
        items.remove(item);
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public abstract void takeDmg(int dmg);

    public abstract void attack(FightInterface character);

    @Override
    public String toString() {
        return name + ": HP[" + HP + "], Strength[" + strength + "], Symbol[" + symbol + "]";
    }

    public boolean isDead() {
        return dead;
    }
;
}
