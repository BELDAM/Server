/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import Interface.FightInterface;
import items.BodyPart;
import items.Item;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Simon
 */
public class Monster implements FightInterface{
    protected int HP;
    protected int level;
    protected boolean dead;
    protected String name;
    protected int strength;
    protected int intelligence;
    protected int PhysicalDefence;
    protected int MagicalDefence;
    protected int giveXP;
    LinkedList<Item> items;
    
    public Monster(int HP, String name, int strength, int defense, int level)
    {
        this.dead = false;
        this.level = level;
        this.intelligence = 0;
        this.HP = HP;
        this.name = name;
        this.strength = strength;
        this.PhysicalDefence = defense;
        items = new LinkedList();
    }
    @Override
    public void takeDmg(int dmg)
    {
        int dmgTaken;
        HP = HP - dmg;
        if(HP <= 0)
        {
            HP = 0;
            dead = true;
        }
    }

    public LinkedList dropItem()
    {
      Random rand = new Random();
      int idDrop;
      int max = items.size();
      int nbrDrop = rand.nextInt((max - 0) + 1) + 0;
      LinkedList<Item> drop = new LinkedList();
      for(int i = 0 ; i < nbrDrop ; i++)
      {     
        idDrop = rand.nextInt((max - 0) + 1) + 0;
        drop.add(items.get(idDrop));
      }
      return drop;  
    }
    boolean isDead()
    {
        return HP == 0;
    }

    @Override
    public void attack(FightInterface character) {
        if(!isDead())
        {
            character.takeDmg(strength * level);
        }
        else
        {
            System.out.println("you are dead");
        }
    }
    @Override
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
    
    
}
