package PaqComercio;

/**
 * @author Juanma
 * @version 01/03/2022
 * Subclase de Vehículo, define vehículos para reparar
 */
public class VehículoParaReparar extends Vehículo{
    private String averia;
    private boolean reparado;
    private int prioridad;

    /**
     * Constructor vacío
     */
    public VehículoParaReparar(){
        this.setMarca("");
        this.setMatricula("");
        this.setModelo("");
        this.averia = "";
        this.reparado = false;
        this.prioridad = -1;
    }

    /**
     * Constructor completo
     * @param a Avería
     * @param r Reparado
     * @param p Prioridad
     * @param mar Marca
     * @param mo Modelo
     * @param ma Matrícula
     */
    public VehículoParaReparar(String a, Boolean r, int p, String mar, String mo, String ma){
        this.setMarca(mar);
        this.setModelo(mo);
        this.setMatricula(ma);
        this.averia = a;
        this.reparado = r;
        this.prioridad = p;
    }

    /**
     * Setter avería
     * @param a Avería
     */
    public void setAveria(String a){
        this.averia = a;
    }

    /**
     * Setter reparado
     * @param r Reparado
     */
    public void setReparado(Boolean r){
        this.reparado = r;
    }

    /**
     * Setter prioridad
     * @param p Prioridad
     */
    public  void setPrioridad(int p){
        this.prioridad = p;
    }

    /**
     * Getter avería
     * @return Avería
     */
    public String getAveria(){
        return this.averia;
    }

    /**
     * Getter reparado
     * @return Reparado
     */
    public Boolean getReparado(){
        return this.reparado;
    }

    /**
     * Getter prioridad
     * @return Prioridad
     */
    public int getPrioridad(){
        return this.prioridad;
    }

    /**
     * Método toString para vehículos para reparar
     * @return String
     */
    public String toString(){
        return super.toString() + "\nAvería: " + averia + "\nReparado: " + reparado +
                "\nPrioridad: " + prioridad;
    }
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehículoParaReparar dos = (VehículoParaReparar) o;
        return super.equals(o) && this.averia == dos.averia && this.reparado == dos.reparado && this.prioridad == dos.prioridad;
    }

    public VehículoParaReparar duplicar(){
        return new VehículoParaReparar(this.averia, this.reparado, this.prioridad, this.getMarca(), this.getModelo(), this.getMatricula());
    }
}
