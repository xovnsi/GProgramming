package Tournament;

import Model.Program;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tournament {
    String testFileName;

    public Tournament(String testFileName) {
        this.testFileName = testFileName;
    }
    public double getResult(List<Integer> values, Program program) {
        return Math.random();
    }

    public double getFitness(double result, double expectedResult) {
        return Math.abs(1 / (expectedResult - result));
    }
    public double getFitnessScore(Program program, String testName) throws FileNotFoundException {
        File testFile = new File(testName);
        Scanner testReader = new Scanner(testFile);
        List<Double> fitnessValues = new ArrayList<>();
        while (testReader.hasNextLine()) {
            List<Integer> values = new ArrayList<>();
            String[] row = testReader.nextLine().split(" ");
            for (String valueText: row) {
                int value = Integer.parseInt(valueText);
                values.add(value);
            }
            double expectedResult = values.get(values.size() - 1);
            values.remove(values.size() - 1);
            double result = getResult(values, program);
            fitnessValues.add(getFitness(result, expectedResult));
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
