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

    public Tournament(String testFileName) {
        this.testFileName = testFileName;
    }
    public List<String> getResult(List<Integer> values, Program program) {
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

    public double getFitness(List<Integer> result, List<Integer> expectedResult) {
        double fitness = 0;

        if(result.size() != expectedResult.size()) return 0;
        for(int i = 0; i < expectedResult.size(); i++) {
            fitness += Math.abs(1 / (expectedResult.get(i) - result.get(i)));
        }
        return fitness / expectedResult.size();
    }
    public double getFitnessScore(Program program, String testName) throws FileNotFoundException {
        File testFile = new File(testName);
        Scanner testReader = new Scanner(testFile);
        List<Double> fitnessValues = new ArrayList<>();
        while (testReader.hasNextLine()) {
            List<Integer> values = new ArrayList<>();
            String[] row = testReader.nextLine().split(" = ");
            String[] rowParams = row[0].split(" ");
            String[] rowResults = row[1].split(" ");
            for (String valueText: rowParams) {
                int value = Integer.parseInt(valueText);
                values.add(value);
            }
            List<Integer> expectedResult = new ArrayList<>();
            for (String valueText: rowResults) {
                int value = Integer.parseInt(valueText);
                expectedResult.add(value);
            }
            List<String> result = getResult(values, program);
            List<Integer> resultInt = result.stream().map(Integer::parseInt).collect(Collectors.toList());
            fitnessValues.add(getFitness(resultInt, expectedResult));
        }
        testReader.close();

        double sum = 0;
        for (Double fitnessValue : fitnessValues) sum = sum + fitnessValue;

        return sum / fitnessValues.size();
    }

    public List<Program> compete(List<Program> competitors, int nOfWinners) throws FileNotFoundException {
        ArrayList<Double> fitnessScores = new ArrayList<>();
        for (Program competitor: competitors) {
            fitnessScores.add(getFitnessScore(competitor, this.testFileName));
        }

        ArrayList<Program> winners = new ArrayList<>();
        System.out.println(fitnessScores);

        for(int i = 0; i < nOfWinners; i++) {
            double maxVal = Collections.max(fitnessScores);
            int maxValIndex = fitnessScores.indexOf(maxVal);
            winners.add(competitors.get(maxValIndex));
            fitnessScores.set(maxValIndex, 0.0);
        }
        System.out.println(fitnessScores);
        return winners;
    }


}
