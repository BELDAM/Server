/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import Visitors.IVisitor;
import Visitors.init;
import items.ItemManager;

/**
 *
 * @author Simon
 */
public class Troll extends Monster {

    public Troll(int level) {
        super(level);
        accept(new init());

    }
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
