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
public class Mage extends PlayerClass implements IVisitable{

    public Mage(String name, int level, int HP, int spirit, int strength) {
        super(name, level, HP, spirit, strength);
        this.spells = new LinkedList();
        this.spells.add("Boule de feu rang 1");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
    public void setSpirit()
    {
        spirit =  spirit + spirit * level/2;
    }
    public void setStrength()
    {
        strength =  strength + strength * level/5;
    }
    public String toString()
    {
        return "Mage " + super.toString();
    }
}
