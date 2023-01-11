package Model.Nodes.ReadStatement;

import Generators.Config;
import Model.Node;
import Model.Nodes.Expressions.Variables.Variable;

public class ReadStatement extends Node {

    @Override
    public String toString() {

        return "read(" +
                childrenNodes.get(0) +
                ");";
    }

    @Override
    public void generate(Config config){
        childrenNodes.add(new Variable(this));
    }

    public ReadStatement(Node parentNode){
        super(parentNode, "ReadStatement");
        generate(getProgramConfig());
    }
}
