package tema14.exercizo_14_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Exercizo_14_1 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        Path ruta = Path.of("archivos\\fich01.txt");
        
        //escribo nun arquivo as filas que o usuario vai metende
        try(BufferedWriter bw = Files.newBufferedWriter(ruta,StandardCharsets.UTF_8, StandardOpenOption.CREATE)){
            String linea = "";
            while(!linea.equalsIgnoreCase("FIN")){
                System.out.println("Introduce texto. Para terminar FIN");
                linea = teclado.nextLine();
                if(!linea.equalsIgnoreCase("FIN")) bw.write(linea + "\n");
            }
                   
        }catch(IOException e){
           e.printStackTrace();
        }
        
        //mostro por pantalla as filas do arquivo
        try(BufferedReader br = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)){
            String linea;
            int lin = 1;
            while((linea = br.readLine()) != null){
                System.out.println("línea: " + lin + " - " + linea);
                lin++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
    
}
