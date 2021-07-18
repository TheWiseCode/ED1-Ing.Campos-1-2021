package Polinomio.datos;

/**
 *
 * @author willy
 */
public class Polinomio {
    
    //private int exp[];
    //private float coef[];
    private Monomio[] m;
    private static final int MAX = 10;
    private int p;
    
    public Polinomio(){
        m = new Monomio[MAX];
        p = 0;
    }
    
    public void insertar(Monomio mo){
        int pos = posMonomio(mo);
        if(pos == -1){
            m[p] = mo;
            p++;
        }else{
            float nuevoCoef = m[pos].getCoef() + mo.getCoef();
            m[pos].setCoef(nuevoCoef);
            if(nuevoCoef == 0){
                for(int k = pos; k < p;k++){
                    m[k] = m[k + 1];
                }
                p--;
            }
        }
    }
    
    private int posMonomio(Monomio mo){
        for(int i = 0;i < p;i++){
            if(m[i].getExp() == mo.getExp()){
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public String toString(){
        String r = "";
        for(int i = 0;i < p;i++){
            r = r + m[i].toString();
            //r = r + signo + Float.toString(coef[i]) + "X^" + Integer.toString(exp[i]);
        }
        return r;
    }
}
