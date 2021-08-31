package p2;

/**
 *
 * @author willy
 */
public class PilaN {
    
    private Nodo cima;
    private int cant;
    
    public PilaN(){
        cima = null;
        cant = 0;
    }
    
    public void push(int e){
        Nodo nuevo = new Nodo();
        nuevo.dato = e;
        nuevo.sig = cima;
        cima = nuevo;
        cant++;
    }
    
    public int pop(){
        if(!vacia()){
           int e = cima.dato;
           cima = cima.sig;
           cant--;
           return e;
        }
        else{
            System.err.println("Pila vacia");
            return 0;
        }
    }
    
    public int peek(){
        if(!vacia()){
            return cima.dato;
        }
        else{
            System.err.println("Pila vacia");
            return 0;
        }
    }
    
    public boolean vacia(){
        return cima == null;
    }
    
    @Override
    public String toString(){
        String s = "";
        Nodo aux = cima;
        while(aux != null){
            int e = aux.dato;
            s += "| " + e +" |\n";
            aux = aux.sig;
        }
        s += "|---|";
        return s;
    }
    
    public void intercambiarPartes(){
        if(cant <= 1)
            return;
        Nodo aux = cima;
        int n, m;
        if(cant % 2 == 0){
            n = cant / 2;    
            m = n -1;
        }else{
            n = cant / 2 + 1;
            m = n -2;
        }
        for(int i = 0;i < n;i++)
            cima = cima.sig;
        Nodo fin = aux;
        for(int i = 0;i < m;i++)
            fin = fin.sig;
        Nodo medio = fin.sig;
        fin.sig = null;
        fin = cima;
        while(fin.sig != null)
            fin = fin.sig;
        if(cant % 2 == 0)
            fin.sig = aux;
        else{
            fin.sig = medio;
            medio.sig = aux;
        }
    }
    
    public static void main(String[] args) {
        PilaN p = new PilaN();
        p.push(1);
        //p.push(2);
        //p.push(3);
        //p.push(4);
        //p.push(5);
        System.out.println(p.toString());
        p.intercambiarPartes();
        System.out.println(p.toString());
    }
}
