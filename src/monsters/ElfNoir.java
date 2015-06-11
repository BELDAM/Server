/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import Visitors.IVisitor;
import items.BodyPart;
import items.Item;

/**
 *
 * @author Simon
 */
public class ElfNoir extends Monster{

    public ElfNoir(int level) {
        super(level);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
