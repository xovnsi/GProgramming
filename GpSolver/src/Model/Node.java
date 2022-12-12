package Model;

import Generators.Config;
import Model.BigNode.HasScope;
import Model.SmallNodes.Expressions.Variables.Variable;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public abstract class Node {
    public Node parentNode;
    public int depth;
    public ArrayList<String> possibleChildrenNodes;
    public ArrayList<Node> childrenNodes;
    public String NAME;

    private static final Random RANDOM = new Random();

    public String toString(){ return null;};

    public static double getRandomPercentages() {
        return RANDOM.nextDouble();
    }

    public String getRandomPossibleChild(){
        if (possibleChildrenNodes == null) return null;
        return possibleChildrenNodes.get((RANDOM.nextInt(possibleChildrenNodes.size())));
    }

    public ArrayList<Node> getChildrenAsNodes(){
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(this);

        for (Node node : this.childrenNodes) {
            nodes.addAll(node.getChildrenAsNodes());
        }
        return nodes;
    }

    public static void swapNodes(Node node1, Node node2) {
        Node parent1 = node1.parentNode;
        Node parent2 = node2.parentNode;

        int node1Position = parent1.childrenNodes.indexOf(node1);
        int node2Position = parent2.childrenNodes.indexOf(node2);

        parent1.childrenNodes.set(node1Position, node2);
        node2.parentNode = parent1;

        parent2.childrenNodes.set(node2Position, node1);
        node1.parentNode = parent2;
    }

    public void generate(Config config){}

    public ArrayList<Node> getChildrenAsNodesWithEmpty() {
        return getChildrenAsNodes();
    }

    public ArrayList<Variable> getProgramVariables() {
        return parentNode.getProgramVariables();
    }



    public void addToProgramVariables(Variable variable) {
        parentNode.addToProgramVariables(variable);
    }

    public Config getProgramConfig(){
        return parentNode.getProgramConfig();
    }

    protected Node addNode(Node child) {
        Objects.requireNonNull(childrenNodes).add(child);
        return child;
    }

    public Node(Node parentNode, String name) {
        this.parentNode = parentNode;
        this.childrenNodes = new ArrayList<>();
        this.possibleChildrenNodes = null;
        this.NAME = name;

        depth = parentNode == null ? -1 : parentNode.depth + 1;
    }
}
