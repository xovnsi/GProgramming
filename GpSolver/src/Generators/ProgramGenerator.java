package Generators;

import Model.Interfaces.PointMutable;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.Program;
import Serializer.Serializer;
import Tournament.Tournament;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.*;

public class ProgramGenerator {

    public Program generateProgram(Config config){
        return new Program(config);
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
                    System.out.println("----------------------------------------\n" +
                            "parent1 node: " + randomParentOneNode + "\nparent2 node: " + node +
                            "\n----------------------------------------");
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

    public Program mutate(Program parent) {
        Program child = parent;
        Random random = new Random();
        ArrayList<Node> parentTree = parent.getChildrenAsNodes();
        Node randomParentOneNode;
        do {
            int randomIndex = random.nextInt(parentTree.size() - 1) + 1;
            randomParentOneNode = parentTree.get(randomIndex);
        } while (Objects.equals(randomParentOneNode.NAME, "Scope") ||
                Objects.equals(randomParentOneNode.NAME, "ReadStatement"));
        System.out.println(randomParentOneNode.NAME + " " + randomParentOneNode);
        if (randomParentOneNode instanceof SubtreeMutable variable) {
            variable.Mutate(parent.config);
        } else if (randomParentOneNode instanceof PointMutable variable) {
            variable.Mutate(parent.config);
        }
        return child;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int populationSize = 10;
        String testFile = "GpSolver/TestCases/test1.txt";

        if (args.length == 1) {
            testFile = args[0];
        } else if (args.length == 2) {
            try {
                populationSize = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[1] + " must be an integer.");
                System.exit(1);
            }
        }

        ProgramGenerator generator = new ProgramGenerator();
        List<Program> population = new ArrayList<>();

        for(int i = 0; i < populationSize; i++) {
            Program program = generator.generateProgram(new Config());
            population.add(program);
        }
        int generation = 1;

        while (true) {
            populationSize = population.size();
            Tournament tournament = new Tournament(testFile, 0);
            Collections.shuffle(population);
            List<Program> winnersGroupOne =
                    tournament.compete(population.subList(0, populationSize), (int)(populationSize * 0.1));
            List<Program> winnersGroupTwo =
                    tournament.compete(population.subList(populationSize / 2, populationSize), (int)(populationSize * 0.1));
            population.clear();
            population.addAll(winnersGroupOne);
            population.addAll(winnersGroupTwo);
            System.out.println("GENERATION: " + generation + " BEST SCORE: " + tournament.getBestScore());
            if (tournament.getBestScore() == 0) {
                break;
            }
        }
        System.out.println(population.get(0).toString());

        /*
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

        System.out.println("------------------- First mutation: -------------------");
        Serializer serializerMutation = new Serializer("Mutation");
        Program firstMutation = generator.mutate(firstProgram);
        System.out.println(firstMutation);
        serializerMutation.writeProgramToTxt(firstMutation);

        System.out.println("------------------- Second mutation: -------------------");
        Program secondMutation = generator.mutate(secondProgram);
        System.out.println(secondMutation);
        System.out.println(secondMutation.variables);
        serializerMutation.writeProgramToTxt(secondMutation);


        //Tournament tournament = new Tournament("GpSolver/TestCases/test1.txt", 0);
        ArrayList<Program> programs = new ArrayList<>();
        programs.add(firstProgram);
        programs.add(secondProgram);
        programs.add(firstMutation);
        programs.add(secondMutation);
        programs.add(children.get(0));
        programs.add(children.get(1));
        //System.out.println(tournament.compete(programs, 1));

        //System.out.println(firstProgram.getProgramVariables());

         */
    }
}
