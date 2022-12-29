package Model.BigNode.ForLoop;

import Generators.Config;
import Model.BigNode.VarAssignment.VarAssigment;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.SmallNodes.Expressions.Expression;
import Model.SmallNodes.Expressions.Variables.Variable;


public class ForAssignment extends VarAssigment implements SubtreeMutable {

    @Override
    public String toString() {
        return childrenNodes.get(0) +
                " = " +
                childrenNodes.get(1);
    }
    public ForAssignment(Node parentNode) {
        super(parentNode, "ForAssignment");

    }
}
