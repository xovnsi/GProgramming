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

    public void test(){
//         System.out.println(Integer.parseInt(childrenNodes.get(0).toString()) +
//                " " + operator + " " +
//                Integer.parseInt(childrenNodes.get(1).toString()));
//        System.out.println(childrenNodes.get(0).NAME);
//        System.out.println(childrenNodes.get(0).toString() + " " +  childrenNodes.get(0).getValue());
    }

    @Override
    public String toString() {

        return "(" +
                childrenNodes.get(0) +
                " " + operator + " " +
                childrenNodes.get(1) + ")";
//        return Integer.toString(value);
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

//    @Override
//    public int getValue(){
//        for (Node child: childrenNodes) {
//            child.evaluate();
//        }
//
//        int v1 = 0, v2 = 0;
//        v1 = childrenNodes.get(0).getValue();
//        v2 = childrenNodes.get(1).getValue();
//
//        switch (operator){
//            case "+" ->
//                value = v1 + v2;
//
//            case "-" ->
//                value = v1 - v2;
//
//            case "/" -> {
//                if(v2 == 0){
//                    v2 = 1;
//                }
//                value = v1 / v2;
//            }
//
//            case "*" ->
//                value = v1 * v2;
//
//        }
//        System.out.println("Eval " + value + " v1: " + v1 + "op " + operator+ " v2 " + v2);
//        return value;
//
////        childrenNodes = new ArrayList<>(value);
////        System.out.println(childrenNodes.get(0).NAME);
////        value = 0;
//    }

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
