import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MenuObj {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Validaciones v = new Validaciones();
        MetodosPilaObj mp = new MetodosPilaObj();
        MetodosColaObj mc = new MetodosColaObj();
        MetodosListaObj ml = new MetodosListaObj();

        Stack<ObjDato> pila = new Stack<>();
        Queue<ObjDato> cola = new LinkedList<>();
        LinkedList<ObjDato> lista = new LinkedList<>();

        System.out.println("Que desea usar?");
        System.out.println("1) Pila");
        System.out.println("2) Cola");
        System.out.println("3) Lista");
        int estructura = v.ValidarRango(1, 3, v.ValidarEntero(sc), sc);

        boolean seguir = true;
        int opt = 0, numero = 0;

        while (seguir) {

            System.out.println("Que desea realizar: ");

            if (estructura == 1) {
                System.out.println("1) llenar Pila");
                System.out.println("2) mostrar Pila");
                System.out.println("3) Modificar Pila");
                System.out.println("4) eliminar Pila");
            } else if (estructura == 2) {
                System.out.println("1) llenar Cola");
                System.out.println("2) mostrar Cola");
                System.out.println("3) Modificar Cola");
                System.out.println("4) eliminar Cola");
            } else {
                System.out.println("1) llenar Lista");
                System.out.println("2) mostrar Lista");
                System.out.println("3) Modificar Lista");
                System.out.println("4) eliminar Lista");
            }

            System.out.println("5) Salir");
            opt = v.ValidarEntero(sc);

            switch (opt) {

                case 1:
                    if (estructura == 1) pila = mp.llenarPila(pila, sc);
                    else if (estructura == 2) cola = mc.llenarCola(cola, sc);
                    else lista = ml.llenarLista(lista, sc);
                    break;

                case 2:
                    if (estructura == 1) mp.mostrarPila(pila);
                    else if (estructura == 2) mc.mostrarCola(cola);
                    else ml.mostrarLista(lista);
                    break;

                case 3:
                    System.out.println("Ingrese el numero a modificar");
                    numero = v.ValidarEntero(sc);
                    if (estructura == 1) pila = mp.modificarPila(pila, numero, sc);
                    else if (estructura == 2) cola = mc.modificarCola(cola, numero, sc);
                    else lista = ml.modificarLista(lista, numero, sc);
                    break;

                case 4:
                    System.out.println("Ingrese el numero a eliminar");
                    numero = v.ValidarEntero(sc);
                    if (estructura == 1) {
                        System.out.println("que metodo desea implementar 1) el depilas, 2) el listas , 3) funcion anonima");
                        int met = sc.nextInt();
                        switch (met) {
                            case 1:
                                pila = mp.eliminarPila(pila, numero, sc);
                                break;
                            case 2:
                                pila = mp.eliminarPilaIndice(pila, numero);
                                break;
                            default:
                                pila = mp.eliminarPilaLambda(pila, numero);
                                break;
                        }
                    } else if (estructura == 2) {
                        System.out.println("que metodo desea implementar 1) el listas , 2) funcion anonima");
                        int met = sc.nextInt();
                        switch (met) {
                            case 1:
                                cola = mc.eliminarColaIndice(cola, numero);
                                break;
                            default:
                                cola = mc.eliminarColaLambda(cola, numero);
                                break;
                        }
                    } else {
                        System.out.println("que metodo desea implementar 1) el listas , 2) funcion anonima");
                        int met = sc.nextInt();
                        switch (met) {
                            case 1:
                                lista = ml.eliminarListaIndice(lista, numero);
                                break;
                            default:
                                lista = ml.eliminarListaLambda(lista, numero);
                                break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Gracias por venir");
                    seguir = false;
                    break;

                default:
                    System.out.println("Por favor ingrese un numero entre 1 y 5");
                    break;
            }
        }
    }
}