package PaqComercio;

import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Juanma
 * @version 01/03/2022
 * Superclase Comercio que define un comercio con todos sus datos, además de una lista de empleados
 */
public class Comercio {
    private String nombre;
    private String direccion;
    private String cif;
    private int totalVentas;
    private double [][] ventasDiarias;
    private int [] stock;
    private Empleado [] empleados;

    /**
     * Constructor vacío
     */
    public Comercio(){
    }

    /**
     * Constructor completo
     * @param nombre Nombre del comercio
     * @param direccion Dirección del comercio
     * @param cif CIF del comercio
     * @param totalVentas Total de ventas del comercio (vector bidimensional)
     * @param numEmpleados Número de empleados
     * @param numStock cantidad de stock
     */
    public Comercio(String nombre, String direccion, String cif, int totalVentas, int numEmpleados, int numStock){
        this.nombre = nombre;
        this.direccion = direccion;
        this.cif = cif;
        this.totalVentas = totalVentas;
        empleados = new Empleado[numEmpleados];
        ventasDiarias = new double[12][31];
        stock = new int[numStock];
    }

    /**
     * Getter nombre
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter dirección
     * @return Direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Getter cif
     * @return CIF
     */
    public String getCif() {
        return cif;
    }

    /**
     * Getter ventas
     * @return totalventas
     */
    public int getTotalVentas() {
        return totalVentas;
    }
    public String getEmpleadoNombre(int n){
        return empleados[n-1].getNombre();
    }


    /**
     * Setter nombre
     * @param nombre Nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter dirección
     * @param direccion Direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Setter CIF
     * @param cif CIF
     */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * Setter totalventas
     * @param totalVentas totalventas
     */
    public void setTotalVentas(int totalVentas) {
        this.totalVentas = totalVentas;
    }

    /**
     * Setter ventas diarias
     * @param ventasDiarias ventasDiarias
     */
    public void setVentasDiarias(double[][] ventasDiarias) {
        this.ventasDiarias = ventasDiarias;
    }

    /**
     * Setter stock
     * @param stock stock
     */
    public void setStock(int[] stock) {
        this.stock = stock;
    }

    /**
     * Setter empleados
     * @param empleados empleados[]
     */
    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    /**
     * Método que calcula el total de ventas y lo devuelve en un entero
     * @return total de ventas
     */
    public int calcularTotalVentas(){
        int salida = 0;
        for (int i = 0; i < ventasDiarias.length; i++)
            for (int j = 0; j < ventasDiarias[i].length; j++)
                salida += ventasDiarias[i][j];
        return salida;
    }

    /**
     * Método que devuelve las ventas en un mes indicado
     * @param mes Mes a calcular las ventas
     * @return Ventas (int) del mes indicado
     */
    public int calcularVentasMensuales(int mes){
        int salida = 0;
        for (int i = 0; i < ventasDiarias[mes-1].length; i++)
            salida += ventasDiarias[mes-1][i];
        return salida;
    }

    /**
     * Método que devuelve el número del mes que más ventas tiene
     * @return entero del mes con más ventas
     */
    public int mesConMasVentas(){
        int venta = 0;
        int salida = -1; //si ningun mes tiene ventas devuelve -1
        for (int i = 1; i<=12; i++) //recorre los 12 meses
            if (calcularVentasMensuales(i) > venta) //compara las ventas mensuales del mes i con las ventas maximas
                salida = i;
        return salida;
    }

    public void actualizarVentas(int venta){
        if (ventasDiarias == null)
            ventasDiarias = new double[12][31];
        LocalDate todayDate = LocalDate.now();
        ventasDiarias[todayDate.getMonthValue()-1][todayDate.getDayOfMonth()-1] += venta;
        totalVentas += venta;
    }

    /**
     * Método que muestra un String con las ventas del mes indicado
     * @param mes mes del que se quieren saber las ventas
     */
    public String mostrarVentasMes(int mes){
        enum meses {Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre};
        return ("En " + meses.values()[mes-1] + " se han realizado " + calcularVentasMensuales(mes) + " ventas.");
    }

    /**
     * Método que muestra el stock de un producto pedido
     * @param index nº del producto pedido
     */
    public void mostrarStock(int index){
        if (index > stock.length || index<1)
            System.out.println("ERROR: ese producto no existe en la base de datos.");
        else
            System.out.println("El stock del producto nº " + index + " es de " + stock[index-1] + " unidad(es).");
    }

    @Override
    public String toString() {
        return "Comercio " + nombre  +
                "\nDireccion: " + direccion +
                "\nCIF: " + cif +
                "\nTotal de ventas: " + totalVentas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comercio comercio = (Comercio) o;
        return totalVentas == comercio.totalVentas && Objects.equals(nombre, comercio.nombre) && Objects.equals(direccion, comercio.direccion) && Objects.equals(cif, comercio.cif) && Arrays.equals(ventasDiarias, comercio.ventasDiarias) && Arrays.equals(stock, comercio.stock) && Arrays.equals(empleados, comercio.empleados);
    }


    public Comercio duplicar(){
        if (stock == null)
            stock = new int[5];
        if (ventasDiarias == null)
            ventasDiarias = new double[12][31];
        Comercio duplicado = new Comercio(this.nombre, this.direccion, this.cif, this.totalVentas, this.empleados.length, this.stock.length);
        for (int i = 0; i < ventasDiarias.length; i++){
            System.arraycopy(ventasDiarias[i], 0, duplicado.ventasDiarias[i], 0, ventasDiarias[0].length);
        }
        System.arraycopy(this.stock, 0, duplicado.stock, 0, this.stock.length);
        for (int i = 0; i < empleados.length; i++){
            if (this.empleados[i] != null)
                duplicado.empleados[i] = this.empleados[i].duplicar();
        }
        return duplicado;
    }
}
