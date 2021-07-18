package datos;

import java.io.Serializable;

/**
 *
 * @author willy
 */
public class Agenda implements Serializable{
    private int cont;
    private int max = 10;
    private Contacto[] contactos;
    
    public Agenda(){
        contactos = new Contacto[max];
        cont = 0;
    }
    
    public void añadir(String nombre, String apellido, int numero,
            boolean esMovil, String grupo){
        if(cont < max){
            contactos[cont] = new Contacto(nombre, apellido, numero, esMovil, grupo);
            cont++;
        }else{
            //REDIMENSIONAN
            contactos[cont] = new Contacto(nombre, apellido, numero, esMovil, grupo);
            cont++;
        }
    }
    
    public Contacto getContacto(int pos){
        return contactos[pos];
    }
    
    public String getContactoString(int pos){
        return contactos[pos].toString();
    }
    
    public void editar(int pos){
        
    }
    
    public void eliminar(int pos){
        
    }
}
