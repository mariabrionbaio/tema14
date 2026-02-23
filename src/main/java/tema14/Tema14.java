package tema14;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Tema14 {

    public static void main(String[] args) {
        //1º ESCRITURA: escribir nun ficheiro un array de Obxectos da clase Persona
        Persona[] pers = {new Persona("Pedro", "981222333", 1234.34f),
                          new Persona("Juan", "982444555", 2222.34f),
                          new Persona("Ana", "666111222", 1555.50f)};
        
        //primeiro temos que crear fichero.dat dentro da carpeta raíz do noso proxecto
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fichero.dat"))) {
            //recorremos o array de persoas e imos escribindo cada unha no ficheiro fichero.dat 
            for (int cont = 0; cont < pers.length; cont++) {
                oos.writeObject(pers[cont]);
            }
        } catch (IOException ex) {
            // tratamiento de la excepción, por ejemplo: 
            ex.printStackTrace();
        }
        
        //2º LECTURA: ir lendo un ficheiro e engadindo os obxectos nun arrayList da clase Persona
        List<Persona> personas = new ArrayList<>(); //creamos o arraylist vacío
        boolean eof = false; //variable que representa el final del fichero
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fichero.dat"))) { 
            while (!eof) {
                personas.add((Persona) ois.readObject()); //imos engadindo no array personas cada Obxecto que atopamos no ficheiro
            }
        }catch (EOFException e) { 
            eof = true;
        }catch (IOException | ClassNotFoundException e) { 
            // tratamiento de la excepción, por ejemplo: 
             e.printStackTrace();
        }
        //Agora recorro o arrayList personas e imprimo cada unha por pantalla
        for(Persona p: personas){
            System.out.println(p.toString());
        }
    }
}
    