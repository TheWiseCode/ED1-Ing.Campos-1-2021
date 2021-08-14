package datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willy
 */
public class Archivos {

    private String ruta;
    public Agenda agenda;

    public Archivos() {
        File f = new File("");
        ruta = f.getAbsolutePath() + "\\agenda.wam";
        agenda = new Agenda();
    }

    public void guardarArchivo() throws IOException {
        try {
            ObjectOutputStream fileOut
                    = new ObjectOutputStream(new FileOutputStream(ruta));
            fileOut.writeObject(agenda);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void leerArchivo() throws IOException {
        ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(ruta));
        try {
            Object o = fileIn.readObject();
            agenda = (Agenda) o;
            fileIn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ejemploArchivo() throws IOException {
        File f1 = new File(ruta);
        if (f1.exists()) {
            leerArchivo();
            System.out.println("Existe");
        } else {
            guardarArchivo();
            System.out.println("Guardado");
        }
    }
    
    public void mostrarAgenda(){
        System.out.println(agenda.toString());
    }

    public static void main(String[] args) {
        Archivos a = new Archivos();
        try {
            /*a.agenda.añadir("Carlos", "Villagram", 7237823, true, "amigos");
            a.agenda.añadir("Pedro", "Villagram", 6237823, true, "familia");
            a.agenda.añadir("Marco", "Villagram", 7237823, true, "amigos");
            a.agenda.añadir("Juan", "Villagram", 6237823, true, "familia");
            a.agenda.añadir("Damian", "Villagram", 7237823, true, "amigos");
            a.agenda.añadir("Jorge", "Villagram", 6237823, true, "familia");
            a.guardarArchivo();*/
            
            //a.leerArchivo();
            //a.agenda.editar(2, "Esther", "Villagram", 6237823, true, "familia");
            //a.guardarArchivo();
            
            //a.leerArchivo();
            //a.mostrarAgenda();
            
            /*a.agenda.eliminar(0);
            a.agenda.eliminar(0);
            a.guardarArchivo();*/
            
            /*a.leerArchivo();
            a.mostrarAgenda();*/
            
            //Guardar
            a.guardarArchivo();
            
            //Leeer y mostrar
            a.leerArchivo();
            a.mostrarAgenda();
            
            //Sobreescribir
            a.leerArchivo();
            a.agenda.añadir("Jorge", "Villagram", 6237823, true, "familia");
            a.guardarArchivo();
            
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
