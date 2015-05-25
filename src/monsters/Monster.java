/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import items.Item;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Simon
 */
public class Monster {
    protected int HP;
    protected String name;
    protected int strength;
    protected int giveXP;
    LinkedList<Item> items;
    
    public Monster(int HP, String name, int strength)
    {
        this.HP = HP;
        this.name = name;
        this.strength = strength;
        items = new LinkedList();
    }
    public void attack()
    {
        
    }
    public void takeDmg(int dmg)
    {
        
    }
    public void die()
    {
        
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
    
    
}
