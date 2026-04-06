import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MetodosColaObj {

    Validaciones v = new Validaciones();

    public Queue<ObjDato> llenarCola(Queue<ObjDato> c, Scanner sc) {
        boolean pedir = true;
        int opt = 0;
        while (pedir) {
            ObjDato o = new ObjDato();
            System.out.println("Ingrese el numero");
            o.setNumero(v.ValidarEntero(sc));
            c.offer(o);
            System.out.println("Desea ingresar mas registros 1) si , 2) no");
            opt = v.ValidarEntero(sc);
            opt = v.ValidarRango(1, 2, opt, sc);
            if (opt == 2) {
                pedir = false;
            }
        }
        return c;
    }

    public void mostrarCola(Queue<ObjDato> c) {
        System.out.print("cola: [");
        int i = 0;
        for (ObjDato o : c) {
            System.out.print(o.getNumero());
            if (i < c.size() - 1) System.out.print(", ");
            i++;
        }
        System.out.println("]");
    }

    public Queue<ObjDato> modificarCola(Queue<ObjDato> c, int numero, Scanner sc) {
        System.out.println("Ingrese el nuevo valor");
        int nuevoValor = v.ValidarEntero(sc);
        for (ObjDato o : c) {
            if (o.getNumero() == numero) {
                o.setNumero(nuevoValor);
            }
        }
        return c;
    }

    // Método 1 — por índice
    public Queue<ObjDato> eliminarColaIndice(Queue<ObjDato> c, int numero) {
        LinkedList<ObjDato> lista = (LinkedList<ObjDato>) c;
        for (int i = lista.size() - 1; i >= 0; i--) {
            if (lista.get(i).getNumero() == numero) {
                lista.remove(i);
            }
        }
        return c;
    }

    // Método 2 — lambda
    public Queue<ObjDato> eliminarColaLambda(Queue<ObjDato> c, int numero) {
        c.removeIf(o -> o.getNumero() == numero);
        return c;
    }

}