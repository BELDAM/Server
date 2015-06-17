package Visitors;

import characters.Elf.Hunter;
import characters.Elf.MageElf;
import characters.Humain.MageHumain;
import characters.Humain.Paladin;
import characters.Orc.Chaman;
import characters.Orc.Warrior;
import monsters.*;

/**
 * Created by Simon on 11.06.2015.
 */
public interface IVisitor {
    void visit(Troll o);
    void visit(Dragon o);
    void visit(BlackElf o);
    void visit(Manwe o);
    void visit(MageElf o);
    void visit(Hunter o);
    void visit(MageHumain o);
    void visit(Paladin o);
    void visit(Chaman o);
    void visit(Warrior o);
}
