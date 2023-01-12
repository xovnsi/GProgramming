package Visitor.antlr4.generated;// Generated from gramma.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link grammaParser}.
 */
public interface grammaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link grammaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(grammaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(grammaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(grammaParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(grammaParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaParser#write}.
	 * @param ctx the parse tree
	 */
	void enterWrite(grammaParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaParser#write}.
	 * @param ctx the parse tree
	 */
	void exitWrite(grammaParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(grammaParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(grammaParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(grammaParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(grammaParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(grammaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(grammaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(grammaParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(grammaParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code twoArgexpression}
	 * labeled alternative in {@link grammaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTwoArgexpression(grammaParser.TwoArgexpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code twoArgexpression}
	 * labeled alternative in {@link grammaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTwoArgexpression(grammaParser.TwoArgexpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constExpression}
	 * labeled alternative in {@link grammaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstExpression(grammaParser.ConstExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constExpression}
	 * labeled alternative in {@link grammaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstExpression(grammaParser.ConstExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExpression}
	 * labeled alternative in {@link grammaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarExpression(grammaParser.VarExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExpression}
	 * labeled alternative in {@link grammaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarExpression(grammaParser.VarExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_expression(grammaParser.Logical_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_expression(grammaParser.Logical_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaParser#logicExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpression(grammaParser.LogicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaParser#logicExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpression(grammaParser.LogicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaParser#compExpression}.
	 * @param ctx the parse tree
	 */
	void enterCompExpression(grammaParser.CompExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaParser#compExpression}.
	 * @param ctx the parse tree
	 */
	void exitCompExpression(grammaParser.CompExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(grammaParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(grammaParser.ConstantContext ctx);
}