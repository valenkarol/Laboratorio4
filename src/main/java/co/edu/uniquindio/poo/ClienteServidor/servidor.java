package co.edu.uniquindio.poo.ClienteServidor;

import java.io.*;
import java.net.*;

public class servidor {

    public static void main(String[] args) {
        int puerto = 5000;

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor esperando conexiones en el puerto " + puerto + "...");

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado");

                BufferedReader entrada = new BufferedReader(
                        new InputStreamReader(cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(
                        cliente.getOutputStream(), true);

                // Leer mensaje
                String mensaje = entrada.readLine();
                System.out.println("Mensaje recibido: " + mensaje);

                // Procesar mensaje
                String respuesta = procesarMensaje(mensaje);

                // Enviar respuesta
                salida.println(respuesta);

                cliente.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String procesarMensaje(String mensaje) {
        try {
            String[] partes = mensaje.split(";");

            int opcion = Integer.parseInt(partes[0]);

            switch (opcion) {

                case 1: // Decimal → Binario
                    int decimal = Integer.parseInt(partes[1]);
                    int bits = Integer.parseInt(partes[2]);
                    return decimalABinario(decimal, bits);

                case 2: // Binario → Decimal
                    return String.valueOf(Integer.parseInt(partes[1], 2));

                case 3: // Decimal → Hexadecimal
                    int dec = Integer.parseInt(partes[1]);
                    int digitos = Integer.parseInt(partes[2]);
                    return decimalAHex(dec, digitos);

                case 4: // Hexadecimal → Decimal
                    return String.valueOf(Integer.parseInt(partes[1], 16));

                case 5: // Binario → Hexadecimal
                    int num = Integer.parseInt(partes[1], 2);
                    int dig = Integer.parseInt(partes[2]);
                    return decimalAHex(num, dig);

                case 6: // Hexadecimal → Binario
                    int numero = Integer.parseInt(partes[1], 16);
                    return Integer.toBinaryString(numero);

                default:
                    return "ERROR: Operacion no valida";
            }

        } catch (Exception e) {
            return "ERROR: Formato incorrecto";
        }
    }

    public static String decimalABinario(int numero, int bits) {
        String bin = Integer.toBinaryString(numero);

        while (bin.length() < bits) {
            bin = "0" + bin;
        }

        return bin;
    }

    public static String decimalAHex(int numero, int digitos) {
        String hex = Integer.toHexString(numero).toUpperCase();

        while (hex.length() < digitos) {
            hex = "0" + hex;
        }

        return hex;
    }
}