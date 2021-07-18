package datos;

import java.io.Serializable;

/**
 *
 * @author willy
 */
public class Contacto implements Serializable{

    private VectorNBits nombre;
    private VectorNBits apellido;
    private int datos;// numero 27b, tipo 1b, grupo 3b

    public Contacto(String nombre, String apellido, int numero,
            boolean esMovil, String grupo) {
        this.nombre = new VectorNBits(21, 8);
        this.apellido = new VectorNBits(21, 8);
        datos = 0;
        int tipoGr = tipoGrupo(grupo);
        if (nombre.length() <= 20 && apellido.length() <= 20
                && tipoGr != -1 && numero <= 79999999) {
            almacenarNombre(nombre);
            almacenarApell(apellido);
            almacenarDatos(numero, esMovil, tipoGr);
        } else {
            System.err.println("Dimension de nombre o apellido no valida");
        }
    }

    private void almacenarNombre(String nombre) {
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            this.nombre.insertar(c, i + 1);
        }
        this.nombre.insertar(0, nombre.length() + 1);
    }

    private void almacenarApell(String apell) {
        for (int i = 0; i < apell.length(); i++) {
            char c = apell.charAt(i);
            this.apellido.insertar(c, i + 1);
        }
        this.apellido.insertar(0, apell.length() + 1);
    }

    private void almacenarDatos(int numero, boolean esMovil, int tipoGrupo) {
        int tipo = esMovil ? 1 : 0;
        datos = numero << 4 | datos;
        datos = tipo << 3 | datos;
        datos = tipoGrupo | datos;
    }

    private int tipoGrupo(String grupo) {
        grupo = grupo.toLowerCase();
        switch (grupo) {
            case "amigos":
                return 0;
            case "vip":
                return 1;
            case "familia":
                return 2;
            case "trabajo":
                return 3;
            case "otros":
                return 4;
            default:
                return -1;
        }
    }

    public String getNombre() {
        String nombr = "";
        int i = 1;
        int caracter = nombre.sacar(i);
        while (caracter != 0) {
            nombr += (char) caracter;
            i++;
            caracter = nombre.sacar(i);
        }
        return nombr;
    }

    public String getApellido() {
        String apell = "";
        int i = 1;
        int caracter = apellido.sacar(i);
        while (caracter != 0) {
            apell += (char) caracter;
            i++;
            caracter = apellido.sacar(i);
        }
        return apell;
    }

    public int getNumero() {
        int valor = datos;
        return valor >> 4;
    }

    public String getTipoTelf() {
        int valor = datos;
        valor = valor << 28;
        valor = valor >>> 31;
        if (valor == 1) {
            return "Movil";
        } else {
            return "Fijo";
        }
    }

    public String getGrupo() {
        int valor = datos;
        valor = valor << 29;
        valor = valor >>> 29;
        switch (valor) {
            case 0:
                return "Amigos";
            case 1:
                return "Vip";
            case 2:
                return "Familia";
            case 3:
                return "Trabajo";
            default:
                return "otros";
        }
    }

    public static void main(String[] args) {
        Contacto a = new Contacto("Pedro", "Velasquez", 76324624, true, "Amigos");
        String name = a.getNombre();
        String last = a.getApellido();
        int num = a.getNumero();
        String telf = a.getTipoTelf();
        String grupo = a.getGrupo();
        System.out.println("Nombre: " + name + ",Apellido: " + last
                + ",Numero: " + num + ",Tipo: " + telf + ",Grupo: " + grupo);
    }

}
