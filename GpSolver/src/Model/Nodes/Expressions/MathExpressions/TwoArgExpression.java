package Model.Nodes.Expressions.MathExpressions;

import Generators.Config;
import Model.Nodes.Expressions.Expression;
import Model.Interfaces.PointMutable;
import Model.Interfaces.SubtreeMutable;
import Model.Node;

import java.util.ArrayList;
import java.util.Objects;

public class TwoArgExpression extends Node implements PointMutable, SubtreeMutable {
    public String operator;
    public int value;

    public String newChildren(String randomPossibleChild){
        return switch (randomPossibleChild) {
            case "+"-> "+";
            case "-" -> "-";
            case "*" -> "*";
            case "/" -> "/";
            //      should never happen
            default -> null;
        };
    }

    @Override
    public String toString() {

        return "(" +
                childrenNodes.get(0) +
                " " + operator + " " +
                childrenNodes.get(1) + ")";
    }

    @Override
    public void Mutate(Config config) {
        do {
            String newOperator = newChildren(getRandomPossibleChild());
            if(!Objects.equals(operator, newOperator)) {
                operator = newOperator;
                break;
            }
        } while (true);
    }

    @Override
    public void generate(Config config){
        childrenNodes.add(new Expression(this));
        operator = newChildren(getRandomPossibleChild());
        childrenNodes.add(new Expression(this));
    }

    public TwoArgExpression(Node parentNode){
        super(parentNode, "TwoArgExpression");
        possibleChildrenNodes = new ArrayList<>(){
            {
                add("+");
                add("-");
                add("*");
                add("/");
            }
        };
        generate(getProgramConfig());
//        evaluate();
    }

}
