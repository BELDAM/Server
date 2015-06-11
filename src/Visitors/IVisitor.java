package Visitors;

import monsters.*;

/**
 * Created by Simon on 11.06.2015.
 */
public interface IVisitor {
    void visit(Troll o);
    void visit(Dragon o);
    void visit(ElfNoir o);
    void visit(Manwe o);
}
