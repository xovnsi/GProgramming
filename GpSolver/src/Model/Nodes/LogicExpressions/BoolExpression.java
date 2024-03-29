package Model.Nodes.LogicExpressions;

import Generators.Config;
import Model.Interfaces.PointMutable;
import Model.Interfaces.SubtreeMutable;
import Model.Node;

import java.util.ArrayList;
import java.util.Objects;

public class BoolExpression extends Node implements PointMutable, SubtreeMutable {

    public String operator;

    public String newChildren(String randomPossibleChild){
        return switch (randomPossibleChild) {
            case "and" -> "and";
            case "or" -> "or";
            //      should never happen
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "(" + childrenNodes.get(0) +
                " " + operator + " " +
                childrenNodes.get(1) +
                ")";
    }

    @Override
    public void Mutate(Config config) {
        if(Objects.equals(operator, "and")) {
            operator = "or";
        } else {
            operator = "and";
        }
    }

    @Override
    public void generate(Config config){
        childrenNodes.add(RandomLogicalExpression(config));
        operator = newChildren(getRandomPossibleChild());
        childrenNodes.add(RandomLogicalExpression(config));
    }

    public Node RandomLogicalExpression(Config config){
        if(this.depth >= config.maxDepth){
            return new ComparisonExpression(this);
        }
        if(getRandomPercentages() > 0.5){
            return new BoolExpression(this);
        }else {
            return new ComparisonExpression(this);
        }
    }

    public BoolExpression(Node parentNode){
        super(parentNode, "BoolExpression");
        possibleChildrenNodes = new ArrayList<>(){
            {
                add("and");
                add("or");
            }
        };
        generate(getProgramConfig());
    }

}
