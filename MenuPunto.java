import java.util.Scanner;
import java.util.Stack;

public class MenuPunto {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Validaciones v = new Validaciones();
        MetodosPunto mp = new MetodosPunto();

        Stack<Integer> pila = new Stack<>();

        boolean seguir = true;
        int opt = 0;

        while (seguir) {

            System.out.println("Que desea realizar");
            System.out.println("1) llenar Pila");
            System.out.println("2) mostrar Pila");
            System.out.println("3) validar y reemplazar");
            System.out.println("4) Salir");
            opt = v.ValidarEntero(sc);

            switch (opt) {

                case 1:
                    pila = mp.llenarPila(pila, sc);
                    break;

                case 2:
                    mp.mostrarPila(pila);
                    break;

                case 3:
                    pila = mp.validarYReemplazar(pila);
                    System.out.println("Pila actualizada");
                    mp.mostrarPila(pila);
                    break;

                case 4:
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