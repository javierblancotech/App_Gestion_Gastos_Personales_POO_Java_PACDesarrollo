/**
 ** @autor Javier Blanco Rodríguez
 * Programacion B - PAC 6 de la UF5
 * Curso Académico: 2021-2022 - Segundo semestre
 * Profesor: Mario Gago
 * 
 * @version 1.0
 * */

import java.util.regex.*;



public class Usuario {
    private String nombre;

    private int edad;

    private String DNI;



    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getEdad() {
        return edad;
    }


    public void setEdad(int edad) {
        this.edad = edad;
    }


    public String getDNI() {
        return DNI;
    }


    public boolean setDNI(String DNI) {
        String auxDNI = DNI.replace("-", ""); // Para la validación eliminamos el guión
        String errorMsg = "DNI introducido incorrecto";

        if (auxDNI.length() == 9) {
            Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]"); // Utilizamos patron  de  exp  regular para  validar  8  números  y  1 letra
            Matcher mat = patron.matcher(auxDNI);

            if (!mat.matches()) {
                System.out.println(errorMsg);
                return false;
            } else {
                this.DNI = DNI; //Si el DNI es valido, guardamos el numero ingresado en el campo DNI del usuario
                return true;
            }
        }else{
            System.out.println(errorMsg);
            return false;
        }
    }


    @Override
    public String toString(){
        return "Nombre: "   + this.nombre +
                "\nEdad: "  + this.edad +
                "\nDNI: "   + this.DNI;
    }
}
