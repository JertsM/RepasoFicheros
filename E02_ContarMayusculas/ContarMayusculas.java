package E02_ContarMayusculas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementa un programa que lea el contenido de un fichero y cuente el número de letras mayúsculas.
 */
public class ContarMayusculas {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("E02.txt");
            int m, contador = 0;
            while ((m = fr.read()) != -1)
                if (m >= 65 && m <= 90)
                    contador++;
            System.out.println("El número de mayúsculas de este fichero es de " + contador + " caracteres.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
