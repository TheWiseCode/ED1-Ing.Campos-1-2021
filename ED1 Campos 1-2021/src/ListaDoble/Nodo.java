package ListaDoble;

/**
 *
 * @author willy
 */
public class Nodo {
    private int dato;
    private Nodo ant;
    private Nodo sig; 
    
    public Nodo(){
        sig = null;
        ant = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }
}
