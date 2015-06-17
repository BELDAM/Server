package Visitors;

import characters.Elf.Hunter;
import characters.Elf.MageElf;
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
}
