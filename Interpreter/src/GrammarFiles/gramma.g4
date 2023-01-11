grammar gramma;

program:   scope | EOF;
read: 'read(' VAR ')' ';';
write: 'write(' (expression | VAR) ')' ';';
loop: 'for (' VAR ' = ' expression ',' compExpression ',' OPERATOR (constant | VAR)')' scope;
if: 'if' '(' logical_expression ')' scope;
assignment: VAR ' = ' (expression) ';';
scope: '{' (read | write | loop | if | assignment)* '}';

expression
    : '(' expression OPERATOR expression ')'            #twoArgexpression
    | constant                                          #constExpression
    | VAR                                               #varExpression
    ;

logical_expression: logicExpression | compExpression;

logicExpression: '(' logical_expression LOGIC_OP logical_expression ')';
compExpression: '(' expression COMP_OP expression ')';


constant : INT | NUMBER | STRING | BOOL | NULL;

OPERATOR : ' + ' | ' - ' | ' * ' | ' / ';
LOGIC_OP : ' and ' | ' or ';
COMP_OP : '>' | '<' | '>=' | '<=' | '==';


INT : '-'?([0-9] | [1-9][0-9]+);
NUMBER : INT ('.'INT+)?;
STRING: ('"' ~'"'* '"') | ('\'' ~'\''* '\'');

BOOL : ' true ' | ' false ';
NULL : ' null ';

WS: [ \n\t\r]+ -> skip;
VAR : '_'[a-z][a-z0-9_]*;