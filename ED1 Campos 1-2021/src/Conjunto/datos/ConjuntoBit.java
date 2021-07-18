package Conjunto.datos;

/**
 *
 * @author willy
 */
public class ConjuntoBit {

    Bitwise C[];
    int cant;

    public ConjuntoBit(int NEle) {
        int Nbw = NEle / 32;
        if (NEle % 32 != 0) {
            Nbw++;
        }
        this.C = new Bitwise[Nbw];
        cant = NEle;
        for (int i = 0; i <= Nbw - 1; i++) {
            C[i] = new Bitwise();

        }
    }

    public void Insertar(int ele) {
        if (ele <= cant) {
            int NBW = CalcNBW(ele);
            int Nbit = CalcNbit(ele);
            C[NBW].Setbit1(Nbit);

        } else {
            System.out.println("Error::ConjuntoBit:Eliminar:Elemento fuera de Rango");
            System.exit(1);
        }
    }

    public void Eliminar(int ele) {
        if (ele <= cant) {
            int NBW = CalcNBW(ele);
            int Nbit = CalcNbit(ele);
            C[NBW].Setbit0(Nbit);

        } else {
            System.out.println("Error::ConjuntoBit:Eliminar:Elemento fuera de Rango");
            System.exit(1);
        }
    }

    private int CalcNBW(int ele) {
        return ((ele - 1) / 32);
    }

    private int CalcNbit(int ele) {
        return (((ele - 1) % 32) + 1);
    }

    public boolean Pertenece(int ele) {
        int NBW = CalcNBW(ele);
        int Nbit = CalcNbit(ele);
        return (C[NBW].Getbit(Nbit) == 1);
    }

    @Override
    public String toString() {
        String S = "C={";
        for (int i = 1; i <= cant; i++) {
            if (Pertenece(i)) {
                S = S + i + " , ";
            }
        }
        S = S + "}";
        return S;
    }
    
    public static void main(String[] args) {
        ConjuntoBit c = new ConjuntoBit(6);
    }

}
