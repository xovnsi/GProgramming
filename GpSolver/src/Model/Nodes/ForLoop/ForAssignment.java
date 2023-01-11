package Model.Nodes.ForLoop;

import Generators.Config;
import Model.Nodes.VarAssignment.VarAssigment;
import Model.Interfaces.SubtreeMutable;
import Model.Node;


public class ForAssignment extends VarAssigment implements SubtreeMutable {

    @Override
    public String toString() {
        return childrenNodes.get(0) +
                " = " +
                childrenNodes.get(1);
    }

    public void Mutate(Config config) {}

    public ForAssignment(Node parentNode) {
        super(parentNode, "ForAssignment");
    }
}
