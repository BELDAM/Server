/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplevisitor;

import java.util.LinkedList;

/**
 *
 * @author Simon
 */
public class Warrior extends PlayerClass implements IVisitable{

    public Warrior(String name, int level, int HP, int spirit, int strength) {
        super(name, level, HP, spirit, strength);
        this.spells = new LinkedList();
        this.spells.add("frappe puissante rang 1");
    }
    public void setSpirit()
    {
        spirit =  spirit + spirit * level/5;
    }
    public void setStrength()
    {
        strength =  strength + strength * level/2;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
        public String toString()
    {
        return "Warrior " + super.toString();
    }
    
}
