import java.util.Scanner;
import java.util.Stack;

public class MetodosPilaObj {

    Validaciones v = new Validaciones();

    public Stack<ObjDato> llenarPila(Stack<ObjDato> p, Scanner sc) {
        boolean pedir = true;
        int opt = 0;
        while (pedir) {
            ObjDato o = new ObjDato();
            System.out.println("Ingrese el numero");
            o.setNumero(v.ValidarEntero(sc));
            p.push(o);
            System.out.println("Desea ingresar mas registros 1) si , 2) no");
            opt = v.ValidarEntero(sc);
            opt = v.ValidarRango(1, 2, opt, sc);
            if (opt == 2) {
                pedir = false;
            }
        }
        return p;
    }

    public void mostrarPila(Stack<ObjDato> p) {
        System.out.print("pila: [");
        for (int i = 0; i < p.size(); i++) {
            System.out.print(p.get(i).getNumero());
            if (i < p.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public Stack<ObjDato> modificarPila(Stack<ObjDato> p, int numero, Scanner sc) {
        System.out.println("Ingrese el nuevo valor");
        int nuevoValor = v.ValidarEntero(sc);
        for (ObjDato o : p) {
            if (o.getNumero() == numero) {
                o.setNumero(nuevoValor);
            }
        }
        return p;
    }

    // Método 1 — pila auxiliar (enfoque puro)
    public Stack<ObjDato> eliminarPila(Stack<ObjDato> p, int numero, Scanner sc) {
        Stack<ObjDato> aux = new Stack<>();
        System.out.println("Eliminar todos repetidos 1, eliminar solo el primero 2");
        int opt = v.ValidarEntero(sc);
        boolean encontrado = true;

        if (opt == 1) {
            while (!p.isEmpty()) {
                if (p.peek().getNumero() == numero) {
                    p.pop();
                } else {
                    aux.push(p.pop());
                }
            }
        } else {
            while (!p.isEmpty()) {
                if (p.peek().getNumero() == numero && encontrado) {
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

    // Método 2 — por índice
    public Stack<ObjDato> eliminarPilaIndice(Stack<ObjDato> p, int numero) {
        for (int i = p.size() - 1; i >= 0; i--) {
            if (p.get(i).getNumero() == numero) {
                p.remove(i);
            }
        }
        return p;
    }

    // Método 3 — lambda
    public Stack<ObjDato> eliminarPilaLambda(Stack<ObjDato> p, int numero) {
        p.removeIf(o -> o.getNumero() == numero);
        return p;
    }

}