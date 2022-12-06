package Model.SmallNodes.Expressions;

import Generators.Config;
import Model.BigNode.ForLoop.ForAssignment;
import Model.BigNode.ForLoop.ForIncrement;
import Model.BigNode.HasScope;
import Model.BigNode.Scope;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.SmallNodes.Expressions.Constants.Constant;
import Model.SmallNodes.Expressions.MathExpressions.TwoArgExpression;
import Model.SmallNodes.Expressions.Variables.Variable;
import Model.SmallNodes.LogicExpressions.ComparisonExpression;
import Model.SmallNodes.SmallNode;

import java.util.ArrayList;

import static Model.BigNode.HasScope.indentCounter;

public class Expression extends Node implements SmallNode, SubtreeMutable {

    @Override
    public ArrayList<Node> getChildrenAsNodes() {
        return null;
    }

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


    @Override
    public void generate(Config config){
        childrenNodes.add(newChildren(getRandomPossibleChild()));
    }

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