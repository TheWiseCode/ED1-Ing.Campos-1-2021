package EF.Pregu1;

/**
 *
 * @author willy
 */
public class Nodo {
    public int izq, der;
    public Nodo enlace;
    
    public Nodo(){
        enlace = null;
    }
    
    public Nodo(int i, int d){
        izq = i;
        der = d;
        enlace = null;
    }
}
