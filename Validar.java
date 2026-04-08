import java.util.Scanner;

public class Validar {
    public int ValidarInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Ingrese un número entero válido:");
            sc.nextLine();
        }
        return sc.nextInt();
    }

    public double ValidarDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Ingrese un número decimal válido:");
            sc.nextLine();
        }
        return sc.nextDouble();
    }

    public int ValidarRango(int num1, int num2, int num, Scanner sc) {
        while (num < num1 || num > num2) {
            System.out.println("Ingrese un número entre " + num1 + " y " + num2 + ":");
            num = ValidarInt(sc);
        }
        return num;
    }

    public boolean ValidarPar(int num) {
        boolean sel;
        if (num % 2 != 0) {
            sel = true;
        }else {
            sel = false;
        }
        
        return sel;
    }
}
