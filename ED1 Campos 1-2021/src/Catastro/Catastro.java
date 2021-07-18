package Catastro;

/**
 *
 * @author willy
 */
public class Catastro {

    private final int max = 1000;

    private String[] nombres;
    private VectorNBits datos1;
    private VectorNBits datos2;//servicio
    private int cont;

    public Catastro() {
        cont = 0;
        nombres = new String[max];
        datos1 = new VectorNBits(max, 27);
        datos2 = new VectorNBits(max, 6);
    }

    public void registrar(String nombre, int uv, int mz, int lote, int sup,
            boolean agua, boolean luz, boolean pav, boolean alcan, boolean telf,
            boolean gas) {
        if (cont < 1000) {
            if (uv > 0 && uv <= 200 && mz > 0 && mz <= 30 && lote > 0 && lote <= 30
                    && sup >= 150 && sup <= 450) {
                cont++;
                int valor1 = 0;
                valor1 = valor1 | (uv << 19);
                valor1 = valor1 | (mz << 14);
                valor1 = valor1 | (lote << 9);
                valor1 = valor1 | sup;
                int valor2 = 0;
                int ag = agua ? 1 : 0;
                int lz = luz ? 1 : 0;
                int pv = pav ? 1 : 0;
                int al = alcan ? 1 : 0;
                int tf = telf ? 1 : 0;
                int gs = gas ? 1 : 0;
                valor2 = valor2 | ag << 5;
                valor2 = valor2 | lz << 4;
                valor2 = valor2 | pv << 3;
                valor2 = valor2 | al << 2;
                valor2 = valor2 | tf << 1;
                valor2 = valor2 | gs;
                datos1.insertar(valor1, cont);
                datos2.insertar(valor2, cont);
                nombres[cont - 1] = nombre;
            }
        }
    }

    public String getNombre(int nroLote) {
        if (nroLote > 0 && nroLote <= 100) {
            return nombres[nroLote - 1];
        } else {
            return "";
        }
    }

    public int getUv(int nroLote) {
        int valor = datos1.sacar(nroLote);
        valor = valor >>> 19;
        return valor;
    }

    public int getMz(int nroLote) {
        int valor = datos1.sacar(nroLote);
        valor = valor << 13;
        valor = valor >>> 27;
        return valor;
    }

    public int getLote(int nroLote) {
        int valor = datos1.sacar(nroLote);
        valor = valor << 18;
        valor = valor >>> 27;
        return valor;
    }

    public int getSup(int nroLote) {
        int valor = datos1.sacar(nroLote);
        valor = valor << 13;
        valor = valor >>> 23;
        return valor;
    }

    public String getAgua(int nroLote) {
        int valor = datos2.sacar(nroLote);
        valor = valor >>> 5;
        if (valor == 1) {
            return "si";
        } else {
            return "no";
        }
    }

    public String getLuz(int nroLote) {
        int valor = datos2.sacar(nroLote);
        valor = valor << 27;
        valor = valor >>> 31;
        if (valor == 1) {
            return "si";
        } else {
            return "no";
        }
    }

    public String getPav(int nroLote) {
        int valor = datos2.sacar(nroLote);
        valor = valor << 28;
        valor = valor >>> 31;
        if (valor == 1) {
            return "si";
        } else {
            return "no";
        }
    }

    public String getAlcan(int nroLote) {
        int valor = datos2.sacar(nroLote);
        valor = valor << 29;
        valor = valor >>> 31;
        if (valor == 1) {
            return "si";
        } else {
            return "no";
        }
    }

    public String getTelf(int nroLote) {
        int valor = datos2.sacar(nroLote);
        valor = valor << 30;
        valor = valor >>> 31;
        if (valor == 1) {
            return "si";
        } else {
            return "no";
        }
    }

    public String getGas(int nroLote) {
        int valor = datos2.sacar(nroLote);
        valor = valor << 31;
        valor = valor >>> 31;
        if (valor == 1) {
            return "si";
        } else {
            return "no";
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 1; i <= cont; i++) {
            String nombre = getNombre(i);
            int uv = getUv(i);
            int mz = getMz(i);
            int lot = getLote(i);
            int sup = getSup(i);
            String ag = getAgua(i);
            String lz = getLuz(i);
            String pv = getPav(i);
            String al = getAlcan(i);
            String tf = getTelf(i);
            String gs = getGas(i);
            s += "NroLote:" + i + ",Nombre:" + nombre + ",UV:" + uv + ",MZ:" + mz + ",Lote:" + lot + ",Sup:" + sup
                    + ",Agua:" + ag + ",Luz:" + lz + ",Pavimento:" + pv + ",Alcantirallado:" + al
                    + ",Telefono:" + tf + ",Gas:" + gs + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Catastro c = new Catastro();
        c.registrar("Jorge", 54, 3, 14, 240, true, true, true, true, true, true);
        c.registrar("Maria", 104, 13, 30, 340, true, true, true, false, true, true);
        c.registrar("Calor", 4, 29, 15, 440, true, false, true, true, true, false);
        System.out.println(c.toString());
    }
}
