package analisador_lexico;
import static analisador_lexico.Token.*; 
%%
%class Lexer 
%type Token
%line
%caseless
%ignorecase

/* 
*   ALFABETO
*/

Letra=[a-zA-Z]+

Escape=[ ,\t, \n, \r]+
Digito=[0-9]+

%{
    public String lexema;
    public int getLine() { return yyline + 1; }
%}
%%

/**
**  REGRAS
*/

{Escape} {/*Ignore*/}
"#".* {/*Ignore*/}

/*
** Tipos de dados
*/

"bool" {return t_bool;}
"verdade" {return t_verdade;}
"falso" {return t_falso;}

{Letra}({Letra} | {Digito})* {lexema = yytext(); return t_id;}

. {return ERROR;}
