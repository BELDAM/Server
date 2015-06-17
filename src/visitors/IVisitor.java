package visitors;

import characters.Elf;
import characters.Human;
import characters.Orc;

public interface IVisitor {
    void visit(Human o);
    void visit(Orc o);
    void visit(Elf o);
}
