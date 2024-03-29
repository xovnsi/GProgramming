package Model.Nodes.Expressions.Variables;

import Generators.Config;
import Model.Interfaces.PointMutable;
import Model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Variable extends Node implements PointMutable {
    public String variableName;

    @Override
    public String toString() {
        return variableName;
    }

    @Override
    public void Mutate(Config config) {
        variableName = createName(config);
    }

    private String createName(Config config) {
        ArrayList<Variable> variables = getProgramVariables();

        if (variables.isEmpty()) {
            return "_v0";
        }

        if (getRandomPercentages() < config.newVarPercentages){
            int idx = 0;
            List<Integer> varIndexes = variables
                    .stream()
                    .map(var -> Integer.parseInt(var.variableName.split("v")[1]))
                    .toList();

            while (varIndexes.contains(idx)) {
                idx += 1;
            }
            return "_v" + idx;
        } else {
            int idx = new Random().nextInt(variables.size());
            return variables.get(idx).variableName;
        }
    }

    @Override
    public void generate(Config config){
        variableName = createName(config);
    }

    public Variable(Node parentNode){
        super(parentNode, "Variable");
        generate(getProgramConfig());
        addToProgramVariables(this);
    }
}
