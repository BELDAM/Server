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
public class SkillUp implements IVisitor{

    @Override
    public void visit(IVisitable o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Mage o) {
        o.learnSpell("Boule de feu rang 2");
    }

    @Override
    public void visit(Warrior o) {
        o.learnSpell("coup de pied");
    }

    @Override
    public void visit(Rogue o) {
        o.learnSpell("camouflage");
    }
    
}
