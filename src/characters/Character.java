package characters;

import Interface.FightInterface;
import items.BodyPart;
import items.Item;

import java.util.LinkedList;

/**
 * Created by bastiangardel on 25.05.15.
 */
public abstract class Character implements FightInterface {
    String name;
    char symbol;
    int life;
    boolean dead;
    static final int LIFE = 10;
    int strength;
    static final int STRENGTH = 10;
    LinkedList<Item> items;

    public Character(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;

        items = new LinkedList<>();
        life = LIFE;
        strength = STRENGTH;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public void addItem(Item newItem){
        BodyPart newPart = newItem.getBodyPart();

        // Check if the slot is empty so the character can carry the new item
        for (Item item : items) {
            BodyPart usedPart = item.getBodyPart();
            if (newPart == usedPart ||
                ((newPart == BodyPart.RIGHT_HAND || newPart == BodyPart.LEFT_HAND) && usedPart == BodyPart.BOTH_HANDS) ||
                ((usedPart == BodyPart.RIGHT_HAND || usedPart == BodyPart.LEFT_HAND) && newPart == BodyPart.BOTH_HANDS)
                ) {
                // TODO Send error to the player (Slot "Right hand" already used by item.toString())
                System.out.println("Slot '" + newPart + "' already used by " + item.toString());
            }
        }

        items.add(newItem);
    }

    public void removeItems(Item item){
        items.remove(item);
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public abstract void takeDmg(int dmg);

    public abstract void attack(FightInterface character);


    @Override
    public String toString() {
        return name + ": life[" + life + "], Strength[" + strength + "], Symbol[" + symbol + "]";
    }


    public boolean isDead(){return dead;};
}
