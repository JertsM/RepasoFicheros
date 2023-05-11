package E04_ValoresAleatorios;

import java.io.DataInput;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.*;

/**
 * Crea un programa que almacene 100 números aleatorios dentro de un fichero, realiza la media, indica cuántos números contiene el fichero y envía una advertencia si se supera el número de valores
 */
public class ValoresAleatorios {
    public static void main(String[] args) {
        DataOutputStream escribirFicheros;
        DataInputStream leerFicheros;
        try {
            escribirFicheros = new DataOutputStream(Files.newOutputStream(Paths.get("NumRandom.txt"), CREATE, APPEND));
            leerFicheros = new DataInputStream(new FileInputStream("NumRandom.txt"));
            for (int i = 0; i < 100; i++) {
                escribirFicheros.writeInt((int) (Math.random() * 100));
            }
            int total = 0, contador = 0;
            while (leerFicheros.available() != 0) {
                int temp = leerFicheros.readInt();
                System.out.println(temp + " ");
                total += temp;
                contador++;
            }
            System.out.println("El total de números es de " + total);
            System.out.println("La media de los números del fichero es de " + (total / contador));
            if (contador > 100)
                try (OutputStream fic = Files.newOutputStream(Paths.get("NumRandom.txt"), DELETE_ON_CLOSE)) {
                    System.out.println("Se han excedido los 100 números aleatorios. Fichero eliminado.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
