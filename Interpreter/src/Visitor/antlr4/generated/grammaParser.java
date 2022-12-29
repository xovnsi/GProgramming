package Visitor.antlr4.generated;// Generated from gramma.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class grammaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, OPERATOR=12, LOGIC_OP=13, COMP_OP=14, INT=15, NUMBER=16, 
		STRING=17, BOOL=18, NULL=19, WS=20, VAR=21;
	public static final int
		RULE_program = 0, RULE_read = 1, RULE_write = 2, RULE_loop = 3, RULE_if_statement = 4, 
		RULE_assignment = 5, RULE_scope = 6, RULE_expression = 7, RULE_logical_expression = 8, 
		RULE_logicExpression = 9, RULE_compExpression = 10, RULE_constant = 11;
	public static final String[] ruleNames = {
		"program", "read", "write", "loop", "if_statement", "assignment", "scope", 
		"expression", "logical_expression", "logicExpression", "compExpression", 
		"constant"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'read('", "')'", "';'", "'write('", "'for ('", "' = '", "','", 
		"'if'", "'('", "'{'", "'}'", null, null, null, null, null, null, null, 
		"' null '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"OPERATOR", "LOGIC_OP", "COMP_OP", "INT", "NUMBER", "STRING", "BOOL", 
		"NULL", "WS", "VAR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "gramma.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public grammaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public TerminalNode EOF() { return getToken(grammaParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				scope();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(grammaParser.VAR, 0); }
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitRead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			match(VAR);
			setState(30);
			match(T__1);
			setState(31);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WriteContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode VAR() { return getToken(grammaParser.VAR, 0); }
		public WriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitWrite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitWrite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteContext write() throws RecognitionException {
		WriteContext _localctx = new WriteContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(T__3);
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(34);
				expression();
				}
				break;
			case 2:
				{
				setState(35);
				match(VAR);
				}
				break;
			}
			setState(38);
			match(T__1);
			setState(39);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(grammaParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(grammaParser.VAR, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompExpressionContext compExpression() {
			return getRuleContext(CompExpressionContext.class,0);
		}
		public TerminalNode OPERATOR() { return getToken(grammaParser.OPERATOR, 0); }
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__4);
			setState(42);
			match(VAR);
			setState(43);
			match(T__5);
			setState(44);
			expression();
			setState(45);
			match(T__6);
			setState(46);
			compExpression();
			setState(47);
			match(T__6);
			setState(48);
			match(OPERATOR);
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case NUMBER:
			case STRING:
			case BOOL:
			case NULL:
				{
				setState(49);
				constant();
				}
				break;
			case VAR:
				{
				setState(50);
				match(VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(53);
			match(T__1);
			setState(54);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statementContext extends ParserRuleContext {
		public Logical_expressionContext logical_expression() {
			return getRuleContext(Logical_expressionContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__7);
			setState(57);
			match(T__8);
			setState(58);
			logical_expression();
			setState(59);
			match(T__1);
			setState(60);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(grammaParser.VAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(VAR);
			setState(63);
			match(T__5);
			{
			setState(64);
			expression();
			}
			setState(65);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScopeContext extends ParserRuleContext {
		public List<ReadContext> read() {
			return getRuleContexts(ReadContext.class);
		}
		public ReadContext read(int i) {
			return getRuleContext(ReadContext.class,i);
		}
		public List<WriteContext> write() {
			return getRuleContexts(WriteContext.class);
		}
		public WriteContext write(int i) {
			return getRuleContext(WriteContext.class,i);
		}
		public List<LoopContext> loop() {
			return getRuleContexts(LoopContext.class);
		}
		public LoopContext loop(int i) {
			return getRuleContext(LoopContext.class,i);
		}
		public List<If_statementContext> if_statement() {
			return getRuleContexts(If_statementContext.class);
		}
		public If_statementContext if_statement(int i) {
			return getRuleContext(If_statementContext.class,i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_scope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__9);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << VAR))) != 0)) {
				{
				setState(73);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(68);
					read();
					}
					break;
				case T__3:
					{
					setState(69);
					write();
					}
					break;
				case T__4:
					{
					setState(70);
					loop();
					}
					break;
				case T__7:
					{
					setState(71);
					if_statement();
					}
					break;
				case VAR:
					{
					setState(72);
					assignment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TwoArgexpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OPERATOR() { return getToken(grammaParser.OPERATOR, 0); }
		public TwoArgexpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterTwoArgexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitTwoArgexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitTwoArgexpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstExpressionContext extends ExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterConstExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitConstExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitConstExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExpressionContext extends ExpressionContext {
		public TerminalNode VAR() { return getToken(grammaParser.VAR, 0); }
		public VarExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterVarExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitVarExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitVarExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expression);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new TwoArgexpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(T__8);
				setState(81);
				expression();
				setState(82);
				match(OPERATOR);
				setState(83);
				expression();
				setState(84);
				match(T__1);
				}
				break;
			case INT:
			case NUMBER:
			case STRING:
			case BOOL:
			case NULL:
				_localctx = new ConstExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				constant();
				}
				break;
			case VAR:
				_localctx = new VarExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_expressionContext extends ParserRuleContext {
		public LogicExpressionContext logicExpression() {
			return getRuleContext(LogicExpressionContext.class,0);
		}
		public CompExpressionContext compExpression() {
			return getRuleContext(CompExpressionContext.class,0);
		}
		public Logical_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterLogical_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitLogical_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitLogical_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_expressionContext logical_expression() throws RecognitionException {
		Logical_expressionContext _localctx = new Logical_expressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_logical_expression);
		try {
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				logicExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				compExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicExpressionContext extends ParserRuleContext {
		public List<Logical_expressionContext> logical_expression() {
			return getRuleContexts(Logical_expressionContext.class);
		}
		public Logical_expressionContext logical_expression(int i) {
			return getRuleContext(Logical_expressionContext.class,i);
		}
		public TerminalNode LOGIC_OP() { return getToken(grammaParser.LOGIC_OP, 0); }
		public LogicExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterLogicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitLogicExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitLogicExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicExpressionContext logicExpression() throws RecognitionException {
		LogicExpressionContext _localctx = new LogicExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_logicExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__8);
			setState(95);
			logical_expression();
			setState(96);
			match(LOGIC_OP);
			setState(97);
			logical_expression();
			setState(98);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMP_OP() { return getToken(grammaParser.COMP_OP, 0); }
		public CompExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterCompExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitCompExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitCompExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompExpressionContext compExpression() throws RecognitionException {
		CompExpressionContext _localctx = new CompExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_compExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__8);
			setState(101);
			expression();
			setState(102);
			match(COMP_OP);
			setState(103);
			expression();
			setState(104);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(grammaParser.INT, 0); }
		public TerminalNode NUMBER() { return getToken(grammaParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(grammaParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(grammaParser.BOOL, 0); }
		public TerminalNode NULL() { return getToken(grammaParser.NULL, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammaListener ) ((grammaListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammaVisitor ) return ((grammaVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << NUMBER) | (1L << STRING) | (1L << BOOL) | (1L << NULL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27o\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\5\2\35\n\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4"+
		"\'\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\66\n\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\7\bL\n\b\f\b\16\bO\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\t[\n\t\3\n\3\n\5\n_\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\3"+
		"\2\21\25\2m\2\34\3\2\2\2\4\36\3\2\2\2\6#\3\2\2\2\b+\3\2\2\2\n:\3\2\2\2"+
		"\f@\3\2\2\2\16E\3\2\2\2\20Z\3\2\2\2\22^\3\2\2\2\24`\3\2\2\2\26f\3\2\2"+
		"\2\30l\3\2\2\2\32\35\5\16\b\2\33\35\7\2\2\3\34\32\3\2\2\2\34\33\3\2\2"+
		"\2\35\3\3\2\2\2\36\37\7\3\2\2\37 \7\27\2\2 !\7\4\2\2!\"\7\5\2\2\"\5\3"+
		"\2\2\2#&\7\6\2\2$\'\5\20\t\2%\'\7\27\2\2&$\3\2\2\2&%\3\2\2\2\'(\3\2\2"+
		"\2()\7\4\2\2)*\7\5\2\2*\7\3\2\2\2+,\7\7\2\2,-\7\27\2\2-.\7\b\2\2./\5\20"+
		"\t\2/\60\7\t\2\2\60\61\5\26\f\2\61\62\7\t\2\2\62\65\7\16\2\2\63\66\5\30"+
		"\r\2\64\66\7\27\2\2\65\63\3\2\2\2\65\64\3\2\2\2\66\67\3\2\2\2\678\7\4"+
		"\2\289\5\16\b\29\t\3\2\2\2:;\7\n\2\2;<\7\13\2\2<=\5\22\n\2=>\7\4\2\2>"+
		"?\5\16\b\2?\13\3\2\2\2@A\7\27\2\2AB\7\b\2\2BC\5\20\t\2CD\7\5\2\2D\r\3"+
		"\2\2\2EM\7\f\2\2FL\5\4\3\2GL\5\6\4\2HL\5\b\5\2IL\5\n\6\2JL\5\f\7\2KF\3"+
		"\2\2\2KG\3\2\2\2KH\3\2\2\2KI\3\2\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3"+
		"\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7\r\2\2Q\17\3\2\2\2RS\7\13\2\2ST\5\20\t\2"+
		"TU\7\16\2\2UV\5\20\t\2VW\7\4\2\2W[\3\2\2\2X[\5\30\r\2Y[\7\27\2\2ZR\3\2"+
		"\2\2ZX\3\2\2\2ZY\3\2\2\2[\21\3\2\2\2\\_\5\24\13\2]_\5\26\f\2^\\\3\2\2"+
		"\2^]\3\2\2\2_\23\3\2\2\2`a\7\13\2\2ab\5\22\n\2bc\7\17\2\2cd\5\22\n\2d"+
		"e\7\4\2\2e\25\3\2\2\2fg\7\13\2\2gh\5\20\t\2hi\7\20\2\2ij\5\20\t\2jk\7"+
		"\4\2\2k\27\3\2\2\2lm\t\2\2\2m\31\3\2\2\2\t\34&\65KMZ^";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}