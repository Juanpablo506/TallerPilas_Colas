import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

public class Metodos {
    Scanner sc = new Scanner(System.in);
    Validar v = new Validar();

    public Stack<Obj> LlenarPila(Stack<Obj> p) {
        boolean continuar = true;
        while (continuar) {
            Obj o = new Obj();
            System.out.println("Ingrese un numero:");
            o.setNum(v.ValidarInt(sc));
            p.push(o);
            System.out.println("¿Desea agregar otro número?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            int opcion = v.ValidarRango(1, 2, v.ValidarInt(sc), sc);
            if (opcion == 2) {
                continuar = false;
            }
        }
        return p;
    }

    public void MostrarPila(Stack<Obj> p) {
        System.out.println("Elementos en la pila:");
        for (Obj o : p) {
            System.out.println(o.getNum());
        }
    }

    public void Cola(Stack<Obj> p) {
        Stack<Obj> aux = new Stack<>();
        Queue<Obj> par = new LinkedList<>();
        Queue<Obj> impar = new LinkedList<>();
        while (!p.isEmpty()) {
            aux.push(p.pop());
            int num = aux.peek().getNum();
            if (v.ValidarPar(num)) {
                par.add(aux.peek());

            } else {
                impar.add(aux.peek());
            }
        }
        while (!aux.isEmpty()) {
            p.push(aux.pop());
        }
        System.out.println("Cola de números pares:");
        MostrarCola(par);
        System.out.println("Cola de números impares:");
        MostrarCola(impar);
    }

    public void MostrarCola(Queue<Obj> q) {
        for (Obj o : q) {
            System.out.println(o.getNum());
        }
    }
}
