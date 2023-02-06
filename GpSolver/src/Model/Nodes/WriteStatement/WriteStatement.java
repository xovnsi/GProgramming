package Model.Nodes.WriteStatement;
import Generators.Config;
import Model.Interfaces.PointMutable;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.Nodes.Expressions.Expression;
import Model.Nodes.Expressions.Variables.Variable;

import java.util.ArrayList;
import java.util.Objects;

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
        String newChild = getRandomPossibleChild();
        if(Objects.equals(newChild, "Variable")
                && Objects.equals(childrenNodes.get(0).NAME, "Variable")
                && childrenNodes.get(0) instanceof PointMutable variable) {
            variable.Mutate(config);
        } else {
            childrenNodes.set(0, newChildren(newChild));
        }
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
