/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplevisitor;

/**
 *
 * @author Simon
 */
public class LevelUp implements IVisitor{
    @Override
    public void visit(Mage o) {
        o.level++;
        o.setSpirit();
        o.setStrength();
        o.setMana();
    }

    @Override
    public void visit(Warrior o) {
        o.level++;
        o.setSpirit();
        o.setStrength();
        o.setRage();
    }

    @Override
    public void visit(Rogue o) {
        o.level++;
        o.setSpirit();
        o.setStrength();
        o.setEnergy();
    }
    
}
