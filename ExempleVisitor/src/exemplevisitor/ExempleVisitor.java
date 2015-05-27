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
        Mage Xaaram = new Mage("Xaaram", 1, 10, 7, 2);
        Xaaram.accept(levelup);
        Warrior BinaryBrain = new Warrior("BinaryBrain", 1, 15, 2, 9);
        Rogue Gweezer7 = new Rogue("Gweezer7", 1, 12, 5, 5);
        System.out.println(Xaaram.toString());
        System.out.println(BinaryBrain.toString());
        System.out.println(Gweezer7.toString());
        
        
        
        BinaryBrain.accept(levelup);
        Gweezer7.accept(levelup);
        System.out.println("");
        System.out.println("");
        System.out.println(Xaaram.toString());
        System.out.println("");
        System.out.println(BinaryBrain.toString());
        System.out.println("");
        System.out.println(Gweezer7.toString());
        
        
        Xaaram.accept(skillUp);
        BinaryBrain.accept(skillUp);
        Gweezer7.accept(skillUp);
        System.out.println("");
        System.out.println("");
        System.out.println(Xaaram.toString());
        System.out.println("");
        System.out.println(BinaryBrain.toString());
        System.out.println("");
        System.out.println(Gweezer7.toString());
    }
    
}
