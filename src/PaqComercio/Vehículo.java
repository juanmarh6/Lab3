package PaqComercio;

/**
 * @author Juanma
 * @version 01/03/2022
 * Superclase que define un vehículo con marca, modelo y matrícula.
 */
public class Vehículo {
    private String marca;
    private String modelo;
    private String matricula;

    /**
     * Constructor vacío
     */
    public Vehículo(){
        marca = "";
        modelo = "";
        matricula = "";
    }

    /**
     * Constructor completo
     * @param m Marca
     * @param mo Modelo
     * @param ma Matrícula
     */
    public Vehículo(String m, String mo, String ma){
        this.marca = m;
        this.modelo = mo;
        this.matricula = ma;
    }

    /**
     * Setter marca
     * @param m Marca
     */
    public void setMarca(String m){
        this.marca = m;
    }

    /**
     * Setter modelo
     * @param m Modelo
     */
    public void setModelo(String m){
        this.modelo = m;
    }

    /**
     * Setter matrícula
     * @param m Matrícula
     */
    public void setMatricula(String m){
        this.matricula = m;
    }

    /**
     * Getter marca
     * @return Marca
     */
    public String getMarca(){
        return this.marca;
    }

    /**
     * Getter modelo
     * @return Modelo
     */
    public String getModelo(){
        return this.modelo;
    }

    /**
     * Getter matrícula
     * @return Matrícula
     */
    public  String getMatricula(){
        return  this.matricula;
    }
    /**
     * Método que devuelve si dos coches son iguales o no
     * @param o Segundo vehículo
     * @return true (son iguales) false (no)
     */
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehículo dos = (Vehículo) o;
        return this.matricula == dos.matricula && this.modelo == dos.modelo && this.matricula == dos.marca;
    }





    /**
     * Devuelve un String con los datos del coche
     * @return String
     */
    public String toString(){
        return "Marca: " + marca + "\nModelo: " + modelo + "\nMatrícula: " + matricula;
    }

    public Vehículo duplicar(){
        return new Vehículo(this.marca, this.modelo, this.matricula);
    }

}
