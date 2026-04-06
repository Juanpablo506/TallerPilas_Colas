import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Validaciones v = new Validaciones();
        MetodosPila mp = new MetodosPila();
        MetodosCola mc = new MetodosCola();

        Stack<Integer> pila = new Stack<>();
        Queue<Integer> cola = new LinkedList<>();

        System.out.println("Que desea usar?");
        System.out.println("1) Pila");
        System.out.println("2) Cola");
        int estructura = v.ValidarRango(1, 2, v.ValidarEntero(sc), sc);

        boolean seguir = true;
        int opt = 0, numero = 0;

        while (seguir) {

            System.out.println("Que desea realizar: ");

            if (estructura == 1) {
                System.out.println("1) llenar Pila");
                System.out.println("2) mostrar Pila");
                System.out.println("3) Modificar Pila");
                System.out.println("4) eliminar Pila");
            } else {
                System.out.println("1) llenar Cola");
                System.out.println("2) mostrar Cola");
                System.out.println("3) Modificar Cola");
                System.out.println("4) eliminar Cola");
            }

            System.out.println("5) Salir");
            opt = v.ValidarEntero(sc);

            switch (opt) {

                case 1:
                    if (estructura == 1) pila = mp.llenarPila(pila, sc);
                    else cola = mc.llenarCola(cola, sc);
                    break;

                case 2:
                    if (estructura == 1) mp.mostrarPila(pila);
                    else mc.mostrarCola(cola);
                    break;

                case 3:
                    System.out.println("Ingrese el numero a modificar");
                    numero = v.ValidarEntero(sc);
                    if (estructura == 1) pila = mp.modificarPila(pila, numero, sc);
                    else cola = mc.modificarCola(cola, numero, sc);
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
                    } else {
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