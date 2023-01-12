package Model.Nodes.Expressions;

import Generators.Config;
import Model.Nodes.Expressions.Constants.Constant;
import Model.Nodes.Expressions.MathExpressions.TwoArgExpression;
import Model.Nodes.Expressions.Variables.Variable;
import Model.Interfaces.SubtreeMutable;
import Model.Node;

import java.util.ArrayList;

public class Expression extends Node implements SubtreeMutable {

    public Node newChildren(String randomPossibleChild){
        return switch (randomPossibleChild) {
            case "TwoArgExpression" -> new TwoArgExpression(this);
            case "Constant" -> new Constant(this);
            case "Variable" -> new Variable(this);
            //      should never happen
            default -> null;
        };
    }

    @Override
    public String toString() {
        return String.valueOf(childrenNodes.get(0));
    }

    public void Mutate(Config config) {
        String newChild = getRandomPossibleChild();
        while (Boolean.FALSE.equals(isChildValid(config, newChild))) {
            newChild = getRandomPossibleChild();
        }
        childrenNodes.set(0, newChildren(newChild));
    }

    @Override
    public void generate(Config config){
        String child = getRandomPossibleChild();
        while (Boolean.FALSE.equals(isChildValid(config, child))) {
            child = getRandomPossibleChild();
        }
        childrenNodes.add(newChildren(child));
    }

    public Boolean isChildValid(Config config, String child){
        return this.depth <= config.maxDepth || !child.equals("TwoArgExpression");
    }

//    @Override
//    public int getValue(){
//        return childrenNodes.get(0).getValue();
//    }

    public Expression(Node parentNode){
        super(parentNode, "Expression");
        possibleChildrenNodes = new ArrayList<>(){
            {
                add("TwoArgExpression");
                add("Constant");
                add("Variable");
            }
        };
        generate(getProgramConfig());
    }
}
