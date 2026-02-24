package co.edu.uniquindio.poo;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== CONVERSOR DE SISTEMAS NUMÉRICOS ===");
        System.out.println("1. Decimal → Binario");
        System.out.println("2. Binario → Decimal");
        System.out.println("3. Decimal → Hexadecimal");
        System.out.println("4. Hexadecimal → Decimal");
        System.out.println("5. Binario → Hexadecimal");
        System.out.println("6. Hexadecimal → Binario");

        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch(opcion) {

            case 1: {
                System.out.print("Ingrese número decimal: ");
                int decimal = scanner.nextInt();

                System.out.print("Ingrese longitud en bits: ");
                int bits = scanner.nextInt();

                String binario = Integer.toBinaryString(decimal);
                String resultado = String.format("%" + bits + "s", binario).replace(' ', '0');

                System.out.println("Resultado: " + resultado);
                break;
            }

            case 2: {
                System.out.print("Ingrese número binario: ");
                String binario = scanner.nextLine();

                int decimal = Integer.parseInt(binario, 2);

                System.out.println("Resultado: " + decimal);
                break;
            }

            case 3: {
                System.out.print("Ingrese número decimal: ");
                int decimal = scanner.nextInt();

                System.out.print("Ingrese ancho en dígitos: ");
                int ancho = scanner.nextInt();

                String hex = Integer.toHexString(decimal).toUpperCase();
                String resultado = String.format("%" + ancho + "s", hex).replace(' ', '0');

                System.out.println("Resultado: " + resultado);
                break;
            }

            case 4: {
                System.out.print("Ingrese número hexadecimal: ");
                String hex = scanner.nextLine();

                int decimal = Integer.parseInt(hex, 16);

                System.out.println("Resultado: " + decimal);
                break;
            }

            case 5: {
                System.out.print("Ingrese número binario: ");
                String binario = scanner.nextLine();

                System.out.print("Ingrese ancho en dígitos hexadecimales: ");
                int ancho = scanner.nextInt();

                int decimal = Integer.parseInt(binario, 2);
                String hex = Integer.toHexString(decimal).toUpperCase();
                String resultado = String.format("%" + ancho + "s", hex).replace(' ', '0');

                System.out.println("Resultado: " + resultado);
                break;
            }

            case 6: {
                System.out.print("Ingrese número hexadecimal: ");
                String hex = scanner.nextLine();

                int decimal = Integer.parseInt(hex, 16);
                String binario = Integer.toBinaryString(decimal);

                System.out.println("Resultado: " + binario);
                break;
            }

            default:
                System.out.println("Opción inválida");
        }

        scanner.close();
    }
}
