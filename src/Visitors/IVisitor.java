package Visitors;

import characters.Elf.Elf;
import characters.Humain.Human;
import characters.Orc.Orc;

public interface IVisitor {
    void visit(Human o);
    void visit(Orc o);
    void visit(Elf o);
}
