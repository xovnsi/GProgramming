package Visitor;

import Visitor.antlr4.generated.grammaLexer;
import Visitor.antlr4.generated.grammaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Visitor {
    public static void main(String[] args) throws Exception {

        String expression = "{\nread(_v0);\n" +
                "\tread(_v0);\n" +
                "\tif (((-16 >= -27) or (_v0 == 35))){\n" +
                "\t\tread(_v0);\n" +
                "\t\twrite(_v0);\n" +
                "\t\tread(_v0);\n" +
                "\t\n}}";

        CharStream stream = CharStreams.fromString(expression);
        grammaLexer lexer = new grammaLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        grammaParser parser = new grammaParser(tokens);
        ParseTree tree = parser.program();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("~~~Errors in program ~~~");
            System.exit(-1000);
        }
        List<Integer> input = new ArrayList<>();
        input.add(10);
        input.add(-11);

        GrammarVisitor<Integer> visitor = new GrammarVisitor<Integer>(input);
        visitor.visit(tree);
        visitor.printVariables();
        visitor.printWriteEl();
    }

}
