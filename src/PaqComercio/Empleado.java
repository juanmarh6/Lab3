package PaqComercio;

/**
 * @author Juanma
 * @version 01/03/2022
 * Clase que define un empleado
 */
public class Empleado {
    protected String nombre;
    protected String direccion;
    protected int telefono;
    protected String email;
    protected String fechainicio;
    protected double salario;
    protected String cargo;

    /**
     * Constuctor vacío
     */
    public Empleado(){
    }

    /**
     * Constructor completo
     * @param nombre Nombre del empleado
     * @param direccion Dirección del empleado
     * @param telefono Número de teléfono del empledao
     * @param email Email del empleado
     * @param fechainicio Fecha de inicio de trabajo del empleado
     * @param salario Salario del empleado
     * @param cargo Cargo que ocupa el empleado
     */
    public Empleado(String nombre, String direccion, int telefono, String email, String fechainicio, double salario, String cargo){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechainicio = fechainicio;
        this.salario = salario;
        this.cargo = cargo;
    }

    /**
     * Setter nombre
     * @param nombre Nombre del empledao
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter direccion
     * @param direccion Direccion del empleado
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Setter fechainicio
     * @param fechainicio fecha de inicio de trabajo del empleado
     */
    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    /**
     * Setter cargo
     * @param cargo cargo que ocupa el empleado
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Setter email
     * @param email Email del empleado
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter salario
     * @param salario salario del empleado
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * setter telefono
     * @param telefono número del empleado
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * getter direccion
     * @return direccion del empleado
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * getter nombre
     * @return nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * getter salario
     * @return salario del empleado
     */
    public double getSalario() {
        return salario;
    }

    /**
     * getter telefono
     * @return telefono del empleado
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * getter cargo
     * @return cargo del empleado
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * getter email
     * @return email del empleado
     */
    public String getEmail() {
        return email;
    }

    /**
     * getter fecha inicio
     * @return fecha de inicio de trabajo del empleado
     */
    public String getFechainicio() {
        return fechainicio;
    }

    public Empleado duplicar(){
        return new Empleado(this.nombre, this.direccion, this.telefono, this.email, this.fechainicio, this.salario, this.cargo);
    }
}
