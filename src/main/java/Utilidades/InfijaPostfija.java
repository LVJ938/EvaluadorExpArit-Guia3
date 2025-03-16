package Utilidades;
/**
 *
 * @author Luis Vargas
 */
import java.util.Stack; // Se mporta la clase Stack para manejar la pila

public class InfijaPostfija {
    
    // Método para convertir una expresión infija a postfija
    public String infijaAPostfija(String expresion) { 
        StringBuilder resultado = new StringBuilder(); //permite modificar el contenido sin crear nuevos objetos en memoria. y se utiliza para almacenar la expresión en notación postfija mientras se procesa.
        Stack<Character> pila = new Stack<>(); // Se crea la pila vacía

        // Recorrido de la expresión caracter por caracter
        for (char c : expresion.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {  // Si el carácter es un operando (número o letra), se agrega a la notacion final
                resultado.append(c).append(" "); 
            }
            
            // Si es un paréntesis de apertura, se agrega a la pila
            else if (c == '(') {
                pila.push(c);
            }
            
            // Si es un paréntesis de cierre, se vacua la pila hasta encontrar '('
            else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    resultado.append(pila.pop()).append(" ");
                }
                pila.pop(); // Eliminar el '(' de la pila
            }
            
            // Si es un operador (+, -, *, /, ^)
            else {
                while (!pila.isEmpty() && prioridad(c) <= prioridad(pila.peek())) { // Mientras la pila no esté vacía y el operador en la cima (pila.peek()) tenga una prioridad mayor o igual que el operador actual (c), se ejecutará el bucle
                    resultado.append(pila.pop()).append(" "); // Se extrae con (pop()) el operador de la cima de la pila y se agrega con (append()) a resultado
                }
                pila.push(c); // El operador actual (c) se coloca en la pila 
            }
        }

        // Sacamos los operadores restantes de la pila
        while (!pila.isEmpty()) {
            resultado.append(pila.pop()).append(" ");
        }

        return resultado.toString().trim(); // trim() elimina los espacios en blanco al inicio y al final de la cadena.
    }

    // Método para determinar la prioridad de los operadores
    private int prioridad(char operador) {
        switch (operador) {
            case '+': case '-': return 1; // Se agrupan al tener la misma prioridad
            case '*': case '/': return 2;
            case '^': return 3;
            default: return -1; // Si no es operador, prioridad baja
        }
    }
}
