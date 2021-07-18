package datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willy
 */
public class Archivos {
    
    
    public Archivos(){
        
    }
    
    public void ejemploArchivo() throws IOException{
        File f = new File("");
        String ruta = f.getAbsolutePath() + "\\agenda.wam";
        File f1 = new File(ruta);
        System.out.println(ruta);
        if(f1.exists()){
            f1.delete();//Elimina fisicamente el archivo
            System.out.println("Existe");
        }else{
            try {
                ObjectOutputStream fileOut = 
                        new ObjectOutputStream(new FileOutputStream(ruta));
                Object agenda = new Agenda();
                fileOut.writeObject(agenda);
                fileOut.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //RECUPERAR DATOS DE ARCHIVOS BINARIOS
    /*
    FileInputStream file = new FileInputStream(rutaDelArchivo);
    ObjectInputStream fileIn = new ObjectInputStream(file);
    */
    
    
    public static void main(String[] args) {
        Archivos a = new Archivos();
        try {
            a.ejemploArchivo();
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
