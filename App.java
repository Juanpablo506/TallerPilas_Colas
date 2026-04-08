import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        Scanner sc   = new Scanner(System.in);
        Metodos m   = new Metodos();
        Stack<Obj> p = new Stack<>();
        Validar v = new Validar();
        boolean c = true;
        while (c) {
            System.out.println("-----------------------------");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Llenar pila");
            System.out.println("2. Mostrar pila");
            System.out.println("3. Pasar a colas");
            System.out.println("4. Salir");
            switch (v.ValidarRango(1, 4, v.ValidarInt(sc), sc)) {
                case 1:
                    p = m.LlenarPila(p);
                    break;
                case 2:
                    m.MostrarPila(p);
                    break;
                case 3:
                    m.Cola(p);
                    break;
                case 4:
                    c = false;
                    break;
            }
        }
    }
}
