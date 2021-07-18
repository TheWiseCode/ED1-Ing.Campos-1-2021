package Modelado.presentacion;

import Modelado.datos.Fraccion;

/**
 *
 * @author willy
 */
public class Consola {
    public static void main(String[] args) {
        Fraccion a = new Fraccion(13, 5);
        Fraccion b = new Fraccion(4, 18);
        Fraccion c = new Fraccion(91, 35);
        //a.sumar(a, b);
        //a.multiplicar(a, b);
        c.simplificar(c);
        System.out.println("" + c);
    }
}
