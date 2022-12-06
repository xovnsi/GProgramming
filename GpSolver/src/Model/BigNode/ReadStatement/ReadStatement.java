package Model.BigNode.ReadStatement;

import Generators.Config;
import Model.Node;
import Model.SmallNodes.Expressions.Variables.Variable;

import java.util.ArrayList;

public class ReadStatement extends Node {

    @Override
    public String toString() {

        return "read(" +
                childrenNodes.get(0) +
                ");";
    }

    @Override
    public ArrayList<Node> getChildrenAsNodes() {
        return null;
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
