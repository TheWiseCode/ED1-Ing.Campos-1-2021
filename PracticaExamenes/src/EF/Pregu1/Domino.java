package EF.Pregu1;

/**
 *
 * @author willy
 */
public class Domino {

    private Nodo ini;
    private Nodo fin;

    public Domino() {
        ini = null;
        fin = null;
    }

    public void insertar(int izq, int der) {
        if (izq >= 1 && izq <= 6 && der >= 1 && der <= 6) {
            if (ini == null && fin == null) {
                Nodo nuevo = new Nodo(izq, der);
                ini = nuevo;
                fin = nuevo;
            } else {
                if (ini.izq == der) {
                    Nodo nuevo = new Nodo(izq, der);
                    nuevo.enlace = ini;
                    ini = nuevo;
                } else if (ini.izq == izq) {
                    Nodo nuevo = new Nodo(der, izq);
                    nuevo.enlace = ini;
                    ini = nuevo;
                } else if (fin.der == izq) {
                    Nodo nuevo = new Nodo(izq, der);
                    fin.enlace = nuevo;
                    fin = nuevo;
                } else if (fin.der == der) {
                    Nodo nuevo = new Nodo(der, izq);
                    fin.enlace = nuevo;
                    fin = nuevo;
                }
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        Nodo aux = ini;
        while (aux != null) {
            int i = aux.izq, d = aux.der;
            s += "[" + i + "," + d + "]";
            if (aux.enlace != null) {
                s += ",";
            }
            aux = aux.enlace;
        }
        return s;
    }

    public static void main(String[] args) {
        Domino d = new Domino();
        d.insertar(1, 2);
        d.insertar(6, 1);
        d.insertar(6, 5);
        d.insertar(2, 3);
        d.insertar(4, 3);
        d.insertar(1, 1);
        System.out.println(d.toString());
    }
}
