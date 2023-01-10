package Visitor;

import Visitor.antlr4.generated.grammaBaseVisitor;
import Visitor.antlr4.generated.grammaParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrammarVisitor<T> extends grammaBaseVisitor<Integer> {
    long startTime = System.currentTimeMillis();
    long threshold = 10;

    public Map<String, Integer> variables;
    public ArrayList<String> toWrite;
    public List<Integer> inputs;


    public Integer visit(ParseTree tree) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - startTime < threshold){
            super.visit(tree);
        }
        else{
            System.out.println("~~~ Time error ~~~");
        }
        return 0;
    }

    public Integer visitChildren(RuleNode node) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - startTime < threshold) {
            super.visitChildren(node);
        }
        else{
            System.out.println("~~~ Time error ~~~");
        }
        return 0;
    }

    public void printWriteEl(){
        System.out.println("\nProgram output:");
        toWrite.forEach(System.out::println);
    }

    @Override public Integer visitProgram(grammaParser.ProgramContext ctx) { return visitChildren(ctx); }
    @Override public Integer visitRead(grammaParser.ReadContext ctx) {
        String varName= ctx.VAR().getText();
        Integer varValue = inputs.get(0);
        inputs.remove(0);
        variables.put(varName, varValue);
        return 0;
    }

    @Override public Integer visitWrite(grammaParser.WriteContext ctx) {
        if(ctx.expression() != null){
            Integer toWrite = super.visit(ctx.expression());
            this.toWrite.add(String.valueOf(toWrite));
        }
        else{
            String name = ctx.VAR().getText();
            if(variables.containsKey(name)){
                toWrite.add(String.valueOf(variables.get(name)));
            }else{
                toWrite.add(String.valueOf(0));
            }
        }
        return 0;
    }

    @Override public Integer visitLoop(grammaParser.LoopContext ctx) {
        String varName = ctx.VAR(0).getText();
        String operator = ctx.OPERATOR().getText();
        Integer varVal = super.visit(ctx.expression());

        if(variables.containsKey(varName)) {
            variables.replace(varName, varVal);
        }else{
            variables.put(varName, varVal);
        }

        int incrementVal = 0;
        if(ctx.getChild(8) == ctx.constant()){
            incrementVal = super.visit(ctx.constant());
        }else{
            String secName = ctx.VAR(1).toString();
            incrementVal = variables.get(secName);
        }
        while (super.visit(ctx.compExpression()) > 0){
            super.visit(ctx.scope());
            varVal = variables.get(varName);
            varVal = incrementValue(varVal, operator, incrementVal);
            variables.replace(varName, varVal);
        }
        return 0;
    }

    public  Integer incrementValue(Integer toIncr, String operator, Integer increment){
        return switch (operator) {
            case " * " -> toIncr * increment;
            case " / " -> toIncr / increment;
            case " + " -> toIncr + increment;
            default -> toIncr - increment;
        };
    }
    @Override public Integer visitIf_statement(grammaParser.If_statementContext ctx) {
        if(super.visit(ctx.logical_expression()) > 0){
            return super.visit(ctx.scope());
        }
        return 0;
    }

    @Override public Integer visitAssignment(grammaParser.AssignmentContext ctx) {
        String currName = ctx.VAR().getText();
        Integer currValue = super.visit(ctx.expression());

        if(variables.containsKey(currName)){
            variables.replace(currName, currValue);
        }
        else{
            variables.put(currName, currValue);
        }
        return variables.get(currName);
    }

    @Override public Integer visitScope(grammaParser.ScopeContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Integer visitTwoArgexpression(grammaParser.TwoArgexpressionContext ctx) {
        int left = super.visit(ctx.expression(0));
        int right = super.visit(ctx.expression(1));
        if (ctx.OPERATOR().getText().equals(" * ")){
            return left * right;
        } else if (ctx.OPERATOR().getText().equals(" / ")) {
            return left / right;
        } else if (ctx.OPERATOR().getText().equals(" + ")) {
            return left + right;
        }
        else{
            return left - right;
        }
    }

    @Override public Integer visitConstExpression(grammaParser.ConstExpressionContext ctx) {
        return Integer.valueOf(ctx.constant().getText());
    }

    @Override public Integer visitVarExpression(grammaParser.VarExpressionContext ctx) {
        String currName = ctx.VAR().getText();
        if(variables.containsKey(currName)){
            return variables.get(currName);
        }
        else{
            variables.put(currName, 0);
            return 0;
        }
    }

    @Override public Integer visitLogical_expression(grammaParser.Logical_expressionContext ctx) {
        if(ctx.getChild(0) == ctx.compExpression()){
            return super.visit(ctx.compExpression());
        } else if (ctx.getChild(0) == ctx.logicExpression()) {
            return super.visit(ctx.logicExpression());
        }
        return 0;
    }

    @Override public Integer visitLogicExpression(grammaParser.LogicExpressionContext ctx) {
        int left = super.visit(ctx.logical_expression(0));
        int right = super.visit(ctx.logical_expression(1));
        if(ctx.LOGIC_OP().getText().equals(" and ")){
            if(left == 1 && right == 1){
                return 1;
            }
        }
        else{
            if(left == 1 || right == 1){
                return 1;
            }
        }
        return 0;
    }

    @Override public Integer visitCompExpression(grammaParser.CompExpressionContext ctx) {
        int left = super.visit(ctx.expression(0));
        int right = super.visit(ctx.expression(1));
        if (ctx.COMP_OP().getText().equals(">")) {
            return (left > right) ? 1 : 0;
        } else if (ctx.COMP_OP().getText().equals("<")) {
            return (left < right) ? 1 : 0;
        } else if (ctx.COMP_OP().getText().equals(">=")) {
            return (left >= right) ? 1 : 0;
        } else if (ctx.COMP_OP().getText().equals("<=")) {
            return (left <= right) ? 1 : 0;
        } else {
            return (left == right) ? 1 : 0;
        }
    }

    @Override public Integer visitConstant(grammaParser.ConstantContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    public void printVariables(){
        System.out.println("Program variables:");
        variables.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    public GrammarVisitor(List<Integer> input){
        this.variables = new HashMap<>();
        this.toWrite = new ArrayList<>();
        this.inputs = input;
    }
}
