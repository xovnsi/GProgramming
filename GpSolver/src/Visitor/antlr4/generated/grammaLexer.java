package Visitor.antlr4.generated;// Generated from gramma.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class grammaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, OPERATOR=12, LOGIC_OP=13, COMP_OP=14, INT=15, NUMBER=16, 
		STRING=17, BOOL=18, NULL=19, WS=20, VAR=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "OPERATOR", "LOGIC_OP", "COMP_OP", "INT", "NUMBER", "STRING", 
		"BOOL", "NULL", "WS", "VAR"
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


	public grammaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gramma.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00c1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r`\n\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\5\16k\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17t\n\17\3\20\5\20w\n\20\3\20\3\20\3\20\6\20|\n\20\r\20\16\20}\5\20"+
		"\u0080\n\20\3\21\3\21\3\21\6\21\u0085\n\21\r\21\16\21\u0086\5\21\u0089"+
		"\n\21\3\22\3\22\7\22\u008d\n\22\f\22\16\22\u0090\13\22\3\22\3\22\3\22"+
		"\7\22\u0095\n\22\f\22\16\22\u0098\13\22\3\22\5\22\u009b\n\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00aa\n\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\6\25\u00b4\n\25\r\25\16\25\u00b5"+
		"\3\25\3\25\3\26\3\26\3\26\7\26\u00bd\n\26\f\26\16\26\u00c0\13\26\2\2\27"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27\3\2\n\4\2>>@@\3\2\62;\3\2\63;\3\2$$\3"+
		"\2))\5\2\13\f\17\17\"\"\3\2c|\5\2\62;aac|\2\u00d2\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67"+
		"\3\2\2\2\13>\3\2\2\2\rD\3\2\2\2\17H\3\2\2\2\21J\3\2\2\2\23M\3\2\2\2\25"+
		"O\3\2\2\2\27Q\3\2\2\2\31_\3\2\2\2\33j\3\2\2\2\35s\3\2\2\2\37v\3\2\2\2"+
		"!\u0081\3\2\2\2#\u009a\3\2\2\2%\u00a9\3\2\2\2\'\u00ab\3\2\2\2)\u00b3\3"+
		"\2\2\2+\u00b9\3\2\2\2-.\7t\2\2./\7g\2\2/\60\7c\2\2\60\61\7f\2\2\61\62"+
		"\7*\2\2\62\4\3\2\2\2\63\64\7+\2\2\64\6\3\2\2\2\65\66\7=\2\2\66\b\3\2\2"+
		"\2\678\7y\2\289\7t\2\29:\7k\2\2:;\7v\2\2;<\7g\2\2<=\7*\2\2=\n\3\2\2\2"+
		">?\7h\2\2?@\7q\2\2@A\7t\2\2AB\7\"\2\2BC\7*\2\2C\f\3\2\2\2DE\7\"\2\2EF"+
		"\7?\2\2FG\7\"\2\2G\16\3\2\2\2HI\7.\2\2I\20\3\2\2\2JK\7k\2\2KL\7h\2\2L"+
		"\22\3\2\2\2MN\7*\2\2N\24\3\2\2\2OP\7}\2\2P\26\3\2\2\2QR\7\177\2\2R\30"+
		"\3\2\2\2ST\7\"\2\2TU\7-\2\2U`\7\"\2\2VW\7\"\2\2WX\7/\2\2X`\7\"\2\2YZ\7"+
		"\"\2\2Z[\7,\2\2[`\7\"\2\2\\]\7\"\2\2]^\7\61\2\2^`\7\"\2\2_S\3\2\2\2_V"+
		"\3\2\2\2_Y\3\2\2\2_\\\3\2\2\2`\32\3\2\2\2ab\7\"\2\2bc\7c\2\2cd\7p\2\2"+
		"de\7f\2\2ek\7\"\2\2fg\7\"\2\2gh\7q\2\2hi\7t\2\2ik\7\"\2\2ja\3\2\2\2jf"+
		"\3\2\2\2k\34\3\2\2\2lt\t\2\2\2mn\7@\2\2nt\7?\2\2op\7>\2\2pt\7?\2\2qr\7"+
		"?\2\2rt\7?\2\2sl\3\2\2\2sm\3\2\2\2so\3\2\2\2sq\3\2\2\2t\36\3\2\2\2uw\7"+
		"/\2\2vu\3\2\2\2vw\3\2\2\2w\177\3\2\2\2x\u0080\t\3\2\2y{\t\4\2\2z|\t\3"+
		"\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177x\3\2\2"+
		"\2\177y\3\2\2\2\u0080 \3\2\2\2\u0081\u0088\5\37\20\2\u0082\u0084\7\60"+
		"\2\2\u0083\u0085\5\37\20\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0082\3\2"+
		"\2\2\u0088\u0089\3\2\2\2\u0089\"\3\2\2\2\u008a\u008e\7$\2\2\u008b\u008d"+
		"\n\5\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u009b\7$"+
		"\2\2\u0092\u0096\7)\2\2\u0093\u0095\n\6\2\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0099\u009b\7)\2\2\u009a\u008a\3\2\2\2\u009a"+
		"\u0092\3\2\2\2\u009b$\3\2\2\2\u009c\u009d\7\"\2\2\u009d\u009e\7v\2\2\u009e"+
		"\u009f\7t\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7g\2\2\u00a1\u00aa\7\"\2"+
		"\2\u00a2\u00a3\7\"\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6"+
		"\7n\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a8\7g\2\2\u00a8\u00aa\7\"\2\2\u00a9"+
		"\u009c\3\2\2\2\u00a9\u00a2\3\2\2\2\u00aa&\3\2\2\2\u00ab\u00ac\7\"\2\2"+
		"\u00ac\u00ad\7p\2\2\u00ad\u00ae\7w\2\2\u00ae\u00af\7n\2\2\u00af\u00b0"+
		"\7n\2\2\u00b0\u00b1\7\"\2\2\u00b1(\3\2\2\2\u00b2\u00b4\t\7\2\2\u00b3\u00b2"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b8\b\25\2\2\u00b8*\3\2\2\2\u00b9\u00ba\7a\2\2"+
		"\u00ba\u00be\t\b\2\2\u00bb\u00bd\t\t\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf,\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\21\2_jsv}\177\u0086\u0088\u008e\u0096\u009a\u00a9\u00b5"+
		"\u00be\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}