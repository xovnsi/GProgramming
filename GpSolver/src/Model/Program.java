package Model;

import Generators.Config;
import Model.Nodes.Scope;
import Model.Nodes.Expressions.Variables.Variable;

import java.util.ArrayList;

public class Program extends Node {

    public Config config;
    public ArrayList<Variable> variables;

    @Override
    public ArrayList<Variable> getProgramVariables() {
        return variables;
    }

    @Override
    public Config getProgramConfig() {
        return config;
    }

    @Override
    public String toString() {
        StringBuilder program = new StringBuilder();

        for (Node node : childrenNodes) {
            program.append(node.toString());
            program.append("\n");
        }
        return program.toString();
    }

    @Override
    public void generate(Config config) {
        this.childrenNodes.add(new Scope(this));
    }

    @Override
    public void addToProgramVariables(Variable variable) {
        variables.add(variable);
    }

    public Program(Config config) {
        super(null, "Program");
        this.config = config;
        this.variables = new ArrayList<>();
        generate(config);
    }
}
