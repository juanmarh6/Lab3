package PaqComercio;

import java.util.Arrays;

public class Concesionario extends Comercio{
    private VehículoVenta [] V;
    private VehículoParaReparar [] R;

    /**
     * Constructor vacío
     */
    public Concesionario(){
        V = new VehículoVenta[0];
        R = new VehículoParaReparar[0];
    }

    /**
     * Constructor completo
     * @param nombre Nombre del comercio
     * @param direccion Dirección del comercio
     * @param cif CIF del comercio
     * @param totalVentas Total de ventas del comercio (vector bidimensional)
     * @param ventasDiarias Ventas diarias del comercio
     * @param stock Stock del comercio0
     * @param empleados Lista de empleados del comercio
     * @param V Lista de vehículos a vender
     * @param R Lista de vehículos a reparar
     */
    public Concesionario(String nombre, String direccion, String cif, int totalVentas, double [][] ventasDiarias, int [] stock, Empleado[] empleados, int V, int R){
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setCif(cif);
        this.setTotalVentas(totalVentas);
        this.setVentasDiarias(ventasDiarias);
        this.setStock(stock);
        this.setEmpleados(empleados);
        this.V = new VehículoVenta[V];
        this.R = new VehículoParaReparar[R];
    }

    /**
     * getter Vehículos a vender
     * @return V
     */
    public VehículoVenta[] getV() {
        return V;
    }

    /**
     * Getter vehículos a reparar
     * @return R
     */
    public VehículoParaReparar[] getR() {
        return R;
    }

    /**
     * Setter vehículos a vender
     * @param v V
     */
    public void setV(VehículoVenta[] v) {
        V = v;
    }

    /**
     * Setter vehículos a reparar
     * @param r R
     */
    public void setR(VehículoParaReparar[] r) {
        R = r;
    }

    /**
     * Método que muestra todos los coches que están a la venta en el concesionario
     * Imprime en pantalla todos los datos de los coches, uno por uno, hasta que no quedan más a la venta
     */
    public String verVehiculosVenta(){
        String mensaje = new String("");
        for (int i = 0; i < V.length; i++)
            mensaje += "Coche nº " + (i+1) + " a vender:\n" + V[i].toString() + "\n";
        return mensaje;
    }

    /**
     * Método que muestra por pantalla los datos de todos los coches a reparar
     * Idéntico a verVehículosVenta()
     */
    public String verTaller(){
        String mensaje = new String("");
        for (int i = 0; i < R.length; i++)
            if (R[i] != null)
                mensaje += "Coche nº " + (i+1) + " a reparar:\n" + R[i].toString() + "\n";
        return mensaje;
    }
    public void añadirReparar(VehículoParaReparar cocher){
        if (R.length < 1)
            R = new VehículoParaReparar[10];
        for (int i = 0; i < R.length; i++){
            if (R[i] == null) {
                R[i] = cocher;
                return;
            }
        }
        VehículoParaReparar [] R2 = new VehículoParaReparar[2 * R.length];
        for (int j = 0; j < R.length; j++)
            R2[j] = R[j];
        R2[R.length + 1] = cocher;
        R = R2.clone();
    }

    public void repararVehículo(String mat){
        for (int i = 0; i < R.length; i++){
            if (R[i].getMatricula() == mat)
                R[i].setReparado(true);
        }
    }
    public VehículoParaReparar recogerVehículo(String mat){
        for (int i = 0; i < R.length; i++){
            if (R[i] != null && R[i].getMatricula() == mat && R[i].getReparado() == true){
                VehículoParaReparar salida = R[i];
                for (int j = i+1; j < R.length; j++)
                    if (R[j] != null)
                        R[j-1] = R[j].duplicar();
                return salida;
            }
        }
        return null;
    }
    public void añadirVenta(VehículoVenta nuevo){
        if (V.length < 1)
            V = new VehículoVenta[10];
        for (int i = 0; i < V.length; i++){
            if (V[i] == null)
                V[i] = nuevo;
            return;
        }
        VehículoVenta V2[] = new VehículoVenta[V.length * 2];
        for (int i = 0; i < V.length; i++)
            V2[i] = V[i];
        V2[V.length + 1] = nuevo;
        V = V2.clone();
    }

    public VehículoVenta venderVehículo(String mat){
        if (V != null)
            for (int i = 0; i < V.length; i++){
                if (V[i] != null && V[i].getMatricula() == mat) {
                    VehículoVenta salida = V[i];
                    for (int j = i+1; j < V.length; j++)
                        if (V[j] != null)
                            V[j-1] = V[j].duplicar();
                    return salida;
                }
            }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Concesionario that = (Concesionario) o;
        return Arrays.equals(V, that.V) && Arrays.equals(R, that.R);
    }


    @Override
    public String toString() {
        return super.toString() + verTaller() + verVehiculosVenta();
    }
}
