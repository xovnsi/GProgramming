package Model.SmallNodes.Expressions.Variables;

import Generators.Config;
import Model.BigNode.HasScope;
import Model.Interfaces.PointMutable;
import Model.Node;
import Model.SmallNodes.SmallNode;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Model.BigNode.HasScope.indentCounter;

public class Variable extends Node implements SmallNode, PointMutable {
    public String variableName;

    @Override
    public String toString() {
        return variableName;
    }


    @Override
    public void Mutate() {

    }
    private String createName(Config config) {
        ArrayList<Variable> variables = getProgramVariables();

        if (variables.size() == 0) {
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
