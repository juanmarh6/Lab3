package PaqPruebas;
import PaqComercio.*;



public class Main {
    public static void main(String[] args) {
        Concesionario con = new Concesionario();
        VehículoParaReparar v1 = new VehículoParaReparar("Puerta rota", false, 1, "Honda", "Civic", "5684A");
        VehículoParaReparar v2 = new VehículoParaReparar("Puerta rota", false, 3, "Ford", "Fiesta", "5684A");
        VehículoParaReparar v3 = new VehículoParaReparar("Puerta rota", false, 2, "Mazda", "cxz", "5684A");
        VehículoParaReparar v4 = new VehículoParaReparar("Puerta rota", false, 10, "Último", "Coche", "5684A");
        con.añadirReparar(v4);
        con.añadirReparar(v1);
        con.añadirReparar(v2);
        con.añadirReparar(v3);
        System.out.println(con.verTaller());
    }
}
