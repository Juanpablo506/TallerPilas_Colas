import java.util.Scanner;

public class Validaciones {

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor digite un numero");
            sc.nextLine();
        }
        return sc.nextInt();
    }

    public Double ValidarDecimal(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Por favor digite un numero decimal");
            sc.nextLine();
        }
        return sc.nextDouble();
    }

    public int ValidarRango(int n1, int n2, int numero, Scanner sc) {
        while (numero < n1 || numero > n2) {
            System.out.println("Por favor ingrese un valor entre " + n1 + " y " + n2);
            numero = ValidarEntero(sc);
        }
        return numero;
    }
}