package PaqComercio;

import java.time.LocalDate;

enum días {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

public class Restaurante extends Comercio{
    public String [] menúDiario;
    private int numMesas;
    private int capacidad;

    public Restaurante(){
    }
    public Restaurante(int mesas, int cp){
        this.menúDiario = new String[7];
        this.numMesas = mesas;
        this.capacidad = cp;
    }

    public String[] getMenúDiario() {
        return menúDiario;
    }

    public void setMenúDiario(String[] menúDiario) {
        this.menúDiario = menúDiario;
    }

    public int getNumMesas() {
        return numMesas;
    }

    public void setNumMesas(int numMesas) {
        this.numMesas = numMesas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void fijarMenúDía(String menu){
        if (menúDiario == null)
            menúDiario = new String[7];
        LocalDate todayDate = LocalDate.now();
        for (int i = 0; i < días.values().length; i++)
            if (String.valueOf(días.values()[i]) == String.valueOf(todayDate.getDayOfWeek())) {
                menúDiario[i] = menu;
                return;
            }
    }

    public String verMenúDía(){
        LocalDate todayDate = LocalDate.now();
        if (menúDiario != null)
            for (int i = 0; i < días.values().length; i++)
                if (String.valueOf(días.values()[i]) == String.valueOf(todayDate.getDayOfWeek()))
                    return menúDiario[i];
        return null;
    }

}
