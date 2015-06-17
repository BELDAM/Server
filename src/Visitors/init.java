package Visitors;

import characters.Elf.Hunter;
import characters.Elf.MageElf;
import monsters.BlackElf;
import monsters.Dragon;
import monsters.BlackElf;
import monsters.Manwe;
import monsters.Troll;

/**
 * Created by Simon on 11.06.2015.
 */
public class init implements IVisitor{
    @Override
    public void visit(Troll o) {
        int level = o.getLevel();
        o.setHP(10);
        o.setStrength(10);
        o.setMagicalDefence(2);
        o.setPhysicalDefence(2);
        o.setIntelligence(3);
        o.setName("Troll");

        o.setHP(o.getHP() + o.getHP() * level/3);
        o.setStrength(o.getStrength() + o.getStrength() * level / 2);
        o.setPhysicalDefence(o.getPhysicalDefence() + level);
        o.setMagicalDefence(o.getMagicalDefence() + level / 2);
        o.setIntelligence(o.getIntelligence() + level / 5);
        o.setGiveXP(o.getGiveXP() + level * 5);
        o.setGiveXP(15* o.getLevel());
    }

    @Override
    public void visit(Dragon o) {
        int level = o.getLevel();
        o.setHP(50);
        o.setStrength(10);
        o.setMagicalDefence(10);
        o.setPhysicalDefence(10);
        o.setIntelligence(10);
        o.setName("Dragon");

        o.setHP(o.getHP() + o.getHP() * level/2);
        o.setStrength(o.getStrength() + o.getStrength() * level / 2);
        o.setPhysicalDefence(o.getPhysicalDefence() + level);
        o.setMagicalDefence(o.getMagicalDefence() + level / 2);
        o.setIntelligence(o.getIntelligence() + level / 2);
        o.setGiveXP(o.getGiveXP() + level * 5);
        o.setGiveXP(100* o.getLevel());
    }

    @Override
    public void visit(BlackElf o) {
        int level = o.getLevel();
        o.setHP(8);
        o.setStrength(4);
        o.setMagicalDefence(2);
        o.setPhysicalDefence(2);
        o.setIntelligence(10);
        o.setName("Black Elf");
        o.setHP(o.getHP() + o.getHP() * level/4);
        o.setStrength(o.getStrength() + o.getStrength() * level / 5);
        o.setPhysicalDefence(o.getPhysicalDefence() + level);
        o.setMagicalDefence(o.getMagicalDefence() + level / 2);
        o.setIntelligence(o.getIntelligence() + level);
        o.setGiveXP(15 + level * 5);
    }

    @Override
    public void visit(Manwe o) {
        int level = o.getLevel();
        o.setHP(200);
        o.setStrength(10);
        o.setMagicalDefence(10);
        o.setPhysicalDefence(10);
        o.setIntelligence(100);
        o.setName("Manwe");
        o.setGiveXP(1000);
    }

    @Override
    public void visit(MageElf o) {

    }

    @Override
    public void visit(Hunter o) {

    }
}
