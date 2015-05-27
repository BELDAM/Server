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
public interface IVisitable {
    void accept(IVisitor visitor); 
}
