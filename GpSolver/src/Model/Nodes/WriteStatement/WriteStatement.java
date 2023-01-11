package Model.Nodes.WriteStatement;
import Generators.Config;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.Nodes.Expressions.Expression;
import Model.Nodes.Expressions.Variables.Variable;

import java.util.ArrayList;

public class WriteStatement extends Node implements SubtreeMutable {
    public Node newChildren(String randomPossibleChild){
        return switch (randomPossibleChild) {
            case "Expression" -> new Expression(this);
            case "Variable" -> new Variable(this);
            //      should never happen
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "write(" + childrenNodes.get(0) +
                ");";
    }

    public void Mutate(Config config){
        Node newChild = newChildren(getRandomPossibleChild());
        childrenNodes.set(0, newChild);
    }

    @Override
    public void generate(Config config){
        childrenNodes.add(newChildren(getRandomPossibleChild()));
    }

    public WriteStatement(Node parentNode){
        super(parentNode, "WriteStatement");
        possibleChildrenNodes = new ArrayList<>(){
            {
                add("Expression");
                add("Variable");
            }
        };
        generate(getProgramConfig());
    }
}
