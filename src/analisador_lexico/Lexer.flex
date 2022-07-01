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

";"	{return t_ptvirgula;}
":"	{return t_doispontos;}
","	{return t_virgula;}
"{"	{return t_Lchaveta;}
"}"	{return t_Rchaveta;}
"("	{return t_Lparenteses;}
")"	{return t_Rparenteses;}
"+"	{return t_soma;}
"-"	{return t_sub;}
"/"	{return t_div;}
"*"	{return t_mult;}
"%"	{return t_mod;}
"="	{return t_atribuicao;}
"!"	{return t_negacao;}
"=="	{return t_igualdade;}
">"	{return t_maior;}
"<"	{return t_menor;}
">="	{return t_maiorIgual;}
"<="	{return t_menorIgual;}


("(-"{Digito}+")") | ("(-"{Digito}+"."{Digito}+")") | {Digito}+ | ({Digito}+"."{Digito}+) {lexema=yytext(); return t_numero;}
{Letra}({Letra} | {Digito})* {lexema = yytext(); return t_id;}

. {return ERROR;}
