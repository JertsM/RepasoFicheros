package E03_ContarLineas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementa un programa que lea el contenido de un fichero y cuente el número de líneas que tiene el fichero.
 * */

public class ContarLineas {

    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("E03.txt");
            int l;
            int contadorLineas = 1;
            while((l = fr.read()) != -1){
                if(l == 10){
                    contadorLineas++;
                }
            }
            System.out.println("El número de líneas del fichero es " + contadorLineas + ".");


        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
