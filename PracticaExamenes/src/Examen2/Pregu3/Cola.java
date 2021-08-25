package Examen2.Pregu3;

/**
 *
 * @author pc
 */
public class Cola {

    private Nodo frente;
    private Nodo atras;
    private int cant;

    public Cola() {
        frente = atras = null;
        cant = 0;
    }

    public boolean vacia() {
        return frente == null;
    }

    public void encolar(int ele) {
        Nodo aux = new Nodo(ele);
        if (vacia()) {
            frente = atras = aux;
        } else {
            atras.setEnlace(aux);
            atras = aux;
        }
        cant++;
    }

    public int decolar() {
        if (!vacia()) {
            int ele = frente.getDato();
            if (frente == atras) {
                frente = atras = null;
            } else {
                frente = frente.getEnlace();
            }
            cant--;
            return ele;
        } else {
            System.out.println("Cola Vacia");
            return -1;
        }
    }

    public int getFrente() {
        if (!vacia()) {
            return frente.getDato();
        } else {
            System.out.println("Error Cola Vacia");
            return -1;
        }
    }

    public int size() {
        return cant;
    }

    @Override
    public String toString() {
        String s = "[";
        Nodo aux = frente;
        while (aux != null) {
            s += aux.getDato();
            aux = aux.getEnlace();
            if (aux != null) {
                s += ",";
            }
        }
        return s + "]";
    }

    public void elimRepetidos() {
        int n = size();
        for (int j = 0; j < n; j++) {
            boolean repe = false;
            int x = decolar();
            int m = size();
            for (int i = 0; i < m; i++) {
                int e = decolar();
                if (x != e) {
                    encolar(e);
                } else {
                    repe = true;
                }
            }
            if(repe){
                n = size();
            }else{
                encolar(x);
                for(int i = 0;i < m;i++)
                    encolar(decolar());
            }
        }
    }

    public static void main(String[] args) {
        Cola q = new Cola();
        q.encolar(1);
        q.encolar(2);
        q.encolar(1);
        q.encolar(3);
        q.encolar(4);
        q.encolar(1);
        q.encolar(2);
        q.encolar(2);
        System.out.println(q.toString());
        q.elimRepetidos();
        System.out.println(q.toString());
    }
}
