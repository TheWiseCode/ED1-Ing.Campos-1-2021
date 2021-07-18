package Polinomio.datos;

/**
 *
 * @author willy
 */
public class Monomio {

    private float coef;
    private int exp;
    private char signo;
    public static final char MAS = '+';
    public static final char MENOS = '-';

    public Monomio() {
        this.coef = 0;
        this.exp = 0;
        this.signo = MAS;
    }

    public Monomio(float coef, int exp) {
        if (coef != 0) {
            this.coef = coef;
            this.exp = exp;
            if (coef > 0) {
                this.signo = MAS;
            } else {
                this.signo = MENOS;
            }
        }else{
            System.out.println("Error: coeficiente diferente de 0");
            //System.exit(1);
        }
    }

    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
        if (coef > 0) {
            this.signo = MAS;
        } else {
            this.signo = MENOS;
        }
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public char getSigno() {
        return this.signo;
    }

    @Override
    public String toString() {
        float c = Math.abs(coef);
        return signo + Float.toString(c) + "X^" + Integer.toString(exp);
    }
}
