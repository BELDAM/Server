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
public class Dragon extends Monster{

    public Dragon(int level) {
        super(level);
        //http://stackoverflow.com/questions/3745760/java-generating-a-random-numbers-with-a-logarithmic-distribution
        accept(new init());
    }


    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
