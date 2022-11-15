/**
 * @autor Javier Blanco Rodríguez
 * Programacion B - PAC 6 de la UF5
 * Curso Académico: 2021-2022 - Segundo semestre
 * Profesor: Mario Gago
 * */

public class Gasto extends Dinero{


    Gasto (double gasto, String description){ //  Constructor  de  gasto  y descripción
        this.dinero = gasto;
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
        return this.description + " - " + dinero;
    }
}

