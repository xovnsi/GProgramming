package Model.BigNode.VarAssignment;

import Generators.Config;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.SmallNodes.Expressions.Expression;
import Model.SmallNodes.Expressions.Variables.Variable;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

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
//    @Override
//    public void evaluate(){
////            Node var = childrenNodes.get(0);
////            if(getProgramVariables().contains(var)){
////                int index = getProgramVariables().indexOf(var);
////                int val = childrenNodes.get(1).getValue();
////                getProgramVariables().get(index).value = val;
////            }
//    }

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
