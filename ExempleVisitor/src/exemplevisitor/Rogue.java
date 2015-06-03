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

    private int energy;
    public Rogue(String name, int level, int HP, int spirit, int strength) {
        super(name, level, HP, spirit, strength);
        this.spells = new LinkedList();
        energy = 150;
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
        strength =  strength + strength * level/4;
    }
    @Override
    public String toString()
    {
        return "Rogue Energy "+ energy + " " + super.toString();
    }
    public void setEnergy()
    {
        this.energy += 10;
    }
    
}
