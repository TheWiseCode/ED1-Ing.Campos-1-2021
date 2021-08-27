package EF.Pregu3;

/**
 *
 * @author willy
 */
public class ColaBanco {

    private VectorNBits datos;
    private int cont;

    public ColaBanco() {
        datos = new VectorNBits(100, 9);
        cont = 0;
    }

    public void encolar(int nro, String ts, String tu) {
        if (cont < 100) {
            cont++;
            int s, u;
            if (ts.equals("CJ")) {
                s = 0;
            } else {
                s = 1;
            }
            if (tu.equals("CC")) {
                u = 0;
            } else {
                u = 1;
            }
            int x = 0;
            x = x | (nro << 2);
            x = x | (s << 1);
            x = x | u;
            datos.insertar(x, cont);
        }
    }

    public boolean vacia() {
        return cont == 0;
    }

    private String posicion(int pos) {
        int dato = datos.sacar(pos);
        int nro = dato >>> 2;
        int s = (dato >>> 1) % 2;
        int u = dato % 2;
        String ts, tu;
        if (s == 0) {
            ts = "CJ";
        } else {
            ts = "PT";
        }
        if (u == 0) {
            tu = "CC";
        } else {
            tu = "TE";
        }
        return nro + "," + ts + "," + tu;
    }

    public String decolar() {
        if (!vacia()) {
            String ret = posicion(1);
            for (int i = 1; i < cont; i++) {
                int x = datos.sacar(i + 1);
                datos.insertar(x, i);
            }
            cont--;
            return ret;
        }
        return "";
    }

    @Override
    public String toString() {
        String sr = "";
        for (int i = 1; i <= cont; i++) {
            sr += "[" + posicion(i) + "],";
        }
        return sr;
    }

    public static void main(String[] args) {
        ColaBanco c = new ColaBanco();
        c.encolar(1, "CJ", "TE");
        c.encolar(2, "PT", "TE");
        System.out.println(c.decolar());
        System.out.println(c.decolar());
        c.encolar(3, "PT", "CC");
        System.out.println(c.decolar());
        System.out.println(c.toString());
    }
}
