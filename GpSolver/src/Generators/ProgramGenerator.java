package Generators;

import Model.Interfaces.PointMutable;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.Program;
import Tournament.Tournament;
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
            Node randomParentOneNode;
            do {
                int randomIndex = random.nextInt(parentOneTree.size() - 1) + 1;
                randomParentOneNode = parentOneTree.get(randomIndex);
            } while (Objects.equals(randomParentOneNode.NAME, "Scope"));
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

    public Program mutate(Program parent) {
        Random random = new Random();
        ArrayList<Node> parentTree = parent.getChildrenAsNodes();
        Node randomParentOneNode;

        if(parentTree.size() - 1 == 1) {
            return parent;
        }
        do {
            int randomIndex = random.nextInt(parentTree.size() - 1) + 1;
            randomParentOneNode = parentTree.get(randomIndex);
        } while (Objects.equals(randomParentOneNode.NAME, "ReadStatement")
                || (Objects.equals(randomParentOneNode.NAME, "Scope") && randomParentOneNode.childrenNodes.isEmpty()));
        if (Objects.equals(randomParentOneNode.NAME, "Scope")) {
            System.out.println(randomParentOneNode.toString());
        }
        if (randomParentOneNode instanceof SubtreeMutable variable) {
            variable.Mutate(parent.config);
        } else if (randomParentOneNode instanceof PointMutable variable) {
            variable.Mutate(parent.config);
        }
        return parent;
    }

    public static void main(String[] args) {
        int populationSize = 10;
        String testFile = "GpSolver/TestCases/test2.txt";

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
            Tournament tournament = new Tournament(testFile, 3);
            Collections.shuffle(population);
            List<Program> winnersGroupOne =
                    tournament.compete(population.subList(0, populationSize / 2), 3);
            List<Program> winnersGroupTwo =
                    tournament.compete(population.subList(populationSize / 2, populationSize), 3);
            population.clear();
            population.addAll(winnersGroupOne);
            population.addAll(winnersGroupTwo);
            populationSize = population.size();
            System.out.println("-----------------------------");
            System.out.println("WINNERS");
            System.out.println("-----------------------------");
            for (Program program: population
                 ) {
                System.out.println(program);
            }
            System.out.println("-----------------------------");
            System.out.println("GENERATION: " + generation + " BEST SCORE: " + tournament.getBestScore() + " POPULATION SIZE: " + populationSize);
            System.out.println(population.get(0).toString());
            if (tournament.getBestScore() < 0.1) {
                break;
            }

            List<Program> newPrograms = new ArrayList<>();
            for (int i = 0; i < populationSize; i++) {
                for (int j = 0; j < populationSize; j++) {
                    if(i != j) {
                        newPrograms.addAll(generator.crossover(population.get(i), population.get(j)));
                    }
                }
            }

            System.out.println("CROSSOVER");
            while(population.size() < 10) {
                newPrograms = new ArrayList<>();
                for (Program program: population) {
                    newPrograms.add(generator.mutate(program));
                }
                population.addAll(newPrograms);
            }
            System.out.println("MUTATION");
            population.addAll(newPrograms);
            populationSize = population.size();
            generation++;
        }
        System.out.println(population.get(0).toString());
    }
}
