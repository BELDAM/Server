/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplevisitor;

import java.util.LinkedList;

/**
 *
 * @author Simon
 */
public class PlayerClass{

    protected String name;
    protected int level;
    protected int HP;
    protected int spirit;
    protected int strength;
    protected LinkedList spells;

    public PlayerClass(String name, int level, int HP, int spirit, int strength) {
        this.name = name;
        this.level = level;
        this.HP = HP;
        this.spirit = spirit;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return name + " " + level + "\nSpirit : " + spirit + "\nStrength : " + strength + "\nSpells " + spelllist();
    }

    public void learnSpell(String s) {
        if (!this.spells.contains(s)) {
            this.spells.add(s);
        }
    }

    private String spelllist() {
        String tmp = "";
        for (Object spell : spells) {
            tmp += "\n - " + spell;
        }
        return tmp;
    }

}
