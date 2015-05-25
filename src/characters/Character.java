package characters;

import items.Item;

import java.util.LinkedList;

/**
 * Created by bastiangardel on 25.05.15.
 */
public abstract class Character implements CharacterFightInterface {
    String name;
    char symbol;
    int life;
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

    public void addItems(Item item){
        items.add(item);
    }

    public void removeItems(Item item){
        items.remove(item);
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public abstract void takeDammage(int dammage);

    public abstract void die();

    public abstract void attack(CharacterFightInterface character);


    @Override
    public String toString() {
        return name + ": life[" + life + "], Strength[" + strength + "], Symbol[" + symbol + "]";
    }
}
