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
        System.out.println(basePath);
        String path = basePath + "\\src\\analisador_lexico\\Lexer.flex";
        System.out.println(path);
        genLexer(path);
        new AnaLex();
    }

    public static void genLexer(String path) {
        File file = new File(path);
        jflex.Main.generate(file);
    }

}
