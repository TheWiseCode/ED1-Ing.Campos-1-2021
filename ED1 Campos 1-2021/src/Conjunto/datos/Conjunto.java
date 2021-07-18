package Conjunto.datos;

/**
 *
 * @author willy
 */
public class Conjunto {
    private int[] vector;
    private int l;
    
    public Conjunto(){
        vector = new int[5];
        l = -1;
    }
    
    public boolean pertenece(int d){
        for(int i = 0;i <= l;i++){
            if(d == vector[i]){
                return true;
            }
        }
        return false;
    }
    
    public boolean insertar(int d){
        if(!pertenece(d)){
            int len = vector.length;
            if(l + 1==len){
                int[] copia = new int[len];
                //System.arraycopy(vector, 0, copia, 0, len);
                for(int i = 0;i < len;i++)
                    copia[i] = vector[i];
                vector = new int[len + 10];
                for(int i = 0;i < len;i++)
                    vector[i] = copia[i];
            }
            l++;
            vector[l] = d; 
            return true;
        }
        return false;
    }
    
    public int longitud(){
        return l + 1;
    }
    
    public boolean vacio(){
        return l == -1;
    }
    
    public void suprime(int d){
        if(pertenece(d)){
            int pos = 0;
            for(int i = 0;i <= l;i++){
                if(d == vector[i]){
                    pos = i;
                    break;
                }
            }
            for(int i = pos;i < l;i++){
                vector[i] = vector[i+1];
            }
            l--;
        }
    }

    @Override
    public String toString() {
        String r = "{";
        for(int i = 0;i <= l;i++){
            r += vector[i];
            if(i <= l - 1)
                r += ",";
        }
        return r + "}";
    }
    
    
}
