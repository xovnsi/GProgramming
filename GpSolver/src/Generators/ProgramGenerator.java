package Generators;

//import Evaluators.Evaluator;
import Model.Node;
import Model.Program;
import Serializer.Serializer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class ProgramGenerator {

    public Program generateProgram(Config config){
        return new Program(config);
    }

    public ArrayList<Program> generateFirstPopulation(Config config){
        ArrayList<Program> programs = new ArrayList<>();
        while (programs.size() < config.populationSize){
            programs.add(generateProgram(config));
        }
        return programs;
    }

    public ArrayList<Program> crossover(Program parentOne, Program parentTwo) {
        ArrayList<Program> children = new ArrayList<>();
        Random random = new Random();

        ArrayList<Node> parentOneTree = parentOne.getChildrenAsNodes();
        ArrayList<Node> parentTwoTree = parentTwo.getChildrenAsNodes();
        boolean findCross = true;

        do {
            int randomIndex = random.nextInt(parentOneTree.size() - 1) + 1;
            Node randomParentOneNode = parentOneTree.get(randomIndex);
            for (Node node : parentTwoTree) {
                if (Objects.equals(randomParentOneNode.NAME, node.NAME)) {
                    Node.swapNodes(randomParentOneNode, node);
                    children.add(parentOne);
                    children.add(parentTwo);
                    findCross = false;
                    break;
                }
            }
        } while (findCross);
        return children;
    }

    public static void main(String[] args) {
        ProgramGenerator generator = new ProgramGenerator();
        Program firstProgram = generator.generateProgram(new Config());
        Program secondProgram = generator.generateProgram(new Config());
        Serializer serializer = new Serializer();

        System.out.println("------------------- First program: ---------------------");
        System.out.println(firstProgram.toString());
        serializer.writeProgramToTxt(firstProgram);

        System.out.println("------------------- Second program: -------------------");
        System.out.println(secondProgram.toString());
        serializer.writeProgramToTxt(secondProgram);
        ArrayList<Program> children = generator.crossover(firstProgram, secondProgram);

        System.out.println("------------------- First child: -------------------");
        System.out.println(children.get(0));
        Serializer serializerChild = new Serializer("Child");
        serializerChild.writeProgramToTxt(children.get(0));

        System.out.println("------------------- Second child: -------------------");
        System.out.println(children.get(1));
        serializerChild.writeProgramToTxt(children.get(1));
//        ArrayList<Node> nodes_ = firstProgram.getChildrenAsNodes();
//        for (Node node: nodes_) {
//            node.evaluate();
//        }
//        ArrayList<Node> nodes__ = secondProgram.getChildrenAsNodes();
//        for (Node node: nodes__) {
//            node.evaluate();
//        }
        int a = 3;
    }
}
