/**
 ** @autor Javier Blanco Rodríguez
 * Programacion B - PAC 6 de la UF5
 * Curso Académico: 2021-2022 - Segundo semestre
 * Profesor: Mario Gago
 * */

public class Ingreso extends Dinero {


    Ingreso (double ingreso, String description){ //  Constructor  de  ingreso  y  descripción
        this.dinero = ingreso;
        this.description = description;
    }


    public double getDinero() {
        return this.dinero;
    }


    public void setDinero(double dinero) {
        this.dinero = dinero;
    }


    public String getDescription() {
        return this.description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString(){
        return this.description + " " + dinero;
    }
}

