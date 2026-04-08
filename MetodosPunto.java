import java.util.Scanner;
import java.util.Stack;

public class MetodosPunto {

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

    public Stack<Integer> validarYReemplazar(Stack<Integer> p) {
        for (int i = 0; i < p.size(); i++) {
            int numero = p.get(i);

            if (numero < 0) {
                p.set(i, 0);
            } else if (numero >= 8 && numero <= 20) {
                p.set(i, 50);
            } else if (numero > 60 && numero < 62) {
                p.set(i, 100);
            }
        }
        return p;
    }

}