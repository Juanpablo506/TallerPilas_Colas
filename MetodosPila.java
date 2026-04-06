import java.util.Scanner;
import java.util.Stack;

public class MetodosPila {

    Validaciones v = new Validaciones();

    public Stack<Integer> llenarPila(Stack<Integer> p, Scanner sc) {
        boolean pedir = true;
        int opt = 0;
        while (pedir) {
            System.out.println("Ingrese el numero");
            p.push(v.ValidarEntero(sc));
            System.out.println("Desea ingresar mas registros 1) si , 2) no");
            opt = v.ValidarEntero(sc);
            opt = v.ValidarRango(1, 2, opt, sc);
            if (opt == 2) {
                pedir = false;
            }
        }
        return p;
    }

    public void mostrarPila(Stack<Integer> p) {
        System.out.println("pila: " + p);
    }

    public Stack<Integer> modificarPila(Stack<Integer> p, int numero, Scanner sc) {
        Stack<Integer> aux = new Stack<>();
        int n = p.size();
        System.out.println("Ingrese el nuevo valor");
        int nuevoValor = v.ValidarEntero(sc);
        for (int i = 0; i < n; i++) {
            if (p.peek().equals(numero)) {
                p.pop();
                aux.push(nuevoValor);
            } else {
                aux.push(p.pop());
            }
        }
        for (int i = 0; i < n; i++) {
            p.push(aux.pop());
        }
        return p;
    }

    // Método 1 — pila auxiliar (enfoque puro)
    public Stack<Integer> eliminarPila(Stack<Integer> p, int numero, Scanner sc) {
        Stack<Integer> aux = new Stack<>();
        System.out.println("Eliminar todos repetidos 1, eliminar solo el primero 2");
        int opt = v.ValidarEntero(sc);
        boolean encontrado = true;

        if (opt == 1) {
            while (!p.isEmpty()) {
                if (p.peek().equals(numero)) {
                    p.pop();
                } else {
                    aux.push(p.pop());
                }
            }
        } else {
            while (!p.isEmpty()) {
                if (p.peek().equals(numero) && encontrado) {
                    p.pop();
                    encontrado = false;
                } else {
                    aux.push(p.pop());
                }
            }
        }

        while (!aux.isEmpty()) {
            p.push(aux.pop());
        }
        return p;
    }

    // Método 2 — acceso por índice
    public Stack<Integer> eliminarPilaIndice(Stack<Integer> p, int numero) {
        for (int i = p.size() - 1; i >= 0; i--) {
            if (p.get(i).equals(numero)) {
                p.remove(i);
            }
        }
        return p;
    }

    // Método 3 — lambda
    public Stack<Integer> eliminarPilaLambda(Stack<Integer> p, int numero) {
        p.removeIf(x -> x.equals(numero));
        return p;
    }

}