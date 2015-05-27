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
public class ExempleVisitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LevelUp levelup = new LevelUp();
        SkillUp skillUp = new SkillUp();
        Mage Xaaram = new Mage("Xaaram", 1, 10, 5, 2);
        Warrior BinaryBrain = new Warrior("BinaryBrain", 1, 15, 2, 9);
        System.out.println(Xaaram.toString());
        System.out.println(BinaryBrain.toString());
        Xaaram.accept(levelup);
        BinaryBrain.accept(levelup);
        System.out.println(Xaaram.toString());
        System.out.println(BinaryBrain.toString());
        
        Xaaram.accept(skillUp);
        BinaryBrain.accept(skillUp);
        
        System.out.println(Xaaram.toString());
        System.out.println(BinaryBrain.toString());
    }
    
}
