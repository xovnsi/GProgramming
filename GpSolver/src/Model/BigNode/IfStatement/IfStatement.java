package Model.BigNode.IfStatement;

import Generators.Config;
import Model.BigNode.HasScope;
import Model.BigNode.Scope;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.SmallNodes.LogicExpressions.BoolExpression;
import Model.SmallNodes.LogicExpressions.ComparisonExpression;

import java.util.ArrayList;

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
    public ArrayList<Node> getChildrenAsNodes() {
        return null;
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
