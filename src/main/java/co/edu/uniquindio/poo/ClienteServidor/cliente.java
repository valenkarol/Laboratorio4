package co.edu.uniquindio.poo.ClienteServidor;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class cliente {

    public static void main(String[] args) {

        // CAMBIA ESTA IP SI ES OTRO COMPUTADOR
        String host = "192.168.1.15"; //ip servidor wifi ipconfig
        int puerto = 5000;

        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket(host, puerto);

            PrintWriter salida = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            System.out.println("=== MENU ===");
            System.out.println("1. Decimal → Binario");
            System.out.println("2. Binario → Decimal");
            System.out.println("3. Decimal → Hexadecimal");
            System.out.println("4. Hexadecimal → Decimal");
            System.out.println("5. Binario → Hexadecimal");
            System.out.println("6. Hexadecimal → Binario");

            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            String mensaje = "";

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese numero decimal: ");
                    int dec = scanner.nextInt();

                    System.out.print("Ingrese numero de bits: ");
                    int bits = scanner.nextInt();

                    mensaje = "1;" + dec + ";" + bits;
                    break;

                case 2:
                    System.out.print("Ingrese numero binario: ");
                    String bin = scanner.next();

                    mensaje = "2;" + bin;
                    break;

                case 3:
                    System.out.print("Ingrese numero decimal: ");
                    int decHex = scanner.nextInt();

                    System.out.print("Ingrese numero de digitos hex: ");
                    int dig = scanner.nextInt();

                    mensaje = "3;" + decHex + ";" + dig;
                    break;

                case 4:
                    System.out.print("Ingrese numero hexadecimal: ");
                    String hex = scanner.next();

                    mensaje = "4;" + hex;
                    break;

                case 5:
                    System.out.print("Ingrese numero binario: ");
                    String binHex = scanner.next();

                    System.out.print("Ingrese numero de digitos hex: ");
                    int digitos = scanner.nextInt();

                    mensaje = "5;" + binHex + ";" + digitos;
                    break;

                case 6:
                    System.out.print("Ingrese numero hexadecimal: ");
                    String hexBin = scanner.next();

                    mensaje = "6;" + hexBin;
                    break;

                default:
                    System.out.println("Opcion no valida");
                    socket.close();
                    return;
            }

            // Enviar mensaje
            salida.println(mensaje);

            // Recibir respuesta
            String respuesta = entrada.readLine();

            System.out.println("Resultado: " + respuesta);

            socket.close();

        } catch (IOException e) {
            System.out.println("Error de conexion");
            e.printStackTrace();
        }
    }
}
