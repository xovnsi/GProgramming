package Model.BigNode;

import Generators.Config;
import Model.BigNode.ForLoop.ForLoop;
import Model.BigNode.IfStatement.IfStatement;
import Model.BigNode.ReadStatement.ReadStatement;
import Model.BigNode.VarAssignment.VarAssigment;
import Model.BigNode.WriteStatement.WriteStatement;
import Model.Interfaces.SubtreeMutable;
import Model.Node;

import java.util.ArrayList;

public class Scope extends Node implements SubtreeMutable {

    public int indentCounter;

    @Override
    public String toString() {
        StringBuilder program = new StringBuilder();

        for (Node node : childrenNodes) {
            if (node instanceof HasScope) {
                ((HasScope) node).reCalculateIndent();
            }
        }

        program.append("{\n");

        for (Node node : childrenNodes) {
            program.append("\t".repeat(indentCounter)).append(node.toString()).append("\n");
        }

        program.append("\t".repeat(indentCounter - 1)).append("}");

        return program.toString();
    }

    public void generate(Config config){
        int counter = 0;

        while (counter < config.maxWidth) {
            childrenNodes.add(newChildren(getRandomPossibleChild()));
            counter += 1;
        }
    }

    public Node newChildren(String randomPossibleChild){
        return switch (randomPossibleChild) {
            case "ReadStatement" -> new ReadStatement(this);
            case "WriteStatement" -> new WriteStatement(this);
            case "ForLoop" -> new ForLoop(this);
            case "IfStatement" -> new IfStatement(this);
            case "VarAssignment" -> new VarAssigment(this);
            //      should never happen
            default -> null;
        };
    }

    public Scope(Node parentNode) {
        super(parentNode, "Scope");
        possibleChildrenNodes = new ArrayList<>(){
            {
                add("ReadStatement");
                add("WriteStatement");
                add("ForLoop");
                add("IfStatement");
                add("VarAssignment");
            }
        };

        if (parentNode instanceof HasScope hasScope) {
            this.indentCounter = hasScope.getIndent();
        } else {
            this.indentCounter = 1;
        }

        if (indentCounter == getProgramConfig().maxWidth){
            return;
        }
        generate(getProgramConfig());
    }

}
