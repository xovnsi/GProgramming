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

        String expression = "{" +
                "_v1 = (23 - 2);" +
                "for (_v0 = 1, (_v0<(_v1 - 10)), + 1){" +
                "if ((23>_v1)){" +
                "_v3 = 55;" +
                "}" +
                "}" +
                "write(-96);" +
                "read(_v5);" +
                "read(_v6);" +
                "}";

        CharStream stream = CharStreams.fromString(expression);
        grammaLexer lexer = new grammaLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        grammaParser parser = new grammaParser(tokens);
        ParseTree tree = parser.program();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Errors in program");
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
