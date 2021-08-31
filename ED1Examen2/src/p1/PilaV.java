package p1;

/**
 *
 * @author willy
 */
public class PilaV {

    private int v[];
    private int num;
    private int cant;

    public PilaV() {
        cant = 0;
        num = 10;
        v = new int[num];
    }

    public void push(int e) {
        if (cant < num) {
            v[cant] = e;
            cant++;
        } else {
            int n = num;
            num += 10;
            int vec[] = new int[n];
            for (int i = 0; i < n; i++) {
                int el = v[i];
                vec[i] = el;
            }
            v = new int[num];
            for (int i = 0; i < n; i++) {
                int el = vec[i];
                v[i] = el;
            }
            v[cant] = e;
            cant++;
        }
    }

    public int pop() {
        if (!vacia()) {
            int e = v[cant - 1];
            cant--;
            return e;
        } else {
            System.err.println("Pila vacia");
            return 0;
        }
    }

    public int peek() {
        if (!vacia()) {
            return v[cant - 1];
        } else {
            System.err.println("Pila vacia");
            return 0;
        }
    }

    public boolean vacia() {
        return cant == 0;
    }

    public int longitud() {
        return cant;
    }
    
    public void intercambiarExtremos(Cola q){
        if(this.longitud() > 1 || q.size() > 1){
            int pq = q.decolar();
            int pp = this.pop();
            int sp = this.longitud();
            int sq = q.size();
            for(int i = 0;i < sp - 1;i++)
                q.encolar(this.pop());
            boolean pilaVacia = this.vacia();
            int up = 0;
            if(!pilaVacia)
                up = this.pop();
            for(int i = 0;i < sq - 1;i++)
                this.push(q.decolar());
            boolean colaVacia = q.vacia();
            int uq = 0;
            int auxSq = sq;
            if(!colaVacia && auxSq > 0)
                uq = q.decolar();
            for(int k = 1;k <= 3;k++){
                sp = this.longitud();
                sq = q.size();
                if(k == 3 && !colaVacia && auxSq > 0)
                    q.encolar(uq);
                for(int i = 0;i < sp;i++)
                    q.encolar(this.pop());
                if(k == 3)
                    this.push(pp);
                for(int i = 0;i < sq;i++)
                    this.push(q.decolar());
            }
            q.encolar(pq);
            if(!pilaVacia)
                this.push(up);
        }
    }


    @Override
    public String toString() {
        String s = "";
        for (int i = cant; i >= 1; i--) {
            int e = v[i - 1];
            s += "| " + e + " |\n";
        }
        s += "|---|";
        return s;
    }

    public static void main(String[] args) {
        PilaV p = new PilaV();
        p.push(1);
        p.push(2);
        p.push(3);
        //p.push(4);
        Cola c = new Cola();
        c.encolar(5);
        //c.encolar(6);
        //c.encolar(7);
        //c.encolar(8);
        System.out.println(p.toString());
        System.out.println(c.toString());
        p.intercambiarExtremos(c);
        System.out.println(p.toString());
        System.out.println(c.toString());
    }
}
