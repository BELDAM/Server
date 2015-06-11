/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsters;

import Visitors.IVisitor;

/**
 *
 * @author Simon
 */
public class Manwe extends Monster{
    public Manwe(int level) {
        super(level);
    }

    @Override
    public void accept(IVisitor visitor) {

    }
}
