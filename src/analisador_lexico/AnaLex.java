/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisador_lexico;

import java.io.*;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author Ussumane-Momade
 */
public class AnaLex {

	Hashtable<String, Token> keywords;
	Hashtable<Integer, String> symbols;
	int contSymbols;

	public AnaLex() {
		String basePath = System.getProperty("user.dir");
		String path = basePath + "\\src\\analisador_lexico\\index.sudo";
		generateKeywordsTable();
		symbols = new Hashtable<Integer, String>();
		contSymbols = 0;
		analyze(path);
	}

	public void analyze(String path) {
		String result = "";
		try {
			Reader reader = new BufferedReader(new FileReader(path));
			Lexer lexer = new Lexer(reader);

			while (true) {
				Token token = lexer.yylex();
				if (token == null) {
					result += "EOF";
					break;
				}
				switch (token) {
					case ERROR:
						System.out.println("Error on line " + lexer.getLine() + "token " + token + " not recognized");
						System.exit(0);
						break;
					case t_bool:
						print(lexer.getLine(), token, "");
						break;
					case t_verdade:
						print(lexer.getLine(), token, "");
						break;

					case t_falso:
						print(lexer.getLine(), token, "");
						break;

					case t_id:
						Token thisToken = verifyIdentifierToken(lexer.lexema);
						if (thisToken == Token.t_id) {
							print(lexer.getLine(), thisToken, lexer.lexema);
							addSymbol(lexer.lexema);
						} else {
							print(lexer.getLine(), thisToken, "");
						}
						break;

					case t_numero:
						print(lexer.getLine(), token, lexer.lexema);
						break;
					case t_ptvirgula:
					case t_doispontos:
					case t_virgula:
					case t_Lchaveta:
					case t_Rchaveta:
					case t_Lparenteses:
					case t_Rparenteses:
					case t_comentario:
					case t_soma:
					case t_sub:
					case t_div:
					case t_mult:
					case t_mod:
					case t_atribuicao:
					case t_negacao:
					case t_igualdade:
					case t_maior:
					case t_menor:
					case t_maiorIgual:
					case t_menorIgual:
						print(lexer.getLine(), token, "");
						break;
					default:
						result += "Token: " + token + "\n";
						break;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println(result);
		printHashTable(symbols);

	}

	public void printHashTable(Hashtable ht) {
		System.out.println("======================================");

		ht.forEach((key, value) -> System.out.println(
				"Key : " + key
						+ "\t\t Value : " + value));
	}

	public void addSymbol(String symbol) {
		if (!symbols.containsValue(symbol)) {
			contSymbols++;
			symbols.put(contSymbols, symbol);
		}

	}

	public void print(int line, Token token, String atrib) {
		if (atrib == "") {
			// System.out.println("<" + line + ", " + token + " >");
			System.out.format("|%3s\t|%16s\t|%7s\t|\n", line, token, "");
                        System.out.println("-------------------------------------------------");
		} else {
			// System.out.println("<" + line + ", " + token + ", " + atrib + ">");
			System.out.format("|%3s\t|%16s\t|%7s\t|\n", line, token, atrib);
                        System.out.println("-------------------------------------------------");
		}

	}

	// Ger
	public void generateKeywordsTable() {
		keywords = new Hashtable<String, Token>();
		keywords.put("bool", Token.t_bool);
		keywords.put("quebrar", Token.t_qbr);
		keywords.put("caso", Token.t_case);
		keywords.put("char", Token.t_char);
		keywords.put("faca", Token.t_faca);
		keywords.put("real", Token.t_real);
		keywords.put("senao", Token.t_senao);
		keywords.put("para", Token.t_para);
		keywords.put("se", Token.t_se);
		keywords.put("inteiro", Token.t_inteiro);
		keywords.put("retorne", Token.t_retorne);
		keywords.put("escolha", Token.t_escolha);
		keywords.put("var", Token.t_var);
		keywords.put("enquanto", Token.t_enquanto);
		keywords.put("verdade", Token.t_verdade);
		keywords.put("falso", Token.t_falso);
		keywords.put("literal", Token.t_literal);
		keywords.put("fun", Token.t_fun);

	}

	// Verificar se o identificador e um token
	public Token verifyIdentifierToken(String id) {
		if (keywords.containsKey(id)) {
			Token token = keywords.get(id);
			return token;
		}
		return Token.t_id;
	}

}
