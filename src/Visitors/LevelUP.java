package Visitors;

import characters.Elf.Hunter;
import characters.Elf.MageElf;
import characters.Humain.MageHumain;
import characters.Humain.Paladin;
import characters.Orc.Chaman;
import characters.Orc.Warrior;
import monsters.Dragon;
import monsters.BlackElf;
import monsters.Manwe;
import monsters.Troll;

/**
 * Created by bastiangardel on 16.06.15.
 */
public class LevelUP implements IVisitor {
    @Override
    public void visit(Troll o) {
        throw new UnsupportedOperationException("Pas disponible");
    }

    @Override
    public void visit(Dragon o) {
        throw new UnsupportedOperationException("Pas disponible");
    }

    @Override
    public void visit(BlackElf o) {
        throw new UnsupportedOperationException("Pas disponible");
    }

    @Override
    public void visit(Manwe o) {
        throw new UnsupportedOperationException("Pas disponible");
    }

    @Override
    public void visit(MageElf o) {

        o.setIntelligence(o.getIntelligence() + 10);
        o.setStrength(o.getStrength() + 2);
        o.setMagicalDefence(o.getMagicalDefence() + 5);
        o.setPhysicalDefence(o.getPhysicalDefence() + 2);

        o.setHP(o.getHP()+ 3);
        o.setLevel(o.getLevel() + 1);

        o.setSpeed(o.getSpeed() + 1);
    }

    @Override
    public void visit(Hunter o) {
        o.setIntelligence(o.getIntelligence() + 4);
        o.setStrength(o.getStrength() + 8);
        o.setMagicalDefence(o.getMagicalDefence() + 4);
        o.setPhysicalDefence(o.getPhysicalDefence() + 4);

        o.setHP(o.getHP()+ 4);
        o.setLevel(o.getLevel() + 1);

        o.setSpeed(o.getSpeed() + 1);
    }

    @Override
    public void visit(MageHumain o) {

    }

    @Override
    public void visit(Paladin o) {

    }

    @Override
    public void visit(Chaman o) {

    }

    @Override
    public void visit(Warrior o) {

    }
}
