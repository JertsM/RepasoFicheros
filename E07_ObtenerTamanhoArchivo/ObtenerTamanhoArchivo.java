package Ejercicios1_8.E07_ObtenerTamanhoArchivo;

import java.io.File;
import java.util.Scanner;

/**
 * 7) Escribir un programa Java para obtener el tamaño del archivo en bytes y KB.
 */
public class ObtenerTamanhoArchivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la ruta del fichero a comprobar: ");
        String ruta = sc.nextLine();
        File rutaFichero = new File(ruta);
        if (rutaFichero.exists()) {
            System.out.println("El tamaño del archivo en bytes es de: " + rutaFichero.length());
            System.out.println("El tamaño del archivo en KB es de: " + rutaFichero.length() / 1000);
        }
    }
}
