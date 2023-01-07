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

import java.io.Console;
import java.util.ArrayList;

import static Model.BigNode.HasScope.indentCounter;

public class Expression extends Node implements SmallNode, SubtreeMutable {
//    public int value;

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

    @Override
    public int getValue(){
//        if(childrenNodes.get(0).NAME.equals("Variable")){
//            Node var = childrenNodes.get(0);
////            if(getProgramVariables().contains(var)){
////                int index = getProgramVariables().indexOf(var);
//////                System.out.println("var " + childrenNodes.get(0));
////                return getProgramVariables().get(index).value;
////            }
////            return childrenNodes.get(0)
//        }
//        if(childrenNodes.get(0).NAME.equals("Constant")){
////            System.out.println("Const " + childrenNodes.get(0));
//            return Integer.parseInt(childrenNodes.get(0).toString());
//        }
//        if(childrenNodes.get(0).NAME.equals("TwoArgExpression")){
//            return  childrenNodes.get(0).getValue();
//        }
        return childrenNodes.get(0).getValue();
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
