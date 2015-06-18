package monsters;

import characters.Character;
import items.Item;
import items.ItemManager;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Monster {

    protected int hp;
    private int level;
    private int strength;
    protected LinkedList<Item> items;
    protected ItemManager itemManager;
    protected Random random;

    Monster(int level, int strength, int hp) {
        this.hp = hp;
        this.strength = strength;
        this.level = level;
        itemManager = new ItemManager();
        items = new LinkedList<>();
        random = new Random();
    }

    public int getHp() {
        return hp;
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
        int str = strength;
        for (Item item : items) {
            str += item.getAttack();
        }
        character.takeDmg(str);
    }

    public List<Item> dropItem() {
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

    @Override
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
