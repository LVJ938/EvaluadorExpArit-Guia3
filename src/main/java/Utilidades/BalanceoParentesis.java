package Utilidades;

/**
 *
 * @author Luis Vargas
 */
import java.util.Stack; // Se mporta la clase Stack para manejar la pila

public class BalanceoParentesis {
      
    public static boolean estaBalanceado(String expresion) {
        Stack<Character> pila = new Stack<>(); // Se crea la pila vacía

        // Recorremos cada caracter de la expresión
        for (char c : expresion.toCharArray()) { // c toma el valor del siguiente carácter de expresion
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c); // Añade el caracter seleccionado a la parte duperior de la pila 
            } 
            else if (c == ')' || c == '}' || c == ']') {
                if (pila.isEmpty()) {
                    return false; // Si la pila queda basia la expresion está desbalanceada
                }
                char top = pila.pop(); // Sacamos el último paréntesis de la pila
                if (!esParentesisValido(top, c)) {
                    return false; // Si no coinciden, está desbalanceado
                }
            }
        }
        return pila.isEmpty(); // Si la pila queda vacía, los paréntesis estaban balanceados
    }

    private static boolean esParentesisValido(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                  (apertura == '{' && cierre == '}') ||
                  (apertura == '[' && cierre == ']');
    }
}
