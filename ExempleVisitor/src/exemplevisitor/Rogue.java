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
public class Rogue extends PlayerClass implements IVisitable{

    public Rogue(String name, int level, int HP, int spirit, int strength) {
        super(name, level, HP, spirit, strength);
        this.spells = new LinkedList();
        this.spells.add("Estropier rang 1");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
    public void setSpirit()
    {
        spirit =  spirit + spirit * level/3;
    }
    public void setStrength()
    {
        strength =  strength + strength * level/3;
    }
    public String toString()
    {
        return "Rogue " + super.toString();
    }
    
}
