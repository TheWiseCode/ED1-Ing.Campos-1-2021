package VacunacionCovid;

import Bitwise.VectorNBits;

/**
 *
 * @author willy
 */
public class VacunaCovid {

    private VectorNBits datos;
    private int cont = 0;

    public VacunaCovid(int nroPersonas) {
        int nroBits = 18;
        datos = new VectorNBits(nroPersonas, nroBits);
    }

    public void registrar(int dia, int mes, int año, int edad, boolean esMasc) {
        if (dia > 0 && dia <= 31 && mes > 0 && mes <= 12 && edad > 0 && edad <= 120) {
            if (año == 2020 || año == 2021) {
                if (cont < datos.cantidad()) {
                    int valor = 0;
                    int despDia = 17 - 5 + 1;
                    dia = dia << despDia;
                    valor = valor | dia;
                    int despMes = 12 - 4 + 1;
                    mes = mes << despMes;
                    valor = valor | mes;
                    año = año % 10;
                    int despAño = 8 - 1 + 1;
                    año = año << despAño;
                    valor = valor | año;
                    int despEdad = 7 - 7 + 1;
                    edad = edad << despEdad;
                    valor = valor | edad;
                    int gen;
                    if (esMasc) {
                        gen = 1;
                    } else {
                        gen = 0;
                    }
                    valor = valor | gen;
                    cont++;
                    datos.insertar(valor, cont);
                    //Prueba y despues borrar
                    //String bin = Integer.toBinaryString(valor);
                    //String binB = String.format("%18s", bin).replaceAll(" ", "0");
                    //System.out.println(binB);
                    //
                }
            }
        }
    }

    public int getDia(int nroCart) {
        int valor = datos.sacar(nroCart);
        valor = valor >>> 13;
        return valor;
    }

    public int getMes(int nroCart) {
        int valor = datos.sacar(nroCart);
        valor = valor << (32 - 18 + 5);
        valor = valor >>> (32 - 4);
        return valor;
    }

    public int getAño(int nroCart) {
        int valor = datos.sacar(nroCart);
        valor = valor << (32 - 18 + 9);
        valor = valor >>> (32 - 1);
        return 2020 + valor;
    }

    public int getEdad(int nroCart) {
        int valor = datos.sacar(nroCart);
        valor = valor << (32 - 18 + 10);
        valor = valor >>> (32 - 7);
        return valor;
    }

    public String getGenero(int nroCart) {
        int valor = datos.sacar(nroCart);
        valor = valor << (32 - 18 + 17);
        valor = valor >>> (32 - 1);
        if (valor == 1) {
            return "Masculino";
        } else {
            return "Femenino";
        }
    }

    @Override
    public String toString() {
        String res = "";
        for(int i = 0;i < this.cont;i++){
            int dia = getDia(i + 1);
            int mes = getMes(i + 1);
            int año = getAño(i + 1);
            int edad = getEdad(i + 1);
            String gen = getGenero(i + 1);
            String fecha = "" +dia +"/"+mes+"/"+año;
            String linea = ""+(i+1)+" | "+ fecha + " | " + edad + " | "+ gen;
            res += linea + "\n";
        }
        return res;
    }

    public static void main(String[] args) {
        VacunaCovid v = new VacunaCovid(20);
        v.registrar(17, 8, 2021, 23, true);
        v.registrar(23, 5, 2021, 53, false);
        v.registrar(17, 11, 2021, 63, false);
        int dia = v.getDia(2);
        int mes = v.getMes(2);
        int año = v.getAño(2);
        int edad = v.getEdad(2);
        System.out.println("Dia,mes: " + dia + "," + mes + "," + año);
        System.out.println("Edad: " + edad);
        System.out.println(v.getGenero(2));
    }

}
