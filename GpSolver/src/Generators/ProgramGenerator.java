package Generators;

import Evaluators.Evaluator;
import Model.Program;

import java.util.ArrayList;

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

    public static void main(String[] args) {
        ProgramGenerator generator = new ProgramGenerator();

        Program firstProgram = generator.generateProgram(new Config());

        System.out.println(firstProgram.toString());
        int a = 3;
    }
}
