package Ejercicio6Boletin;

import java.io.*;

/**
 * Desarrolla un programa que lea los datos de un fichero de texto y que vuelque en otro
 * fichero todas las líneas del primero cuyo contenido esté en mayúsculas.
 */

public class Ejercicio6Boletin {

    public static void main(String[] args) {
        File fic = new File("datosEj6.txt");
        File fic2 = new File("datosEj6_mayus.txt");
        try(FileReader fr = new FileReader(fic);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(fic2)){
            String s;
            while((s = br.readLine()) != null){
                if(s.toUpperCase().equals(s)){
                    fw.write(s + '\n');
                }
            }
            System.out.println("Copia realizada.");

        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
