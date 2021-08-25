package Examen2.Pregu2;

/**
 *
 * @author willy
 */
public class PilaV {
 
    private int v[];
    private int num;
    private int cant;
    
    public PilaV(){
        cant = 0;
        num = 10;
        v = new int[num];
    }
    
    public void push(int e){
        if(cant < num){
            v[cant] = e;
            cant++;
        }else{
            int n = num;
            num += 10;
            int vec[] = new int[n];
            for(int i = 0;i < n;i++){
                int el = v[i];
                vec[i] = el;
            }
            v = new int[num];
            for(int i = 0;i < n;i++){
                int el = vec[i];
                v[i] = el;
            }
            v[cant] = e;
            cant++;
        }
    }
    
    public int pop(){
        if(!vacia()){
            int e = v[cant - 1];
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
            return v[cant - 1];
        }
        else{
            System.err.println("Pila vacia");
            return 0;
        }
    }
    
    public int longitud(){
        return cant;
    }
    
    public boolean vacia(){
        return cant == 0;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(int i = cant;i >= 1;i--){
            int e = v[i - 1];
            s += "| " + e + " |\n";
        }
        s += "|---|";
        return s;
    }
    
    public void intercalar(){
        if(longitud() > 1){
            boolean impar = longitud() % 2 == 1;
            int x = 0;
            if(impar){
                x = pop();
            }
            int a = pop();
            int b = pop();
            intercalar();
            push(a);
            push(b);
            if(impar){
                push(x);
            }
        }
    }
    
    public static void main(String[] args) {
        PilaV p = new PilaV();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        //p.push(5);
        System.out.println(p.toString());
        p.intercalar();
        System.out.println("");
        System.out.println(p.toString());
    }
}
