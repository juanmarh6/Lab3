package PaqComercio;

/**
 * @author Juanma
 * @version 01/03/2022
 * Subclase de Vehículo, define vehículos en venta
 */
public class VehículoVenta extends Vehículo{
    private double precio;
    private int descuento;

    /**
     * Constructor vacío
     */
    public VehículoVenta(){
        this.setMarca("");
        this.setMatricula("");
        this.setModelo("");
        this.precio = -1;
        this.descuento = -1;
    }

    /**
     *
     * @param p Precio
     * @param d Descuento
     * @param mar Marca
     * @param mo Modelo
     * @param ma Matrícula
     */
    public VehículoVenta(double p, int d, String mar, String mo, String ma){
        super(mar,mo,ma);
        this.precio = p;
        this.descuento = d;
    }

    /**
     * Getter precio
     * @return Precio
     */
    public double getPrecio(){
        return this.precio;
    }

    /**
     * Getter descuento
     * @return Descuento
     */
    public int getDescuento(){
        return  this.descuento;
    }

    /**
     * Setter precio
     * @param p Precio
     */
    public void setPrecio(double p){
        this.precio = p;
    }

    /**
     * Setter descuento
     * @param d Descuento
     */
    public void setDescuento(int d){
        this.descuento = d;
    }

    /**
     * Método toString para vehículos en venta
     * @return String
     */
    public String toString(){
        return super.toString() + "\nPrecio: " + precio + "€\nDescuento: " + descuento + "€";
    }
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehículoVenta dos = (VehículoVenta) o;
        return super.equals(o) && this.descuento == dos.descuento && this.precio == dos.precio;
    }
    public VehículoVenta duplicar(){
        return new VehículoVenta(this.precio, this.descuento, this.getMarca(), this.getModelo(), this.getMatricula());
    }

}
