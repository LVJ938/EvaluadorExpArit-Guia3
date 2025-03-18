package com.luisvargas.evaluadorexpart;
/**
 *
 * @author Luis Vargas
 */
import java.util.Scanner;
import Utilidades.BalanceoParentesis;
import Utilidades.EvaluadorPostfijo;
import Utilidades.InfijaPostfija;

public class EvaluadorExpArt {

    public static void main(String[] args) {
        
      
         Scanner scanner = new Scanner(System.in);
         
        // Primero se pide la expresión al usuario
        System.out.println("Ingrese la expresión en notacion infija:");
        String expresion = scanner.nextLine();

        // Segundo verificar si los paréntesis están balanceados
        if (!BalanceoParentesis.estaBalanceado(expresion)) {
            System.out.println("\nLos paréntesis no están balanceados.");
            return; 
        }

        // Tercero convertir notación infija a postfija
        String expresionPostfija = InfijaPostfija.pasaInfPostf(expresion);
        System.out.println("Expresion en notacion postfija: ");
        System.out.println(expresionPostfija);

        // Cuarto se evalua la expresión postfija
        int resultado = EvaluadorPostfijo.evaluarPostfijo(expresionPostfija);
        System.out.println("Resultado de la expresion: ");
        System.out.println(resultado);
        scanner.close();
        }
    }

