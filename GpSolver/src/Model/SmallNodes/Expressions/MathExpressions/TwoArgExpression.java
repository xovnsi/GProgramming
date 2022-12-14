package Model.SmallNodes.Expressions.MathExpressions;

import Generators.Config;
import Model.Interfaces.PointMutable;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.SmallNodes.Expressions.Expression;
import Model.SmallNodes.SmallNode;

import java.util.ArrayList;
import java.util.Objects;

import static Model.BigNode.HasScope.indentCounter;

public class TwoArgExpression extends Node implements SmallNode, PointMutable, SubtreeMutable {
    public String operator;

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
    }

}
