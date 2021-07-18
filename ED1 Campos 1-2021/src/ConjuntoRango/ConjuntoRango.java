package ConjuntoRango;

import Conjunto.datos.*;

/**
 *
 * @author willy
 */
public class ConjuntoRango {

    Bitwise C[];
    //int cant;
    int limiteA, limiteB;
    int NEle;

    public ConjuntoRango(int a, int b) {
        limiteA = a;
        limiteB = b;
        NEle = b - a + 1;
        int Nbw = NEle / 32;
        if (NEle % 32 != 0) {
            Nbw++;
        }
        this.C = new Bitwise[Nbw];
        //cant = NEle;
        for (int i = 0; i <= Nbw - 1; i++) {
            C[i] = new Bitwise();
        }
    }

    public void Insertar(int ele) {
        if (ele >= limiteA && ele <= limiteB) {
            ele = ele - limiteA + 1;
            int NBW = CalcNBW(ele);
            int Nbit = CalcNbit(ele);
            C[NBW].Setbit1(Nbit);

        } else {
            System.err.println("Error::ConjuntoBit:Eliminar:Elemento fuera de Rango");
        }
    }

    public void Eliminar(int ele) {
        if (ele >= limiteA && ele <= limiteB) {
            ele = ele - limiteA + 1;
            int NBW = CalcNBW(ele);
            int Nbit = CalcNbit(ele);
            C[NBW].Setbit0(Nbit);

        } else {
            System.err.println("Error::ConjuntoBit:Eliminar:Elemento fuera de Rango");
        }
    }

    private int CalcNBW(int ele) {
        return ((ele - 1) / 32);
    }

    private int CalcNbit(int ele) {
        return (((ele - 1) % 32) + 1);
    }

    public boolean Pertenece(int ele) {
        ele = ele - limiteA + 1;
        int NBW = CalcNBW(ele);
        int Nbit = CalcNbit(ele);
        return (C[NBW].Getbit(Nbit) == 1);
    }

    @Override
    public String toString() {
        String S = "C={";
        for (int i = limiteA; i <= limiteB; i++) {
            if (Pertenece(i)) {
                S = S + i + " , ";
            }
        }
        S = S + "}";
        return S;
    }
    
    public static void main(String[] args) {
        ConjuntoRango c = new ConjuntoRango(20, 80);
        c.Insertar(24);
        c.Insertar(14);
        c.Insertar(44);
        c.Insertar(54);
        c.Insertar(64);
        c.Insertar(94);
        System.out.println(c.toString());
    }

}
