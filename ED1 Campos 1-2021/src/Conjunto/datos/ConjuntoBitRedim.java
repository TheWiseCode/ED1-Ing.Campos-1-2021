package Conjunto.datos;

/**
 *
 * @author willy
 */
public class ConjuntoBitRedim {

    Bitwise C[];
    int cant;

    public ConjuntoBitRedim() {
        this.C = new Bitwise[1];
        cant = 32;
        C[0] = new Bitwise();
    }

    public void insertar(int ele) {
        if (ele <= cant) {
            int NBW = calcNBW(ele);
            int Nbit = calcNbit(ele);
            C[NBW].Setbit1(Nbit);
        } else {
            int nuevaDim = (ele / 32) + 1;
            redimensionar(nuevaDim);
            int NBW = calcNBW(ele);
            int Nbit = calcNbit(ele);
            C[NBW].Setbit1(Nbit);
        }
    }

    private void redimensionar(int dim) {
        int n = this.C.length;
        Bitwise[] copia = new Bitwise[n];
        for (int i = 0; i < n; i++) {
            copia[i] = this.C[i];
        }
        this.C = new Bitwise[dim];
        for (int i = 0; i < n; i++) {
            this.C[i] = copia[i];
        }
        for (int i = n; i < dim; i++) {
            this.C[i] = new Bitwise();
        }
        this.cant = 32 * dim;
    }

    public void eliminar(int ele) {
        if (ele <= cant) {
            int NBW = calcNBW(ele);
            int Nbit = calcNbit(ele);
            C[NBW].Setbit0(Nbit);
        } else {
            System.out.println("Error::ConjuntoBit:Eliminar:Elemento fuera de Rango");
            System.exit(1);
        }
    }

    private int calcNBW(int ele) {
        return (ele - 1) / 32;
    }

    private int calcNbit(int ele) {
        return ((ele - 1) % 32) + 1;
    }

    public boolean pertenece(int ele) {
        int NBW = calcNBW(ele);
        int Nbit = calcNbit(ele);
        return C[NBW].Getbit(Nbit) == 1;
    }
    
    public int longitud(){
        int l = 0;
        for (int i = 1; i <= cant; i++) {
            if (pertenece(i)) {
                l++;
            }
        }
        return l;
    }
    
    public boolean vacio(){
        for (int i = 1; i <= cant; i++) {
            if (pertenece(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String S = "C={";
        for (int i = 1; i <= cant; i++) {
            if (pertenece(i)) {
                S = S + i + ",";
            }
        }
        S = S.substring(0, S.length() - 1);
        S = S + "}";
        return S;
    }

    public static void main(String[] args) {
        ConjuntoBitRedim c = new ConjuntoBitRedim();
        c.insertar(4);
        c.insertar(30);
        c.insertar(15);
        c.insertar(83);
        c.insertar(253);
        c.eliminar(83);
        System.out.println(c.toString());
    }

}
