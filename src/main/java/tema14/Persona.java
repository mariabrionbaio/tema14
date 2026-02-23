package tema14;

import java.io.Serializable;

public class Persona implements Serializable { //(import.java.io.*)

    public String nombre;
    public String telefono;
    public float sueldo;

    public Persona(String nombre, String telefono, float sueldo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Teléfono: " + telefono + " - Sueldo: " + sueldo + "€\n";

    }
}
