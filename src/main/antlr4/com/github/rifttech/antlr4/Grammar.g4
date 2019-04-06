grammar Grammar;

parse
 : expression EOF
 ;

expression
 : LPAREN expression RPAREN                             #parenExpression
 | NOT expression                                       #notExpression
 | left=expression op1=binary_set_1 right=expression    #binaryExpression
 | left=expression op2=binary_set_2 right=expression    #binaryExpression
 | left=expression op3=binary_set_3 right=expression    #binaryExpression
 | bool                                                 #boolExpression
 | IDENTIFIER                                           #identifierExpression
 ;

binary_set_1
    : AND | NAND
    ;

binary_set_2
    : OR | NOR | XOR
    ;
binary_set_3
    : XNOR | IMPL | CIMPL | NIMPL | CNIMPL
    ;
bool
 : TRUE | FALSE
 ;

TRUE : 'TRUE';
FALSE : 'FALSE';

NOT        : 'NOT';
AND        : 'AND' ;
NAND       : 'NAND';
OR         : 'OR' ;
NOR        : 'NOR';
XNOR       : 'XNOR';
XOR        : 'XOR';
IMPL       : 'IMPL';
CIMPL      : 'CIMPL';
CNIMPL     : 'CNIMPL';
NIMPL      : 'NIMPL';
LPAREN     : '(' ;
RPAREN     : ')' ;
IDENTIFIER : [A-Z];
WS         : [ \r\t\u000C\n]+ -> skip;