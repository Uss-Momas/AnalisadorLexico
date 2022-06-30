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

"quebrar" {return t_qbr}
"caso" {return t_case}
"char"	{return t_char}
"faca"	{return t_faca}
"real"	{return t_real}
"senao"	{return t_senao}
"para"	{return t_para}
"se"	    {return t_se}
inteiro	{return t_inteiro}
retorne	{return t_retorne}
escolha	{return t_escolha}
var	    {return t_var}
enquanto{return t_enquanto}
verdade	{return t_verdade}
falso	{return t_falso}
literal	{return t_literal}
fun	    {return t_fun}
identificador/variável	{return t_id}
numero	{return t_numero}
;	{return t_ptvirgula}
:	{return t_doispontos}
,	{return t_virgula}
{	{return t_Lchaveta}
}	{return t_Rchaveta}
(	{return t_Lparenteses}
)	{return t_Rparenteses}
#	{return t_comentario}
+	{return t_soma}
-	{return t_sub}
/	{return t_div}
*	{return t_mult}
%	{return t_mod}
=	{return t_atribuicao}
!	{return t_negacao}
==	{return t_igualdade}
>	{return t_maior}
<	{return t_menor}
>=	{return t_maiorIgual}
<=	{return t_menorIgual}









{Letra}({Letra} | {Digito})* {lexema = yytext(); return t_id;}

. {return ERROR;}
