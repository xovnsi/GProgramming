package Model.BigNode.ForLoop;

import Generators.Config;
import Model.BigNode.HasScope;
import Model.BigNode.IfStatement.IfStatement;
import Model.BigNode.ReadStatement.ReadStatement;
import Model.BigNode.Scope;
import Model.BigNode.VarAssignment.VarAssigment;
import Model.BigNode.WriteStatement.WriteStatement;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.SmallNodes.Expressions.Constants.Constant;
import Model.SmallNodes.Expressions.Expression;
import Model.SmallNodes.Expressions.MathExpressions.TwoArgExpression;
import Model.SmallNodes.Expressions.Variables.Variable;
import Model.SmallNodes.LogicExpressions.ComparisonExpression;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class ForLoop extends Node implements SubtreeMutable, HasScope {

    public int indentCounter = 0;

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
        childrenNodes.add(new ForAssignment(this));
        childrenNodes.add(new ComparisonExpression(this));
        childrenNodes.add(new ForIncrement(this));
        childrenNodes.add(new Scope(this));
    }

    public void Mutate(Config config) {
        Random random = new Random();
        int randomIndex = random.nextInt(4);

        if(randomIndex == 0) {
            ForAssignment toMutate = (ForAssignment) childrenNodes.get(0);
            toMutate.Mutate(config);
        } else if (randomIndex == 1) {
            ComparisonExpression toMutate = (ComparisonExpression) childrenNodes.get(1);
            toMutate.Mutate(config);
        } else if (randomIndex == 2) {
            ForIncrement toMutate = (ForIncrement) childrenNodes.get(2);
            toMutate.Mutate(config);
        }
    }

    @Override
    public String toString() {

        return "for (" +
                childrenNodes.get(0).toString() +
                ", " +
                childrenNodes.get(1).toString() +
                ", " +
                childrenNodes.get(2).toString() +
                ")" +
                childrenNodes.get(3).toString();
    }

    public ForLoop(Node parentNode) {
        super(parentNode, "ForLoop");
        indentCounter = getParentIndent() + 1;
        generate(getProgramConfig());
    }
}
