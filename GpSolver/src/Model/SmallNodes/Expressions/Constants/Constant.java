package Model.SmallNodes.Expressions.Constants;

import Generators.Config;
import Model.Interfaces.PointMutable;
import Model.Node;
import Model.SmallNodes.Expressions.Expression;
import Model.SmallNodes.SmallNode;

import java.util.ArrayList;
import java.util.Random;

public class Constant extends Node implements SmallNode, PointMutable {

    String value;
    String type;


    @Override
    public String toString(){
        return value;
    }
    @Override
    public void Mutate(Config config) {
        value = generateValue(type, config);
    }

    @Override
    public void generate(Config config){
        type = getRandomPossibleChild();
        value = generateValue(type, config);
    }

    public String generateValue(String type, Config config){
        switch (type){
            case "int" -> {
                return Integer.toString(generateInt(config));
            }
            // should never happen
            default -> {
                return null;
            }
        }
    }

    public int generateInt(Config config){
        return (int) ((Math.random() * (config.maxValue - config.minValue)) + config.minValue);
    }
    public Constant(Node parentNode){
        super(parentNode, "Constant");
        possibleChildrenNodes = new ArrayList<>(){
            {
                add("int");
            }
        };
        generate(getProgramConfig());
    }

}
