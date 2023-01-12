package Visitor.antlr4.generated;// Generated from gramma.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link grammaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface grammaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link grammaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(grammaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammaParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(grammaParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammaParser#write}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite(grammaParser.WriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammaParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(grammaParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammaParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(grammaParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammaParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(grammaParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammaParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(grammaParser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code twoArgexpression}
	 * labeled alternative in {@link grammaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTwoArgexpression(grammaParser.TwoArgexpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constExpression}
	 * labeled alternative in {@link grammaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExpression(grammaParser.ConstExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExpression}
	 * labeled alternative in {@link grammaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpression(grammaParser.VarExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammaParser#logical_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_expression(grammaParser.Logical_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammaParser#logicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpression(grammaParser.LogicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammaParser#compExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpression(grammaParser.CompExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammaParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(grammaParser.ConstantContext ctx);
}