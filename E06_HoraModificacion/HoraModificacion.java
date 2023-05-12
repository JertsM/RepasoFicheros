package Ejercicios1_8.E06_HoraModificacion;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 6) Escribir un programa Java para obtener la última hora de modificación de un archivo.
 */
public class HoraModificacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la ruta del fichero a comprobar: ");
        String ruta = sc.nextLine();
        File rutaFichero = new File(ruta);
        if (rutaFichero.exists())
            System.out.println("La hora de modificación más reciente del fichero es: " + new Date(rutaFichero.lastModified()));
    }
}
