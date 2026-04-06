import java.util.LinkedList;
import java.util.Scanner;

public class MetodosListaObj {

    Validaciones v = new Validaciones();

    public LinkedList<ObjDato> llenarLista(LinkedList<ObjDato> l, Scanner sc) {
        boolean pedir = true;
        int opt = 0;
        while (pedir) {
            ObjDato o = new ObjDato();
            System.out.println("Ingrese el numero");
            o.setNumero(v.ValidarEntero(sc));
            l.add(o);
            System.out.println("Desea ingresar mas registros 1) si , 2) no");
            opt = v.ValidarEntero(sc);
            opt = v.ValidarRango(1, 2, opt, sc);
            if (opt == 2) {
                pedir = false;
            }
        }
        return l;
    }

    public void mostrarLista(LinkedList<ObjDato> l) {
        System.out.print("lista: [");
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i).getNumero());
            if (i < l.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public LinkedList<ObjDato> modificarLista(LinkedList<ObjDato> l, int numero, Scanner sc) {
        System.out.println("Ingrese el nuevo valor");
        int nuevoValor = v.ValidarEntero(sc);
        for (ObjDato o : l) {
            if (o.getNumero() == numero) {
                o.setNumero(nuevoValor);
            }
        }
        return l;
    }

    // Método 1 — por índice
    public LinkedList<ObjDato> eliminarListaIndice(LinkedList<ObjDato> l, int numero) {
        for (int i = l.size() - 1; i >= 0; i--) {
            if (l.get(i).getNumero() == numero) {
                l.remove(i);
            }
        }
        return l;
    }

    // Método 2 — lambda
    public LinkedList<ObjDato> eliminarListaLambda(LinkedList<ObjDato> l, int numero) {
        l.removeIf(o -> o.getNumero() == numero);
        return l;
    }

}