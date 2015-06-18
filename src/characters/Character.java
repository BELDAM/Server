package characters;

import items.BodyPart;
import items.Item;
import monsters.Monster;

import java.util.LinkedList;

public abstract class Character {

    private int level;
    private int xp;
    public static final int XPtoLevel = 100;
    private String name;
    private char symbol;
    private int hp;
    private static final int LIFE = 100;
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

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {

        this.xp = xp;

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    protected Character(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        dead = false;
        xp = 0;
        items = new LinkedList<>();
        hp = LIFE;
        strength = STRENGTH;
        intelligence = INTELLIGENCE;
        physicalDefence = PHYSICAL_DEFENCE;
        magicalDefence = MAGICAL_DEFENCE;
        level = 1;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
        int str = strength;
        for (Item i : items) {
            str += i.getAttack();
        }
        return str;
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
        hp += newItem.getDefense();
    }

    public void removeItems(Item item) {
        items.remove(item);
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public void takeDmg(int dmg) {
        hp -= dmg;

        if (hp <= 0) {
            hp = 0;
        }

        if (hp == 0) {
            dead = true;
        }
    }

    public void attack(Monster monster) {
        if (!isDead()) {
            if (!monster.isDead()) {
                monster.takeDmg(getStrength());
                if (monster.isDead()) {
                    setXp(5);
                }
            } else {
                System.out.println("Your Ennemi is dead");
            }

        } else {
            System.out.println("you are dead");
        }
    }

    public void magicAttack(Monster character) {
        if (!isDead()) {
            if (!character.isDead()) {
                // character.takeMagicDmg(getStrength());
                if (character.isDead()) {
                    System.out.println("setXP");
                }
            } else {
                System.out.println("Your Ennemi is dead");
            }

        } else {
            System.out.println("you are dead");
        }
    }

    @Override
    public String toString() {
        return name + ": hp[" + hp + "], Strength[" + strength + "], Symbol[" + symbol + "]";
    }

    public boolean isDead() {
        return dead;
    }
;
}
