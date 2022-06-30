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

Letra = [a-zA-Z]+
Escape = [ ,\t, \n, \r]+
Delimitadores = [;(){}\[\]]
Digito = [0-9]+

%{
    public String lexema;
    public int getLine() { return yyline + 1; }
%}
%%

/**
**  CARACTERES IGNORADOS
*/

{Escape} {/*Ignore*/}
"#".* {/*Ignore*/}

/*
** TOKENS DA LINGUAGEM
*/

"bool" {return t_bool;}
"verdade" {return t_verdade;}
"falso" {return t_falso;}

{Letra}({Letra} | {Digito})* {lexema = yytext(); return t_id;}

. {return ERROR;}
