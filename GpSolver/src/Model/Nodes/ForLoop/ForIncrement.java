package Model.Nodes.ForLoop;

import Generators.Config;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.Nodes.Expressions.Constants.Constant;
import Model.Nodes.Expressions.Variables.Variable;

import java.util.ArrayList;
import java.util.Objects;

public class ForIncrement extends Node implements SubtreeMutable{
    public String operator;

    public String newChildren(String randomPossibleChild){
        return switch (randomPossibleChild) {
            case "+" -> "+ ";
            case "-" -> "- ";
            case "*" -> "* ";
            case "/" -> "/ ";
            //      should never happen
            default -> null;
        };
    }

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
        operator = newChildren(getRandomPossibleChild());
        childrenNodes.add(RandomSpace());
    }

    @Override
    public String toString() {
        return operator + childrenNodes.get(0);
    }

    public Node RandomSpace(){
        if(getRandomPercentages() > 0.5){
            return new Constant(this);
        }else {
            return new Variable(this);
        }
    }

    public ForIncrement(Node parentNode) {
        super(parentNode, "ForIncrement");
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
