/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package analisador_lexico;

/**
 *
 * @author Ussumane-Momade
 */
/* bool valor = verdade -> <t_bool, bool>, <t_id, valor> <t_verdade, verdade> */
public enum Token {
	t_id,
	t_bool,
	t_verdade,
	t_falso,
	t_qbr,
	t_case,
	t_char,
	t_faca,
	t_real,
	t_senao,
	t_para,
	t_se,
	t_inteiro,
	t_retorne,
	t_escolha,
	t_var,
	t_enquanto,
	t_literal,
	t_fun,
	t_numero,
	t_ptvirgula,
	t_doispontos,
	t_virgula,
	t_Lchaveta,
	t_Rchaveta,
	t_Lparenteses,
	t_Rparenteses,
	t_comentario,
	t_soma,
	t_sub,
	t_div,
	t_mult,
	t_mod,
	t_atribuicao,
	t_negacao,
	t_igualdade,
	t_maior,
	t_menor,
	t_maiorIgual,
	t_menorIgual,
	ERROR
}

/*
 * "bool" {return t_bool;}
 * "verdade" {return t_verdade;}
 * "falso" {return t_falso;}
 * "quebrar" {return t_qbr;}
 * "caso" {return t_case;}
 * "char" {return t_char;}
 * "faca" {return t_faca;}
 * "real" {return t_real;}
 * "senao" {return t_senao;}
 * "para" {return t_para;}
 * "se" {return t_se;}
 * "inteiro" {return t_inteiro;}
 * "retorne" {return t_retorne;}
 * "escolha" {return t_escolha;}
 * "var" {return t_var;}
 * "enquanto" {return t_enquanto;}
 * "verdade" {return t_verdade;}
 * "falso" {return t_falso;}
 * "literal" {return t_literal;}
 * "fun" {return t_fun;}
 */

/**
 * bool |
 * quebrar |
 * caso |
 * char |
 * faca |
 * real |
 * senao |
 * para |
 * se |
 * inteiro |
 * retorne |
 * escolha |
 * var |
 * enquanto |
 * verdade |
 * falso |
 * literal |
 * fun {lexema=yytext(); return Palavra_reservada;}
 */
