package E05_Aleatorios_IntercambioFicheros;

import java.io.*;
import java.lang.management.MemoryType;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;

/**
 * Programa que abra un fichero y escriba 100 valores numéricos enteros
 * obtenidos aleatoriamente.
 * A continuación, el programa deberá mostrar su contenido
 * en pantalla y calcular su media.
 * Si se abre el fichero con el bloc de notas veremos que
 * algunos caracteres son legibles.
 */

public class IntercambioFicherosAleatorios {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    valoresAleatorios();
                    break;
                case 2:
                    intercambiarContenido();
                    break;
            }
        } while (opcion != 0);

    }

    public static int menu(){
        System.out.println("-- Streams --");
        System.out.println("1-- Fichero con 100 valores");
        System.out.println("2-- Intercambiar contenido");
        System.out.println("0-- Salir");
        return Integer.parseInt(teclado.nextLine());
    }
    public static void valoresAleatorios(){
        DataOutputStream escribirFichero;
        DataInputStream leerFichero;

        try{
            escribirFichero = new DataOutputStream(Files.newOutputStream(Paths.get("NumRandom.txt"), CREATE, APPEND));
            leerFichero = new DataInputStream(new FileInputStream("NumRandom.txt"));

            for (int i = 0; i < 100; i++){
                escribirFichero.writeInt((int) Math.random()*100);
            }

            int total = 0;
            int contador = 0;

            while(leerFichero.available() != 0){
                int temp = leerFichero.readInt();
                System.out.println(temp + " ");
                total += temp;
                contador++;
            }

            System.out.println("El total de números es de " + total);
            System.out.println("La media de los números aleatorios es " + (total/contador));

            if(contador > 100){
                try(OutputStream fic = Files.newOutputStream(Paths.get("NumRandom.txt"), DELETE_ON_CLOSE)){
                    System.out.println("Se han excedido los 100 números. Fichero eliminado");
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void intercambiarContenido(){

        File Temp;
        DataOutputStream escribirFichero1, escribirFichero2, escribirFicheroTemporal;
        DataInputStream leerFichero1, leerFichero2, leerFicheroTemporal;

        try{
            // Creación de archivos
            Temp = File.createTempFile("Temporal", ".txt");
            leerFichero1 = new DataInputStream(new FileInputStream("FICHERO1.txt"));
            escribirFicheroTemporal = new DataOutputStream(new FileOutputStream(Temp));

            // Escribirá en el fichero temporal aquello que lea en el fichero 1.
            while(leerFichero1.available() != 0){
                escribirFicheroTemporal.writeInt(leerFichero1.read());
            }

            //Cerramos los ficheros.
            leerFichero1.close();
            escribirFicheroTemporal.close();

            leerFichero2 = new DataInputStream(new FileInputStream("FICHERO2.txt"));
            escribirFichero1 = new DataOutputStream(new FileOutputStream("FICHERO1.txt"));

            while(leerFichero2.available() != 0){
                escribirFichero1.writeInt(leerFichero2.read());
            }

            leerFichero2.close();
            escribirFichero1.close();

            leerFicheroTemporal  = new DataInputStream(new FileInputStream(Temp));
            escribirFichero2 = new DataOutputStream(new FileOutputStream("FICHERO2.txt"));

            while(leerFichero2.available() != 0){
                escribirFichero2.writeInt(leerFicheroTemporal.read());
            }

            leerFicheroTemporal.close();
            escribirFichero2.close();

            System.out.println((Temp.delete() ? "Temporal eliminado con exito" : "No se pudo eliminar el temporal"));

        } catch (IOException e) {
            System.err.println("Error al manipular el archivo");
        }


    }
}
