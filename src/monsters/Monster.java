package monsters;

import characters.Character;
import items.Item;

import java.util.LinkedList;
import java.util.Random;

public class Monster {

    private int hp;
    private int level;
    private int strength;
    LinkedList<Item> items = new LinkedList<>();

    Monster(int level, int strength) {
        this.level = level;
        this.strength = strength;

        for (Item item : items) {
            this.strength += item.getAttack();
            // this.physicalDefence += item.getDefense();
        }
    }

    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public void takeDmg(int dmg) {
        int dmgTaken = dmg;

        if (dmgTaken <= 0) {
            dmgTaken = 0;
        }

        hp = hp - dmgTaken;

        if (hp <= 0) {
            hp = 0;
        }
    }

    public void attack(Character character) {
        character.takeDmg(strength);
    }

    public LinkedList dropItem() {
        Random rand = new Random();
        int idDrop;
        int max = items.size();
        int nbrDrop = rand.nextInt(max);
        LinkedList<Item> drop = new LinkedList<>();

        for (int i = 0; i < nbrDrop; i++) {
            idDrop = rand.nextInt(max + 1);
            drop.add(items.get(idDrop));
        }

        return drop;
    }

    public boolean isDead() {
        return hp == 0;
    }

    void addItem(Item newItem) {
        items.add(newItem);
    }

    public String toString() {
        return "level: " + level + ", life: " + hp + ", strength: " + strength + "\r\n" + toStringItems();
    }

    String toStringItems() {
        String tmp = "";

        for (Item item : items) {
            tmp += item.toString() + "\r\n";
        }

        return tmp;
    }
}
