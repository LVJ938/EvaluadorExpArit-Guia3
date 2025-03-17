package Utilidades;
/**
 *
 * @author Luis Vargas
 */

import java.util.Stack; // Se mporta la clase Stack para manejar la pila

public class EvaluadorPostfijo {
    
    // Método para evaluar una expresión postfija
    public static int evaluarPostfijo(String expresion) {
        
        Stack<Integer> pila = new Stack<>();
        String[] partes = expresion.split("\\s+"); // Divide la cadena en palabras separadas por espacios en blanco (\s+ significa "uno o más espacios").

        for (String parte : partes) {
            if (esNumero(parte)) { 
                pila.push(Integer.parseInt(parte)); // Si parte es un número, se agrega como valor entero a la pila
            } 
            else {
                // Si es un operador, se sacan los dos últimos operandos de la pila
                int b = pila.pop(); // Último número en la pila
                int a = pila.pop(); // Segundo número en la pila
                int resultado = aplicarOperacion(a, b, parte);  // Se llama a la funcion que opera segun corresponda
                pila.push(resultado); // Se gurada el resultado en la pila
            }
        }
        return pila.pop();// Al final, la pila debe contener solo el resultado final
    }

    // Método para verificar si parte es un número
    private static boolean esNumero(String parte) {
        try {
                Integer.parseInt(parte);
                 return true;
            } 
        catch (NumberFormatException e) { // Comprueba que la cadena no es un número válido (por ejemplo, "abc" o "12.5").
            return false;
        }
    }

    // Método para aplicar la operación aritmética
    private static int aplicarOperacion(int a, int b, String operador) {
        switch (operador) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Asumiendo que no hay división por cero
            case "^": return (int) Math.pow(a, b);
            default: throw new IllegalArgumentException("Operador inválido: " + operador);//  Crea una excepción específica que indica que el argumento (operador) es inválido.
        }
    }
}
