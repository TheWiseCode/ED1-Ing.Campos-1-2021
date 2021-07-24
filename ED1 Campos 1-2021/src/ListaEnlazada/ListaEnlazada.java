package ListaEnlazada;

/**
 *
 * @author willy
 */
public class ListaEnlazada {

    private Nodo inicio;
    private int cant;

    public ListaEnlazada() {
        inicio = null;
        cant = 0;
    }

    public void insertar(int num) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(num);
        if (cant == 0) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            Nodo ant = null;
            while (aux != null && aux.getDato() != num && aux.getDato() < num) {
                ant = aux;
                aux = aux.getSig();
            }
            if(aux != null && aux.getDato() == num){
                System.err.println("Elemento ya insertado");
                return;
            }
            if(ant == null){//inicio
                nuevo.setSig(inicio);
                inicio = nuevo;
            }else if(aux == null){//fin
                ant.setSig(nuevo);
            }else{//medio
                ant.setSig(nuevo);
                nuevo.setSig(aux);
            }
        }
        cant++;
    }
    
    public void eliminar(int num){
        Nodo aux = inicio;
        Nodo ant = null;
        while(aux != null && aux.getDato() != num){
            ant = aux;
            aux = aux.getSig();
        }
        if(aux == null){
            System.err.println("Elemento no encontrado");
            return;
        }
        if(ant == null){
            inicio = inicio.getSig();
        }else{
            ant.setSig(aux.getSig());
        }
        cant--;
    }
    
    public int get(int pos){
        int cont = 1;
        Nodo aux = inicio;
        while(aux != null){
            if(pos == cont)
                return aux.getDato();
            aux = aux.getSig();
        }
        return 0;
    }
    
    @Override
    public String toString(){
        String s = "[";
        Nodo aux = inicio;
        while(aux != null){
            s = s + aux.getDato();
            if(aux.getSig() != null)
                s = s + ",";
            aux = aux.getSig();
        }
        return s + "]";
    }
    
    public static void main(String[] args) {
        ListaEnlazada l = new ListaEnlazada();
        l.insertar(3);
        l.insertar(1);
        l.insertar(7);
        l.insertar(4);
        System.out.println(l.toString());
        l.eliminar(3);
        l.eliminar(7);
        l.eliminar(1);
        l.eliminar(4);
        System.out.println(l.toString());
    }
}
