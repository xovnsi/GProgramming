package Serializer;

import Generators.Config;
import Generators.ProgramGenerator;
import Model.Program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Serializer {
    public String path;
    public int counter;
    public String fileName;

    public void writeProgramToTxt(Program program) {
        String path_ = path + "/" + fileName + counter + ".txt";
        String text = program.toString();

        try {
            Files.write(Paths.get(path_), text.getBytes());
            System.out.println("Successfully saved to: " + path_);
            counter++;

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Serializer() {
        path = "GpSolver/SavedPrograms";
        fileName = "Program";
        counter = 0;
    }

    public Serializer(Config config, String fileName_) {
        path = config.saveFolder;
        counter = 0;
        fileName = fileName_;
    }

    public Serializer(String fileName_) {
        path = "GpSolver/SavedPrograms";
        counter = 0;
        fileName = fileName_;
    }

    public static void main(String[] args) {
        ProgramGenerator generator = new ProgramGenerator();
        Program program = generator.generateProgram(new Config());
        Serializer serializer = new Serializer();
        serializer.writeProgramToTxt(program);
    }
}
