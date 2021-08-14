package datos;

import java.io.Serializable;

/**
 *
 * @author willy
 */
public class Agenda implements Serializable {

    public int contador;
    private int max = 10;
    private Contacto[] contactos;

    public Agenda() {
        contactos = new Contacto[max];
        contador = 0;
    }

    public void añadir(String nombre, String apellido, int numero,
            boolean esMovil, String grupo) {
        if (contador < max) {
            contactos[contador] = new Contacto(nombre, apellido, numero, esMovil, grupo);
            contador++;
        } else {
            //REDIMENSIONAN
            contactos[contador] = new Contacto(nombre, apellido, numero, esMovil, grupo);
            contador++;
        }
    }
    
    public void añadir(Contacto contacto){
        if (contador < max) {
            contactos[contador] = contacto;
            contador++;
        } else {
            //REDIMENSIONAN
            contactos[contador] = contacto;
            contador++;
        }
    }

    public Contacto getContacto(int pos) {
        return contactos[pos];
    }

    public String getContactoString(int pos) {
        return contactos[pos].toString();
    }

    public void editar(int pos, String nombre, String apellido, int numero,
            boolean esMovil, String grupo) {
        if (pos >= 0 && pos < contador) {
            contactos[pos] = new Contacto(nombre, apellido, numero, esMovil, grupo);
        }
    }

    public void eliminar(int pos) {
        for (int k = pos; k < contador; k++) {
            contactos[k] = contactos[k + 1];
        }
        contador--;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < contador; i++) {
            s += contactos[i].toString() + "\n";
        }
        return s;
    }
}
