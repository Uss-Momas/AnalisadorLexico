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
        String path = "D:\\github\\AnalisadorLexico\\src\\analisador_lexico\\index.sudo";
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
                        System.out.println("Error on line " + lexer.getLine() + "token " + token + "not recognized");
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
        System.out.println(line + " | " + token + " | " + atrib);
    }

}
