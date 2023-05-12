package Ejercicios1_8.E08_CrearEstructura;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 8) Programa que cree una carpeta en una ruta especificada, y dos archivos en dicha carpeta. A continuación listar sus nombres y eliminar uno de ellos.
 */

public class CrearEstructura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la ruta donde quiera crear la estructura: ");
        String ruta = sc.nextLine();
        File rutaFichero = new File(ruta);
        if(rutaFichero.mkdir()){
            System.out.println("Fichero cargado.");
            System.out.println("Creando ficheros...");
            File archivo1 = new File(ruta + "/archivo1.txt");
            File archivo2 = new File(ruta + "/archivo2.txt");

            try{
                System.out.println(archivo1.createNewFile() ? "El primer fichero se ha creado satisfactoriamente" : "No se ha podido crear el primer fichero");
                System.out.println(archivo1.createNewFile() ? "El segundo fichero se ha creado satisfactoriamente" : "No se ha podido crear el segundo fichero");
            } catch (IOException e) {
                System.out.println("Error");;
            }

            System.out.println("Nombres: ");
            String[] ficheros = rutaFichero.list();
            for(int i = 0; i < ficheros.length; i++){
                System.out.println(" - " + ficheros[i]);
            }

            if(archivo2.delete()){
                System.out.println("El archivo 2 ha sido eliminado");
            }else{
                System.out.println("No se ha podido crear la carpeta.");
            }
        }
    }
}
