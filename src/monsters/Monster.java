/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import Interface.FightInterface;
import Visitors.init;
import items.BodyPart;
import items.Item;
import items.ItemManager;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Simon
 */
public abstract class Monster implements FightInterface{
    protected int HP;
    protected int level;
    protected boolean dead;
    protected String name;
    protected int strength;
    protected int intelligence;
    protected int physicalDefence;
    protected int magicalDefence;
    protected int giveXP;
    LinkedList<Item> items;

    public Monster(int level) {
        this.dead = false;
        this.level = level;
        items = new LinkedList();

    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
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

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getPhysicalDefence() {
        return physicalDefence;
    }

    public void setPhysicalDefence(int physicalDefence) {
        this.physicalDefence = physicalDefence;
    }

    public int getMagicalDefence() {
        return magicalDefence;
    }

    public void setMagicalDefence(int magicalDefence) {
        this.magicalDefence = magicalDefence;
    }

    public int getGiveXP() {
        return giveXP;
    }

    public void setGiveXP(int giveXP) {
        this.giveXP = giveXP;
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public void setItems(LinkedList<Item> items) {
        this.items = items;
    }


    @Override
    public void takeDmg(int dmg) {
        int dmgTaken = dmg - physicalDefence;
        if(dmgTaken <= 0)
            dmgTaken = 0;
        HP = HP - dmgTaken;
        if (HP <= 0) {
            HP = 0;
            dead = true;
        }
    }
    public void takeMagicDmg(int dmg){
        int dmgTaken = dmg - magicalDefence;
        if(dmgTaken <= 0)
            dmgTaken = 0;
        HP = HP - dmgTaken;
        if (HP <= 0) {
            HP = 0;
            dead = true;
        }
    }

    @Override
    public void attack(FightInterface character) {
        if (!isDead()) {
            character.takeDmg(strength);
        } else {
            System.out.println("you are dead");
        }
    }
    @Override
    public void magiclAttack(FightInterface character) {
        if (!isDead()) {
            character.takeDmg(intelligence);
        } else {
            System.out.println("you are dead");
        }
    }
    public LinkedList dropItem() {
        Random rand = new Random();
        int idDrop;
        int max = items.size();
        int nbrDrop = rand.nextInt(max);
        LinkedList<Item> drop = new LinkedList();
        for (int i = 0; i < nbrDrop; i++) {
            idDrop = rand.nextInt((max - 0) + 1) + 0;
            drop.add(items.get(idDrop));
        }
        return drop;
    }

    public boolean isDead() {
        return HP == 0;
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
    @Override
    public String toString() {
        return name + ": ,level[" + level + "] ,life[" + HP + "], Strength[" + strength + "], intelligence[" + intelligence + "]" + "\r\n" + toStringItems();
    }
    public String toStringItems()
    {
        String tmp = "";
        for(int i = 0 ; i < items.size() ; i++)
        {
            tmp += items.get(i).toString() + "\r\n";
        }
        return tmp;
    }


}
