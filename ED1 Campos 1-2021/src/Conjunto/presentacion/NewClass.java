package Conjunto.presentacion;

import Conjunto.datos.Conjunto;

/**
 *
 * @author willy
 */
public class NewClass {
    
    
    public static void main(String[] args) {
        Conjunto c = new Conjunto();
        c.insertar(1);
        c.insertar(2);
        c.insertar(6);
        c.insertar(11);
        c.insertar(21);
        c.insertar(61);
        System.out.println(c.toString());
        c.suprime(6);
        c.suprime(1);
        c.suprime(2);
        c.suprime(11);
        c.suprime(21);
        c.suprime(61);
        System.out.println(c.toString());
    }
}
