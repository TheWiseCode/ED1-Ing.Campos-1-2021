package Modelado.datos;

/**
 *
 * @author willy
 */
public class Fraccion {

    private int numerador, denominador;

    public Fraccion() {
        numerador = 1;
        denominador = 1;
    }

    public Fraccion(int num, int dem) {
        numerador = num;
        denominador = dem;
    }

    public void setNumerador(int num) {
        numerador = num;
    }

    public void setDenominador(int dem) {
        denominador = dem;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public int siguiente_primo(int n) {
        int res = n + 1;
        boolean es_primo = false;
        while (!es_primo) {
            int mitad = res / 2;
            boolean primo = true;
            for (int i = 2; i < mitad; i++) {
                if (res % i == 0) {
                    primo = false;
                    break;
                }
            }
            if (primo) {
                es_primo = true;
            } else {
                res++;
            }
        }
        return res;
    }

    public int mcm(int a, int b) {
        int res = 1;
        int div = 2;
        while (a > 1 || b > 1) {
            boolean avanzar = true;
            if (a % div == 0) {
                a = a / div;
                res = res * div;
                avanzar = false;
            }
            if (b % div == 0) {
                b = b / div;
                if (avanzar) {
                    res = res * div;
                }
                avanzar = false;
            }
            if (avanzar) {
                div = siguiente_primo(div);
            }
        }
        return res;
    }

    public void sumar(Fraccion a, Fraccion b) {
        int denA = a.getDenominador();
        int denB = b.getDenominador();
        int comunDivisor = mcm(denA, denB);
        int na = (comunDivisor/denA)*a.getNumerador();
        int nb = (comunDivisor/denB)*b.getNumerador();
        int nuevoNum = na + nb;
        a.setNumerador(nuevoNum);
        a.setDenominador(comunDivisor);
        a.simplificar(a);
    }
    
    public void multiplicar(Fraccion a, Fraccion b){
        int nuevoNum = a.getNumerador() * b.getNumerador();
        int nuevoDem = a.getDenominador() * b.getDenominador();
        a.setNumerador(nuevoNum);
        a.setDenominador(nuevoDem);
        a.simplificar(a);
    }
    
    public void simplificar(Fraccion a){
        int num = a.getNumerador();
        int dem = a.getDenominador();
        if(dem > 1){
            int comunDiv = 2;
            while(comunDiv <= dem){
                if(num % comunDiv == 0 && dem % comunDiv == 0){
                    num = num / comunDiv;
                    dem = dem / comunDiv;
                }else{
                    comunDiv++;
                }
            }
            a.setNumerador(num);
            a.setDenominador(dem);
            
        }
    }
    
    @Override
    public String toString(){
        return "" + getNumerador() + "/" + getDenominador();
    }

    public static void main(String[] args) {
    }

}
