package Model.BigNode.VarAssignment;

import Generators.Config;
import Model.BigNode.HasScope;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.SmallNodes.Expressions.Constants.Constant;
import Model.SmallNodes.Expressions.Expression;
import Model.SmallNodes.Expressions.MathExpressions.TwoArgExpression;
import Model.SmallNodes.Expressions.Variables.Variable;

import java.util.ArrayList;
import java.util.Objects;

import static Model.BigNode.HasScope.indentCounter;

public class VarAssigment extends Node implements SubtreeMutable {

    @Override
    public void generate(Config config){
        childrenNodes.add(new Variable(this));
        childrenNodes.add(new Expression(this));
    }

    @Override
    public String toString() {
        return childrenNodes.get(0) +
                " = " +
                childrenNodes.get(1) +
                ";";
    }

    public VarAssigment(Node parentNode){
        super(parentNode, "VarAssigment");
        generate(getProgramConfig());
    }
    public VarAssigment(Node parentNode, String name){
        super(parentNode, name);
        generate(getProgramConfig());
    }
}
