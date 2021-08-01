package ListaDoble;

/**
 *
 * @author willy
 */
public class ListaDoble {

    private Nodo inicio;
    private Nodo fin;
    private int cant;

    public ListaDoble() {
        inicio = null;
        fin = null;
        cant = 0;
    }

    public boolean vacia() {
        return cant == 0;
    }

    public void insertar(int num) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(num);
        if (cant == 0) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux != null && aux.getDato() != num && aux.getDato() < num) {
                aux = aux.getSig();
            }
            if (aux != null && aux.getDato() == num) {
                System.err.println("Elemento ya insertado");
                return;
            }
            if (aux == inicio) {//inicio
                nuevo.setSig(inicio);
                inicio.setAnt(nuevo);
                inicio = nuevo;
            } else if (aux == null) {//fin
                fin.setSig(nuevo);
                nuevo.setAnt(fin);
                fin = nuevo;
            } else {//medio
                Nodo ante = aux.getAnt();
                ante.setSig(nuevo);
                aux.setAnt(nuevo);
                nuevo.setSig(aux);
                nuevo.setAnt(ante);
            }
        }
        cant++;
    }

    public void eliminar(int num) {
        if (vacia()) {
            return;
        }
        Nodo aux = inicio;
        while (aux != null && aux.getDato() != num) {
            aux = aux.getSig();
        }
        if (aux == null) {
            System.err.println("Elemento no encontrado");
            return;
        }
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            if (aux == inicio) {
                Nodo sigi = inicio.getSig();
                inicio.setSig(null);
                inicio = sigi;
                inicio.setAnt(null);
            } else if (aux == fin) {
                Nodo ante = fin.getAnt();
                fin.setAnt(null);
                fin = ante;
                fin.setSig(null);
            } else {
                Nodo ante = aux.getAnt();
                Nodo sigi = aux.getSig();
                ante.setSig(sigi);
                sigi.setAnt(ante);
                aux.setAnt(null);
                aux.setSig(null);
            }
        }
        cant--;
    }

    public int get(int pos) {
        int cont = 1;
        Nodo aux = inicio;
        while (aux != null) {
            if (pos == cont) {
                return aux.getDato();
            }
            aux = aux.getSig();
        }
        return 0;
    }

    @Override
    public String toString() {
        String s = "[";
        Nodo aux = inicio;
        while (aux != null) {
            s = s + aux.getDato();
            if (aux.getSig() != null) {
                s = s + ",";
            }
            aux = aux.getSig();
        }
        return s + "]";
    }

    public static void main(String[] args) {
        ListaDoble l = new ListaDoble();
        l.insertar(1);
        l.insertar(2);
        l.insertar(3);
        //l.insertar(4);
        System.out.println(l.toString());
        l.eliminar(2);
        //l.eliminar(7);
        //l.eliminar(1);
        //l.eliminar(4);
        System.out.println(l.toString());
        l.eliminar(3);
        System.out.println(l.toString());
        l.eliminar(1);
        System.out.println(l.toString());
        l.insertar(1);
        l.insertar(2);
        l.insertar(3);
        l.insertar(4);
        System.out.println(l.toString());
    }

}
