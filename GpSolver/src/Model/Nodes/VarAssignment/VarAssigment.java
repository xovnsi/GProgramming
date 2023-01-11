package Model.Nodes.VarAssignment;

import Generators.Config;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.Nodes.Expressions.Expression;
import Model.Nodes.Expressions.Variables.Variable;

import java.util.Random;

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

    public void Mutate(Config config) {
        Random random = new Random();
        int randomIndex = random.nextInt(2);
        if (randomIndex == 0) {
            Variable varName = (Variable) childrenNodes.get(0);
            varName.Mutate(config);
        } else {
            Expression exp = (Expression) childrenNodes.get(1);
            exp.Mutate(config);
        }
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
