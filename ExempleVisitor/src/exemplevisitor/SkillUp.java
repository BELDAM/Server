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
public class SkillUp implements IVisitor {
    @Override
    public void visit(IVisitable o) {
        o.accept(this);
    }

    @Override
    public void visit(Mage o) {
        o.learnSpell("Boule de feu rang " + o.level);
    }

    @Override
    public void visit(Warrior o) {
        if (o.level == 2) {
            o.learnSpell("Coup de pied");
        }
    }

    @Override
    public void visit(Rogue o) {
        if (o.level == 2) {
            o.learnSpell("Camouflage");
        }else if (o.level == 3)
        {
            o.learnSpell("Assassina");
        }
    }

}
