import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MetodosCola {

    Validaciones v = new Validaciones();

    public Queue<Integer> llenarCola(Queue<Integer> c, Scanner sc) {
        boolean pedir = true;
        int opt = 0;
        while (pedir) {
            System.out.println("Ingrese el numero");
            c.offer(v.ValidarEntero(sc));
            System.out.println("Desea ingresar mas registros 1) si , 2) no");
            opt = v.ValidarEntero(sc);
            opt = v.ValidarRango(1, 2, opt, sc);
            if (opt == 2) {
                pedir = false;
            }
        }
        return c;
    }

    public void mostrarCola(Queue<Integer> c) {
        System.out.println("cola: " + c);
    }

    public Queue<Integer> modificarCola(Queue<Integer> c, int numero, Scanner sc) {
        LinkedList<Integer> lista = (LinkedList<Integer>) c;
        System.out.println("Ingrese el nuevo valor");
        int nuevoValor = v.ValidarEntero(sc);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(numero)) {
                lista.set(i, nuevoValor);
            }
        }
        return c;
    }

    // Método 1 — por índice
    public Queue<Integer> eliminarColaIndice(Queue<Integer> c, int numero) {
        LinkedList<Integer> lista = (LinkedList<Integer>) c;
        for (int i = lista.size() - 1; i >= 0; i--) {
            if (lista.get(i).equals(numero)) {
                lista.remove(i);
            }
        }
        return c;
    }

    // Método 2 — lambda
    public Queue<Integer> eliminarColaLambda(Queue<Integer> c, int numero) {
        c.removeIf(x -> x.equals(numero));
        return c;
    }

}