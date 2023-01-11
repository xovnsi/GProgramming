package Generators;

import Model.Interfaces.PointMutable;
import Model.Interfaces.SubtreeMutable;
import Model.Node;
import Model.Program;
import Serializer.Serializer;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

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
        System.out.println(".." + randomParentOneNode.NAME + " " + randomParentOneNode);
        if (randomParentOneNode instanceof SubtreeMutable variable) {
            variable.Mutate(parent.config);
        } else if (randomParentOneNode instanceof PointMutable variable) {
            variable.Mutate(parent.config);
        }
        return child;
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

        System.out.println("------------------- First mutation: -------------------");
        Serializer serializerMutation = new Serializer("Mutation");
        Program firstMutation = generator.mutate(firstProgram);
        System.out.println(firstMutation);
        serializerMutation.writeProgramToTxt(firstMutation);

        System.out.println("------------------- Second mutation: -------------------");
        Program secondMutation = generator.mutate(secondProgram);
        System.out.println(secondMutation);
        serializerMutation.writeProgramToTxt(secondMutation);

    }
}
