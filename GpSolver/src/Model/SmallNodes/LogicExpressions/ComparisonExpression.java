package Model.SmallNodes.LogicExpressions;

import Generators.Config;
import Model.BigNode.ForLoop.ForAssignment;
import Model.BigNode.ForLoop.ForIncrement;
import Model.BigNode.HasScope;
import Model.BigNode.Scope;
import Model.Interfaces.PointMutable;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.SmallNodes.Expressions.Constants.Constant;
import Model.SmallNodes.Expressions.Expression;
import Model.SmallNodes.Expressions.MathExpressions.TwoArgExpression;
import Model.SmallNodes.Expressions.Variables.Variable;
import Model.SmallNodes.SmallNode;

import java.util.ArrayList;

import static Model.BigNode.HasScope.indentCounter;

public class ComparisonExpression extends Node implements SmallNode, PointMutable, SubtreeMutable {

    public String operator;

    public String newChildren(String randomPossibleChild){
        return switch (randomPossibleChild) {
            case ">" -> ">";
            case ">=" -> ">=";
            case "<" -> "<";
            case "<=" -> "<=";
            case "==" ->  "==";
            //      should never happen
            default -> null;
        };
    }

    @Override
    public String toString() {

        return "(" +
                childrenNodes.get(0) +
                " " + operator + " " +
                childrenNodes.get(1) +
                ")";
    }


    @Override
    public void generate(Config config){
        childrenNodes.add(new Expression(this));
        operator = newChildren(getRandomPossibleChild());
        childrenNodes.add(new Expression(this));
    }

    @Override
    public void Mutate() {
        
    }

    public ComparisonExpression(Node parentNode){
        super(parentNode, "ComparisonExpression");
        possibleChildrenNodes = new ArrayList<>(){
            {
                add(">");
                add(">=");
                add("<");
                add("<=");
                add("==");
            }
        };
        generate(getProgramConfig());
    }

}
