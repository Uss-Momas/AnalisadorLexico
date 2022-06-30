/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisador_lexico;

import java.io.File;

/**
 *
 * @author LEWIS
 */
public class Main {

    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir");
        String path = "D:\\github\\AnalisadorLexico\\src\\analisador_lexico\\Lexer.flex";
        genLexer(path);
        new AnaLex();
    }

    public static void genLexer(String path) {
        File file = new File(path);
        jflex.Main.generate(file);
    }

}
