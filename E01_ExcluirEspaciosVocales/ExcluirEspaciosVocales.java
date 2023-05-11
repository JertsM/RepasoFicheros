package E01_ExcluirEspaciosVocales;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementa un programa que lea el contenido de un fichero y muestre por pantalla todos aquellos caracteres de su contenido, exceptuando los espacios y las vocales.
 */
public class ExcluirEspaciosVocales {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("E01.txt");
            int c;
            while ((c = fr.read()) != -1)
                if (c != 32 && c != 97 && c != 101 && c != 105 && c != 111 && c != 117)
                    System.out.print((char) c);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
