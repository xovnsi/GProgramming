package Tournament;

import Model.Program;
import Visitor.GrammarVisitor;
import Visitor.antlr4.generated.grammaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import Visitor.antlr4.generated.grammaLexer;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class Tournament {
    String testFileName;
    int fitnessOption;
    double bestScore;

    public Tournament(String testFileName, int fitnessOption) {
        this.testFileName = testFileName;
        this.fitnessOption = fitnessOption;
        this.bestScore = 0;
    }

    public double getBestScore() {
        return this.bestScore;
    }

    public List<String> getResults(List<Integer> values, Program program) {
        CharStream stream = CharStreams.fromString(program.toString());
        grammaLexer lexer = new grammaLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        grammaParser parser = new grammaParser(tokens);
        ParseTree tree = parser.program();

        List<Integer> input = new ArrayList<>();
        for(Integer value: values) {
            input.add(value);
        }

        GrammarVisitor<Integer> visitor = new GrammarVisitor<Integer>(input);
        visitor.visit(tree);
        return visitor.toWrite;
    }

    /**
     * Function that returns the value of selected fitness function
     * @param results - list of results generated by program
     * @param expectedResults - list of expected results
     * @return fitness score
     */
    public double getFitness(List<Integer> results, List<Integer> expectedResults) {
        return switch (this.fitnessOption) {
            case 0 -> Fitness.fitnessOutput(results.size(), expectedResults.size());
            case 1 -> Fitness.fitnessSensitivity(results);
            case 2 -> Fitness.fitnessOne(results, expectedResults);
            case 3 -> Fitness.fitnessResult(results, expectedResults);
            default -> throw new UnsupportedOperationException();
        };
    }

    /**
     * Function
     * @param program - generated program
     * @return fitness score of given program
     */
    public double testProgram(Program program){
        File testFile = new File(this.testFileName);
        Scanner testReader = null;
        try {
            testReader = new Scanner(testFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Double> fitnessValues = new ArrayList<>();

        while (testReader.hasNextLine()) {
            List<Integer> inputs = new ArrayList<>();
            List<Integer> outputs = new ArrayList<>();

            String[] row = testReader.nextLine().split(" = ");
            String[] stringInputs = row[0].split(" ");
            String[] stringOutputs = row[1].split(" ");

            for (String inputValue: stringInputs) {
                int value = Integer.parseInt(inputValue);
                inputs.add(value);
            }

            for (String outputValue: stringOutputs) {
                int value = Integer.parseInt(outputValue);
                outputs.add(value);
            }

            List<String> result = getResults(inputs, program);
            List<Integer> resultInt = new ArrayList<>();

            if (result.contains(null)) {
                if(this.fitnessOption != 2) {
                    resultInt.add(Integer.MAX_VALUE);
                }
            } else {
                resultInt = result.stream().map(Integer::parseInt).collect(Collectors.toList());
            }
            fitnessValues.add(getFitness(resultInt, outputs));
        }

        testReader.close();
        double sum = 0;
        for (Double fitnessValue : fitnessValues) sum = sum + fitnessValue;
        return sum > Double.MAX_VALUE ? Double.MAX_VALUE : sum / fitnessValues.size();
    }

    /**
     *
     * @param competitors - pool of programs for competition
     * @param nOfWinners - number of winners
     * @return list of winners
     */
    public List<Program> compete(List<Program> competitors, int nOfWinners) {
        ArrayList<Double> fitnessScores = new ArrayList<>();
        for (Program competitor: competitors) {
            fitnessScores.add(testProgram(competitor));
        }

        ArrayList<Program> winners = new ArrayList<>();
        for(int i = 0; i < nOfWinners; i++) {
            double value = Collections.min(fitnessScores);
            if (i == 0) {
                this.bestScore = value;
            }
            int valueIndex = fitnessScores.indexOf(value);
            winners.add(competitors.get(valueIndex));
            fitnessScores.set(valueIndex, Double.MAX_VALUE);
        }
        return winners;
    }
}
