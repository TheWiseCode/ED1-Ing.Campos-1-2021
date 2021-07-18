package ConjuntoFraccion;

/**
 *
 * @author willy
 */
public class ConjuntoV {

    private int[] vNum;
    private int[] vDem;
    private char[] vSign;
    private int l;

    public ConjuntoV() {
        vNum = new int[5];
        vDem = new int[5];
        vSign = new char[5];
        l = -1;
    }

    public boolean pertenece(int num, int dem) {
        char s;
        if ((num > 0 && dem > 0) || (num < 0 && dem < 0)) {
            s = '+';
        } else {
            s = '-';
        }
        num = (int) Math.abs(num);
        dem = (int) Math.abs(dem);
        for (int i = 0; i <= l; i++) {
            if (num == vNum[i] && dem == vDem[i] && s == vSign[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean insertar(int num, int dem) {
        if (!pertenece(num, dem)) {
            int len = vNum.length;
            if (l + 1 == len) {
                int[] copiaN = new int[len];
                int[] copiaD = new int[len];
                char[] copiaS = new char[len];
                //System.arraycopy(vector, 0, copia, 0, len);
                for (int i = 0; i < len; i++) {
                    copiaN[i] = vNum[i];
                    copiaD[i] = vDem[i];
                    copiaS[i] = vSign[i];
                }
                vNum = new int[len + 10];
                vDem = new int[len + 10];
                vSign = new char[len + 10];
                for (int i = 0; i < len; i++) {
                    vNum[i] = copiaN[i];
                    vDem[i] = copiaD[i];
                    vSign[i] = copiaS[i];
                }
            }
            l++;
            char s;
            if ((num > 0 && dem > 0) || (num < 0 && dem < 0)) {
                s = '+';
            } else {
                s = '-';
            }
            vNum[l] = (int) Math.abs(num);
            vDem[l] = (int) Math.abs(dem);
            vSign[l] = s;
            return true;
        }else{
            System.err.println("Elemento ya insertado");
            return false;
        }
    }

    public int longitud() {
        return l + 1;
    }

    public boolean vacio() {
        return l == -1;
    }

    public void suprime(int num, int dem) {
        if (pertenece(num, dem)) {
            int pos = 0;
            char s;
            if ((num > 0 && dem > 0) || (num < 0 && dem < 0)) {
                s = '+';
            } else {
                s = '-';
            }
            int nu = (int)Math.abs(num);
            int de = (int)Math.abs(dem);
            for (int i = 0; i <= l; i++) {
                if (nu == vNum[i] && de == vDem[i] && s == vSign[i]) {
                    pos = i;
                    break;
                }
            }
            for (int i = pos; i < l; i++) {
                vNum[i] = vNum[i + 1];
                vDem[i] = vDem[i + 1];
                vSign[i] = vSign[i + 1];
            }
            l--;
        }
    }

    @Override
    public String toString() {
        String r = "{";
        for (int i = 0; i <= l; i++) {
            r += "" + vSign[i] + vNum[i] + '/' + vDem[i];
            if (i <= l - 1) {
                r += ",";
            }
        }
        return r + "}";
    }
    
    public static void main(String[] args) {
        ConjuntoV c = new ConjuntoV();
        c.insertar(-1, 2);
        c.insertar(3, -4);
        c.insertar(2, 2);
        c.insertar(-1, -1);
        System.out.println(c.toString());
        c.insertar(1, -2);
        c.suprime(-3, 4);
        System.out.println(c.toString());
    }
}
