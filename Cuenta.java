/**
 * @autor Javier Blanco Rodríguez
 * Programacion B - PAC 6 de la UF5
 * Curso Académico: 2021-2022 - Segundo semestre
 * Profesor: Mario Gago
 * */

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;

   Cuenta(Usuario usuario){ //Constructor
        this.usuario = usuario;
        this.saldo = 0;
        gastos = new ArrayList<>();
        ingresos = new ArrayList<>();
    }


    
    public double getSaldo() {
        return saldo;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public Usuario getUsuario() {
        return usuario;
    }



    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public List<Gasto> getGastos() {
        return gastos;
    }


    public List<Ingreso> getIngresos() {
        return ingresos;
    }


    public double addIngresos(String description, double cantidad){
        this.ingresos.add(new Ingreso(cantidad, description));
        this.saldo += cantidad;
        return this.saldo;
    }


    public double addGastos(String description, double cantidad) {
       try{
           if (this.saldo < cantidad) {
               throw new GastoException();
           }else{
               this.gastos.add(new Gasto(cantidad, description));
               this.saldo -= cantidad;
           }
       }catch (GastoException e){
           
            // Mensaje de la excepcion: "Saldo insuficiente".
           
       }finally {
           return this.saldo;
       }
    }


    
    @Override
    public String toString(){
        return "Usuario: " + this.usuario.getNombre() +
                "\nSaldo: " + this.saldo;
    }

}
