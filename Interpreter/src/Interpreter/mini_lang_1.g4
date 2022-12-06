grammar mini_lang_1;

program
    :   instruction+ EOF;

instruction
    :   read
    |   write
    |   loop
    |   scope
    |   conditional_exp
    |   var_assignment
    ;

read
    : 'read()' NL;

write
    : 'write(' (TEXT | VAR) ')' NL;

scope
    : '{' NL* instruction* NL*'}' NL;

loop
    : 'for ' VAR ' in range(' NUMBER ',' NUMBER ',' NUMBER')' scope;

constant : NUMBER | INT;

operation
    : LPAREN operation OPERATOR operation RPAREN NL*
    | constant
    | VAR ;

logical_operation
    : LPAREN operation COMP_OP operation RPAREN NL
    | LPAREN operation EQ_OP (BOOL | NULL | operation) RPAREN NL
    | LPAREN logical_operation LOGIC_OP logical_operation RPAREN NL;

var_assignment
    : VAR ' = ' (read | operation | NUMBER | INT | TEXT) NL;

conditional_exp
    : 'if ' NOT? LPAREN logical_operation RPAREN scope NL;

OPERATOR : ' + ' | ' - ' | ' * ' | ' / ';

LOGIC_OP : ' and ' | ' or ';

COMP_OP : '>' | '<';

EQ_OP: '==';

NOT : 'not ';

NL : '\n';

L_BRACE : '{';

R_BRACE : '}';

QUOTE : '"';

TEXT : QUOTE (~[\r\n"])+ QUOTE;

VAR : '_'[a-z][a-z0-9_]*;

NUMBER : INT ('.'INT+)?;

INT : [0-9] | [1-9][0-9]+;

BOOL : ' true ' | ' false ';

NULL : ' null ';

RPAREN : ')';

LPAREN : '(';

WS: [ \t\r]+ -> skip;