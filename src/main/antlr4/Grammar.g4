grammar Grammar;

@header {
    package com.github.rifttech.antlr4;
}

parse
 : expression EOF
 ;

expression
 : LPAREN expression RPAREN                                                         #parenExpression
 | NOT expression                                                                   #notExpression
 | left=expression op1=(AND | NAND) right=expression                                #binaryExpression
 | left=expression op2=(OR | NOR | XOR) right=expression                            #binaryExpression
 | left=expression op3= (XNOR | IMPL | CIMPL | NIMPL | CNIMPL ) right=expression    #binaryExpression
 | bool                                                                             #boolExpression
 | IDENTIFIER                                                                       #identifierExpression
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
NIMPL      : 'NIPL';
LPAREN     : '(' ;
RPAREN     : ')' ;
IDENTIFIER : [A-Z];
WS         : [ \r\t\u000C\n]+ -> skip;