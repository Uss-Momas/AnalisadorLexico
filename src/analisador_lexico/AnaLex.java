/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisador_lexico;

import java.io.*;

/**
 *
 * @author Ussumane-Momade
 */
public class AnaLex {

    public AnaLex() {
        String basePath = System.getProperty("user.dir");
        String path = basePath + "\\src\\analisador_lexico\\index.sudo";
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
                        print(lexer.getLine(), token, lexer.lexema);
                        break;
                    case t_qbr:
                    case t_case:
                    case t_char:
                    case t_faca:
                    case t_real:
                    case t_senao:
                    case t_para:
                    case t_se:
                    case t_inteiro:
                    case t_retorne:
                    case t_escolha:
                    case t_var:
                    case t_enquanto:
                    case t_literal:
                    case t_fun:
                        print(lexer.getLine(), token, "");break;
                    case t_numero:
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
                        print(lexer.getLine(), token, lexer.lexema);break;
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

    }

    public void print(int line, Token token, String atrib) {
        if(atrib == ""){
            System.out.println("<"+line+", "+token+" >");
        }else{
            System.out.println("<"+line+", "+token+", "+atrib+">");
        }
        
    }
    
    public void generateTable(){
        
    }

}
