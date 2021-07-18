package ConjuntoFraccion;

/**
 *
 * @author willy
 */
public class ConjuntoB {
    private VectorNBits vNum;
    private VectorNBits vDem;
    private VectorNBits vSign;
    private int cant;

    public ConjuntoB() {
        vNum = new VectorNBits(20, 7);
        vDem = new VectorNBits(20, 7);
        vSign = new VectorNBits(20, 1);
        cant = 0;
    }

    public boolean pertenece(int num, int dem) {
        int s;
        if ((num > 0 && dem > 0) || (num < 0 && dem < 0)) {
            s = 0;
        } else {
            s = 1;
        }
        num = (int) Math.abs(num);
        dem = (int) Math.abs(dem);
        for (int i = 0; i <= cant; i++) {
            if (num == vNum.sacar(i + 1) &&
                dem == vDem.sacar(i + 1) &&
                s == vSign.sacar(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean insertar(int num, int dem) {
        if (!pertenece(num, dem)) {
            int len = vNum.cantidad();
            if(cant < len){
                cant++;
                int s;
                if ((num > 0 && dem > 0) || (num < 0 && dem < 0)) {
                    s = 0;
                } else {
                    s = 1;
                }
                vNum.insertar((int) Math.abs(num), cant);
                vDem.insertar((int) Math.abs(dem), cant);
                vSign.insertar(s, cant);
                return true;
            }
            System.err.println("No hay espacio en el conjunto");
            return false;
        }
        System.err.println("Elemento ya insertado");
        return false;
    }

    public int longitud() {
        return cant + 1;
    }


    @Override
    public String toString() {
        String r = "{";
        for (int i = 0; i < cant; i++) {
            String s;
            if(vSign.sacar(i+1) == 0)
                s = "+";
            else
                s = "-";
            r += "" + s + vNum.sacar(i+1) + '/' + vDem.sacar(i+1);
            if (i < cant - 1) {
                r += ",";
            }
        }
        return r + "}";
    }
    
    public static void main(String[] args) {
        ConjuntoB c = new ConjuntoB();
        c.insertar(-1, 2);
        c.insertar(3, -4);
        c.insertar(2, 2);
        c.insertar(-1, -1);
        System.out.println(c.toString());
        c.insertar(1, -2);
        System.out.println(c.toString());
    }
}
