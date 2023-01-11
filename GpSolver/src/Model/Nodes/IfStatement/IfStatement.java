package Model.Nodes.IfStatement;

import Generators.Config;
import Model.Nodes.HasScope;
import Model.Nodes.Scope;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.Nodes.LogicExpressions.BoolExpression;
import Model.Nodes.LogicExpressions.ComparisonExpression;

import java.util.ArrayList;
import java.util.Objects;

public class IfStatement extends Node implements SubtreeMutable, HasScope {

    public int indentCounter = 0;

    public Node newChildren(String randomPossibleChild){
        return switch (randomPossibleChild) {
            case "BoolExpression" -> new BoolExpression(this);
            case "ComparisonExpression" -> new ComparisonExpression(this);
             //     should never happen
            default -> null;
        };
    }

    @Override
    public void reCalculateIndent() {
        this.setIndent(this.getParentIndent() + 1);
    }

    @Override
    public void setIndent(int toSet) {
        this.indentCounter = toSet;
    }

    @Override
    public int getParentIndent() {
        if(parentNode instanceof Scope scope){
            return scope.indentCounter;
        }
        return 0;
    }

    @Override
    public int getIndent() {
        return indentCounter;
    }

    public void Mutate(Config config) {
        String name = childrenNodes.get(0).NAME;
        if(Objects.equals(name, "ComparisonExpression")) {
            ComparisonExpression exp = (ComparisonExpression) childrenNodes.get(0);
            exp.Mutate(config);
        } else if (Objects.equals(name, "BoolExpression")) {
            BoolExpression exp = (BoolExpression) childrenNodes.get(0);
            exp.Mutate(config);
        }
    }

    @Override
    public void generate(Config config){
        childrenNodes.add(newChildren(getRandomPossibleChild()));
        childrenNodes.add(new Scope(this));
    }

    @Override
    public String toString() {
        return "if (" +
                childrenNodes.get(0) +
                ")" +
                childrenNodes.get(1);
    }

    public IfStatement(Node parentNode) {
        super(parentNode, "IfStatement");
        indentCounter = getParentIndent() + 1;
        possibleChildrenNodes = new ArrayList<>(){
            {
                add("BoolExpression");
                add("ComparisonExpression");
            }
        };
        generate(getProgramConfig());
    }

}
