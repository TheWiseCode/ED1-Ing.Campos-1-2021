package Bitwise;

/**
 *
 */
public class Bitwise {

    int x;

    public Bitwise() {
        this.x = 0;
    }

    public void Setbit1(int pos) {
        if (pos <= 32) {
            int mask = 1;
            mask = mask << pos - 1;
            x = x | mask;
        }
    }

    public void Setbit0(int pos) {
        if (pos <= 32) {
            int mask = 1;
            mask = mask << pos - 1;
            mask = ~mask;
            x = x & mask;
        }
    }

    public int Getbit(int pos) {
        int mask = 1;
        mask = mask << pos - 1;
        mask = mask & x;
        mask = mask >>> pos - 1;
        return (mask);
    }

    @Override
    public String toString() {
        String S = "X= ";
        for (int i = 32; i >= 1; i--) {
            S = S + " " + Getbit(i);
        }
        return (S);
    }

}
